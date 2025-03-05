package com.barion.the_witcher.registry.item;

import com.barion.the_witcher.world.TWTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public final class TWToolMaterials {
    public static final ToolMaterial SILVER = new ToolMaterial(BlockTags.INCORRECT_FOR_GOLD_TOOL, 1024, 0, 1, 20, TWTags.Items.SILVER_INGOTS);
    public static final ToolMaterial SILVER2 = new ToolMaterial(BlockTags.INCORRECT_FOR_GOLD_TOOL, 1024, 0, 1, 20, TWTags.Items.SILVER_INGOTS);
    public static final ToolMaterial STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2048, -2, 9, 20, TWTags.Items.STEEL_INGOTS);
}