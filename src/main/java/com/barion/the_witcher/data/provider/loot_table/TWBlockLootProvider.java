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
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

import static com.ametrinstudios.ametrin.data.LootTableProviderHelper.one;

public final class TWBlockLootProvider extends ExtendedBlockLootSubProvider {
    public TWBlockLootProvider(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected void generate() {
        dropSelfOther(TWBlocks.SILVER_BLOCK,
                TWBlocks.RAW_SILVER_BLOCK,
                TWBlocks.MASTER_SMITHING_TABLE,

                TWBlocks.FROSTED_STONE_STAIRS,
                TWBlocks.FROSTED_STONE_SLAB,
                TWBlocks.FROSTED_STONE_WALL,
                TWBlocks.FROSTED_STONE_BUTTON,
                TWBlocks.FROSTED_COBBLESTONE,
                TWBlocks.FROSTED_COBBLESTONE_STAIRS,
                TWBlocks.FROSTED_COBBLESTONE_SLAB,
                TWBlocks.FROSTED_COBBLESTONE_WALL,
                TWBlocks.FROSTED_COBBLESTONE_BUTTON,
                TWBlocks.FROSTED_STONE_BRICKS,
                TWBlocks.FROSTED_STONE_BRICK_STAIRS,
                TWBlocks.FROSTED_STONE_BRICK_SLAB,
                TWBlocks.FROSTED_STONE_BRICK_WALL,
                TWBlocks.FROSTED_STONE_BRICK_BUTTON,
                TWBlocks.CRACKED_FROSTED_STONE_BRICKS,
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS,
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB,
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL,
                TWBlocks.CRACKED_FROSTED_STONE_BRICK_BUTTON,

                TWBlocks.DEEP_FROSTED_STONE_STAIRS,
                TWBlocks.DEEP_FROSTED_STONE_SLAB,
                TWBlocks.DEEP_FROSTED_STONE_WALL,
                TWBlocks.DEEP_FROSTED_STONE_BUTTON,
                TWBlocks.DEEP_FROSTED_COBBLESTONE,
                TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS,
                TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB,
                TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL,
                TWBlocks.DEEP_FROSTED_COBBLESTONE_BUTTON,
                TWBlocks.DEEP_FROSTED_STONE_BRICKS,
                TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS,
                TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB,
                TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL,
                TWBlocks.DEEP_FROSTED_STONE_BRICK_BUTTON,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_WALL,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON,
                TWBlocks.DEEP_FROSTED_STONE_TILES,
                TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS,
                TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB,
                TWBlocks.DEEP_FROSTED_STONE_TILE_WALL,
                TWBlocks.DEEP_FROSTED_STONE_TILE_BUTTON,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_SLAB,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_WALL,
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON,

                TWBlocks.HALLUCINATED_STONE,
                TWBlocks.HALLUCINATED_STONE_STAIRS,
                TWBlocks.HALLUCINATED_STONE_SLAB,
                TWBlocks.HALLUCINATED_STONE_WALL,
                TWBlocks.HALLUCINATED_STONE_BUTTON,
                TWBlocks.ALCITE
        );

        dropOther(TWBlocks.FROSTED_STONE.get(), TWBlocks.FROSTED_COBBLESTONE.get());
        dropOther(TWBlocks.DEEP_FROSTED_STONE.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE.get());
        dropWhenSilkTouch(TWBlocks.ICICLE.get());
        dropWhenSilkTouch(TWBlocks.LARIMAR.get());

        dropBush(TWBlocks.WHITE_MYRTLE_BUSH.get(), TWItems.WHITE_MYRTLE.get());
        dropBush(TWBlocks.CELANDINE_BUSH.get(), TWItems.CELANDINE.get());
    }

    @SafeVarargs
    private void dropSelfOther(final DeferredBlock<? extends Block>... blocks) {
        dropSelfOther(Arrays.stream(blocks).map(DeferredBlock::get).iterator());
    }

    private  void dropSelfOther(Iterator<? extends Block> blocks) {
        blocks.forEachRemaining(this::dropSelf);
    }

    private void dropBush(Block bush, ItemLike drop){
        this.add(bush, (block) -> applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(drop)).apply(SetItemCountFunction.setCount(one())))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return TWBlocks.REGISTER.getEntries().stream().map(block -> (Block) block.get()).toList();
    }
}
