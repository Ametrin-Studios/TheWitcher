package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.renderer.entity.state.TWWildHuntKnightRenderState;
import com.barion.the_witcher.world.entity.TWWildHuntKnightEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class TWWildHuntKnightRenderer extends HumanoidMobRenderer<TWWildHuntKnightEntity, TWWildHuntKnightRenderState, HumanoidModel<TWWildHuntKnightRenderState>> {
    private static final ResourceLocation TEXTURE = TheWitcher.locate("textures/entity/wild_hunt_knight.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TheWitcher.locate("wild_hunt_knight"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_INNER_ARMOR = new ModelLayerLocation(TheWitcher.locate("wild_hunt_knight_inner_armor"), "main");
    public static final ModelLayerLocation LAYER_LOCATION_OUTER_ARMOR = new ModelLayerLocation(TheWitcher.locate("wild_hunt_knight_outer_armor"), "main");

    public TWWildHuntKnightRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(LAYER_LOCATION)), 0.5f);
        addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(LAYER_LOCATION_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(LAYER_LOCATION_OUTER_ARMOR)), context.getEquipmentRenderer()));
    }

    @Override
    public @NotNull TWWildHuntKnightRenderState createRenderState() {
        return new TWWildHuntKnightRenderState();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TWWildHuntKnightRenderState renderState) {
        return TEXTURE;
    }
}