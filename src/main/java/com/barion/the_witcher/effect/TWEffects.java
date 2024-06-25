package com.barion.the_witcher.effect;

import com.ametrinstudios.ametrin.world.effect.ExternalEffect;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.*;

public class TWEffects {
    public static final DeferredRegister<MobEffect> REGISTER = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, TheWitcher.MOD_ID);

    public static final DeferredHolder<MobEffect, ExternalEffect> ENERGY_REGENERATION = REGISTER.register("energy_regeneration", ()-> new ExternalEffect(MobEffectCategory.BENEFICIAL, new Color(255, 255, 155)));
    public static final DeferredHolder<MobEffect, ExternalEffect> FROST_RESISTANCE = REGISTER.register("frost_resistance", ()-> new ExternalEffect(MobEffectCategory.BENEFICIAL, new Color(168, 255, 255)));
}