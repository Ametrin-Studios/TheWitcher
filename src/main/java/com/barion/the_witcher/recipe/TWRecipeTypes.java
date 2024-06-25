package com.barion.the_witcher.recipe;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.Supplier;

public class TWRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, TheWitcher.MOD_ID);

    public static final Supplier<RecipeSerializer<TWMasterSmithingRecipe>> MASTER_SMITHING = REGISTER.register("master_smithing", () -> TWMasterSmithingRecipe.Serializer.INSTANCE);

    public static void registerRecipeTypes(final RegisterEvent event) {
        event.register(Registries.RECIPE_TYPE, helper ->{
            helper.register(TWUtil.location(TWMasterSmithingRecipe.Type.ID), TWMasterSmithingRecipe.Type.INSTANCE);
        });
    }
}