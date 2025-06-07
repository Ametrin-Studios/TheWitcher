package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, TheWitcher.MOD_ID);

    public static final Supplier<SimpleParticleType> AARD = REGISTER.register("aard", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> IGNI = REGISTER.register("igni", () -> new SimpleParticleType(false));
    public static final Supplier<SimpleParticleType> QUEN = REGISTER.register("quen", () -> new SimpleParticleType(false));
}
