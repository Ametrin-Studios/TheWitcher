package com.barion.the_witcher.registry.item;

import com.ametrinstudios.ametrin.world.item.CustomArmorItem;
import com.ametrinstudios.ametrin.world.item.PortalCatalystItem;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWArmorMaterials;
import com.barion.the_witcher.registry.TWEntityTypes;
import com.barion.the_witcher.registry.TWLevels;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.world.item.TWHotWaterBottleItem;
import com.barion.the_witcher.world.item.TWKikimoraToothItem;
import com.barion.the_witcher.world.item.TWSilverSwordItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Iterator;
import java.util.function.Supplier;

public final class TWItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(TheWitcher.MOD_ID);
    public static final Item.Properties DEFAULT_PROPERTIES = properties();

    public static final DeferredItem<Item> TAB_LOGO = REGISTER.register("tab_logo", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = register("raw_silver", item(DEFAULT_PROPERTIES));
    public static final DeferredItem<Item> SILVER_INGOT = register("silver_ingot", item(DEFAULT_PROPERTIES));
    public static final DeferredItem<Item> SILVER_NUGGET = register("silver_nugget", item(DEFAULT_PROPERTIES));
    public static final DeferredItem<TWSilverSwordItem> SILVER_SWORD = register("silver_sword", silverSword(12, 256, Rarity.COMMON));
    public static final DeferredItem<TWSilverSwordItem> MASTERFUL_SILVER_SWORD = register("masterful_silver_sword", silverSword(16, 512, Rarity.RARE));

    public static final DeferredItem<Item> STEEL_INGOT = register("steel_ingot", item(DEFAULT_PROPERTIES));
    public static final DeferredItem<Item> STEEL_NUGGET = register("steel_nugget", item(DEFAULT_PROPERTIES));
    public static final DeferredItem<SwordItem> STEEL_SWORD = register("steel_sword", sword(TWTiers.STEEL, 0, -2, 0, Rarity.COMMON));
    public static final DeferredItem<SwordItem> MASTERFUL_STEEL_SWORD = register("masterful_steel_sword", sword(TWTiers.STEEL, 4, -1.5f, 500, Rarity.RARE));
    public static final DeferredItem<CustomArmorItem> REINFORCED_LEATHER_HELMET = register("reinforced_leather_helmet", ()-> new CustomArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.HELMET, properties()));
    public static final DeferredItem<CustomArmorItem> REINFORCED_LEATHER_CHESTPLATE = register("reinforced_leather_chestplate", ()-> new CustomArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.CHESTPLATE, properties()));
    public static final DeferredItem<CustomArmorItem> REINFORCED_LEATHER_LEGGINGS = register("reinforced_leather_leggings", ()-> new CustomArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.LEGGINGS, properties()));
    public static final DeferredItem<CustomArmorItem> REINFORCED_LEATHER_BOOTS = register("reinforced_leather_boots", ()-> new CustomArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.BOOTS, properties()));

    public static final DeferredItem<TWKikimoraToothItem> KIKIMORA_TOOTH = register("kikimora_tooth", TWKikimoraToothItem::new);
    public static final DeferredItem<ItemNameBlockItem> WHITE_MYRTLE = register("white_myrtle", blockItem(TWBlocks.WHITE_MYRTLE_BUSH));
    public static final DeferredItem<ItemNameBlockItem> CELANDINE = register("celandine", blockItem(TWBlocks.CELANDINE_BUSH));
    public static final DeferredItem<Item> HOT_WATER_BOTTLE = register("hot_water_bottle", () -> new TWHotWaterBottleItem(properties().stacksTo(4).craftRemainder(Items.GLASS_BOTTLE).food(TWFoodProperties.HOT_WATER_BOTTLE)));
    public static final DeferredItem<Item> BEER = register("beer", item(properties().stacksTo(4).craftRemainder(Items.GLASS_BOTTLE).food(TWFoodProperties.BEER)));

    public static final DeferredItem<SpawnEggItem> WILD_HUNT_KNIGHT_SPAWN_EGG = register("wild_hunt_knight_spawn_egg", ()-> new DeferredSpawnEggItem(TWEntityTypes.WILD_HUNT_KNIGHT, -16777216, -6684673, DEFAULT_PROPERTIES));
    public static final DeferredItem<SpawnEggItem> WILD_HUNT_HOUND_SPAWN_EGG = register("wild_hunt_hound_spawn_egg", ()-> new DeferredSpawnEggItem(TWEntityTypes.WILD_HUNT_HOUND, -13421773, -16737895, DEFAULT_PROPERTIES));
    public static final DeferredItem<SpawnEggItem> ICE_GHOST_SPAWN_EGG = register("ice_ghost_spawn_egg", ()-> new DeferredSpawnEggItem(TWEntityTypes.ICE_GHOST, -13369345, -16776961, DEFAULT_PROPERTIES));

    public static final DeferredItem<PortalCatalystItem> ICE_STUFF = register("ice_stuff", ()-> new PortalCatalystItem(TWBlocks.WHITE_FROST_PORTAL, TWLevels.WHITE_FROST, properties().stacksTo(1).rarity(Rarity.EPIC)));

//    public static final DeferredItem<BucketItem> ACID_BUCKET = register("acid_bucket", ()-> new BucketItem(TWFluids.SOURCE_ACID.get(), properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    private static Supplier<Item> item(Item.Properties properties) {return () -> new Item(properties);}
    private static Supplier<ItemNameBlockItem> blockItem(Supplier<? extends Block> block) {return () -> new ItemNameBlockItem(block.get(), DEFAULT_PROPERTIES);}
    private static Supplier<TWSilverSwordItem> silverSword(int dmgBonus, int bonusUses, Rarity rarity){
        return () -> new TWSilverSwordItem(TWTiers.SILVER, dmgBonus, 2, properties().durability(TWTiers.SILVER.getUses() + bonusUses).rarity(rarity));
    }
    private static Supplier<SwordItem> sword(Tier tier, int dmg, float speed, int bonusUses, Rarity rarity){
        return () -> new SwordItem(tier, properties().durability(tier.getUses() + bonusUses).rarity(rarity));
    }

    public static Item.Properties properties() {return new Item.Properties();}

    private static <I extends Item> DeferredItem<I> register(String id, Supplier<I> item) {return REGISTER.register(id, item);}
    public static Iterator<? extends Item> getAllItems() {return REGISTER.getEntries().stream().map(DeferredHolder::get).iterator();}
}