package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public final class TWBiomes {
    public static final ResourceKey<Biome> SNOWY_DESERT = ResourceKey.create(Registries.BIOME, TheWitcher.locate("snowy_desert"));
    public static final ResourceKey<Biome> ICY_PEAKS = ResourceKey.create(Registries.BIOME, TheWitcher.locate("icy_peaks"));
    public static final ResourceKey<Biome> FROZEN_SPIKES = ResourceKey.create(Registries.BIOME, TheWitcher.locate("frozen_spikes"));
    public static final ResourceKey<Biome> FROSTED_OCEAN = ResourceKey.create(Registries.BIOME, TheWitcher.locate("frosted_ocean"));
    public static final ResourceKey<Biome> ARCTIC_BONEYARD = ResourceKey.create(Registries.BIOME, TheWitcher.locate("arctic_boneyard"));
    public static final ResourceKey<Biome> ICEBOUND_DEPTHS = ResourceKey.create(Registries.BIOME, TheWitcher.locate("icebound_depths"));
}