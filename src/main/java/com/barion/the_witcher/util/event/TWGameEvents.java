package com.barion.the_witcher.util.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.attachment.TWEnergyWrapper;
import com.barion.the_witcher.command.TWGetEnergyCommand;
import com.barion.the_witcher.command.TWGetSignStrengthCommand;
import com.barion.the_witcher.command.TWSetEnergyCommand;
import com.barion.the_witcher.command.TWSetSignStrengthCommand;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import com.barion.the_witcher.registry.TWEffects;
import com.barion.the_witcher.registry.TWLevels;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.registry.item.TWPotions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public final class TWGameEvents {
    @SubscribeEvent
    public static void entityTick(final EntityTickEvent event){
        if(event.getEntity() instanceof LivingEntity livingEntity) {
            freezeEntity(livingEntity);
        }
    }

    private static void freezeEntity(LivingEntity entity) {
        if(entity.level().dimension() != TWLevels.WHITE_FROST) { return; }
        if(entity.isOnFire()) {
            entity.clearFire();
        }

        if(entity.getType().is(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES) || entity.hasEffect(TWEffects.FROST_RESISTANCE)) { return; }
        if(entity instanceof Player && ((Player) entity).getAbilities().invulnerable) { return; }

        entity.setIsInPowderSnow(true);
        entity.setTicksFrozen(Math.min(entity.getTicksRequiredToFreeze()+2, entity.getTicksFrozen() + 3)); //very bad, need a better solution
    }

    @SubscribeEvent
    public static void playerTick(PlayerTickEvent event) {
        updateEnergy((ServerPlayer) event.getEntity());
    }

    private static void updateEnergy(ServerPlayer player) {
        var signStrength = player.getData(TWAttachmentTypes.SIGN_STRENGTH);
        if(signStrength == 0) {
            return;
        }

        var energyWrapper = new TWEnergyWrapper(player);
        if(energyWrapper.isFull()) {
            return;
        }

        var increase = 0.2f + signStrength/5f;
        if(player.hasEffect(TWEffects.ENERGY_REGENERATION)){
            increase += (player.getEffect(TWEffects.ENERGY_REGENERATION).getAmplifier()+1)/5f;
        }

        energyWrapper.increase(increase);
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD, TWItems.KIKIMORA_TOOTH.get(), TWPotions.ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(TWPotions.ENERGY_REGENERATION_POTION, Items.REDSTONE, TWPotions.LONG_ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(TWPotions.ENERGY_REGENERATION_POTION, Items.GLOWSTONE_DUST, TWPotions.STRONG_ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(Potions.AWKWARD, Items.BLAZE_ROD, TWPotions.FROST_RESISTANCE_POTION);
        event.getBuilder().addMix(TWPotions.FROST_RESISTANCE_POTION, Items.REDSTONE, TWPotions.LONG_FROST_RESISTANCE_POTION);
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        new TWSetEnergyCommand(event.getDispatcher());
        new TWGetEnergyCommand(event.getDispatcher());
        new TWSetSignStrengthCommand(event.getDispatcher());
        new TWGetSignStrengthCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}