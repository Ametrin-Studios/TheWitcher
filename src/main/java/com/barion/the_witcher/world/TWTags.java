package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public final class TWTags {
    public static final class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_SILVER = common("storage_blocks/silver");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = common("storage_blocks/raw_silver");
        public static final TagKey<Block> SPIKES_CAN_PLACE = tw("spikes_can_place");
        public static final TagKey<Block> ICE_GROUND_REPLACEABLE = tw("replaceable/ice_ground");
        public static final TagKey<Block> WHITE_FROST_PORTAL_FRAME = tw("portal_frame/white_frost");

        private static TagKey<Block> common(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Block> tw(String path) {
            return BlockTags.create(TWUtil.locate(path));
        }
    }

    public static final class Items {
        public static final TagKey<Item> STORAGE_BLOCKS_SILVER = common("storage_blocks/silver");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = common("storage_blocks/raw_silver");
        public static final TagKey<Item> RAW_MATERIALS_SILVER = common("raw_materials/raw_silver");
        public static final TagKey<Item> SILVER_INGOTS = common("ingots/silver");
        public static final TagKey<Item> SILVER_NUGGETS = common("nuggets/silver");

        public static final TagKey<Item> STEEL_INGOTS = tw("ingots/steel");
        public static final TagKey<Item> STEEL_NUGGETS = tw("nuggets/steel");
        public static final TagKey<Item> BREWS_BEER = tw("brews_beer");

        private static TagKey<Item> common(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Item> tw(String path) {
            return ItemTags.create(TWUtil.locate(path));
        }
    }

    public static final class EntityTypes {
        public static final TagKey<EntityType<?>> MAGIC_MOB = common("magic_mob");
        public static final TagKey<EntityType<?>> WILD_HUNT = tw("wild_hunt");
        public static final TagKey<EntityType<?>> WILD_HUNT_IGNORE = tw("wild_hunt_ignore");

        private static TagKey<EntityType<?>> common(String path) {
            return create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<EntityType<?>> tw(String path) {
            return create(TheWitcher.locate(path));
        }

        private static TagKey<EntityType<?>> create(ResourceLocation location) {
            return TagKey.create(Registries.ENTITY_TYPE, location);
        }
    }

    public static final class Biomes {
        public static final TagKey<Biome> IS_WHITE_FROST = tw("is/white_frost");
        public static final TagKey<Biome> HAS_ICY_RUIN = tw("has/icy_ruin");
        public static final TagKey<Biome> HAS_WITCHER_CITADEL = tw("has/witcher_citadel");
        public static final TagKey<Biome> ICICLE_CAN_GROW_IN = tw("icicle_can_grow_in");
        public static final TagKey<Biome> DEALS_FREEZING_DAMAGE = tw("deals_freezing_damage");
        public static final TagKey<Biome> HAS_WHITE_MYRTLE = tw("has/white_myrtle");

        private static TagKey<Biome> tw(String path) {
            return create(TheWitcher.locate(path));
        }

        private static TagKey<Biome> create(ResourceLocation location) {
            return TagKey.create(Registries.BIOME, location);
        }
    }
}