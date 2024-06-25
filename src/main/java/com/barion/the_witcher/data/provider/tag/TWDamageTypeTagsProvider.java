package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public final class TWDamageTypeTagsProvider extends DamageTypeTagsProvider {
    public TWDamageTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryAccess, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, registryAccess, TheWitcher.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider registryAccess) {
        tag(DamageTypeTags.BYPASSES_ARMOR) //includes BYPASSES_SHIELD
                .add(TWDamageTypes.HOT_WATER.getKey());

        tag(DamageTypeTags.BYPASSES_ENCHANTMENTS)
                .add(TWDamageTypes.HOT_WATER.getKey());
    }
}
