package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWBiomes;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class TWBiomeTagsProvider extends BiomeTagsProvider {
    public TWBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TheWitcher.MOD_ID);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        tag(TWTags.Biomes.HAS_WITCHER_CITADEL)
                .addTag(Tags.Biomes.IS_FOREST)
                .addTag(Tags.Biomes.IS_PLAINS)
                .addTag(Tags.Biomes.IS_SAVANNA)
                .addTag(Tags.Biomes.IS_DEAD)

                .remove(Tags.Biomes.IS_MOUNTAIN)
                .remove(Tags.Biomes.IS_STONY_SHORES)
                .remove(Tags.Biomes.IS_BEACH)
                .remove(Tags.Biomes.IS_WINDSWEPT)
        ;

        tag(TWTags.Biomes.IS_WHITE_FROST)
                .addOptional(TWBiomes.FROZEN_SPIKES.location())
                .addOptional(TWBiomes.ICY_PEAKS.location())
                .addOptional(TWBiomes.SNOWY_DESERT.location())
                .addOptional(TWBiomes.ARCTIC_BONEYARD.location())
                .addOptional(TWBiomes.FROSTED_OCEAN.location())
                .addOptional(TWBiomes.ICEBOUND_DEPTHS.location())
        ;

        tag(TWTags.Biomes.HAS_ICY_RUIN)
                .addOptional(TWBiomes.FROZEN_SPIKES.location())
                .addOptional(TWBiomes.ICY_PEAKS.location())
                .addOptional(TWBiomes.SNOWY_DESERT.location())
                .addOptional(TWBiomes.ARCTIC_BONEYARD.location())
        ;

        tag(TWTags.Biomes.ICICLE_CAN_GROW_IN)
                .addTag(TWTags.Biomes.IS_WHITE_FROST)
                .addTag(Tags.Biomes.IS_ICY)
        ;

        tag(TWTags.Biomes.DEALS_FREEZING_DAMAGE)
                .addTag(TWTags.Biomes.IS_WHITE_FROST)
        ;

        tag(BiomeTags.HAS_NETHER_FOSSIL)
                .addOptional(TWBiomes.ARCTIC_BONEYARD.location())
        ;

        tag(TWTags.Biomes.HAS_WHITE_MYRTLE).add(
                Biomes.FLOWER_FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST
        );
    }
}