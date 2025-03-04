package com.barion.the_witcher.registry.item;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class TWCreateModeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, TheWitcher.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WITCHER_TAB = REGISTER.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.the_witcher"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> TWItems.TAB_LOGO.get().getDefaultInstance())
            .displayItems(TWCreateModeTabs::fillWitcherTab)
            .build()
    );

    private static void fillWitcherTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output event){
        event.accept(TWBlocks.ALCITE);
        event.accept(TWItems.RAW_SILVER);
        event.accept(TWBlocks.SILVER_BLOCK);
        event.accept(TWItems.SILVER_INGOT);
        event.accept(TWItems.SILVER_NUGGET);
        event.accept(TWItems.SILVER_SWORD);
        event.accept(TWItems.MASTERFUL_SILVER_SWORD);

        event.accept(TWItems.STEEL_INGOT);
        event.accept(TWItems.STEEL_NUGGET);
        event.accept(TWItems.STEEL_SWORD);
        event.accept(TWItems.MASTERFUL_STEEL_SWORD);
        event.accept(TWItems.REINFORCED_LEATHER_HELMET);
        event.accept(TWItems.REINFORCED_LEATHER_CHESTPLATE);
        event.accept(TWItems.REINFORCED_LEATHER_LEGGINGS);
        event.accept(TWItems.REINFORCED_LEATHER_BOOTS);
        event.accept(TWBlocks.MASTER_SMITHING_TABLE);

        event.accept(TWBlocks.POWER_BLOCK);

        event.accept(TWBlocks.FROSTED_COBBLESTONE);
        event.accept(TWBlocks.FROSTED_COBBLESTONE_STAIRS);
        event.accept(TWBlocks.FROSTED_COBBLESTONE_SLAB);
        event.accept(TWBlocks.FROSTED_COBBLESTONE_WALL);
        event.accept(TWBlocks.FROSTED_COBBLESTONE_BUTTON);
        event.accept(TWBlocks.FROSTED_STONE);
        event.accept(TWBlocks.FROSTED_STONE_STAIRS);
        event.accept(TWBlocks.FROSTED_STONE_SLAB);
        event.accept(TWBlocks.FROSTED_STONE_WALL);
        event.accept(TWBlocks.FROSTED_STONE_BUTTON);
        event.accept(TWBlocks.FROSTED_STONE_BRICKS);
        event.accept(TWBlocks.FROSTED_STONE_BRICK_STAIRS);
        event.accept(TWBlocks.FROSTED_STONE_BRICK_SLAB);
        event.accept(TWBlocks.FROSTED_STONE_BRICK_WALL);
        event.accept(TWBlocks.FROSTED_STONE_BRICK_BUTTON);
        event.accept(TWBlocks.CRACKED_FROSTED_STONE_BRICKS);
        event.accept(TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS);
        event.accept(TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB);
        event.accept(TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL);
        event.accept(TWBlocks.CRACKED_FROSTED_STONE_BRICK_BUTTON);

        event.accept(TWBlocks.DEEP_FROSTED_COBBLESTONE);
        event.accept(TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS);
        event.accept(TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB);
        event.accept(TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL);
        event.accept(TWBlocks.DEEP_FROSTED_COBBLESTONE_BUTTON);
        event.accept(TWBlocks.DEEP_FROSTED_STONE);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_STAIRS);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_SLAB);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_WALL);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BUTTON);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BRICKS);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_BRICK_BUTTON);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_STAIRS);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_SLAB);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_WALL);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICK_BUTTON);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_TILES);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_TILE_WALL);
        event.accept(TWBlocks.DEEP_FROSTED_STONE_TILE_BUTTON);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_STAIRS);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_SLAB);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_WALL);
        event.accept(TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILE_BUTTON);
        event.accept(TWBlocks.ICICLE);
        event.accept(TWBlocks.LARIMAR);

        event.accept(TWItems.CELANDINE);
        event.accept(TWItems.WHITE_MYRTLE);
        event.accept(TWItems.KIKIMORA_TOOTH);
        event.accept(TWItems.HOT_WATER_BOTTLE);

        event.accept(TWItems.ICE_STAFF);
        event.accept(TWItems.WILD_HUNT_KNIGHT_SPAWN_EGG);
        event.accept(TWItems.WILD_HUNT_HOUND_SPAWN_EGG);
        event.accept(TWItems.ICE_GHOST_SPAWN_EGG);

        event.accept(TWBlocks.HALLUCINATED_STONE);
        event.accept(TWBlocks.HALLUCINATED_STONE_STAIRS);
        event.accept(TWBlocks.HALLUCINATED_STONE_SLAB);
        event.accept(TWBlocks.HALLUCINATED_STONE_WALL);
        event.accept(TWBlocks.HALLUCINATED_STONE_BUTTON);
        event.accept(TWBlocks.ALCITE);
    }
}
