package com.barion.the_witcher.registry.recipe;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class TWRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, TheWitcher.MOD_ID);

    public static final Supplier<RecipeSerializer<TWMasterSmithingRecipe>> MASTER_SMITHING = REGISTER.register(TWMasterSmithingRecipe.ID, TWMasterSmithingRecipe.Serializer::new);
}
