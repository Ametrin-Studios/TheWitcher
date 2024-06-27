package com.barion.the_witcher.client.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.TWKeyBinding;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public final class TWGameClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event){
        if(TWKeyBinding.CAST_SIGN.consumeClick()){

        }
    }
}