package com.barion.the_witcher.registry.recipe;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, TheWitcher.MOD_ID);

    public static final Supplier<RecipeType<TWMasterSmithingRecipe>> MASTER_SMITHING = REGISTER.register(TWMasterSmithingRecipe.ID, TWMasterSmithingRecipe.Type::new);
}