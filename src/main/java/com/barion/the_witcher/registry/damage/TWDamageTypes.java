package com.barion.the_witcher.registry.damage;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class TWDamageTypes {
    public static final DeferredRegister<DamageType> REGISTER = DeferredRegister.create(Registries.DAMAGE_TYPE, TheWitcher.MOD_ID);

    public static  final DeferredHolder<DamageType, DamageType> HOT_WATER = REGISTER.register("hot_water", ()-> new DamageType("hot_water", 0.1F, DamageEffects.BURNING));
}

