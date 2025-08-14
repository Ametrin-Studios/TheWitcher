package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public final class TWLevels {
    public static final ResourceKey<Level> WHITE_FROST = ResourceKey.create(Registries.DIMENSION, TheWitcher.locate("white_frost"));
}