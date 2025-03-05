package com.barion.the_witcher.data.provider.loot_table;

import com.barion.the_witcher.registry.TWLootTables;
import com.barion.the_witcher.registry.item.TWItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;

import java.util.function.BiConsumer;

import static com.ametrinstudios.ametrin.data.LootTableProviderHelper.*;

public final class TWEquipmentLootProvider implements LootTableSubProvider {
    public TWEquipmentLootProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(TWLootTables.Equipment.WITCHER_CITADEL_TOP_SKELETON, LootTable.lootTable()
                .withPool(pool(one()).add(item(Items.LEATHER_HELMET, 1, one())))
        );

        output.accept(TWLootTables.Equipment.WILD_HUNT_KNIGHT, LootTable.lootTable()
                .withPool(pool(one())
                        .add(item(TWItems.REINFORCED_LEATHER_HELMET, 1, one()))
                        .add(item(Items.IRON_HELMET, 2, one()))
                        .add(EmptyLootItem.emptyItem())
                )
                .withPool(pool(one())
                        .add(item(TWItems.REINFORCED_LEATHER_CHESTPLATE, 1, one()))
                        .add(item(Items.IRON_CHESTPLATE, 2, one()))
                        .add(EmptyLootItem.emptyItem())
                )
                .withPool(pool(one())
                        .add(item(TWItems.REINFORCED_LEATHER_LEGGINGS, 1, one()))
                        .add(item(Items.IRON_LEGGINGS, 2, one()))
                        .add(EmptyLootItem.emptyItem())
                )
                .withPool(pool(one())
                        .add(item(TWItems.REINFORCED_LEATHER_BOOTS, 1, one()))
                        .add(item(Items.IRON_BOOTS, 2, one()))
                        .add(EmptyLootItem.emptyItem())
                )
                .withPool(pool(one())
                        .add(item(TWItems.STEEL_SWORD, 1, one()))
                        .add(item(Items.IRON_SWORD, 3, one()))
                )
                .withPool(pool(one())
                        .add(item(Items.SHIELD, 1, one()))
                        .add(EmptyLootItem.emptyItem())
                        .add(EmptyLootItem.emptyItem())
                )
        );
    }
}
