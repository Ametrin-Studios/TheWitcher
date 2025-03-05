package com.barion.the_witcher.data.provider.loot_table.chests;

import com.barion.the_witcher.registry.TWLootTables;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.registry.item.TWPotions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

import static com.ametrinstudios.ametrin.data.LootTableProviderHelper.*;

public interface TWWitcherCitadelLootProvider {
    static void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        consumer.accept(TWLootTables.Chests.WITCHER_CITADEL_BREWING, LootTable.lootTable()
                        .withPool(pool(number(10, 15))
                                .add(item(TWItems.WHITE_MYRTLE.get(), 6, one()))
                                .add(item(TWItems.BEER.get(), 4, one()))
                                .add(item(Items.WHEAT, 10, number(1, 4)))
                                .add(item(Items.GUNPOWDER, 10, number(1, 2)))
                                .add(item(Items.SPIDER_EYE, 12, number(1, 3)))
                                .add(item(Items.GLOWSTONE_DUST, 2, one()))
                                .add(item(TWItems.HOT_WATER_BOTTLE.get(), 4, one()))
                                .add(item(Items.REDSTONE, 3, one()))
                        )
                        .withPool(pool(number(1, 3))
                                        .add(item(TWItems.CELANDINE.get(), 2, number(1, 2)))
                                        .add(item(TWItems.KIKIMORA_TOOTH.get(), 2, one()))
                                        .add(item(Items.BLAZE_POWDER))
//                        .add(potion(TWItems.WhiteGull.get(), 2, one()))
                                        .add(potion(1, Potions.LONG_REGENERATION, number(0, 1)))
                                        .add(potion(1, TWPotions.ENERGY_REGENERATION_POTION, number(0, 1)))
                        )
        );

        consumer.accept(TWLootTables.Chests.WITCHER_CITADEL_FOOD, LootTable.lootTable()
                .withPool(pool(number(14, 19))
                                .add(item(Items.BREAD, 2, one()))
                                .add(item(Items.WHEAT_SEEDS, 4, one()))
                                .add(item(Items.PUMPKIN_SEEDS, 3, one()))
                                .add(item(Items.MELON_SEEDS, 3, one()))
                                .add(item(Items.GOLDEN_CARROT))
                                .add(item(Items.GOLDEN_APPLE, 1, number(0, 1)))
                                .add(item(Items.APPLE, 2, one()))
                                .add(suspiciousStew(2, one()))
                                .add(item(Items.BAKED_POTATO, 2, one()))
                                .add(item(Items.POTATO, 2, one()))
                                .add(item(Items.CARROT, 2, one()))
                                .add(item(Items.SUGAR_CANE, 2, one()))
                                .add(item(Items.MUSHROOM_STEW, 2, one()))
                                .add(item(Items.ROTTEN_FLESH, 5, one()))
                                .add(item(Items.COOKED_MUTTON))
                                .add(item(Items.COOKED_BEEF))
                                .add(item(Items.COOKED_PORKCHOP))
                                .add(item(Items.COOKED_CHICKEN))
                                .add(item(Items.COOKED_RABBIT))
                                .add(item(Items.COOKED_SALMON))
                                .add(item(Items.COOKED_COD))
                        //.add(lootItem(TWItems.Beer.get(), 1, lootNumber(0, 1)))
                )
        );

        consumer.accept(TWLootTables.Chests.WITCHER_CITADEL_SMITHING, LootTable.lootTable()
                .withPool(pool(number(4, 6))
                        .add(item(TWItems.SILVER_NUGGET.get(), 2, number(3, 4)))
                        .add(item(TWItems.RAW_SILVER.get(), 1, number(1, 2)))
                        .add(item(Items.IRON_INGOT, 5, number(2, 3)))
                        .add(item(Items.IRON_NUGGET, 7, number(3, 6)))
                        .add(item(Items.RAW_IRON, 5, number(2, 4)))
                        .add(item(Items.GOLD_INGOT, 5, number(2, 3)))
                        .add(item(Items.GOLD_NUGGET, 6, number(3, 6)))
                        .add(item(Items.RAW_GOLD, 5, number(2, 4)))
                )
                .withPool(pool(number(0, 2))
                        .add(item(TWItems.REINFORCED_LEATHER_HELMET.get(), 2, number(0, 1)))
                        .add(item(TWItems.REINFORCED_LEATHER_CHESTPLATE.get(), 2, number(0, 1)))
                        .add(item(TWItems.REINFORCED_LEATHER_LEGGINGS.get(), 2, number(0, 1)))
                        .add(item(TWItems.REINFORCED_LEATHER_BOOTS.get(), 2, number(0, 1)))
                        .add(item(TWItems.STEEL_SWORD.get(), 2, one()))
                        .add(item(TWItems.STEEL_INGOT.get(), 2, one()))
                        .add(item(TWItems.SILVER_INGOT.get(), 3, one()))
                        .add(item(TWItems.STEEL_NUGGET.get(), 3, number(1, 2)))
                        .add(item(Items.BLAZE_POWDER))
                )
        );

        consumer.accept(TWLootTables.Chests.WITCHER_CITADEL_UTIL, LootTable.lootTable()
                .withPool(pool(number(7, 14))
                        .add(item(Items.ARROW, 12, number(1, 3)))
                        .add(item(Items.COBWEB, 7, one()))
                        .add(item(Items.STRING, 9, number(1, 3)))
                        .add(item(TWItems.SILVER_NUGGET.get()))
                        .add(item(TWItems.STEEL_NUGGET.get(), 1, number(0, 1)))
                        .add(item(Items.REDSTONE, 7, one()))
                        .add(item(Items.ROTTEN_FLESH, 14, number(1, 3)))
                        .add(item(Items.GUNPOWDER, 9, one()))
                        .add(item(Items.PAPER, 10, one()))
                        .add(item(Items.BLAZE_POWDER, 1, number(0, 1)))
                        .add(item(TWItems.KIKIMORA_TOOTH.get(), 1, number(0, 1)))
                )
        );
    }
}
