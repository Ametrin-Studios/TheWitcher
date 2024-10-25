package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public final class TWIceGhostRenderer extends MobRenderer<TWIceGhostEntity, TWIceGhostModel> {
    private static final ResourceLocation TEXTURE = TWUtil.locate("textures/entity/ice_ghost.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TWUtil.locate("ice_ghost"), "main");

    public TWIceGhostRenderer(EntityRendererProvider.Context renderContext) {
        super(renderContext, new TWIceGhostModel(renderContext.bakeLayer(LAYER_LOCATION)), 0.2f);
    }

    @Override @Nonnull @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(TWIceGhostEntity entity) {return TEXTURE;}
}