package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.gen.feature.TWLargeDripstoneFeature;
import com.barion.the_witcher.world.gen.feature.TWLargeSpikeFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TWFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FEATURE, TheWitcher.MOD_ID);

    public static final Supplier<TWLargeSpikeFeature> LargeSpike = REGISTER.register("large_spike", TWLargeSpikeFeature::new);
    public static final Supplier<TWLargeDripstoneFeature> LargeDripstone = REGISTER.register("large_dripstone", TWLargeDripstoneFeature::new);
}