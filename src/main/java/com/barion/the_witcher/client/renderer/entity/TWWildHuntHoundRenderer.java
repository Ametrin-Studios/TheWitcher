package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.entity.state.TWWildHuntHoundRenderState;
import com.barion.the_witcher.world.entity.TWWildHuntHoundEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class TWWildHuntHoundRenderer extends MobRenderer<TWWildHuntHoundEntity, TWWildHuntHoundRenderState, TWWildHuntHoundModel> {
    private static final ResourceLocation TEXTURE = TheWitcher.locate("textures/entity/wild_hunt_hound.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TheWitcher.locate("wild_hunt_hound"), "main");

    public TWWildHuntHoundRenderer(EntityRendererProvider.Context context) {
        super(context, new TWWildHuntHoundModel(context.bakeLayer(LAYER_LOCATION)), 1.1f);
    }

    @Override
    public @NotNull TWWildHuntHoundRenderState createRenderState() {
        return new TWWildHuntHoundRenderState();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TWWildHuntHoundRenderState renderState) {
        return TEXTURE;
    }
}