package com.barion.the_witcher.world.item;

import com.barion.the_witcher.registry.damage.TWDamageSources;
import com.barion.the_witcher.registry.item.TWConsumeEffectTypes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public record TWApplyDamageConsumeEffect(float damage) implements ConsumeEffect {

    public static final MapCodec<TWApplyDamageConsumeEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("damage", 1.0f).forGetter(TWApplyDamageConsumeEffect::damage))
                    .apply(instance, TWApplyDamageConsumeEffect::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, TWApplyDamageConsumeEffect> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, TWApplyDamageConsumeEffect::damage, TWApplyDamageConsumeEffect::new
    );

    @Override
    @ParametersAreNonnullByDefault
    public boolean apply(Level level, ItemStack stack, LivingEntity entity) {
        if (level instanceof ServerLevel) {
            return entity.hurtServer((ServerLevel) level, TWDamageSources.hotWater(entity), damage);
        }
        return false;
    }

    @Override
    public @NotNull Type<? extends ConsumeEffect> getType() {
        return TWConsumeEffectTypes.APPLY_DAMAGE.get();
    }
}
