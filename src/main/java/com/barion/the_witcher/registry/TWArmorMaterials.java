package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.item.TWItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class TWArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTER = DeferredRegister.create(Registries.ARMOR_MATERIAL, TheWitcher.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> REINFORCED_LEATHER = register("reinforced_leather", (defences) -> {
        defences.put(ArmorItem.Type.BOOTS, 3);
        defences.put(ArmorItem.Type.LEGGINGS, 7);
        defences.put(ArmorItem.Type.CHESTPLATE, 9);
        defences.put(ArmorItem.Type.HELMET, 4);
    }, 19, SoundEvents.ARMOR_EQUIP_LEATHER, TWItems.STEEL_INGOT::get, 3, 0.1f);


    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String name, Consumer<EnumMap<ArmorItem.Type, Integer>> defenceBuilder, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<ItemLike> repairIngredient, float toughness, float knockbackResistance) {
        var defence = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        defenceBuilder.accept(defence);
        return register(name, defence, enchantmentValue, equipSound, () -> Ingredient.of(repairIngredient.get()), toughness, knockbackResistance);
    }

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defence, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance) {
        var layers = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
        return REGISTER.register(name, () -> new ArmorMaterial(defence, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
}
