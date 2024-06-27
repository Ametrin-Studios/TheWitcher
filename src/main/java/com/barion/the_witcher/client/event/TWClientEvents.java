package com.barion.the_witcher.client.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.TWGuiOverlay;
import com.barion.the_witcher.client.TWKeyBinding;
import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.TWWhiteFrostSpecialEffects;
import com.barion.the_witcher.client.renderer.entity.TWIceGhostRenderer;
import com.barion.the_witcher.client.renderer.entity.TWWildHuntHoundRenderer;
import com.barion.the_witcher.client.renderer.entity.TWWildHuntKnightRenderer;
import com.barion.the_witcher.client.screen.TWMasterSmithingScreen;
import com.barion.the_witcher.registry.TWEntityTypes;
import com.barion.the_witcher.registry.TWMenuTypes;
import com.barion.the_witcher.registry.fluid.TWFluids;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;

@EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class TWClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(TWFluids.SOURCE_ACID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TWFluids.FLOWING_ACID.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerMenuScreens(final RegisterMenuScreensEvent event) {
        event.register(TWMenuTypes.MASTER_SMITHING_TABLE_MENU.get(), TWMasterSmithingScreen::new);
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event){
        event.register(TWKeyBinding.CAST_SIGN);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiLayersEvent event){
        event.registerBelow(ResourceLocation.withDefaultNamespace("hotbar"), TWUtil.location("energy_level"), TWGuiOverlay.EnergyLevel);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntityTypes.ICE_GHOST.get(), TWIceGhostRenderer::new);
        event.registerEntityRenderer(TWEntityTypes.WILD_HUNT_HOUND.get(), TWWildHuntHoundRenderer::new);
        event.registerEntityRenderer(TWEntityTypes.WILD_HUNT_KNIGHT.get(), TWWildHuntKnightRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TWIceGhostRenderer.LAYER_LOCATION, TWIceGhostModel::createMesh);
        event.registerLayerDefinition(TWWildHuntHoundRenderer.LAYER_LOCATION, TWWildHuntHoundModel::createMesh);
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LAYER_LOCATION, ()-> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0), 64, 32));
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LAYER_LOCATION_OUTER_ARMOR, ()-> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1), 0), 64, 32));
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LAYER_LOCATION_INNER_ARMOR, ()-> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5f), 0), 64, 32));
    }

    @SubscribeEvent
    public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event){
        event.register(TWUtil.location("white_frost"), new TWWhiteFrostSpecialEffects());
    }
}