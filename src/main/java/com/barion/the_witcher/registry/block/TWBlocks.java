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

import static com.ametrinstudios.ametrin.world.block.helper.BlockBehaviourPropertiesHelper.*;
import static com.ametrinstudios.ametrin.world.block.helper.BlockRegisterHelper.*;

public final class TWBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(TheWitcher.MOD_ID);

    private static final BlockBehaviour.Properties FROSTED_PROPERTIES = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5f, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction());
    private static final BlockBehaviour.Properties COBBLED_FROSTED_PROPERTIES = copyProperties(FROSTED_PROPERTIES).destroyTime(2);
    private static final BlockBehaviour.Properties DEEP_FROSTED_PROPERTIES = copyProperties(FROSTED_PROPERTIES).destroyTime(3).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());
    private static final BlockBehaviour.Properties DEEP_COBBLED_FROSTED_PROPERTIES = copyProperties(DEEP_FROSTED_PROPERTIES).destroyTime(3.5f);
    private static final BlockBehaviour.Properties HALLUCINATED_STONE_PROPERTIES = properties().mapColor(MapColor.COLOR_BLACK).strength(3, 9).requiresCorrectToolForDrops();

    public static final DeferredBlock<Block> SILVER_BLOCK = register("silver_block", ()-> new Block(copyProperties(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = register("raw_silver_block", ()-> new Block(copyProperties(Blocks.RAW_IRON_BLOCK)));
    public static final DeferredBlock<TWMasterSmithingTableBlock> MASTER_SMITHING_TABLE = register("master_smithing_table", () -> new TWMasterSmithingTableBlock(copyProperties(Blocks.SMITHING_TABLE)));

    public static final DeferredBlock<TWPowerBlock> POWER_BLOCK = register("power_block", ()-> new TWPowerBlock(copyProperties(Blocks.GLASS).noLootTable()));

    public static final DeferredBlock<Block> FROSTED_COBBLESTONE = register("frosted_cobblestone", ()-> new Block(COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> FROSTED_COBBLESTONE_STAIRS = register("frosted_cobblestone_stairs", ()-> stair(FROSTED_COBBLESTONE.get().defaultBlockState(), COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> FROSTED_COBBLESTONE_SLAB = register("frosted_cobblestone_slab", ()-> new SlabBlock(COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> FROSTED_COBBLESTONE_WALL = register("frosted_cobblestone_wall", ()-> new WallBlock(COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> FROSTED_COBBLESTONE_BUTTON = register("frosted_cobblestone_button", ()-> stoneButton());
    public static final DeferredBlock<Block> FROSTED_STONE = register("frosted_stone", ()-> new Block(FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> FROSTED_STONE_STAIRS = register("frosted_stone_stairs", ()-> stair(FROSTED_STONE.get().defaultBlockState(), FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_SLAB = register("frosted_stone_slab", ()-> new SlabBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> FROSTED_STONE_WALL = register("frosted_stone_wall", ()-> new WallBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BUTTON = register("frosted_stone_button", ()-> stoneButton());
    public static final DeferredBlock<Block> FROSTED_STONE_BRICKS = register("frosted_stone_bricks", ()-> new Block(FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> FROSTED_STONE_BRICK_STAIRS = register("frosted_stone_brick_stairs", ()-> stair(FROSTED_STONE_BRICKS.get().defaultBlockState(), FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_BRICK_SLAB = register("frosted_stone_brick_slab", ()-> new SlabBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> FROSTED_STONE_BRICK_WALL = register("frosted_stone_brick_wall", ()-> new WallBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BRICK_BUTTON = register("frosted_stone_brick_button", ()-> stoneButton());
    public static final DeferredBlock<Block> CRACKED_FROSTED_STONE_BRICKS = register("cracked_frosted_stone_bricks", ()-> new Block(FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> CRACKED_FROSTED_STONE_BRICK_STAIRS = register("cracked_frosted_stone_brick_stairs", ()-> stair(CRACKED_FROSTED_STONE_BRICKS.get().defaultBlockState(), FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> CRACKED_FROSTED_STONE_BRICK_SLAB = register("cracked_frosted_stone_brick_slab", ()-> new SlabBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> CRACKED_FROSTED_STONE_BRICK_WALL = register("cracked_frosted_stone_brick_wall", ()-> new WallBlock(FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> CRACKED_FROSTED_STONE_BRICK_BUTTON = register("cracked_frosted_stone_brick_button", ()-> stoneButton());

    public static final DeferredBlock<Block> DEEP_FROSTED_COBBLESTONE = register("deep_frosted_cobblestone", ()-> new Block(DEEP_COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_COBBLESTONE_STAIRS = register("deep_frosted_cobblestone_stairs", ()-> stair(DEEP_FROSTED_COBBLESTONE.get().defaultBlockState(), DEEP_COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_COBBLESTONE_SLAB = register("deep_frosted_cobblestone_slab", ()-> new SlabBlock(DEEP_COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_COBBLESTONE_WALL = register("deep_frosted_cobblestone_wall", ()-> new WallBlock(DEEP_COBBLED_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_COBBLESTONE_BUTTON = register("deep_frosted_cobblestone_button", ()-> stoneButton());
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE = register("deep_frosted_stone", ()-> new Block(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_STAIRS = register("deep_frosted_stone_stairs", ()-> stair(DEEP_FROSTED_STONE.get().defaultBlockState(), DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_SLAB = register("deep_frosted_stone_slab", ()-> new SlabBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_WALL = register("deep_frosted_stone_wall", ()-> new WallBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_BUTTON = register("deep_frosted_stone_button", ()-> stoneButton());
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE_BRICKS = register("deep_frosted_stone_bricks", ()-> new Block(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_BRICK_STAIRS = register("deep_frosted_stone_brick_stairs", ()-> stair(DEEP_FROSTED_STONE_BRICKS.get().defaultBlockState(), DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_BRICK_SLAB = register("deep_frosted_stone_brick_slab", ()-> new SlabBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_BRICK_WALL = register("deep_frosted_stone_brick_wall", ()-> new WallBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_BRICK_BUTTON = register("deep_frosted_stone_brick_button", ()-> stoneButton());
    public static final DeferredBlock<Block> CRACKED_DEEP_FROSTED_STONE_BRICKS = register("cracked_deep_frosted_stone_bricks", ()-> new Block(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS = register("cracked_deep_frosted_stone_brick_stairs", ()-> stair(CRACKED_DEEP_FROSTED_STONE_BRICKS.get().defaultBlockState(), DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB = register("cracked_deep_frosted_stone_brick_slab", ()-> new SlabBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_WALL = register("cracked_deep_frosted_stone_brick_wall", ()-> new WallBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON = register("cracked_deep_frosted_stone_brick_button", ()-> stoneButton());
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE_TILES = register("deep_frosted_stone_tiles", ()-> new Block(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_TILE_STAIRS = register("deep_frosted_stone_tile_stairs", ()-> stair(DEEP_FROSTED_STONE_TILES.get().defaultBlockState(), DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_TILE_SLAB = register("deep_frosted_stone_tile_slab", ()-> new SlabBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_TILE_WALL = register("deep_frosted_stone_tile_wall", ()-> new WallBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_TILE_BUTTON = register("deep_frosted_stone_tile_button", ()-> stoneButton());
    public static final DeferredBlock<Block> CRACKED_DEEP_FROSTED_STONE_TILES = register("cracked_deep_frosted_stone_tiles", ()-> new Block(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<StairBlock> CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS = register("cracked_deep_frosted_stone_tile_stairs", ()-> stair(CRACKED_DEEP_FROSTED_STONE_TILES.get().defaultBlockState(), DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<SlabBlock> CRACKED_DEEP_FROSTED_STONE_TILE_SLAB = register("cracked_deep_frosted_stone_tile_slab", ()-> new SlabBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<WallBlock> CRACKED_DEEP_FROSTED_STONE_TILE_WALL = register("cracked_deep_frosted_stone_tile_wall", ()-> new WallBlock(DEEP_FROSTED_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON = register("cracked_deep_frosted_stone_tile_button", ()-> stoneButton());

    public static final DeferredBlock<TWIcicleBlock> ICICLE = register("icicle", ()-> new TWIcicleBlock(copyProperties(Blocks.POINTED_DRIPSTONE).sound(SoundType.GLASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<TWLarimar> LARIMAR = register("larimar", ()-> new TWLarimar(properties().lightLevel(emission(13)).strength(0, 10).sound(SoundType.AMETHYST_CLUSTER).emissiveRendering((blockState, level, pos)-> true).noCollission()));

    public static final DeferredBlock<TWWhiteFrostPortalBlock> WHITE_FROST_PORTAL = REGISTER.register("white_frost_portal", TWWhiteFrostPortalBlock::new);
    public static final DeferredBlock<Block> WHITE_FROST_PORTAL_FRAME = register("white_frost_portal_frame", ()-> new Block(copyProperties(Blocks.OBSIDIAN).noLootTable()));

    public static final DeferredBlock<AgeableBushBlock> WHITE_MYRTLE_BUSH = REGISTER.register("white_myrtle_bush", ()-> bush(1, 6));
    public static final DeferredBlock<AgeableBushBlock> CELANDINE_BUSH = REGISTER.register("celandine_bush", ()-> bush(0,12));

    public static final DeferredBlock<LiquidBlock> ACID = REGISTER.register("acid", ()-> new LiquidBlock(TWFluids.SOURCE_ACID.get(), copyProperties(Blocks.WATER).lightLevel(emission(5)).noLootTable()));
    public static final DeferredBlock<Block> HALLUCINATED_STONE = register("hallucinated_stone", ()-> new Block(HALLUCINATED_STONE_PROPERTIES));
    public static final DeferredBlock<StairBlock> HALLUCINATED_STONE_STAIRS = register("hallucinated_stone_stairs", ()-> stair(HALLUCINATED_STONE.get().defaultBlockState(), HALLUCINATED_STONE_PROPERTIES));
    public static final DeferredBlock<SlabBlock> HALLUCINATED_STONE_SLAB = register("hallucinated_stone_slab", ()-> new SlabBlock(HALLUCINATED_STONE_PROPERTIES));
    public static final DeferredBlock<WallBlock> HALLUCINATED_STONE_WALL = register("hallucinated_stone_wall", ()-> new WallBlock(HALLUCINATED_STONE_PROPERTIES));
    public static final DeferredBlock<ButtonBlock> HALLUCINATED_STONE_BUTTON = register("hallucinated_stone_button", ()-> stoneButton());
    public static final DeferredBlock<Block> ALCITE = register("alcite", ()-> new Block(copyProperties(HALLUCINATED_STONE.get()).lightLevel(emission(4))));

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        var registered = REGISTER.register(name, block);
        TWItems.REGISTER.register(name, () -> new BlockItem(registered.get(), TWItems.DEFAULT_PROPERTIES));
        return registered;
    }

    public static Iterator<? extends Block> getAllBlocks() {
        return REGISTER.getEntries().stream().map(DeferredHolder::get).iterator();
    }
}