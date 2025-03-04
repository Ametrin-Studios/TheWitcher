package com.barion.the_witcher.data.provider.tag;

import com.ametrinstudios.ametrin.data.provider.ExtendedBlockTagsProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.util.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public final class TWBlockTagsProvider extends ExtendedBlockTagsProvider {
    public TWBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
        super(output, lookupProvider, TheWitcher.MOD_ID);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider lookupProvider) {
        runRules(TWBlocks.getAllBlocks());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TWBlocks.RAW_SILVER_BLOCK.get(),
                TWBlocks.SILVER_BLOCK.get(),

                TWBlocks.FROSTED_COBBLESTONE.get(),
                TWBlocks.FROSTED_COBBLESTONE_STAIRS.get(),
                TWBlocks.FROSTED_COBBLESTONE_SLAB.get(),
                TWBlocks.FROSTED_COBBLESTONE_WALL.get(),
                TWBlocks.FROSTED_COBBLESTONE_BUTTON.get(),
                TWBlocks.FROSTED_STONE.get(),
                TWBlocks.FROSTED_STONE_STAIRS.get(),
                TWBlocks.FROSTED_STONE_SLAB.get(),
                TWBlocks.FROSTED_STONE_WALL.get(),
                TWBlocks.FROSTED_STONE_BUTTON.get(),
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

                TWBlocks.DEEP_FROSTED_COBBLESTONE.get(),
                TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS.get(),
                TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB.get(),
                TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL.get(),
                TWBlocks.DEEP_FROSTED_COBBLESTONE_BUTTON.get(),
                TWBlocks.DEEP_FROSTED_STONE.get(),
                TWBlocks.DEEP_FROSTED_STONE_STAIRS.get(),
                TWBlocks.DEEP_FROSTED_STONE_SLAB.get(),
                TWBlocks.DEEP_FROSTED_STONE_WALL.get(),
                TWBlocks.DEEP_FROSTED_STONE_BUTTON.get(),
                TWBlocks.DEEP_FROSTED_STONE_BRICKS.get(),
                TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS.get(),
                TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB.get(),
                TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL.get(),
                TWBlocks.DEEP_FROSTED_STONE_BRICK_BUTTON.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_WALL.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON.get(),
                TWBlocks.DEEP_FROSTED_STONE_TILES.get(),
                TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS.get(),
                TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB.get(),
                TWBlocks.DEEP_FROSTED_STONE_TILE_WALL.get(),
                TWBlocks.DEEP_FROSTED_STONE_TILE_BUTTON.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_SLAB.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_WALL.get(),
                TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON.get(),
                TWBlocks.ICICLE.get(),

                TWBlocks.HALLUCINATED_STONE.get(),
                TWBlocks.HALLUCINATED_STONE_STAIRS.get(),
                TWBlocks.HALLUCINATED_STONE_SLAB.get(),
                TWBlocks.HALLUCINATED_STONE_WALL.get(),
                TWBlocks.HALLUCINATED_STONE_BUTTON.get(),
                TWBlocks.ALCITE.get()
        );

        tag(BlockTags.MINEABLE_WITH_AXE).add(
                TWBlocks.MASTER_SMITHING_TABLE.get(),
                TWBlocks.ICICLE.get()
        );

        tag(BlockTags.NEEDS_STONE_TOOL).add(
                TWBlocks.HALLUCINATED_STONE.get(),
                TWBlocks.HALLUCINATED_STONE_STAIRS.get(),
                TWBlocks.HALLUCINATED_STONE_SLAB.get(),
                TWBlocks.HALLUCINATED_STONE_WALL.get(),
                TWBlocks.HALLUCINATED_STONE_BUTTON.get(),
                TWBlocks.ALCITE.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                TWBlocks.RAW_SILVER_BLOCK.get(),
                TWBlocks.SILVER_BLOCK.get()
        );

        tag(TWTags.Blocks.ICE_GROUND_REPLACEABLE).add(
                TWBlocks.FROSTED_STONE.get(),
                TWBlocks.DEEP_FROSTED_STONE.get(),
                Blocks.SNOW_BLOCK,
                Blocks.SNOW,
                Blocks.POWDER_SNOW,
                Blocks.ICE,
                Blocks.PACKED_ICE,
                Blocks.BLUE_ICE
        );

        tag(BlockTags.BEACON_BASE_BLOCKS).add(TWBlocks.SILVER_BLOCK.get());
        tag(TWTags.Blocks.STORAGE_BLOCKS_SILVER).add(TWBlocks.SILVER_BLOCK.get());
        tag(TWTags.Blocks.STORAGE_BLOCKS_RAW_SILVER).add(TWBlocks.RAW_SILVER_BLOCK.get());
        tag(TWTags.Blocks.SPIKES_CAN_PLACE).add(TWBlocks.FROSTED_STONE.get(), TWBlocks.DEEP_FROSTED_STONE.get(), Blocks.STONE, Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(TWTags.Blocks.STORAGE_BLOCKS_SILVER).addTag(TWTags.Blocks.STORAGE_BLOCKS_RAW_SILVER);
        tag(BlockTags.VALID_SPAWN).add(TWBlocks.FROSTED_STONE.get(), TWBlocks.DEEP_FROSTED_STONE.get());
        tag(TWTags.Blocks.WHITE_FROST_PORTAL_FRAME).add(TWBlocks.WHITE_FROST_PORTAL_FRAME.get());
    }
}