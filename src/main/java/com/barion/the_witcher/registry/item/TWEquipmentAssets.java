package com.barion.the_witcher.registry.item;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public final class TWEquipmentAssets {
    public static final ResourceKey<EquipmentAsset> REINFORCED_LEATHER = createId("reinforced_leather");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, TheWitcher.locate(name));
    }
}
