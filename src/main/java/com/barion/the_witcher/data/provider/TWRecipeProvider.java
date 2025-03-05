package com.barion.the_witcher.data.provider;

import com.ametrinstudios.ametrin.data.provider.ExtendedRecipeProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class TWRecipeProvider extends ExtendedRecipeProvider {

    public TWRecipeProvider(HolderLookup.Provider registries, RecipeOutput output, Set<ResourceLocation> recipeSet) {
        super(TheWitcher.MOD_ID, registries, output, recipeSet);
    }

    @Override
    protected void buildRecipes() {
        oreSmelting(TWItems.SILVER_INGOT.get(), TWItems.RAW_SILVER.get());
        nineBlockStorage(RecipeCategory.MISC, TWItems.SILVER_INGOT.get(), TWBlocks.SILVER_BLOCK.get());
        nineBlockStorage(RecipeCategory.MISC, TWItems.SILVER_NUGGET.get(), TWItems.SILVER_INGOT.get());
        nineBlockStorage(RecipeCategory.MISC, TWItems.RAW_SILVER.get(), TWBlocks.RAW_SILVER_BLOCK.get());
        nineBlockStorage(RecipeCategory.MISC, TWItems.STEEL_NUGGET.get(), TWItems.STEEL_INGOT.get());

        {shaped(RecipeCategory.COMBAT, TWItems.SILVER_SWORD.get())
                .define('#', TWTags.Items.SILVER_INGOTS)
                .define('+', TWTags.Items.STEEL_INGOTS)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("+")
                .pattern("-")
                .unlockedBy("has_silver_ingot", has(TWTags.Items.SILVER_INGOTS))
                .save(output);} // Silver Sword
        sword(TWItems.STEEL_SWORD.get(), TWTags.Items.STEEL_INGOTS);

        stairSlabWallButton(TWBlocks.FROSTED_COBBLESTONE_STAIRS.get(), TWBlocks.FROSTED_COBBLESTONE_SLAB.get(), TWBlocks.FROSTED_COBBLESTONE_WALL.get(), TWBlocks.FROSTED_COBBLESTONE_BUTTON.get(), TWBlocks.FROSTED_COBBLESTONE.get(), TWBlocks.FROSTED_STONE.get());
        stairSlabWallButton(TWBlocks.FROSTED_STONE_STAIRS.get(), TWBlocks.FROSTED_STONE_SLAB.get(), TWBlocks.FROSTED_STONE_WALL.get(), TWBlocks.FROSTED_STONE_BUTTON.get(), TWBlocks.FROSTED_STONE.get(), true);
        stairSlabWallButton(TWBlocks.FROSTED_STONE_BRICK_STAIRS.get(), TWBlocks.FROSTED_STONE_BRICK_SLAB.get(), TWBlocks.FROSTED_STONE_BRICK_WALL.get(), TWBlocks.FROSTED_STONE_BRICK_BUTTON.get(), TWBlocks.FROSTED_STONE_BRICKS.get(), TWBlocks.FROSTED_STONE.get(), TWBlocks.FROSTED_COBBLESTONE.get());
        stairSlabWallButton(TWBlocks.CRACKED_FROSTED_STONE_BRICK_STAIRS.get(), TWBlocks.CRACKED_FROSTED_STONE_BRICK_SLAB.get(), TWBlocks.CRACKED_FROSTED_STONE_BRICK_WALL.get(), TWBlocks.CRACKED_FROSTED_STONE_BRICK_BUTTON.get(), TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get(), TWBlocks.FROSTED_STONE_BRICKS.get(), TWBlocks.FROSTED_STONE.get(), TWBlocks.FROSTED_COBBLESTONE.get());
        stairSlabWallButton(TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE_BUTTON.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE.get(), TWBlocks.DEEP_FROSTED_STONE.get());
        stairSlabWallButton(TWBlocks.DEEP_FROSTED_STONE_STAIRS.get(), TWBlocks.DEEP_FROSTED_STONE_SLAB.get(), TWBlocks.DEEP_FROSTED_STONE_WALL.get(), TWBlocks.DEEP_FROSTED_STONE_BUTTON.get(), TWBlocks.DEEP_FROSTED_STONE.get(), true);
        stairSlabWallButton(TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS.get(), TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB.get(), TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL.get(), TWBlocks.DEEP_FROSTED_STONE_BRICK_BUTTON.get(), TWBlocks.DEEP_FROSTED_STONE_BRICKS.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE.get(), TWBlocks.DEEP_FROSTED_STONE.get());
        stairSlabWallButton(TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS.get(), TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB.get(), TWBlocks.DEEP_FROSTED_STONE_TILE_WALL.get(), TWBlocks.DEEP_FROSTED_STONE_TILE_BUTTON.get(), TWBlocks.DEEP_FROSTED_STONE_TILES.get(), TWBlocks.DEEP_FROSTED_COBBLESTONE.get(), TWBlocks.DEEP_FROSTED_STONE.get(), TWBlocks.DEEP_FROSTED_STONE_BRICKS.get());

        shapeless(RecipeCategory.BUILDING_BLOCKS, TWBlocks.FROSTED_STONE.get(), 4, TWBlocks.FROSTED_COBBLESTONE.get(), 4);
        shapeless(RecipeCategory.BUILDING_BLOCKS, TWBlocks.DEEP_FROSTED_STONE.get(), 4, TWBlocks.DEEP_FROSTED_COBBLESTONE.get(), 4);

        float xp = 0.1f;
        int time = 200;

        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, TWBlocks.FROSTED_COBBLESTONE.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE_STAIRS, TWBlocks.FROSTED_COBBLESTONE_STAIRS.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE_SLAB, TWBlocks.FROSTED_COBBLESTONE_SLAB.get(), xp/2, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE_WALL, TWBlocks.FROSTED_COBBLESTONE_WALL.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE, TWBlocks.FROSTED_STONE.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_STAIRS, TWBlocks.FROSTED_STONE_STAIRS.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_SLAB, TWBlocks.FROSTED_STONE_SLAB.get(), xp/2, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BUTTON, TWBlocks.FROSTED_STONE_BUTTON.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, TWBlocks.FROSTED_STONE_BRICKS.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_STAIRS, TWBlocks.FROSTED_STONE_BRICK_STAIRS.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_SLAB, TWBlocks.FROSTED_STONE_BRICK_SLAB.get(), xp/2, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_WALL, TWBlocks.FROSTED_STONE_BRICK_WALL.get(), xp, time);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.CRACKED_STONE_BRICKS, TWBlocks.CRACKED_FROSTED_STONE_BRICKS.get(), xp, time);

        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE, TWBlocks.DEEP_FROSTED_COBBLESTONE.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE_STAIRS, TWBlocks.DEEP_FROSTED_COBBLESTONE_STAIRS.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE_SLAB, TWBlocks.DEEP_FROSTED_COBBLESTONE_SLAB.get(), xp, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE_WALL, TWBlocks.DEEP_FROSTED_COBBLESTONE_WALL.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE, TWBlocks.DEEP_FROSTED_STONE.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICKS, TWBlocks.DEEP_FROSTED_STONE_BRICKS.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_STAIRS, TWBlocks.DEEP_FROSTED_STONE_BRICK_STAIRS.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_SLAB, TWBlocks.DEEP_FROSTED_STONE_BRICK_SLAB.get(), xp, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_WALL, TWBlocks.DEEP_FROSTED_STONE_BRICK_WALL.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.CRACKED_DEEPSLATE_BRICKS, TWBlocks.CRACKED_DEEP_FROSTED_STONE_BRICKS.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILES, TWBlocks.DEEP_FROSTED_STONE_TILES.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_STAIRS, TWBlocks.DEEP_FROSTED_STONE_TILE_STAIRS.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_SLAB, TWBlocks.DEEP_FROSTED_STONE_TILE_SLAB.get(), xp, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_WALL, TWBlocks.DEEP_FROSTED_STONE_TILE_WALL.get(), xp*2, time*2);
        smelting(RecipeCategory.BUILDING_BLOCKS, Items.CRACKED_DEEPSLATE_TILES, TWBlocks.CRACKED_DEEP_FROSTED_STONE_TILES.get(), xp*2, time*2);

        shapeless(RecipeCategory.FOOD, TWItems.BEER.get())
                .requires(tag(TWTags.Items.BREWS_BEER), 4)
                .requires(TWItems.HOT_WATER_BOTTLE.get())
                .unlockedBy(getHasName(TWItems.HOT_WATER_BOTTLE.get()), has(TWItems.HOT_WATER_BOTTLE.get()))
                .save(output, recipeID(TWItems.BEER.get(), TWItems.HOT_WATER_BOTTLE.get()));

        smelting(RecipeCategory.FOOD, TWItems.HOT_WATER_BOTTLE.get(), Items.POTION, 0.1f, 200);
        smoking(TWItems.HOT_WATER_BOTTLE.get(), Items.POTION, 0.1f, 200);

        stairSlabWallButton(TWBlocks.HALLUCINATED_STONE_STAIRS.get(), TWBlocks.HALLUCINATED_STONE_SLAB.get(), TWBlocks.HALLUCINATED_STONE_WALL.get(), TWBlocks.HALLUCINATED_STONE_BUTTON.get(), TWBlocks.HALLUCINATED_STONE_STAIRS.get());
    }

    public static class Runner extends ExtendedRecipeProvider.Runner{
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected ExtendedRecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput, Set<ResourceLocation> set) {
            return new TWRecipeProvider(provider, recipeOutput, set);
        }

        @Override
        public @NotNull String getName() {
            return "The Witcher recipes";
        }
    }
}