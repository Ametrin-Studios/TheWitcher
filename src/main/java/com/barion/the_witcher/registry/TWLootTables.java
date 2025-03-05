package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public interface TWLootTables {
    interface Equipment {
        ResourceKey<LootTable> WITCHER_CITADEL_TOP_SKELETON = locate("equipment/witcher_citadel/top_skeleton");
        ResourceKey<LootTable> WILD_HUNT_KNIGHT = locate("wild_hunt_knight");
    }

    private static ResourceKey<LootTable> locate(String key) {
        return ResourceKey.create(Registries.LOOT_TABLE, TheWitcher.locate(key));
    }
}
