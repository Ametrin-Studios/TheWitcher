package com.barion.the_witcher.client.model;
// Made with Blockbench 4.2.2

import com.barion.the_witcher.client.renderer.entity.state.TWIceGhostRenderState;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;

public final class TWIceGhostModel extends AbstractZombieModel<TWIceGhostRenderState> {
    public TWIceGhostModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createMesh() {
        MeshDefinition meshdefinition = new MeshDefinition();
        var partdefinition = meshdefinition.getRoot();

        var head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
        var hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -4.0F));
        var hat_r1 = hat.addOrReplaceChild("hat_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        var body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 31).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
        var left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(34, 15).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(4.0F, 5.0F, 0.0F, -1.0472F, 0.0F, 0.0F));
        var right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(12, 47).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-4.0F, 5.0F, 0.0F, -1.0472F, 0.0F, 0.0F));
        var right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));
        var left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}