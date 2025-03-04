package com.barion.the_witcher.registry.block;

import net.minecraft.data.BlockFamily;

public final class TWBlockFamilies {
    public static final BlockFamily FROSTED_COBBLESTONE = new BlockFamily.Builder(TWBlocks.FROSTED_COBBLESTONE.get())
            .stairs(TWBlocks.FROSTED_COBBLESTONE_STAIRS.get())
            .slab(TWBlocks.FROSTED_COBBLESTONE_SLAB.get())
            .wall(TWBlocks.FROSTED_COBBLESTONE_WALL.get())
            .button(TWBlocks.FROSTED_COBBLESTONE_BUTTON.get())
            .getFamily();

    public static final BlockFamily FROSTED_STONE = new BlockFamily.Builder(TWBlocks.FROSTED_STONE.get())
            .stairs(TWBlocks.FROSTED_STONE_STAIRS.get())
            .slab(TWBlocks.FROSTED_STONE_SLAB.get())
            .wall(TWBlocks.FROSTED_STONE_WALL.get())
            .button(TWBlocks.FROSTED_STONE_BUTTON.get())
            .getFamily();

    public static final BlockFamily FROSTED_STONE_BRICKS = new BlockFamily.Builder(TWBlocks.FROSTED_STONE_BRICKS.get())
            .stairs(TWBlocks.FROSTED_STONE_BRICK_STAIRS.get())
            .slab(TWBlocks.FROSTED_STONE_BRICK_SLAB.get())
            .wall(TWBlocks.FROSTED_STONE_BRICK_WALL.get())
            .button(TWBlocks.FROSTED_STONE_BRICK_BUTTON.get())
            .cracked(TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get())
            .getFamily();

    public static final BlockFamily CRACKED_FROSTED_STONE_BRICKS = new BlockFamily.Builder(TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get())
            .stairs(TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS.get())
            .slab(TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB.get())
            .wall(TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL.get())
            .button(TWBlocks.CRACKED_FROSTED_STONE_BRICK_BUTTON.get())
            .getFamily();

    public static final BlockFamily DEEP_FROSTED_COBBLESTONE = new BlockFamily.Builder(TWBlocks.DEEP_FROSTED_COBBLESTONE.get())
            .stairs(TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS.get())
            .slab(TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB.get())
            .wall(TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL.get())
            .button(TWBlocks.DEEP_FROSTED_COBBLESTONE_BUTTON.get())
            .getFamily();

    public static final BlockFamily DEEP_FROSTED_STONE = new BlockFamily.Builder(TWBlocks.DEEP_FROSTED_STONE.get())
            .stairs(TWBlocks.DEEP_FROSTED_STONE_STAIRS.get())
            .slab(TWBlocks.DEEP_FROSTED_STONE_SLAB.get())
            .wall(TWBlocks.DEEP_FROSTED_STONE_WALL.get())
            .button(TWBlocks.DEEP_FROSTED_STONE_BUTTON.get())
            .getFamily();

    public static final BlockFamily DEEP_FROSTED_STONE_BRICKS = new BlockFamily.Builder(TWBlocks.DEEP_FROSTED_STONE_BRICKS.get())
            .stairs(TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS.get())
            .slab(TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB.get())
            .wall(TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL.get())
            .button(TWBlocks.DEEP_FROSTED_STONE_BRICK_BUTTON.get())
            .cracked(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get())
            .getFamily();

    public static final BlockFamily CRACKED_DEEP_FROSTED_STONE_BRICKS = new BlockFamily.Builder(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get())
            .stairs(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS.get())
            .slab(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB.get())
            .wall(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_WALL.get())
            .button(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON.get())
            .getFamily();

    public static final BlockFamily DEEP_FROSTED_STONE_TILES = new BlockFamily.Builder(TWBlocks.DEEP_FROSTED_STONE_TILES.get())
            .stairs(TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS.get())
            .slab(TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB.get())
            .wall(TWBlocks.DEEP_FROSTED_STONE_TILE_WALL.get())
            .button(TWBlocks.DEEP_FROSTED_STONE_TILE_BUTTON.get())
            .cracked(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES.get())
            .getFamily();

    public static final BlockFamily CRACKED_DEEP_FROSTED_STONE_TILES = new BlockFamily.Builder(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES.get())
            .stairs(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS.get())
            .slab(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_SLAB.get())
            .wall(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_WALL.get())
            .button(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON.get())
            .getFamily();

    public static final BlockFamily HALLUCINATED_STONE = new BlockFamily.Builder(TWBlocks.HALLUCINATED_STONE.get())
            .stairs(TWBlocks.HALLUCINATED_STONE_STAIRS.get())
            .slab(TWBlocks.HALLUCINATED_STONE_SLAB.get())
            .wall(TWBlocks.HALLUCINATED_STONE_WALL.get())
            .button(TWBlocks.HALLUCINATED_STONE_BUTTON.get())
            .getFamily();
}
