package com.barion.the_witcher.data.provider.loot_table;

import com.ametrinstudios.ametrin.data.provider.loot_table.ExtendedBlockLootSubProvider;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.item.TWItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static com.ametrinstudios.ametrin.data.LootTableProviderHelper.one;

public final class TWBlockLoot extends ExtendedBlockLootSubProvider {
    public TWBlockLoot(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected void generate() {
        dropSelf(TWBlocks.SILVER_BLOCK.get(),
                TWBlocks.RAW_SILVER_BLOCK.get(),
                TWBlocks.MASTER_SMITHING_TABLE.get(),

                TWBlocks.FROSTED_STONE_STAIRS.get(),
                TWBlocks.FROSTED_STONE_SLAB.get(),
                TWBlocks.FROSTED_STONE_WALL.get(),
                TWBlocks.FROSTED_STONE_BUTTON.get(),
                TWBlocks.FROSTED_COBBLESTONE.get(),
                TWBlocks.FROSTED_COBBLESTONE_STAIRS.get(),
                TWBlocks.FROSTED_COBBLESTONE_SLAB.get(),
                TWBlocks.FROSTED_COBBLESTONE_WALL.get(),
                TWBlocks.FROSTED_COBBLESTONE_BUTTON.get(),
                TWBlocks.FROSTED_STONE_BRICKS.get(),
                TWBlocks.FROSTED_STONE_BRICK_STAIRS.get(),
                TWBlocks.FROSTED_STONE_BRICK_SLAB.get(),
                TWBlocks.FROSTED_STONE_BRICK_WALL.get(),
                TWBlocks.FROSTED_STONE_BRICK_BUTTON.get(),
                TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get(),
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS.get(),
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB.get(),
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL.get(),
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_BUTTON.get(),

                TWBlocks.DeepFrostedStoneStairs.get(),
                TWBlocks.DeepFrostedStoneSlab.get(),
                TWBlocks.DeepFrostedStoneWall.get(),
                TWBlocks.DeepFrostedStoneButton.get(),
                TWBlocks.DeepFrostedCobblestone.get(),
                TWBlocks.DeepFrostedCobblestoneStairs.get(),
                TWBlocks.DeepFrostedCobblestoneSlab.get(),
                TWBlocks.DeepFrostedCobblestoneWall.get(),
                TWBlocks.DeepFrostedCobblestoneButton.get(),
                TWBlocks.DeepFrostedStoneBricks.get(),
                TWBlocks.DeepFrostedStoneBrickStairs.get(),
                TWBlocks.DeepFrostedStoneBrickSlab.get(),
                TWBlocks.DeepFrostedStoneBrickWall.get(),
                TWBlocks.DeepFrostedStoneBrickButton.get(),
                TWBlocks.CrackedDeepFrostedStoneBricks.get(),
                TWBlocks.CrackedDeepFrostedStoneBrickStairs.get(),
                TWBlocks.CrackedDeepFrostedStoneBrickSlab.get(),
                TWBlocks.CrackedDeepFrostedStoneBrickWall.get(),
                TWBlocks.CrackedDeepFrostedStoneBrickButton.get(),
                TWBlocks.DeepFrostedStoneTiles.get(),
                TWBlocks.DeepFrostedStoneTileStairs.get(),
                TWBlocks.DeepFrostedStoneTileSlab.get(),
                TWBlocks.DeepFrostedStoneTileWall.get(),
                TWBlocks.DeepFrostedStoneTileButton.get(),
                TWBlocks.CrackedDeepFrostedStoneTiles.get(),
                TWBlocks.CrackedDeepFrostedStoneTileStairs.get(),
                TWBlocks.CrackedDeepFrostedStoneTileSlab.get(),
                TWBlocks.CrackedDeepFrostedStoneTileWall.get(),
                TWBlocks.CrackedDeepFrostedStoneTileButton.get(),

                TWBlocks.HALLUCINATED_STONE.get(),
                TWBlocks.HALLUCINATED_STONE_STAIRS.get(),
                TWBlocks.HALLUCINATED_STONE_SLAB.get(),
                TWBlocks.HALLUCINATED_STONE_WALL.get(),
                TWBlocks.HALLUCINATED_STONE_BUTTON.get(),
                TWBlocks.ALCITE.get()
        );

        dropOther(TWBlocks.FROSTED_STONE.get(), TWBlocks.FROSTED_COBBLESTONE.get());
        dropOther(TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedCobblestone.get());
        dropWhenSilkTouch(TWBlocks.ICICLE.get());
        dropWhenSilkTouch(TWBlocks.LARIMAR.get());

        dropBush(TWBlocks.WHITE_MYRTLE_BUSH.get(), TWItems.WHITE_MYRTLE.get());
        dropBush(TWBlocks.CELANDINE_BUSH.get(), TWItems.CELANDINE.get());
    }

    private void dropBush(Block bush, ItemLike drop){
        this.add(bush, (block) -> applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(drop)).apply(SetItemCountFunction.setCount(one())))));
    }

    @Override @Nonnull
    protected @NotNull Iterable<Block> getKnownBlocks() { return TWBlocks.REGISTER.getEntries().stream().map(DeferredHolder::get).map(block -> (Block)block).toList(); }
}
