package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public interface TWLootTables {
    interface Chests {
        ResourceKey<LootTable> ICE_RUIN = locate("ice_ruin");

        ResourceKey<LootTable> WHITE_FROST_PORTAL = locate("white_frost_portal");

        ResourceKey<LootTable> WITCHER_CITADEL_BREWING = locate("witcher_citadel/brewing");
        ResourceKey<LootTable> WITCHER_CITADEL_FOOD = locate("witcher_citadel/food");
        ResourceKey<LootTable> WITCHER_CITADEL_SMITHING = locate("witcher_citadel/smithing");
        ResourceKey<LootTable> WITCHER_CITADEL_UTIL = locate("witcher_citadel/util");

        private static ResourceKey<LootTable> locate(String key) {
            return locateRoot("chests/" + key);
        }
    }

    interface Equipment {
        ResourceKey<LootTable> WITCHER_CITADEL_TOP_SKELETON = locate("witcher_citadel/top_skeleton");
        ResourceKey<LootTable> WILD_HUNT_KNIGHT = locate("wild_hunt_knight");

        private static ResourceKey<LootTable> locate(String key) {
            return locateRoot("equipment/" + key);
        }
    }

    private static ResourceKey<LootTable> locateRoot(String key) {
        return ResourceKey.create(Registries.LOOT_TABLE, TheWitcher.locate(key));
    }
}
