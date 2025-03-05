package com.barion.the_witcher.registry;

import com.ametrinstudios.ametrin.world.item.helper.ArmorMaterialBuilder;
import com.barion.the_witcher.registry.item.TWEquipmentAssets;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public final class TWArmorMaterials {

    public static final ArmorMaterial REINFORCED_LEATHER = new ArmorMaterialBuilder(TWEquipmentAssets.REINFORCED_LEATHER)
            .defence((defences) -> {
                defences.put(ArmorType.BOOTS, 3);
                defences.put(ArmorType.LEGGINGS, 7);
                defences.put(ArmorType.CHESTPLATE, 9);
                defences.put(ArmorType.HELMET, 4);
            })
            .enchantmentValue(19)
            .equipSound(SoundEvents.ARMOR_EQUIP_LEATHER)
            .repairIngredient(TWTags.Items.STEEL_INGOTS)
            .toughness(3)
            .knockbackResistance(0.1f)
            .build();
}
