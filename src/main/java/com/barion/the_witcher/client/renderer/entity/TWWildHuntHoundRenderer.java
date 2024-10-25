package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWWildHuntHoundEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public final class TWWildHuntHoundRenderer extends MobRenderer<TWWildHuntHoundEntity, TWWildHuntHoundModel> {
    private static final ResourceLocation TEXTURE = TWUtil.locate("textures/entity/wild_hunt_hound.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TWUtil.locate("wild_hunt_hound"), "main");

    public TWWildHuntHoundRenderer(EntityRendererProvider.Context context) {
        super(context, new TWWildHuntHoundModel(context.bakeLayer(LAYER_LOCATION)), 1.1f);
    }

    @Override @Nonnull
    public ResourceLocation getTextureLocation(@NotNull TWWildHuntHoundEntity entity) { return TEXTURE; }
}