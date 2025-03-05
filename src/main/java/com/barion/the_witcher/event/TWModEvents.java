package com.barion.the_witcher.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.network.TWEnergyS2C;
import com.barion.the_witcher.network.TWMaxEnergyS2C;
import com.barion.the_witcher.network.TWSignStrengthS2C;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

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
    }
}