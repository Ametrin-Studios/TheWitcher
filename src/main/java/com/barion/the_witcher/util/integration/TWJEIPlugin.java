//package com.barion.the_witcher.util.integration;
//
//import com.barion.the_witcher.TheWitcher;
//import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.RecipeHolder;
//import org.jetbrains.annotations.NotNull;
//
//
//@JeiPlugin
//@SuppressWarnings("unused")
//public final class TWJEIPlugin implements IModPlugin {
//    private static final ResourceLocation UID = TheWitcher.locate("jei_plugin");
//
//
//    @Override
//    public @NotNull ResourceLocation getPluginUid() {
//        return UID;
//    }
//
//    @Override
//    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new TWMasterSmithingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//
//    public void registerRecipes(@NotNull IRecipeRegistration registration) {
//        var recipes = recipeMap.byType(TWRecipeTypes.MASTER_SMITHING.get()).stream().map(RecipeHolder::signType).toList();
//        registration.addRecipes(TWMasterSmithingRecipeCategory.RECIPE_TYPE, recipes);
//    }
//}
