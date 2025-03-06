package com.barion.the_witcher.world.block;

import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingTableBlock extends CraftingTableBlock {
    public static final Component TEXT_COMPONENT = Component.translatable("container.the_witcher.master_smithting");

    public TWMasterSmithingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public @NotNull MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, player) -> new TWMasterSmithingMenu(id, inventory, ContainerLevelAccess.create(level, pos), DataSlot.standalone()), TEXT_COMPONENT);
    }
}