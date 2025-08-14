package com.barion.the_witcher.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.attachment.TWEnergyWrapper;
import com.barion.the_witcher.command.TWGetEnergyCommand;
import com.barion.the_witcher.command.TWGetSignStrengthCommand;
import com.barion.the_witcher.command.TWSetEnergyCommand;
import com.barion.the_witcher.command.TWSetSignStrengthCommand;
import com.barion.the_witcher.network.*;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import com.barion.the_witcher.registry.TWEffects;
import com.barion.the_witcher.registry.TWLevels;
import com.barion.the_witcher.registry.TWRegistries;
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
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = TheWitcher.MOD_ID)
public final class TWEvents {
    @SubscribeEvent
    public static void entityTick(final EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity livingEntity) {
            freezeEntity(livingEntity);
        }
    }

    private static void freezeEntity(LivingEntity entity) {
        if (entity.level().dimension() != TWLevels.WHITE_FROST) {
            return;
        }
        if (entity.isOnFire()) {
            entity.clearFire();
        }

        if (entity.getType().is(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES) || entity.hasEffect(TWEffects.FROST_RESISTANCE)) {
            return;
        }
        if (entity instanceof Player player && player.getAbilities().invulnerable) {
            return;
        }

        entity.setIsInPowderSnow(true);
        entity.setTicksFrozen(Math.min(entity.getTicksRequiredToFreeze() + 2, entity.getTicksFrozen() + 3)); // very bad, need a better solution
    }

    @SubscribeEvent
    public static void onPlayerJoined(final EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PacketDistributor.sendToPlayer(player, new TWSignStrengthS2C(player.getData(TWAttachmentTypes.SIGN_STRENGTH)));
            PacketDistributor.sendToPlayer(player, new TWMaxEnergyS2C(player.getData(TWAttachmentTypes.MAX_ENERGY)));
            PacketDistributor.sendToPlayer(player, new TWEnergyS2C(player.getData(TWAttachmentTypes.ENERGY)));
        }
    }

    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide) {
            updateEnergy((ServerPlayer) event.getEntity());
        }
    }

    private static void updateEnergy(ServerPlayer player) {
        int signStrength = player.getData(TWAttachmentTypes.SIGN_STRENGTH);
        if (signStrength == 0) {
            return;
        }

        var energyWrapper = new TWEnergyWrapper(player);
        if (energyWrapper.isFull()) {
            return;
        }

        var increase = 0.2f + signStrength / 5f;
        if (player.hasEffect(TWEffects.ENERGY_REGENERATION)) {
            increase += (player.getEffect(TWEffects.ENERGY_REGENERATION).getAmplifier() + 1) / 5f;
        }

        energyWrapper.increase(increase);
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(final RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD, TWItems.KIKIMORA_TOOTH.get(), TWPotions.ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(TWPotions.ENERGY_REGENERATION_POTION, Items.REDSTONE, TWPotions.LONG_ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(TWPotions.ENERGY_REGENERATION_POTION, Items.GLOWSTONE_DUST, TWPotions.STRONG_ENERGY_REGENERATION_POTION);
        event.getBuilder().addMix(Potions.AWKWARD, Items.BLAZE_ROD, TWPotions.FROST_RESISTANCE_POTION);
        event.getBuilder().addMix(TWPotions.FROST_RESISTANCE_POTION, Items.REDSTONE, TWPotions.LONG_FROST_RESISTANCE_POTION);
    }

    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        new TWSetEnergyCommand(event.getDispatcher());
        new TWGetEnergyCommand(event.getDispatcher());
        new TWSetSignStrengthCommand(event.getDispatcher());
        new TWGetSignStrengthCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void registerPayloadsEvent(final RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar("1");

        registrar.playToClient(TWEnergyS2C.TYPE, TWEnergyS2C.STREAM_CODEC, (payload, context) -> {
            context.player().setData(TWAttachmentTypes.ENERGY.get(), payload.value());
        });

        registrar.playToClient(TWMaxEnergyS2C.TYPE, TWMaxEnergyS2C.STREAM_CODEC, (payload, context) -> {
            context.player().setData(TWAttachmentTypes.MAX_ENERGY.get(), payload.value());
        });

        registrar.playToClient(TWSignStrengthS2C.TYPE, TWSignStrengthS2C.STREAM_CODEC, (payload, context) -> {
            context.player().setData(TWAttachmentTypes.SIGN_STRENGTH.get(), payload.value());
        });

        registrar.playToServer(TWCastSignC2S.TYPE, TWCastSignC2S.STREAM_CODEC, (payload, context) -> {
            var energy = new TWEnergyWrapper((ServerPlayer) context.player());
            var signType = TWRegistries.SIGN_TYPE.getOrThrow(payload.signType()).value();
            if(energy.get() < signType.energyConsumed()){
                return;
            }
            energy.decrease(signType.energyConsumed());
            PacketDistributor.sendToAllPlayers(new TWSignCastedS2C(payload.signType()));
        });

        registrar.playToClient(TWSignCastedS2C.TYPE, TWSignCastedS2C.STREAM_CODEC, (payload, context) -> {
            var player = context.player();
            var signType = TWRegistries.SIGN_TYPE.getOrThrow(payload.signType()).value();
            player.level().addParticle(signType.particle(), player.getX(), player.getY(), player.getZ(), 0, 1, 0);
        });
    }

    @SubscribeEvent
    public static void newRegistryEvent(final NewRegistryEvent event){
        event.register(TWRegistries.SIGN_TYPE);
    }
}