package com.barion.the_witcher.data.provider;

import com.ametrinstudios.ametrin.data.provider.ExtendedModelProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlockFamilies;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public final class TWModelProvider extends ExtendedModelProvider {
    public static final ModelTemplate BIG_SWORD_TEMPLATE = new ModelTemplate(Optional.of(TheWitcher.locate("item/big_sword")), Optional.empty(), TextureSlot.LAYER0);

    public TWModelProvider(PackOutput output) {
        super(output, TheWitcher.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Blocks

        blockModels.createTrivialCube(TWBlocks.SILVER_BLOCK.get());
        blockModels.createTrivialCube(TWBlocks.RAW_SILVER_BLOCK.get());
        masterSmithingTableBlock(blockModels, TWBlocks.MASTER_SMITHING_TABLE.get());

        powerBlock(blockModels, TWBlocks.POWER_BLOCK.get());

        blockModels.family(TWBlocks.FROSTED_COBBLESTONE.get()).generateFor(TWBlockFamilies.FROSTED_COBBLESTONE);
        blockModels.family(TWBlocks.FROSTED_STONE.get()).generateFor(TWBlockFamilies.FROSTED_STONE);
        blockModels.family(TWBlocks.FROSTED_STONE_BRICKS.get()).generateFor(TWBlockFamilies.FROSTED_STONE_BRICKS);
        blockModels.familyWithExistingFullBlock(TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get()).generateFor(TWBlockFamilies.CRACKED_FROSTED_STONE_BRICKS);

        blockModels.family(TWBlocks.DEEP_FROSTED_COBBLESTONE.get()).generateFor(TWBlockFamilies.DEEP_FROSTED_COBBLESTONE);
        blockModels.family(TWBlocks.DEEP_FROSTED_STONE.get()).generateFor(TWBlockFamilies.DEEP_FROSTED_STONE);
        blockModels.family(TWBlocks.DEEP_FROSTED_STONE_BRICKS.get()).generateFor(TWBlockFamilies.DEEP_FROSTED_STONE_BRICKS);
        blockModels.familyWithExistingFullBlock(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get()).generateFor(TWBlockFamilies.CRACKED_DEEP_FROSTED_STONE_BRICKS);
        blockModels.family(TWBlocks.DEEP_FROSTED_STONE_TILES.get()).generateFor(TWBlockFamilies.DEEP_FROSTED_STONE_TILES);
        blockModels.familyWithExistingFullBlock(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES.get()).generateFor(TWBlockFamilies.CRACKED_DEEP_FROSTED_STONE_TILES);

        icicleBlock(blockModels, TWBlocks.ICICLE.get());

        createPlanePortalBlock(blockModels, TWBlocks.WHITE_FROST_PORTAL.get());
        blockModels.createTrivialCube(TWBlocks.WHITE_FROST_PORTAL_FRAME.get());

        createAgeableBush(blockModels, TWBlocks.WHITE_MYRTLE_BUSH.get());
        createAgeableBush(blockModels, TWBlocks.CELANDINE_BUSH.get());

        blockModels.createNonTemplateModelBlock(TWBlocks.ACID.get());
        blockModels.family(TWBlocks.HALLUCINATED_STONE.get()).generateFor(TWBlockFamilies.HALLUCINATED_STONE);
        blockModels.createTrivialCube(TWBlocks.ALCITE.get());

        // Items

        itemModels.generateFlatItem(TWItems.TAB_LOGO.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TWItems.RAW_SILVER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.SILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.SILVER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.SILVER_SWORD.get(), BIG_SWORD_TEMPLATE);
        itemModels.generateFlatItem(TWItems.MASTERFUL_SILVER_SWORD.get(), BIG_SWORD_TEMPLATE);

        itemModels.generateFlatItem(TWItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.STEEL_SWORD.get(), BIG_SWORD_TEMPLATE);
        itemModels.generateFlatItem(TWItems.MASTERFUL_STEEL_SWORD.get(), BIG_SWORD_TEMPLATE);
        itemModels.generateFlatItem(TWItems.REINFORCED_LEATHER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.REINFORCED_LEATHER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.REINFORCED_LEATHER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.REINFORCED_LEATHER_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TWItems.KIKIMORA_TOOTH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.WHITE_MYRTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.CELANDINE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.HOT_WATER_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TWItems.BEER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateSpawnEgg(TWItems.ICE_GHOST_SPAWN_EGG.get(), -13369345, -16776961);
        itemModels.generateSpawnEgg(TWItems.WILD_HUNT_KNIGHT_SPAWN_EGG.get(), -16777216, -6684673);
        itemModels.generateSpawnEgg(TWItems.WILD_HUNT_HOUND_SPAWN_EGG.get(), -13421773, -16737895);

        itemModels.generateFlatItem(TWItems.ICE_STAFF.get(), ModelTemplates.FLAT_ITEM);
    }

    private void powerBlock(BlockModelGenerators blockModels, TWPowerBlock powerBlock) {
        var texture = TextureMapping.getBlockTexture(powerBlock);

        var mappingOn = new TextureMapping().put(TextureSlot.PARTICLE, texture.withSuffix("/on")).put(TextureSlot.ALL, texture.withSuffix("/on"));
        var mappingOff = new TextureMapping().put(TextureSlot.PARTICLE, texture.withSuffix("/off")).put(TextureSlot.ALL, texture.withSuffix("/off"));

        var on = ModelTemplates.CUBE_ALL.createWithSuffix(powerBlock, "/on", mappingOn, blockModels.modelOutput);
        var off = ModelTemplates.CUBE_ALL.createWithSuffix(powerBlock, "/off", mappingOff, blockModels.modelOutput);

        blockModels.registerSimpleItemModel(powerBlock, on);
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(powerBlock)
                .with(PropertyDispatch.property(TWPowerBlock.HAS_POWER)
                        .select(true, Variant.variant().with(VariantProperties.MODEL, on))
                        .select(false, Variant.variant().with(VariantProperties.MODEL, off))
                )
        );
    }

    private void masterSmithingTableBlock(BlockModelGenerators blockModels, TWMasterSmithingTableBlock block) {
        var texture = TextureMapping.getBlockTexture(block);

        var top = texture.withSuffix("_top");
        var bottom = texture.withSuffix("_bottom");
        var front = texture.withSuffix("_front");
        var side = texture.withSuffix("_side");

        var mapping = new TextureMapping()
                .put(TextureSlot.PARTICLE, top)
                .put(TextureSlot.TOP, top)
                .put(TextureSlot.BOTTOM, bottom)
                .put(TextureSlot.FRONT, front)
                .put(TextureSlot.SIDE, side);

        var model = ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM.create(block, mapping, blockModels.modelOutput);

        blockModels.registerSimpleItemModel(block, model);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
    }

//    public static void larimarBlock(BlockModelGenerators blockModels, TWLarimar block) {
//        var model = TheWitcher.locate("models/block/larimar");
//        blockModels.exi();
//    }

    public static void icicleBlock(BlockModelGenerators blockModels, TWIcicleBlock block) {
        var propertyDispatch = PropertyDispatch.properties(
                BlockStateProperties.VERTICAL_DIRECTION, BlockStateProperties.DRIPSTONE_THICKNESS
        );

        for (DripstoneThickness dripstonethickness : DripstoneThickness.values()) {
            propertyDispatch = propertyDispatch.select(Direction.UP, dripstonethickness, icicleBlockVariant(blockModels, block, Direction.UP, dripstonethickness));
            propertyDispatch = propertyDispatch.select(Direction.DOWN, dripstonethickness, icicleBlockVariant(blockModels, block, Direction.DOWN, dripstonethickness));
        }

        blockModels.registerSimpleFlatItemModel(block, "/down/tip");
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(propertyDispatch));
    }

    public void createAgeableBush(BlockModelGenerators blockModels, Block block) {
        var model = ModelTemplates.CROSS.extend().renderType("cutout").build();

        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.AGE_3)
                        .generate(value -> Variant.variant()
                                .with(VariantProperties.MODEL, value > 2
                                        ? blockModels.createSuffixedVariant(block, "/stage" + value, model, TextureMapping::cross)
                                        : model.createWithSuffix(block, "/stage" + value, TextureMapping.cross(TextureMapping.getBlockTexture(Blocks.SWEET_BERRY_BUSH, "_stage"+value)), blockModels.modelOutput)
                                )
                        )
                )
        );
    }

    private static final ModelTemplate ICICLE_TEMPLATE = ModelTemplates.POINTED_DRIPSTONE.extend().renderType("cutout").build();

    private static Variant icicleBlockVariant(BlockModelGenerators blockModels, TWIcicleBlock block, Direction direction, DripstoneThickness dripstoneThickness) {
        var suffix = "/" + direction.getSerializedName() + "/" + dripstoneThickness.getSerializedName();
        var mapping = TextureMapping.cross(TextureMapping.getBlockTexture(block, suffix));
        return Variant.variant().with(VariantProperties.MODEL, ICICLE_TEMPLATE.createWithSuffix(block, suffix, mapping, blockModels.modelOutput));
    }

    @Override
    protected @NotNull Stream<? extends Holder<Block>> getKnownBlocks() {
        return super.getKnownBlocks().filter(b -> !b.is(TWBlocks.LARIMAR));
    }
}
