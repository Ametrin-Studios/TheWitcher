//package com.barion.the_witcher.util.integration;
//
//import com.barion.the_witcher.TheWitcher;
//import com.barion.the_witcher.client.screen.TWMasterSmithingScreen;
//import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
//import com.barion.the_witcher.registry.block.TWBlocks;
//import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import mezz.jei.api.recipe.types.IRecipeType;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import org.jetbrains.annotations.NotNull;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//public class TWMasterSmithingRecipeCategory implements IRecipeCategory<TWMasterSmithingRecipe> {
//    public static final ResourceLocation UID = TheWitcher.locate("master_smithing");
//    public static final IRecipeType<TWMasterSmithingRecipe> RECIPE_TYPE = IRecipeType.create(UID, TWMasterSmithingRecipe.class);
//    private final IDrawable background;
//    private final IDrawable icon;
//
//    public TWMasterSmithingRecipeCategory(IGuiHelper guiHelper) {
//        background = guiHelper.createDrawable(TWMasterSmithingScreen.TEXTURE_LOCATION, 4, 4, 167, 77);
//        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TWBlocks.MASTER_SMITHING_TABLE));
//    }
//
//
//    @Override
//    @ParametersAreNonnullByDefault
//    public void setRecipe(IRecipeLayoutBuilder builder, TWMasterSmithingRecipe recipe, IFocusGroup focuses) {
//        builder.addSlot(RecipeIngredientRole.INPUT, 40, 35).add(recipe.getIngredient());
//
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 112, 35).add(Ingredient.of(recipe.output.getItem()));
//    }
//
//    @Override
//    public @NotNull IRecipeType<TWMasterSmithingRecipe> getRecipeType() {
//        return RECIPE_TYPE;
//    }
//
//    @Override
//    public @NotNull Component getTitle() {
//        return TWMasterSmithingTableBlock.TEXT_COMPONENT;
//    }
//
//    @Override
//    public @NotNull IDrawable getIcon() {
//        return icon;
//    }
//
//    @Override
//    public int getWidth() {
//        return background.getWidth();
//    }
//
//    @Override
//    public int getHeight() {
//        return background.getHeight();
//    }
//
//    @Override
//    public void draw(@NotNull TWMasterSmithingRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
//        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
//        background.draw(guiGraphics);
//    }
//}
