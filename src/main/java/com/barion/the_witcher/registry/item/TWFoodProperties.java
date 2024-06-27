package com.barion.the_witcher.registry.item;

import com.ametrinstudios.ametrin.util.Extensions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public final class TWFoodProperties {
    public static final FoodProperties HOT_WATER_BOTTLE = new FoodProperties.Builder().alwaysEdible().nutrition(0).saturationModifier(0).build();
    public static final FoodProperties BEER = new FoodProperties.Builder().alwaysEdible().nutrition(6).saturationModifier(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, Extensions.SecondsToTicks(10)), 1).build();
}