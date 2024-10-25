package com.barion.the_witcher;

import com.ametrinstudios.ametrin.data.DataProviderHelper;
import com.barion.the_witcher.data.provider.TWBlockStateProvider;
import com.barion.the_witcher.data.provider.TWDamageTypeProvider;
import com.barion.the_witcher.data.provider.TWItemModelProvider;
import com.barion.the_witcher.data.provider.TWRecipeProvider;
import com.barion.the_witcher.data.provider.loot_table.TWBlockLoot;
import com.barion.the_witcher.data.provider.tag.*;
import com.barion.the_witcher.registry.*;
import com.barion.the_witcher.registry.block.TWBlockEntities;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.damage.TWDamageTypes;
import com.barion.the_witcher.registry.fluid.TWFluidTypes;
import com.barion.the_witcher.registry.fluid.TWFluids;
import com.barion.the_witcher.registry.item.TWCreateModeTabs;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.registry.item.TWPotions;
import com.barion.the_witcher.registry.recipe.TWRecipeSerializers;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import com.barion.the_witcher.util.TWConfig;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(TheWitcher.MOD_ID)
public final class TheWitcher {
    public static final String MOD_ID = "the_witcher";

    public TheWitcher(IEventBus modBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, TWConfig.Common.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, TWConfig.Client.SPEC);

        TWBlockEntities.REGISTER.register(modBus);
        TWBlocks.REGISTER.register(modBus);

        TWDamageTypes.REGISTER.register(modBus);

        TWFluids.REGISTER.register(modBus);
        TWFluidTypes.REGISTER.register(modBus);

        TWCreateModeTabs.REGISTER.register(modBus);
        TWItems.REGISTER.register(modBus);
        TWPotions.REGISTER.register(modBus);

        TWRecipeTypes.REGISTER.register(modBus);
        TWRecipeSerializers.REGISTER.register(modBus);

        TWArmorMaterials.REGISTER.register(modBus);
        TWAttachmentTypes.REGISTER.register(modBus);
        TWEffects.REGISTER.register(modBus);
        TWEntityTypes.REGISTER.register(modBus);
        TWFeatures.REGISTER.register(modBus);
        TWMenuTypes.REGISTER.register(modBus);
        TWPOIs.REGISTER.register(modBus);

        modBus.addListener(TWEntityTypes::registerAttributes);
        TWStructures.init();

//        RegistrarHandler.registerHandlers(MOD_ID, modBus);
    }

    public static ResourceLocation locate(String key) { return ResourceLocation.fromNamespaceAndPath(TheWitcher.MOD_ID, key); }

    @EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class DataGenerators {
        private DataGenerators() {}

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event){
            var helper = new DataProviderHelper(event);


            helper.add((PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) -> new DatapackBuiltinEntriesProvider(output, lookupProvider, new RegistrySetBuilder()
                    .add(Registries.DAMAGE_TYPE, TWDamageTypeProvider::run),
                    Set.of(MOD_ID)
            ));

            helper.add(TWBlockStateProvider::new);
            helper.add(TWItemModelProvider::new);
            helper.add(TWBiomeTagsProvider::new);
            helper.add(TWRecipeProvider::new);

            helper.addLootTables(builder -> builder.addBlockProvider(TWBlockLoot::new));

            helper.addBlockAndItemTags(TWBlockTagsProvider::new, TWItemTagsProvider::new);
            helper.add(TWEntityTypeTagsProvider::new);
            helper.add(TWDamageTypeTagsProvider::new);

        }
    }
}