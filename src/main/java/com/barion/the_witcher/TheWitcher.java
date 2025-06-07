package com.barion.the_witcher;

import com.ametrinstudios.ametrin.data.provider.CustomLootTableProvider;
import com.barion.the_witcher.data.provider.TWDamageTypeProvider;
import com.barion.the_witcher.data.provider.TWEquipmentAssetProvider;
import com.barion.the_witcher.data.provider.TWModelProvider;
import com.barion.the_witcher.data.provider.TWRecipeProvider;
import com.barion.the_witcher.data.provider.loot_table.TWBlockLootProvider;
import com.barion.the_witcher.data.provider.loot_table.TWChestLootProvider;
import com.barion.the_witcher.data.provider.tag.*;
import com.barion.the_witcher.registry.*;
import com.barion.the_witcher.registry.block.TWBlockEntities;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.block.TWDynamicSpawners;
import com.barion.the_witcher.registry.damage.TWDamageTypes;
import com.barion.the_witcher.registry.fluid.TWFluidTypes;
import com.barion.the_witcher.registry.fluid.TWFluids;
import com.barion.the_witcher.registry.item.TWConsumeEffectTypes;
import com.barion.the_witcher.registry.item.TWCreateModeTabs;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.registry.item.TWPotions;
import com.barion.the_witcher.registry.recipe.TWRecipeBookCategories;
import com.barion.the_witcher.registry.recipe.TWRecipeSerializers;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import com.barion.the_witcher.util.TWConfig;
import com.legacy.structure_gel.api.registry.registrar.RegistrarHandler;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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
        TWConsumeEffectTypes.REGISTER.register(modBus);
        TWItems.REGISTER.register(modBus);
        TWPotions.REGISTER.register(modBus);

        TWRecipeBookCategories.REGISTER.register(modBus);
        TWRecipeTypes.REGISTER.register(modBus);
        TWRecipeSerializers.REGISTER.register(modBus);

        TWAttachmentTypes.REGISTER.register(modBus);
        TWEffects.REGISTER.register(modBus);
        TWEntityTypes.REGISTER.register(modBus);
        TWFeatures.REGISTER.register(modBus);
        TWMenuTypes.REGISTER.register(modBus);
        TWPOIs.REGISTER.register(modBus);
        TWParticleTypes.REGISTER.register(modBus);

        TWSignTypes.REGISTER.register(modBus);

        modBus.addListener(TWEntityTypes::registerAttributes);

        RegistrarHandler.registerHandlers(MOD_ID, modBus, TWDynamicSpawners.HANDLER, TWLootTableAliases.HANDLER);
    }

    public static ResourceLocation locate(String key) {
        return ResourceLocation.fromNamespaceAndPath(TheWitcher.MOD_ID, key);
    }

    @EventBusSubscriber(modid = TheWitcher.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class DataGenerators {
        private DataGenerators() { }

        @SubscribeEvent
        public static void gatherData(GatherDataEvent.Client event) {
            event.createProvider(TWBiomeTagsProvider::new);

            event.createDatapackRegistryObjects(RegistrarHandler.injectRegistries(new RegistrySetBuilder())
                    .add(Registries.DAMAGE_TYPE, TWDamageTypeProvider::run)
            );

            event.createProvider(TWModelProvider::new);
            event.createProvider(TWRecipeProvider.Runner::new);

            event.createProvider(CustomLootTableProvider.builder()
                    .addBlockProvider(TWBlockLootProvider::new)
                    .addChestProvider(TWChestLootProvider::new)
                    ::build);

            event.createBlockAndItemTags(TWBlockTagsProvider::new, TWItemTagsProvider::new);
            event.createProvider(TWEntityTypeTagsProvider::new);
            event.createProvider(TWDamageTypeTagsProvider::new);
            event.createProvider(TWEquipmentAssetProvider::new);
        }
    }
}