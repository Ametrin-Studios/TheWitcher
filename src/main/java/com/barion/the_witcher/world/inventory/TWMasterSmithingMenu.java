package com.barion.the_witcher.world.inventory;

import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import com.barion.the_witcher.registry.TWMenuTypes;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingMenu extends AbstractContainerMenu implements RecipeInput {
    private final Player player;
    private final Level level;
    private final ItemStackHandler itemHandler;
    private final ContainerLevelAccess access;
    private final DataSlot xpSlot;
    private TWMasterSmithingRecipe selectedRecipe;

    public static final int SLOT_COUNT = 2;
    public static final int RESULT_SLOT_ID = 1;
    public static final int INPUT_SLOT_ID = 0;

    public TWMasterSmithingMenu(int id, Inventory inventory, FriendlyByteBuf data) {
        this(id, inventory, data == null ? ContainerLevelAccess.NULL : ContainerLevelAccess.create(inventory.player.level(), data.readBlockPos()), DataSlot.standalone());
    }

    public TWMasterSmithingMenu(int id, Inventory inventory, ContainerLevelAccess containerAccess, DataSlot xpSlot) {
        super(TWMenuTypes.MASTER_SMITHING_TABLE_MENU.get(), id);
        player = inventory.player;
        level = inventory.player.level();
        access = containerAccess;
        this.xpSlot = xpSlot;
        xpSlot.set(-1);
        itemHandler = new ItemStackHandler(SLOT_COUNT) {
            @Override
            protected void onContentsChanged(int slot) {
                slotsChanged(getContainer());
            }
        };
        checkContainerSize(inventory, SLOT_COUNT);

        addSlot(new SlotItemHandler(itemHandler, 0, 44, 39));
        addSlot(new SlotItemHandler(itemHandler, 1, 116, 39) {
            @Override
            public boolean mayPlace(@NotNull ItemStack itemStack) {
                return false;
            }

            @Override
            public boolean mayPickup(@NotNull Player player) {
                return TWMasterSmithingMenu.this.mayPickup(player, hasItem());
            }

            @Override
            @ParametersAreNonnullByDefault
            public void onTake(Player player, ItemStack itemStack) {
                itemStack.onCraftedBy(player.level(), player, itemStack.getCount());
                if (!player.getAbilities().instabuild) {
                    player.giveExperienceLevels(-selectedRecipe.getXpCost());
                }
                itemHandler.extractItem(INPUT_SLOT_ID, 1, false);
                access.execute((level, pos) -> level.levelEvent(1044, pos, 0));
            }
        });

        addDataSlot(xpSlot);


        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);
    }

    protected boolean isValidBlock(BlockState blockState) {
        return blockState.is(TWBlocks.MASTER_SMITHING_TABLE.get());
    }

    protected boolean mayPickup(Player player, boolean hasItem) {
        return this.selectedRecipe != null && selectedRecipe.matches(this, level);
    }

    public void createResult() {
        var recipes = level.getServer().getRecipeManager().getRecipeFor(TWRecipeTypes.MASTER_SMITHING.get(), this, level);
        if (recipes.isEmpty()) {
            if (itemHandler.getStackInSlot(RESULT_SLOT_ID) != ItemStack.EMPTY) {
                itemHandler.setStackInSlot(RESULT_SLOT_ID, ItemStack.EMPTY);
                selectedRecipe = null;
                xpSlot.set(-1);
            }
        } else {
            selectedRecipe = recipes.get().value();
            xpSlot.set(selectedRecipe.getXpCost());
            if (!canCraft()) {
                return;
            }
            var resultItem = selectedRecipe.assemble(this, level.registryAccess());
            if (!itemHandler.getStackInSlot(RESULT_SLOT_ID).is(resultItem.getItem())) {
                resultItem.copyFrom(itemHandler.getStackInSlot(INPUT_SLOT_ID), DataComponents.ENCHANTMENTS, DataComponents.DAMAGE);
                itemHandler.setStackInSlot(RESULT_SLOT_ID, resultItem);
            }
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return access.evaluate((level, pos) -> isValidBlock(level.getBlockState(pos)) && player.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D, true);
    }

    @Override
    public void slotsChanged(@NotNull Container container) {
        this.access.execute((level, access) -> {
            this.createResult();
        });
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        access.execute((level, pos) -> clearContainer(player));
    }

    protected void clearContainer(Player player) {
        if (!player.isAlive() || player instanceof ServerPlayer && ((ServerPlayer) player).hasDisconnected()) {
            player.drop(itemHandler.getStackInSlot(INPUT_SLOT_ID), false);
        } else {
            var inventory = player.getInventory();
            if (inventory.player instanceof ServerPlayer) {
                inventory.placeItemBackInInventory(itemHandler.getStackInSlot(INPUT_SLOT_ID));
            }
        }
    }

    private SimpleContainer getContainer() {
        var inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        return inventory;
    }

    public boolean enoughXP() {
        return player.experienceLevel >= getXPCost() || player.getAbilities().instabuild;
    }

    public int getXPCost() {
        return xpSlot.get();
    }

    public boolean canCraft() {
        return getSelectedRecipe() != null && enoughXP();
    }

    public @Nullable TWMasterSmithingRecipe getSelectedRecipe() {
        return selectedRecipe;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOTS = 9;
    private static final int PLAYER_INVENTORY_ROWS = 3;
    private static final int PLAYER_INVENTORY_COLUMNS = 9;
    private static final int PLAYER_INVENTORY_SLOTS = PLAYER_INVENTORY_COLUMNS * PLAYER_INVENTORY_ROWS;
    private static final int VANILLA_SLOTS = HOTBAR_SLOTS + PLAYER_INVENTORY_SLOTS;
    private static final int FIRST_SLOT = 0;
    private static final int MOD_FIRST_SLOT = FIRST_SLOT + VANILLA_SLOTS;

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        var sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  // EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < FIRST_SLOT + VANILLA_SLOTS) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, MOD_FIRST_SLOT, MOD_FIRST_SLOT
                    + SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < MOD_FIRST_SLOT + SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, FIRST_SLOT, FIRST_SLOT + VANILLA_SLOTS, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public @NotNull ItemStack getItem(int index) {
        return itemHandler.getStackInSlot(index);
    }

    @Override
    public int size() {
        return 2;
    }
}