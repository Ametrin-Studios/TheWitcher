package com.barion.the_witcher.registry.item;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.item.TWApplyDamageConsumeEffect;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWConsumeEffectTypes {
    public static final DeferredRegister<ConsumeEffect.Type<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.CONSUME_EFFECT_TYPE, TheWitcher.MOD_ID);

    public static final Supplier<ConsumeEffect.Type<TWApplyDamageConsumeEffect>> APPLY_DAMAGE = REGISTER.register("apply_damage", () -> new ConsumeEffect.Type<>(TWApplyDamageConsumeEffect.CODEC, TWApplyDamageConsumeEffect.STREAM_CODEC));
}
