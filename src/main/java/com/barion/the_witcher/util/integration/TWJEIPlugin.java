package com.barion.the_witcher.util.integration;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import com.barion.the_witcher.util.TWUtil;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@JeiPlugin
public class TWJEIPlugin implements IModPlugin {
    public static final RecipeType<TWMasterSmithingRecipe> MASTER_SMITHING = RecipeType.create(TheWitcher.MOD_ID, "master_smithing", TWMasterSmithingRecipe.class);
    @Override
    public @NotNull ResourceLocation getPluginUid() {return TWUtil.locate("jei_plugin");}

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TWMasterSmithingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        var recipes = manager.getAllRecipesFor(TWRecipeTypes.MASTER_SMITHING.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(new RecipeType<>(TWMasterSmithingRecipeCategory.UID, TWMasterSmithingRecipe.class), recipes);
    }
}
