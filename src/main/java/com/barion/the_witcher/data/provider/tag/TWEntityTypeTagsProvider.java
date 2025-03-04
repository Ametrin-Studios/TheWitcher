package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWEntityTypes;
import com.barion.the_witcher.util.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public final class TWEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public TWEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TheWitcher.MOD_ID);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider lookupProvider){
        tag(TWTags.EntityTypes.MAGIC_MOB).add(
                EntityType.VEX,
                EntityType.CREEPER,
                TWEntityTypes.WILD_HUNT_HOUND.get(),
                TWEntityTypes.ICE_GHOST.get()
        );

        tag(TWTags.EntityTypes.WILD_HUNT).add(
                TWEntityTypes.WILD_HUNT_HOUND.get(),
                TWEntityTypes.WILD_HUNT_KNIGHT.get()
        );

        tag(TWTags.EntityTypes.WILD_HUNT_IGNORE).addTag(TWTags.EntityTypes.WILD_HUNT).add(
                EntityType.AXOLOTL,
                EntityType.BEE,
                EntityType.CREEPER,
                EntityType.DOLPHIN,
                EntityType.FOX,
                EntityType.POLAR_BEAR,
                EntityType.PARROT,
                EntityType.SKELETON_HORSE
        );

        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(
                TWEntityTypes.WILD_HUNT_HOUND.get(),
                TWEntityTypes.WILD_HUNT_KNIGHT.get(),
                TWEntityTypes.ICE_GHOST.get()
        );
        tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS).add(
                TWEntityTypes.WILD_HUNT_HOUND.get(),
                TWEntityTypes.ICE_GHOST.get()
        );
    }
}