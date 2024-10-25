package com.barion.the_witcher.registry.item;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWEffects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.ametrinstudios.ametrin.util.TimeHelper.MinutesToTicks;

public final class TWPotions {
    public static final DeferredRegister<Potion> REGISTER = DeferredRegister.create(BuiltInRegistries.POTION, TheWitcher.MOD_ID);

    public static final DeferredHolder<Potion, Potion> ENERGY_REGENERATION_POTION = REGISTER.register("energy_regeneration_potion", ()-> new Potion(new MobEffectInstance(TWEffects.ENERGY_REGENERATION, 6000, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_ENERGY_REGENERATION_POTION = REGISTER.register("long_energy_regeneration_potion", ()-> new Potion("energy_regeneration_potion", new MobEffectInstance(TWEffects.ENERGY_REGENERATION, 9000, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_ENERGY_REGENERATION_POTION = REGISTER.register("strong_energy_regeneration_potion", ()-> new Potion("energy_regeneration_potion", new MobEffectInstance(TWEffects.ENERGY_REGENERATION, 6000, 1)));

    public static final DeferredHolder<Potion, Potion> FROST_RESISTANCE_POTION = REGISTER.register("frost_resistance_potion", ()-> new Potion(new MobEffectInstance(TWEffects.FROST_RESISTANCE, MinutesToTicks(20), 0)));
    public static final DeferredHolder<Potion, Potion> LONG_FROST_RESISTANCE_POTION = REGISTER.register("long_frost_resistance_potion", ()-> new Potion("frost_resistance_potion", new MobEffectInstance(TWEffects.FROST_RESISTANCE, MinutesToTicks(30), 0)));
}