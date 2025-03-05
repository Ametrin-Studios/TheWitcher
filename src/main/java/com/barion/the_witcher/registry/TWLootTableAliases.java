package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.legacy.structure_gel.api.registry.StructureGelRegistries;
import com.legacy.structure_gel.api.registry.registrar.RegistrarHandler;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public final class TWLootTableAliases {
    public static final RegistrarHandler<ResourceKey<LootTable>> HANDLER = RegistrarHandler.getOrCreate(StructureGelRegistries.Keys.LOOT_TABLE_ALIAS, TheWitcher.MOD_ID);

    static {
        createSelf(TWLootTables.Chests.ICE_RUIN);
        createSelf(TWLootTables.Chests.WHITE_FROST_PORTAL);
        createSelf(TWLootTables.Chests.WITCHER_CITADEL_FOOD);
        createSelf(TWLootTables.Chests.WITCHER_CITADEL_BREWING);
        createSelf(TWLootTables.Chests.WITCHER_CITADEL_SMITHING);
        createSelf(TWLootTables.Chests.WITCHER_CITADEL_UTIL);
    }


    static void createSelf(ResourceKey<LootTable> key){
        HANDLER.createStatic(key.location().getPath(), () -> key);
    }
}
