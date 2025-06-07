package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWSignType;
import net.minecraft.core.particles.ParticleTypes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class TWSignTypes {
    public static final DeferredRegister<TWSignType> REGISTER = DeferredRegister.create(TWRegistries.SIGN_TYPE, TheWitcher.MOD_ID);

    public static final DeferredHolder<TWSignType, TWSignType> AARD = REGISTER.register("aard", ()-> new TWSignType(TWParticleTypes.AARD.get(), 40));
    public static final DeferredHolder<TWSignType, TWSignType> IGNI = REGISTER.register("igni", ()-> new TWSignType(TWParticleTypes.IGNI.get(), 40));
    public static final DeferredHolder<TWSignType, TWSignType> QUEN = REGISTER.register("quen", ()-> new TWSignType(ParticleTypes.HEART, 60));
}
