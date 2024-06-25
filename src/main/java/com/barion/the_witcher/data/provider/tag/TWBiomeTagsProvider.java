package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.gen.TWBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TWBiomeTagsProvider extends BiomeTagsProvider {
    public TWBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheWitcher.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        tag(TWTags.Biomes.IS_WHITE_FROST).add(
                TWBiomes.FROZEN_SPIKES,
                TWBiomes.ICY_PEAKS,
                TWBiomes.SNOWY_DESERT,
                TWBiomes.ARCTIC_BONEYARD,
                TWBiomes.FROSTED_OCEAN,
                TWBiomes.ICEBOUND_DEPTHS
        );
        tag(TWTags.Biomes.HAS_ICY_RUIN).add(
                TWBiomes.FROZEN_SPIKES,
                TWBiomes.ICY_PEAKS,
                TWBiomes.SNOWY_DESERT,
                TWBiomes.ARCTIC_BONEYARD
        );

        tag(TWTags.Biomes.ICICLE_CAN_GROW_IN).addTag(TWTags.Biomes.IS_WHITE_FROST).addTag(Tags.Biomes.IS_COLD);
        tag(TWTags.Biomes.DEALS_FREEZING_DAMAGE).addTag(TWTags.Biomes.IS_WHITE_FROST);

        tag(BiomeTags.HAS_NETHER_FOSSIL).add(
                TWBiomes.ARCTIC_BONEYARD
        );

        tag(TWTags.Biomes.HAS_WHITE_MYRTLE).add(
                Biomes.FLOWER_FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST
        );
    }
}