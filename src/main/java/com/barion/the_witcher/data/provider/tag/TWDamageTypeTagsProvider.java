package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.damage.TWDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class TWDamageTypeTagsProvider extends DamageTypeTagsProvider {
    public TWDamageTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryAccess) {
        super(output, registryAccess, TheWitcher.MOD_ID);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider registryAccess) {
        tag(DamageTypeTags.BYPASSES_ARMOR) //included in BYPASSES_SHIELD
                .add(TWDamageTypes.HOT_WATER);

        tag(DamageTypeTags.BYPASSES_ENCHANTMENTS)
                .add(TWDamageTypes.HOT_WATER);
    }
}
