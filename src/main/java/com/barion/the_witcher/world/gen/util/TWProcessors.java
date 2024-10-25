package com.barion.the_witcher.world.gen.util;

import com.ametrinstudios.ametrin.world.gen.structure.processor.KeepStateRandomBlockSwapProcessor;
import com.barion.the_witcher.registry.block.TWBlocks;
//import com.legacy.structure_gel.api.structure.processor.RandomBlockSwapProcessor;

public class TWProcessors {
//    public static final RandomBlockSwapProcessor CrackStoneBricks = new RandomBlockSwapProcessor(Blocks.STONE_BRICKS, 0.06f, Blocks.CRACKED_STONE_BRICKS);
//    public static final RandomBlockSwapProcessor CrackFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.FROSTED_STONE_BRICKS.get(), 0.05f, TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickStairs = new KeepStateRandomBlockSwapProcessor(TWBlocks.FROSTED_STONE_BRICK_STAIRS.get(), 0.05f, TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickSlab = new KeepStateRandomBlockSwapProcessor(TWBlocks.FROSTED_STONE_BRICK_SLAB.get(), 0.05f, TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickWall = new KeepStateRandomBlockSwapProcessor(TWBlocks.FROSTED_STONE_BRICK_WALL.get(), 0.05f, TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL.get());
//    public static final RandomBlockSwapProcessor CobbleFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.FROSTED_STONE_BRICKS.get(), 0.15f, TWBlocks.FROSTED_COBBLESTONE.get());

//    public static final RandomBlockSwapProcessor CrackDeepFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.DEEP_FROSTED_STONE_BRICKS.get(), 0.2f, TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get());
    public static final KeepStateRandomBlockSwapProcessor CrackDeepFrostedStoneBrickStairs = new KeepStateRandomBlockSwapProcessor(TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS.get(), 0.2f, TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS.get());
//    public static final RandomBlockSwapProcessor DamageBattlements = new RandomBlockSwapProcessor(TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL.get(), 0.15f, Blocks.SNOW);
//    public static final RandomBlockSwapProcessor PowderSnow = new RandomBlockSwapProcessor(Blocks.SNOW_BLOCK, 0.15f, Blocks.POWDER_SNOW);
}