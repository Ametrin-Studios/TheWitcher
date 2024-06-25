package com.barion.the_witcher;

import com.ametrinstudios.ametrin.data.DataProviderHelper;
import com.barion.the_witcher.data.provider.TWBlockStateProvider;
import com.barion.the_witcher.data.provider.TWItemModelProvider;
import com.barion.the_witcher.data.provider.TWRecipeProvider;
import com.barion.the_witcher.data.provider.loot_table.TWBlockLoot;
import com.barion.the_witcher.data.provider.tag.*;
import com.barion.the_witcher.effect.TWEffects;
import com.barion.the_witcher.fluid.TWFluidTypes;
import com.barion.the_witcher.fluid.TWFluids;
import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.potion.TWPotions;
import com.barion.the_witcher.recipe.TWRecipeTypes;
import com.barion.the_witcher.registry.*;
import com.barion.the_witcher.util.TWConfig;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.block.entity.TWBlockEntities;
import com.barion.the_witcher.world.gen.TWFeatures;
import com.barion.the_witcher.world.gen.TWStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(TheWitcher.MOD_ID)
public class TheWitcher {
    public static final String MOD_ID = "the_witcher";

    public static final ResourceKey<Level> WHITE_FROST = ResourceKey.create(Registries.DIMENSION, TWUtil.location("white_frost"));

    public TheWitcher(IEventBus modBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, TWConfig.Common.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, TWConfig.Client.SPEC);

        TWItems.REGISTER.register(modBus);
        TWBlocks.REGISTER.register(modBus);
        TWEntityTypes.REGISTER.register(modBus);
        TWFeatures.REGISTER.register(modBus);
        TWBlockEntities.REGISTER.register(modBus);
        TWMenuTypes.REGISTER.register(modBus);
        TWRecipeTypes.REGISTER.register(modBus);
        TWEffects.REGISTER.register(modBus);
        TWPotions.REGISTER.register(modBus);
        TWPOIs.REGISTER.register(modBus);
        TWFluids.REGISTER.register(modBus);
        TWFluidTypes.REGISTER.register(modBus);

        modBus.addListener(this::setup);
        modBus.addListener(TWRecipeTypes::registerRecipeTypes);
        modBus.addListener(TWEntityTypes::registerAttributes);
        TWStructures.init();

//        RegistrarHandler.registerHandlers(MOD_ID, modBus);
    }

    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(()-> {
            TWMessages.register();
        });
    }

    @EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class DataGenerators{
        private DataGenerators() {}

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event){
            var helper = new DataProviderHelper(event);

            helper.add(TWBlockStateProvider::new);
            helper.add(TWItemModelProvider::new);
            helper.add(TWBiomeTagsProvider::new);
            helper.add(TWRecipeProvider::new);

            helper.addLootTables(builder -> builder.AddBlockProvider(TWBlockLoot::new));

            helper.addBlockAndItemTags(TWBlockTagsProvider::new, TWItemTagsProvider::new);
            helper.add(TWEntityTypeTagsProvider::new);
            helper.add(TWDamageTypeTagsProvider::new);
        }
    }
}