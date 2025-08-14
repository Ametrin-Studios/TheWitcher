package com.barion.the_witcher.util.integration;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.event.RecipeEventHandler;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


@JeiPlugin
@SuppressWarnings("unused")
public final class TWJEIPlugin implements IModPlugin {
    private static final ResourceLocation UID = TheWitcher.locate("jei_plugin");


    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TWMasterSmithingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (RecipeEventHandler.recipes != null) {
            registration.addRecipes(TWMasterSmithingRecipeCategory.RECIPE_TYPE, RecipeEventHandler.recipes);
        }
    }
}
