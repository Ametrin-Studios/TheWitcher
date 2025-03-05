package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public interface TWEquipmentAssets {
    ResourceKey<EquipmentAsset> REINFORCED_LEATHER = locate("reinforced_leather");

    static ResourceKey<EquipmentAsset> locate(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, TheWitcher.locate(name));
    }
}
