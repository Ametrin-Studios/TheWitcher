package com.barion.the_witcher.registry.damage;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class TWDamageTypes {
    public static final DeferredRegister<DamageType> REGISTER = DeferredRegister.create(Registries.DAMAGE_TYPE, TheWitcher.MOD_ID);

    public static final ResourceKey<DamageType> HOT_WATER = ResourceKey.create(Registries.DAMAGE_TYPE, TheWitcher.locate("hot_water"));

}

