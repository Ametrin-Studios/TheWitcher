package com.barion.the_witcher.registry.damage;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public final class TWDamageSources {
    public static DamageSource hotWater(LivingEntity target) {
        return new DamageSource(target.level().registryAccess().holderOrThrow(TWDamageTypes.HOT_WATER));
    }
}
