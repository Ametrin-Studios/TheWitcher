package com.barion.the_witcher.world.gen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record TWLargeSpikeConfiguration(BlockStateProvider baseBlock, IntProvider columnRadius,
                                        FloatProvider heightScale, FloatProvider bluntness, FloatProvider windSpeed,
                                        int minRadiusForWind,
                                        float minBluntnessForWind) implements FeatureConfiguration {
    public static final Codec<TWLargeSpikeConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
                    BlockStateProvider.CODEC.fieldOf("base_block").forGetter((configuration) -> configuration.baseBlock),
                    IntProvider.codec(1, 60).fieldOf("column_radius").forGetter((configuration) -> configuration.columnRadius),
                    FloatProvider.codec(0, 20).fieldOf("height_scale").forGetter((configuration) -> configuration.heightScale),
                    FloatProvider.codec(0.1f, 10).fieldOf("bluntness").forGetter((configuration) -> configuration.bluntness),
                    FloatProvider.codec(0, 2).fieldOf("wind_speed").forGetter((configuration) -> configuration.windSpeed),
                    Codec.intRange(0, 100).fieldOf("min_radius_for_wind").forGetter((configuration) -> configuration.minRadiusForWind),
                    Codec.floatRange(0, 5).fieldOf("min_bluntness_for_wind").forGetter((configuration) -> configuration.minBluntnessForWind))
            .apply(instance, TWLargeSpikeConfiguration::new));

}
