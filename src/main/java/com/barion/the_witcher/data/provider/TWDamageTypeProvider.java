package com.barion.the_witcher.data.provider;

import com.barion.the_witcher.registry.damage.TWDamageTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public final class TWDamageTypeProvider {
    public static void run(BootstrapContext<DamageType> bootstrap) {
        bootstrap.register(TWDamageTypes.HOT_WATER, new DamageType("hot_water", DamageScaling.NEVER, 0.1f, DamageEffects.BURNING));
    }
}
