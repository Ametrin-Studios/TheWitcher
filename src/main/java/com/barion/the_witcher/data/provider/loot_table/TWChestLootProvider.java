package com.barion.the_witcher.data.provider.loot_table;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.data.provider.loot_table.chests.TWWitcherCitadelLootProvider;
import com.barion.the_witcher.registry.TWLootTables;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.registry.item.TWPotions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

import static com.ametrinstudios.ametrin.data.LootTableProviderHelper.*;

public final class TWChestLootProvider implements LootTableSubProvider {

    public TWChestLootProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(TWLootTables.Chests.ICE_RUIN, LootTable.lootTable()
                .withPool(pool(number(6, 10))
                        .add(item(Items.ICE, 15, one()))
                        .add(item(Items.SNOW_BLOCK, 8, one()))
                        .add(item(Items.BONE, 5, one()))
                        .add(item(Items.POWDER_SNOW_BUCKET))
                        .add(item(TWItems.SILVER_NUGGET))
                        .add(potion(1, TWPotions.FROST_RESISTANCE_POTION, one()))
                )
        );

        output.accept(TWLootTables.Chests.WHITE_FROST_PORTAL, LootTable.lootTable()
                .withPool(pool(one())
                        .add(item(TWItems.ICE_STAFF))
                )
                .withPool(pool(one())
                        .add(potion(1, TWPotions.FROST_RESISTANCE_POTION, one()))
                        .add(potion(1, TWPotions.LONG_FROST_RESISTANCE_POTION, one()))
                )
                .withPool(pool(number(4, 8))
                        .add(item(Items.ICE, 20, number(3, 5)))
                        .add(item(TWItems.SILVER_NUGGET.get(), 8, number(1, 3)))
                        .add(item(TWItems.RAW_SILVER.get(), 5, number(0, 1)))
                        .add(item(TWItems.SILVER_INGOT.get(), 4, number(0, 1)))
                        .add(item(TWItems.STEEL_NUGGET.get(), 1, number(0, 3)))
                        .add(potion(1, Potions.STRENGTH, number(0, 1)))
                )
        );

        TWWitcherCitadelLootProvider.generate(output);
    }

    public static ResourceKey<LootTable> locate(String key) {
        return ResourceKey.create(Registries.LOOT_TABLE, TheWitcher.locate("chests/" + key));
    }
}