package com.barion.the_witcher.registry.item;

import com.ametrinstudios.ametrin.world.item.PortalCatalystItem;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWArmorMaterials;
import com.barion.the_witcher.registry.TWEntityTypes;
import com.barion.the_witcher.registry.TWPortals;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.world.item.TWKikimoraToothItem;
import com.barion.the_witcher.world.item.TWSilverSwordItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class TWItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(TheWitcher.MOD_ID);

    public static final DeferredItem<Item> TAB_LOGO = REGISTER.registerSimpleItem("tab_logo");

    public static final DeferredItem<Item> RAW_SILVER = REGISTER.registerSimpleItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = REGISTER.registerSimpleItem("silver_ingot");
    public static final DeferredItem<Item> SILVER_NUGGET = REGISTER.registerSimpleItem("silver_nugget");
    public static final DeferredItem<TWSilverSwordItem> SILVER_SWORD = REGISTER.registerItem("silver_sword", properties -> silverSword(12, 256, Rarity.COMMON, properties));
    public static final DeferredItem<TWSilverSwordItem> MASTERFUL_SILVER_SWORD = REGISTER.registerItem("masterful_silver_sword", properties -> silverSword(16, 512, Rarity.RARE, properties));

    public static final DeferredItem<Item> STEEL_INGOT = REGISTER.registerSimpleItem("steel_ingot");
    public static final DeferredItem<Item> STEEL_NUGGET = REGISTER.registerSimpleItem("steel_nugget");
    public static final DeferredItem<SwordItem> STEEL_SWORD = REGISTER.registerItem("steel_sword", properties -> sword(TWToolMaterials.STEEL, 0, -2, 0, Rarity.COMMON, properties));
    public static final DeferredItem<SwordItem> MASTERFUL_STEEL_SWORD = REGISTER.registerItem("masterful_steel_sword", properties -> sword(TWToolMaterials.STEEL, 4, -1.5f, 500, Rarity.RARE, properties));
    public static final DeferredItem<ArmorItem> REINFORCED_LEATHER_HELMET = REGISTER.registerItem("reinforced_leather_helmet", properties -> new ArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorType.HELMET, properties));
    public static final DeferredItem<ArmorItem> REINFORCED_LEATHER_CHESTPLATE = REGISTER.registerItem("reinforced_leather_chestplate", properties -> new ArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorType.CHESTPLATE, properties));
    public static final DeferredItem<ArmorItem> REINFORCED_LEATHER_LEGGINGS = REGISTER.registerItem("reinforced_leather_leggings", properties -> new ArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorType.LEGGINGS, properties));
    public static final DeferredItem<ArmorItem> REINFORCED_LEATHER_BOOTS = REGISTER.registerItem("reinforced_leather_boots", properties -> new ArmorItem(TWArmorMaterials.REINFORCED_LEATHER, ArmorType.BOOTS, properties));

    public static final DeferredItem<TWKikimoraToothItem> KIKIMORA_TOOTH = REGISTER.registerItem("kikimora_tooth", TWKikimoraToothItem::new);
    public static final DeferredItem<BlockItem> WHITE_MYRTLE = REGISTER.registerItem("white_myrtle", (properties) -> new BlockItem(TWBlocks.WHITE_MYRTLE_BUSH.get(), properties.useItemDescriptionPrefix()));
    public static final DeferredItem<BlockItem> CELANDINE = REGISTER.registerItem("celandine", (properties) -> new BlockItem(TWBlocks.CELANDINE_BUSH.get(), properties.useItemDescriptionPrefix()));
    public static final DeferredItem<Item> HOT_WATER_BOTTLE = REGISTER.registerSimpleItem("hot_water_bottle", new Item.Properties().stacksTo(4).craftRemainder(Items.GLASS_BOTTLE).component(DataComponents.CONSUMABLE, TWConsumables.HOT_WATER));
    public static final DeferredItem<Item> BEER = REGISTER.registerSimpleItem("beer", new Item.Properties().stacksTo(4).craftRemainder(Items.GLASS_BOTTLE).food(TWFoodProperties.BEER).component(DataComponents.CONSUMABLE, TWConsumables.BEER));

    public static final DeferredItem<SpawnEggItem> ICE_GHOST_SPAWN_EGG = REGISTER.registerItem("ice_ghost_spawn_egg", properties -> new SpawnEggItem(TWEntityTypes.ICE_GHOST.get(), properties));
    public static final DeferredItem<SpawnEggItem> WILD_HUNT_KNIGHT_SPAWN_EGG = REGISTER.registerItem("wild_hunt_knight_spawn_egg", properties -> new SpawnEggItem(TWEntityTypes.WILD_HUNT_KNIGHT.get(), properties));
    public static final DeferredItem<SpawnEggItem> WILD_HUNT_HOUND_SPAWN_EGG = REGISTER.registerItem("wild_hunt_hound_spawn_egg", properties -> new SpawnEggItem(TWEntityTypes.WILD_HUNT_HOUND.get(), properties));

    public static final DeferredItem<PortalCatalystItem> ICE_STAFF = REGISTER.registerItem("ice_staff", properties -> new PortalCatalystItem(TWPortals.WHITE_FROST, properties.stacksTo(1).rarity(Rarity.EPIC)));

//    public static final DeferredItem<BucketItem> ACID_BUCKET = register("acid_bucket", ()-> new BucketItem(TWFluids.SOURCE_ACID.get(), properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    private static TWSilverSwordItem silverSword(int dmgBonus, int bonusUses, Rarity rarity, Item.Properties properties) {
        return new TWSilverSwordItem(TWToolMaterials.SILVER, dmgBonus, 2, properties.durability(TWToolMaterials.SILVER.durability() + bonusUses).rarity(rarity));
    }

    private static SwordItem sword(ToolMaterial material, int dmg, float speed, int bonusUses, Rarity rarity, Item.Properties properties) {
        return new SwordItem(material, dmg, speed, properties.durability(material.durability() + bonusUses).rarity(rarity));
    }

//    public static Iterator<? extends Item> getAllItems() {
//        return REGISTER.getEntries().stream().map(DeferredHolder::get).iterator();
//    }
}