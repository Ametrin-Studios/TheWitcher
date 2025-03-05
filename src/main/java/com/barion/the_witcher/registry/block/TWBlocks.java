package com.barion.the_witcher.registry.block;

import com.ametrinstudios.ametrin.world.block.AgeableBushBlock;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.fluid.TWFluids;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Iterator;
import java.util.function.Function;

import static com.ametrinstudios.ametrin.world.block.helper.BlockBehaviourPropertiesHelper.copyProperties;
import static com.ametrinstudios.ametrin.world.block.helper.BlockBehaviourPropertiesHelper.properties;
import static com.ametrinstudios.ametrin.world.block.helper.BlockRegisterHelper.*;

public final class TWBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(TheWitcher.MOD_ID);

    private static final BlockBehaviour.Properties FROSTED_PROPERTIES = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5f, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction());
    private static final BlockBehaviour.Properties COBBLED_FROSTED_PROPERTIES = copyProperties(FROSTED_PROPERTIES).destroyTime(2);
    private static final BlockBehaviour.Properties DEEP_FROSTED_PROPERTIES = copyProperties(FROSTED_PROPERTIES).destroyTime(3).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());
    private static final BlockBehaviour.Properties DEEP_COBBLED_FROSTED_PROPERTIES = copyProperties(DEEP_FROSTED_PROPERTIES).destroyTime(3.5f);
    private static final BlockBehaviour.Properties HALLUCINATED_STONE_PROPERTIES = properties().mapColor(MapColor.COLOR_BLACK).strength(3, 9).requiresCorrectToolForDrops();

    public static final DeferredBlock<Block> SILVER_BLOCK = registerSimpleWithItem("silver_block", copyProperties(Blocks.IRON_BLOCK));
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerSimpleWithItem("raw_silver_block", copyProperties(Blocks.RAW_IRON_BLOCK));
    public static final DeferredBlock<TWMasterSmithingTableBlock> MASTER_SMITHING_TABLE = registerWithItem("master_smithing_table", TWMasterSmithingTableBlock::new, copyProperties(Blocks.SMITHING_TABLE));

    public static final DeferredBlock<TWPowerBlock> POWER_BLOCK = registerWithItem("power_block", TWPowerBlock::new, copyProperties(Blocks.GLASS).noLootTable());

    public static final DeferredBlock<Block> FROSTED_COBBLESTONE = registerSimpleWithItem("frosted_cobblestone", COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> FROSTED_COBBLESTONE_STAIRS = registerWithItem("frosted_cobblestone_stairs", stair(()-> FROSTED_COBBLESTONE.get().defaultBlockState()), COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> FROSTED_COBBLESTONE_SLAB = registerWithItem("frosted_cobblestone_slab", SlabBlock::new, COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> FROSTED_COBBLESTONE_WALL = registerWithItem("frosted_cobblestone_wall", WallBlock::new, COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> FROSTED_COBBLESTONE_BUTTON = registerStoneButton("frosted_cobblestone_button", TWBlockSetTypes.FROSTED_COBBLESTONE);
    public static final DeferredBlock<Block> FROSTED_STONE = registerSimpleWithItem("frosted_stone", FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> FROSTED_STONE_STAIRS = registerWithItem("frosted_stone_stairs", stair(()-> FROSTED_STONE.get().defaultBlockState()), FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_SLAB = registerWithItem("frosted_stone_slab", SlabBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> FROSTED_STONE_WALL = registerWithItem("frosted_stone_wall", WallBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BUTTON = registerStoneButton("frosted_stone_button", TWBlockSetTypes.FROSTED_STONE);
    public static final DeferredBlock<Block> FROSTED_STONE_BRICKS = registerWithItem("frosted_stone_bricks", Block::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> FROSTED_STONE_BRICK_STAIRS = registerWithItem("frosted_stone_brick_stairs", stair(()-> FROSTED_STONE_BRICKS.get().defaultBlockState()), FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> FROSTED_STONE_BRICK_SLAB = registerWithItem("frosted_stone_brick_slab", SlabBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> FROSTED_STONE_BRICK_WALL = registerWithItem("frosted_stone_brick_wall", WallBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> FROSTED_STONE_BRICK_BUTTON = registerStoneButton("frosted_stone_brick_button", TWBlockSetTypes.FROSTED_STONE);
    public static final DeferredBlock<Block> CRACKED_FROSTED_STONE_BRICKS = registerWithItem("cracked_frosted_stone_bricks", Block::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> CRACKED_FROSTED_STONE_BRICK_STAIRS = registerWithItem("cracked_frosted_stone_brick_stairs", stair(()-> CRACKED_FROSTED_STONE_BRICKS.get().defaultBlockState()), FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> CRACKED_FROSTED_STONE_BRICK_SLAB = registerWithItem("cracked_frosted_stone_brick_slab", SlabBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> CRACKED_FROSTED_STONE_BRICK_WALL = registerWithItem("cracked_frosted_stone_brick_wall", WallBlock::new, FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> CRACKED_FROSTED_STONE_BRICK_BUTTON = registerStoneButton("cracked_frosted_stone_brick_button", TWBlockSetTypes.FROSTED_STONE);

    public static final DeferredBlock<Block> DEEP_FROSTED_COBBLESTONE = registerSimpleWithItem("deep_frosted_cobblestone", DEEP_COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_COBBLESTONE_STAIRS = registerWithItem("deep_frosted_cobblestone_stairs", stair(()-> DEEP_FROSTED_COBBLESTONE.get().defaultBlockState()), DEEP_COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_COBBLESTONE_SLAB = registerWithItem("deep_frosted_cobblestone_slab", SlabBlock::new, DEEP_COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_COBBLESTONE_WALL = registerWithItem("deep_frosted_cobblestone_wall", WallBlock::new, DEEP_COBBLED_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_COBBLESTONE_BUTTON = registerStoneButton("deep_frosted_cobblestone_button", TWBlockSetTypes.DEEP_FROSTED_COBBLESTONE);
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE = registerSimpleWithItem("deep_frosted_stone", DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_STAIRS = registerWithItem("deep_frosted_stone_stairs", stair(()-> DEEP_FROSTED_STONE.get().defaultBlockState()), DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_SLAB = registerWithItem("deep_frosted_stone_slab", SlabBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_WALL = registerWithItem("deep_frosted_stone_wall", WallBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_BUTTON = registerStoneButton("deep_frosted_stone_button", TWBlockSetTypes.DEEP_FROSTED_STONE);
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE_BRICKS = registerSimpleWithItem("deep_frosted_stone_bricks", DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_BRICK_STAIRS = registerWithItem("deep_frosted_stone_brick_stairs", stair(()-> DEEP_FROSTED_STONE_BRICKS.get().defaultBlockState()), DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_BRICK_SLAB = registerWithItem("deep_frosted_stone_brick_slab", SlabBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_BRICK_WALL = registerWithItem("deep_frosted_stone_brick_wall", WallBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_BRICK_BUTTON = registerStoneButton("deep_frosted_stone_brick_button", TWBlockSetTypes.DEEP_FROSTED_STONE);
    public static final DeferredBlock<Block> CRACKED_DEEP_FROSTED_STONE_BRICKS = registerSimpleWithItem("cracked_deep_frosted_stone_bricks", DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS = registerWithItem("cracked_deep_frosted_stone_brick_stairs", stair(()-> CRACKED_DEEP_FROSTED_STONE_BRICKS.get().defaultBlockState()), DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB = registerWithItem("cracked_deep_frosted_stone_brick_slab", SlabBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_WALL = registerWithItem("cracked_deep_frosted_stone_brick_wall", WallBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON = registerStoneButton("cracked_deep_frosted_stone_brick_button", TWBlockSetTypes.DEEP_FROSTED_STONE);
    public static final DeferredBlock<Block> DEEP_FROSTED_STONE_TILES = registerSimpleWithItem("deep_frosted_stone_tiles", DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> DEEP_FROSTED_STONE_TILE_STAIRS = registerWithItem("deep_frosted_stone_tile_stairs", stair(()-> DEEP_FROSTED_STONE_TILES.get().defaultBlockState()), DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> DEEP_FROSTED_STONE_TILE_SLAB = registerWithItem("deep_frosted_stone_tile_slab", SlabBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> DEEP_FROSTED_STONE_TILE_WALL = registerWithItem("deep_frosted_stone_tile_wall", WallBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> DEEP_FROSTED_STONE_TILE_BUTTON = registerStoneButton("deep_frosted_stone_tile_button", TWBlockSetTypes.DEEP_FROSTED_STONE);
    public static final DeferredBlock<Block> CRACKED_DEEP_FROSTED_STONE_TILES = registerSimpleWithItem("cracked_deep_frosted_stone_tiles", DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<StairBlock> CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS = registerWithItem("cracked_deep_frosted_stone_tile_stairs", stair(()-> CRACKED_DEEP_FROSTED_STONE_TILES.get().defaultBlockState()), DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<SlabBlock> CRACKED_DEEP_FROSTED_STONE_TILE_SLAB = registerWithItem("cracked_deep_frosted_stone_tile_slab", SlabBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<WallBlock> CRACKED_DEEP_FROSTED_STONE_TILE_WALL = registerWithItem("cracked_deep_frosted_stone_tile_wall", WallBlock::new, DEEP_FROSTED_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON = registerStoneButton("cracked_deep_frosted_stone_tile_button", TWBlockSetTypes.DEEP_FROSTED_STONE);

    public static final DeferredBlock<TWIcicleBlock> ICICLE = registerWithItem("icicle", TWIcicleBlock::new, copyProperties(Blocks.POINTED_DRIPSTONE).sound(SoundType.GLASS).offsetType(BlockBehaviour.OffsetType.XZ));
    public static final DeferredBlock<TWLarimar> LARIMAR = registerWithItem("larimar", TWLarimar::new, properties().lightLevel(emission(13)).strength(0, 10).sound(SoundType.AMETHYST_CLUSTER).emissiveRendering((blockState, level, pos) -> true).noCollission());

    public static final DeferredBlock<TWWhiteFrostPortalBlock> WHITE_FROST_PORTAL = REGISTER.registerBlock("white_frost_portal", TWWhiteFrostPortalBlock::new, copyProperties(Blocks.NETHER_PORTAL).noLootTable());
    public static final DeferredBlock<Block> WHITE_FROST_PORTAL_FRAME = REGISTER.registerSimpleBlock("white_frost_portal_frame", copyProperties(Blocks.OBSIDIAN).noLootTable());

    public static final DeferredBlock<AgeableBushBlock> WHITE_MYRTLE_BUSH = REGISTER.registerBlock("white_myrtle_bush", (properties) -> new AgeableBushBlock(1, 6, properties), copyProperties(Blocks.SWEET_BERRY_BUSH));
    public static final DeferredBlock<AgeableBushBlock> CELANDINE_BUSH = REGISTER.registerBlock("celandine_bush", properties -> new AgeableBushBlock(0, 12, properties), copyProperties(Blocks.SWEET_BERRY_BUSH));

    public static final DeferredBlock<LiquidBlock> ACID = REGISTER.registerBlock("acid", properties -> new LiquidBlock(TWFluids.SOURCE_ACID.get(), properties), copyProperties(Blocks.WATER).lightLevel(emission(5)));
    public static final DeferredBlock<Block> HALLUCINATED_STONE = registerSimpleWithItem("hallucinated_stone", HALLUCINATED_STONE_PROPERTIES);
    public static final DeferredBlock<StairBlock> HALLUCINATED_STONE_STAIRS = registerWithItem("hallucinated_stone_stairs", stair(()-> HALLUCINATED_STONE.get().defaultBlockState()), HALLUCINATED_STONE_PROPERTIES);
    public static final DeferredBlock<SlabBlock> HALLUCINATED_STONE_SLAB = registerWithItem("hallucinated_stone_slab", SlabBlock::new, HALLUCINATED_STONE_PROPERTIES);
    public static final DeferredBlock<WallBlock> HALLUCINATED_STONE_WALL = registerWithItem("hallucinated_stone_wall", WallBlock::new, HALLUCINATED_STONE_PROPERTIES);
    public static final DeferredBlock<ButtonBlock> HALLUCINATED_STONE_BUTTON = registerStoneButton("hallucinated_stone_button", TWBlockSetTypes.HALLUCINATED_STONE);
    public static final DeferredBlock<Block> ALCITE = registerSimpleWithItem("alcite", copyProperties(HALLUCINATED_STONE_PROPERTIES).lightLevel(emission(4)));

    private static DeferredBlock<ButtonBlock> registerStoneButton(String name, BlockSetType type) {
        return registerButton(name, type, STONE_BUTTON_TICKS_PRESSED);
    }

    private static DeferredBlock<ButtonBlock> registerButton(String name, BlockSetType type, int ticksToStayPressed) {
        return registerWithItem(name, properties -> new ButtonBlock(type, ticksToStayPressed, properties), buttonProperties());
    }

    private static <T extends Block> DeferredBlock<T> registerWithItem(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        var registered = REGISTER.registerBlock(name, factory, properties);
        TWItems.REGISTER.registerSimpleBlockItem(name, registered);
        return registered;
    }

    private static DeferredBlock<Block> registerSimpleWithItem(String name, BlockBehaviour.Properties properties) {
        var registered = REGISTER.registerSimpleBlock(name, properties);
        TWItems.REGISTER.registerSimpleBlockItem(name, registered);
        return registered;
    }

    public static Iterator<? extends Block> getAllBlocks() {
        return REGISTER.getEntries().stream().map(DeferredHolder::get).iterator();
    }
}