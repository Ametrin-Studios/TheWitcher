package com.barion.the_witcher.registry;

import com.barion.the_witcher.util.TWTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class TWTiers {
    public static final Tier SILVER = new SimpleTier(BlockTags.INCORRECT_FOR_GOLD_TOOL, 1024, 0, 1, 20, ()-> Ingredient.of(TWTags.Items.SILVER_INGOTS));
    public static final Tier STEEL = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2048, -2, 9, 20, ()-> Ingredient.of(TWTags.Items.STEEL_INGOTS));
}