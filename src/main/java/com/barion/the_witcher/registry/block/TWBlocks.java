package com.barion.the_witcher.registry.block;

import com.ametrinstudios.ametrin.world.block.AgeableBushBlock;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.fluid.TWFluids;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Iterator;
import java.util.function.Supplier;

import static com.ametrinstudios.ametrin.world.block.helper.BlockBehaviourPropertiesHelper.CopyProperties;
import static com.ametrinstudios.ametrin.world.block.helper.BlockBehaviourPropertiesHelper.Properties;
import static com.ametrinstudios.ametrin.world.block.helper.BlockRegisterHelper.*;

public final class TWBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(TheWitcher.MOD_ID);

    private static final BlockBehaviour.Properties frostedProperties = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5f, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction());
    private static final BlockBehaviour.Properties frostedPropertiesNoCollision = CopyProperties(frostedProperties).noCollission();
    private static final BlockBehaviour.Properties cobbledFrostedProperties = CopyProperties(frostedProperties).destroyTime(2);
    private static final BlockBehaviour.Properties deepFrostedProperties = CopyProperties(frostedProperties).destroyTime(3).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());
    private static final BlockBehaviour.Properties deepFrostedPropertiesNoCollision = CopyProperties(deepFrostedProperties).noCollission();
    private static final BlockBehaviour.Properties deepCobbledFrostedProperties = CopyProperties(deepFrostedProperties).destroyTime(3.5f);
    private static final BlockBehaviour.Properties hallucinatedStoneProperties = Properties().mapColor(MapColor.COLOR_BLACK).strength(3, 9).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties hallucinatedStonePropertiesNoCollision = CopyProperties(hallucinatedStoneProperties).noCollission();

    public static final DeferredBlock<Block> SILVER_BLOCK = register("silver_block", ()-> new Block(CopyProperties(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = register("raw_silver_block", ()-> new Block(CopyProperties(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<TWMasterSmithingTableBlock> MASTER_SMITHING_TABLE = register("master_smithing_table", () -> new TWMasterSmithingTableBlock(CopyProperties(Blocks.SMITHING_TABLE)));

    public static final DeferredBlock<TWPowerBlock> POWER_BLOCK = register("power_block", ()-> new TWPowerBlock(CopyProperties(Blocks.GLASS).noLootTable()));

    public static final DeferredBlock<Block> FROSTED_COBBLESTONE = register("frosted_cobblestone", ()-> new Block(cobbledFrostedProperties));
    public static final DeferredBlock<StairBlock> FROSTED_COBBLESTONE_STAIRS = register("frosted_cobblestone_stairs", stair(cobbledFrostedProperties, () -> FROSTED_COBBLESTONE.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> FROSTED_COBBLESTONE_SLAB = register("frosted_cobblestone_slab", ()-> new SlabBlock(cobbledFrostedProperties));
    public static final DeferredBlock<WallBlock> FROSTED_COBBLESTONE_WALL = register("frosted_cobblestone_wall", ()-> new WallBlock(cobbledFrostedProperties));
    public static final DeferredBlock<ButtonBlock> FROSTED_COBBLESTONE_BUTTON = register("frosted_cobblestone_button", stoneButton());
    public static final DeferredBlock<Block> FROSTED_STONE = register("frosted_stone", ()-> new Block(frostedProperties));
    public static final DeferredBlock<StairBlock> FROSTED_STONE_STAIRS = register("frosted_stone_stairs", stair(frostedProperties, () -> FROSTED_STONE.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_SLAB = register("frosted_stone_slab", ()-> new SlabBlock(frostedProperties));
    public static final DeferredBlock<WallBlock> FROSTED_STONE_WALL = register("frosted_stone_wall", ()-> new WallBlock(frostedProperties));
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BUTTON = register("frosted_stone_button", stoneButton());
    public static final DeferredBlock<Block> FROSTED_STONE_BRICKS = register("frosted_stone_bricks", ()-> new Block(frostedProperties));
    public static final DeferredBlock<StairBlock> FROSTED_STONE_BRICK_STAIRS = register("frosted_stone_brick_stairs", stair(frostedProperties, () -> FROSTED_STONE_BRICKS.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_BRICK_SLAB = register("frosted_stone_brick_slab", ()-> new SlabBlock(frostedProperties));
    public static final DeferredBlock<WallBlock> FROSTED_STONE_BRICK_WALL = register("frosted_stone_brick_wall", ()-> new WallBlock(frostedProperties));
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BRICK_BUTTON = register("frosted_stone_brick_button", stoneButton());
    public static final DeferredBlock<Block> CRACKED_FROSTED_STONE_BRICKS = register("cracked_frosted_stone_bricks", ()-> new Block(frostedProperties));
    public static final DeferredBlock<StairBlock> CRACKED_FROSTED_STONE_BRICK_STAIRS = register("cracked_frosted_stone_brick_stairs", stair(frostedProperties, () -> CRACKED_FROSTED_STONE_BRICKS.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> CRACKED_FROSTED_STONE_BRICK_SLAB = register("cracked_frosted_stone_brick_slab", ()-> new SlabBlock(frostedProperties));
    public static final DeferredBlock<WallBlock> CRACKED_FROSTED_STONE_BRICK_WALL = register("cracked_frosted_stone_brick_wall", ()-> new WallBlock(frostedProperties));
    public static final DeferredBlock<ButtonBlock> CRACKED_FROSTED_STONE_BRICK_BUTTON = register("cracked_frosted_stone_brick_button", stoneButton());

    public static final DeferredBlock<Block> DeepFrostedCobblestone = register("deep_frosted_cobblestone", ()-> new Block(deepCobbledFrostedProperties));
    public static final DeferredBlock<StairBlock> DeepFrostedCobblestoneStairs = register("deep_frosted_cobblestone_stairs", stair(deepCobbledFrostedProperties, ()-> DeepFrostedCobblestone.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> DeepFrostedCobblestoneSlab = register("deep_frosted_cobblestone_slab", ()-> new SlabBlock(deepCobbledFrostedProperties));
    public static final DeferredBlock<WallBlock> DeepFrostedCobblestoneWall = register("deep_frosted_cobblestone_wall", ()-> new WallBlock(deepCobbledFrostedProperties));
    public static final DeferredBlock<ButtonBlock> DeepFrostedCobblestoneButton = register("deep_frosted_cobblestone_button", stoneButton());
    public static final DeferredBlock<Block> DeepFrostedStone = register("deep_frosted_stone", ()-> new Block(deepFrostedProperties));
    public static final DeferredBlock<StairBlock> DeepFrostedStoneStairs = register("deep_frosted_stone_stairs", stair(deepFrostedProperties, () -> DeepFrostedStone.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> DeepFrostedStoneSlab = register("deep_frosted_stone_slab", ()-> new SlabBlock(deepFrostedProperties));
    public static final DeferredBlock<WallBlock> DeepFrostedStoneWall = register("deep_frosted_stone_wall", ()-> new WallBlock(deepFrostedProperties));
    public static final DeferredBlock<ButtonBlock> DeepFrostedStoneButton = register("deep_frosted_stone_button", stoneButton());
    public static final DeferredBlock<Block> DeepFrostedStoneBricks = register("deep_frosted_stone_bricks", ()-> new Block(deepFrostedProperties));
    public static final DeferredBlock<StairBlock> DeepFrostedStoneBrickStairs = register("deep_frosted_stone_brick_stairs", stair(deepFrostedProperties, () -> DeepFrostedStoneBricks.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> DeepFrostedStoneBrickSlab = register("deep_frosted_stone_brick_slab", ()-> new SlabBlock(deepFrostedProperties));
    public static final DeferredBlock<WallBlock> DeepFrostedStoneBrickWall = register("deep_frosted_stone_brick_wall", ()-> new WallBlock(deepFrostedProperties));
    public static final DeferredBlock<ButtonBlock> DeepFrostedStoneBrickButton = register("deep_frosted_stone_brick_button", stoneButton());
    public static final DeferredBlock<Block> CrackedDeepFrostedStoneBricks = register("cracked_deep_frosted_stone_bricks", ()-> new Block(deepFrostedProperties));
    public static final DeferredBlock<StairBlock> CrackedDeepFrostedStoneBrickStairs = register("cracked_deep_frosted_stone_brick_stairs", stair(deepFrostedProperties, () -> CrackedDeepFrostedStoneBricks.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> CrackedDeepFrostedStoneBrickSlab = register("cracked_deep_frosted_stone_brick_slab", ()-> new SlabBlock(deepFrostedProperties));
    public static final DeferredBlock<WallBlock> CrackedDeepFrostedStoneBrickWall = register("cracked_deep_frosted_stone_brick_wall", ()-> new WallBlock(deepFrostedProperties));
    public static final DeferredBlock<ButtonBlock> CrackedDeepFrostedStoneBrickButton = register("cracked_deep_frosted_stone_brick_button", stoneButton());
    public static final DeferredBlock<Block> DeepFrostedStoneTiles = register("deep_frosted_stone_tiles", ()-> new Block(deepFrostedProperties));
    public static final DeferredBlock<StairBlock> DeepFrostedStoneTileStairs = register("deep_frosted_stone_tile_stairs", stair(deepFrostedProperties, () -> DeepFrostedStoneTiles.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> DeepFrostedStoneTileSlab = register("deep_frosted_stone_tile_slab", ()-> new SlabBlock(deepFrostedProperties));
    public static final DeferredBlock<WallBlock> DeepFrostedStoneTileWall = register("deep_frosted_stone_tile_wall", ()-> new WallBlock(deepFrostedProperties));
    public static final DeferredBlock<ButtonBlock> DeepFrostedStoneTileButton = register("deep_frosted_stone_tile_button", stoneButton());
    public static final DeferredBlock<Block> CrackedDeepFrostedStoneTiles = register("cracked_deep_frosted_stone_tiles", ()-> new Block(deepFrostedProperties));
    public static final DeferredBlock<StairBlock> CrackedDeepFrostedStoneTileStairs = register("cracked_deep_frosted_stone_tile_stairs", stair(deepFrostedProperties, () -> CrackedDeepFrostedStoneTiles.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> CrackedDeepFrostedStoneTileSlab = register("cracked_deep_frosted_stone_tile_slab", ()-> new SlabBlock(deepFrostedProperties));
    public static final DeferredBlock<WallBlock> CrackedDeepFrostedStoneTileWall = register("cracked_deep_frosted_stone_tile_wall", ()-> new WallBlock(deepFrostedProperties));
    public static final DeferredBlock<ButtonBlock> CrackedDeepFrostedStoneTileButton = register("cracked_deep_frosted_stone_tile_button", stoneButton());

    public static final DeferredBlock<TWIcicleBlock> ICICLE = register("icicle", ()-> new TWIcicleBlock(CopyProperties(Blocks.POINTED_DRIPSTONE).sound(SoundType.GLASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<TWLarimar> LARIMAR = register("larimar", ()-> new TWLarimar(Properties().lightLevel(emission(13)).strength(0, 10).sound(SoundType.AMETHYST_CLUSTER).emissiveRendering((blockState, level, pos)-> true).noCollission()));

    public static final DeferredBlock<TWWhiteFrostPortalBlock> WHITE_FROST_PORTAL = registerWithoutItem("white_frost_portal", TWWhiteFrostPortalBlock::new);
    public static final DeferredBlock<Block> WHITE_FROST_PORTAL_FRAME = register("white_frost_portal_frame", ()-> new Block(CopyProperties(Blocks.OBSIDIAN).noLootTable()));

    public static final DeferredBlock<AgeableBushBlock> WHITE_MYRTLE_BUSH = registerWithoutItem("white_myrtle_bush", bush(1, 6));
    public static final DeferredBlock<AgeableBushBlock> CELANDINE_BUSH = registerWithoutItem("celandine_bush", bush(0,12));

    public static final DeferredBlock<LiquidBlock> ACID = registerWithoutItem("acid", ()-> new LiquidBlock(TWFluids.SOURCE_ACID.get(), CopyProperties(Blocks.WATER).lightLevel(emission(5)).noLootTable()));
    public static final DeferredBlock<Block> HALLUCINATED_STONE = register("hallucinated_stone", ()-> new Block(hallucinatedStoneProperties));
    public static final DeferredBlock<StairBlock> HALLUCINATED_STONE_STAIRS = register("hallucinated_stone_stairs", stair(hallucinatedStoneProperties, ()-> HALLUCINATED_STONE.get().defaultBlockState()));
    public static final DeferredBlock<SlabBlock> HALLUCINATED_STONE_SLAB = register("hallucinated_stone_slab", ()-> new SlabBlock(hallucinatedStoneProperties));
    public static final DeferredBlock<WallBlock> HALLUCINATED_STONE_WALL = register("hallucinated_stone_wall", ()-> new WallBlock(hallucinatedStoneProperties));
    public static final DeferredBlock<ButtonBlock> HALLUCINATED_STONE_BUTTON = register("hallucinated_stone_button", stoneButton());
    public static final DeferredBlock<Block> ALCITE = register("alcite", ()-> new Block(CopyProperties(HALLUCINATED_STONE.get()).lightLevel(emission(4))));

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block){
        var registered = registerWithoutItem(name, block);
        TWItems.REGISTER.register(name, () -> new BlockItem(registered.get(), TWItems.DEFAULT_PROPERTIES));
        return registered;
    }

    private static <T extends Block> DeferredBlock<T> registerWithoutItem(String name, Supplier<T> block) {return REGISTER.register(name, block);}
    public static Iterator<? extends Block> getAllBlocks() {
        return REGISTER.getEntries().stream().map(DeferredHolder::get).iterator();
    }
}