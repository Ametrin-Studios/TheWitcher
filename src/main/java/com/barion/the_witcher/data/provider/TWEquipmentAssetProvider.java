package com.barion.the_witcher.data.provider;

import com.barion.the_witcher.registry.TWEquipmentAssets;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.function.BiConsumer;

public final class TWEquipmentAssetProvider extends EquipmentAssetProvider {
    public TWEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(TWEquipmentAssets.REINFORCED_LEATHER, EquipmentClientInfo.builder().addHumanoidLayers(TWEquipmentAssets.REINFORCED_LEATHER.location()).build());
    }
}
