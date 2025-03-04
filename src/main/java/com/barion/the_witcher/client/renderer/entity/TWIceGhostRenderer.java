package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.renderer.entity.state.TWIceGhostRenderState;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class TWIceGhostRenderer extends MobRenderer<TWIceGhostEntity, TWIceGhostRenderState, TWIceGhostModel> {
    private static final ResourceLocation TEXTURE = TWUtil.locate("textures/entity/ice_ghost.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TWUtil.locate("ice_ghost"), "main");

    public TWIceGhostRenderer(EntityRendererProvider.Context renderContext) {
        super(renderContext, new TWIceGhostModel(renderContext.bakeLayer(LAYER_LOCATION)), 0.2f);
    }

    @Override
    public @NotNull TWIceGhostRenderState createRenderState() {
        return new TWIceGhostRenderState();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TWIceGhostRenderState rendererState) {
        return TEXTURE;
    }
}