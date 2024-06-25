package com.barion.the_witcher.registry;

import net.minecraft.world.damagesource.DamageSource;

public final class TWDamageSources {
    private static final DamageSource hotWater = new DamageSource(TWDamageTypes.HOT_WATER);

    public static DamageSource hotWater() {
        return hotWater;
    }
}
