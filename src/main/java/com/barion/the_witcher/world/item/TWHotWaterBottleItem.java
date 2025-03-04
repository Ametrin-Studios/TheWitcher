package com.barion.the_witcher.world.item;

import com.barion.the_witcher.registry.damage.TWDamageSources;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWHotWaterBottleItem extends Item {
    public TWHotWaterBottleItem(Properties properties) {
        super(properties);
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        super.finishUsingItem(itemStack, level, entity);
        if (entity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            entity.hurt(TWDamageSources.hotWater(entity), 10);
        }

        if (itemStack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (entity instanceof Player player && !((Player)entity).getAbilities().instabuild) {
                var itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return itemStack;
        }
    }

    @Override @ParametersAreNonnullByDefault
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 40;
    }

    @Override public @NotNull ItemUseAnimation getUseAnimation(@NotNull ItemStack stack) { return ItemUseAnimation.DRINK; }
//    @Override public @NotNull SoundEvent getDrinkingSound() { return SoundEvents.HONEY_DRINK; }
//    @Override public @NotNull SoundEvent getEatingSound() { return SoundEvents.HONEY_DRINK; }



    @Override @ParametersAreNonnullByDefault
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}