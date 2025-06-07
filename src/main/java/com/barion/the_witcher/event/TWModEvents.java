package com.barion.the_witcher.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.attachment.TWEnergyWrapper;
import com.barion.the_witcher.network.*;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import com.barion.the_witcher.registry.TWRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class TWModEvents {
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
            var signType = TWRegistries.SIGN_TYPE.get(payload.signType()).get().value();
            if(energy.get() < signType.energyConsumed()){
                return;
            }
            energy.decrease(signType.energyConsumed());
            PacketDistributor.sendToAllPlayers(new TWSignCastedS2C(payload.signType()));
        });

        registrar.playToClient(TWSignCastedS2C.TYPE, TWSignCastedS2C.STREAM_CODEC, (payload, context) -> {
            var player = context.player();
            var signType = TWRegistries.SIGN_TYPE.get(payload.signType()).get().value();
            player.level().addParticle(signType.particle(), player.getX(), player.getY(), player.getZ(), 0, 1, 0);
        });
    }

    @SubscribeEvent
    public static void newRegistryEvent(final NewRegistryEvent event){
        event.register(TWRegistries.SIGN_TYPE);
    }
}