package com.barion.the_witcher.registry.item;

import com.ametrinstudios.ametrin.util.TimeHelper;
import com.barion.the_witcher.world.item.TWApplyDamageConsumeEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public final class TWConsumables {
    public static final Consumable BEER = Consumables.defaultDrink().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, TimeHelper.secondsToTicks(10)))).build();
    public static final Consumable HOT_WATER = Consumables.defaultDrink().onConsume(new TWApplyDamageConsumeEffect(10)).build();
}
