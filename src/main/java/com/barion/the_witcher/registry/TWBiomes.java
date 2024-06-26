package com.barion.the_witcher.registry;

import com.barion.the_witcher.util.TWUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class TWBiomes {
    public static final ResourceKey<Biome> SNOWY_DESERT = ResourceKey.create(Registries.BIOME, TWUtil.location("snowy_desert"));
    public static final ResourceKey<Biome> ICY_PEAKS = ResourceKey.create(Registries.BIOME, TWUtil.location("icy_peaks"));
    public static final ResourceKey<Biome> FROZEN_SPIKES = ResourceKey.create(Registries.BIOME, TWUtil.location("frozen_spikes"));
    public static final ResourceKey<Biome> FROSTED_OCEAN = ResourceKey.create(Registries.BIOME, TWUtil.location("frosted_ocean"));
    public static final ResourceKey<Biome> ARCTIC_BONEYARD = ResourceKey.create(Registries.BIOME, TWUtil.location("arctic_boneyard"));
    public static final ResourceKey<Biome> ICEBOUND_DEPTHS = ResourceKey.create(Registries.BIOME, TWUtil.location("icebound_depths"));
}