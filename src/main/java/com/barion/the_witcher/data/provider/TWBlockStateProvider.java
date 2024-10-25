package com.barion.the_witcher.data.provider;

import com.ametrinstudios.ametrin.data.provider.ExtendedBlockStateProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWLarimar;
import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class TWBlockStateProvider extends ExtendedBlockStateProvider {
    public TWBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, TheWitcher.MOD_ID, existingFileHelper);
    }

    {
        excludedClasses.add(TWLarimar.class);
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWMasterSmithingTableBlock)) {return false;}
            masterSmithingTableBlock((TWMasterSmithingTableBlock)block, name, texture);
            return true;
        });
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWIcicleBlock)) {return false;}
            icicleBlock((TWIcicleBlock) block, name, texture);
            return true;
        });
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWPowerBlock)) {return false;}
            powerBlock((TWPowerBlock) block, name, texture);
            return true;
        });
    }

    @Override
    protected void registerStatesAndModels() {runProviderRules(TWBlocks.getAllBlocks());}

    private void powerBlock(TWPowerBlock powerBlock, String name, String texture){
        var on = models().cubeAll("block/" + name + "/on", modBlockLoc(texture + "/on"));
        var off = models().cubeAll("block/" + name + "/off", modBlockLoc(texture + "/off"));
        getVariantBuilder(powerBlock).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(TWPowerBlock.HAS_POWER) ? on : off).build());
    }

    private void masterSmithingTableBlock(TWMasterSmithingTableBlock block, String name, String texture){
        ResourceLocation bottom = modBlockLoc(texture + "_bottom");
        ResourceLocation top = modBlockLoc(texture + "_top");
        ResourceLocation front = modBlockLoc(texture + "_front");
        ResourceLocation side = modBlockLoc(texture + "_side");
        simpleBlock(block, models().cube("master_smithing_table", bottom, top, front, front, side, side).texture("particle", top));
    }

    private void icicleBlock(TWIcicleBlock icicle, String name, String texture) {
        ModelFile downBase = models().cross("block/" + name + "/down/base", modBlockLoc(texture + "/down/base")).renderType(RenderTypes.CUTOUT);
        ModelFile downFrustum = models().cross("block/" + name + "/down/frustum", modBlockLoc(texture + "/down/frustum")).renderType(RenderTypes.CUTOUT);
        ModelFile downMiddle = models().cross("block/" + name + "/down/middle", modBlockLoc(texture + "/down/middle")).renderType(RenderTypes.CUTOUT);
        ModelFile downTip = models().cross("block/" + name + "/down/tip", modBlockLoc(texture + "/down/tip")).renderType(RenderTypes.CUTOUT);
        ModelFile downTipMerge = models().cross("block/" + name + "/down/tip_merge", modBlockLoc(texture + "/down/tip_merge")).renderType(RenderTypes.CUTOUT);
        ModelFile upBase = models().cross("block/" + name + "/up/base", modBlockLoc(texture + "/up/base")).renderType(RenderTypes.CUTOUT);
        ModelFile upFrustum = models().cross("block/" + name + "/up/frustum", modBlockLoc(texture + "/up/frustum")).renderType(RenderTypes.CUTOUT);
        ModelFile upMiddle = models().cross("block/" + name + "/up/middle", modBlockLoc(texture + "/up/middle")).renderType(RenderTypes.CUTOUT);
        ModelFile upTip = models().cross("block/" + name + "/up/tip", modBlockLoc(texture + "/up/tip")).renderType(RenderTypes.CUTOUT);
        ModelFile upTipMerge = models().cross("block/" + name + "/up/tip_merge", modBlockLoc(texture + "/up/tip_merge")).renderType(RenderTypes.CUTOUT);
        getVariantBuilder(icicle).forAllStates(state -> {
            final DripstoneThickness thickness = state.getValue(TWIcicleBlock.THICKNESS);
            final Direction direction = state.getValue(TWIcicleBlock.TIP_DIRECTION);
            return ConfiguredModel.builder().modelFile((direction == Direction.UP) ? (thickness == DripstoneThickness.BASE) ? upBase : (thickness == DripstoneThickness.FRUSTUM) ? upFrustum : (thickness == DripstoneThickness.MIDDLE) ? upMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? upTipMerge : upTip : (thickness == DripstoneThickness.BASE) ? downBase : (thickness == DripstoneThickness.FRUSTUM) ? downFrustum : (thickness == DripstoneThickness.MIDDLE) ? downMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? downTipMerge : downTip).build();
        });
    }
}