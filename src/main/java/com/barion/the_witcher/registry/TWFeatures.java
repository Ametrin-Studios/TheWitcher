package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.gen.feature.TWLargeDripstoneFeature;
import com.barion.the_witcher.world.gen.feature.TWLargeSpikeFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FEATURE, TheWitcher.MOD_ID);

    public static final Supplier<TWLargeSpikeFeature> LARGE_SPIKE = REGISTER.register("large_spike", TWLargeSpikeFeature::new);
    public static final Supplier<TWLargeDripstoneFeature> LARGE_DRIPSTONE = REGISTER.register("large_dripstone", TWLargeDripstoneFeature::new);
}