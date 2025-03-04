package com.barion.the_witcher.registry.recipe;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWRecipeBookCategories {
    public static final DeferredRegister<RecipeBookCategory> REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_BOOK_CATEGORY, TheWitcher.MOD_ID);

    public static Supplier<RecipeBookCategory> MASTER_SMITHING = REGISTER.register("master_smithing", RecipeBookCategory::new);
}
