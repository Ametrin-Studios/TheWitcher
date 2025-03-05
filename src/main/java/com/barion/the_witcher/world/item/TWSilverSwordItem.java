package com.barion.the_witcher.world.item;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TWSilverSwordItem extends SwordItem {
    private final int magicDamage;
    private final Component magicDamageInfo;
    public TWSilverSwordItem(ToolMaterial toolMaterial, int magicDamage, float attackSpeed, Properties properties) {
        super(toolMaterial, 0, attackSpeed, properties);
        this.magicDamage = magicDamage;
        magicDamageInfo = Component.translatable("item.the_witcher.silver_sword.info", this.magicDamage);
    }

    @Override @ParametersAreNonnullByDefault
    public void postHurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        //TODO: fix
        if(target.getType().is(TWTags.EntityTypes.MAGIC_MOB)) {
            var damageSource = target.level().damageSources().mobAttack(attacker);
            float damage = magicDamage;
            var enchantmentBonus = getAttackDamageBonus(target, damage, damageSource);
            if(attacker instanceof Player){
                var dmgScale = ((Player) attacker).getAttackStrengthScale(0.5f);
                damage *= 0.2f + dmgScale * dmgScale * 0.8f;
                enchantmentBonus *= dmgScale;
                TWUtil.Logger.info("Scaled damage with: " + 0.2f + dmgScale * dmgScale * 0.8f);
            }
            damage += enchantmentBonus;
            TWUtil.Logger.info("Total Damage: " + damage);
            target.hurt(damageSource, damage);
        }
        super.postHurtEnemy(itemStack, target, attacker);
    }

    @Override @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(itemStack, context, components, flag);
        components.add(magicDamageInfo);
    }
}