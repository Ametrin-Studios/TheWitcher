package com.barion.the_witcher.util.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWItems;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.item.TWCreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class TWEvents {
    @SubscribeEvent
    public static void registerCreativeModeTabs(Creat.Register event){
        TWCreativeModeTabs.WITCHER_TAB = event.registerCreativeModeTab(TWUtil.location("the_witcher"),
                builder -> builder.icon(()-> TWItems.TAB_LOGO.get().getDefaultInstance())
                        .title(Component.translatable("itemGroup.the_witcher")));
    }

    @SubscribeEvent
    public static void fillCreativeTabs(CreativeModeTabEvent.BuildContents event){
        TWCreativeModeTabs.registerWitcherTab(event);
    }
}