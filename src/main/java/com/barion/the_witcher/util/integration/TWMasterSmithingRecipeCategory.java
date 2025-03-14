//package com.barion.the_witcher.util.integration;
//
//import com.barion.the_witcher.client.screen.TWMasterSmithingScreen;
//import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
//import com.barion.the_witcher.registry.block.TWBlocks;
//import com.barion.the_witcher.util.TWUtil;
//import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import org.jetbrains.annotations.NotNull;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//public class TWMasterSmithingRecipeCategory implements IRecipeCategory<TWMasterSmithingRecipe> {
//    public static final ResourceLocation UID = TWUtil.locate("master_smithing");
//    private final IDrawable background;
//    private final IDrawable icon;
//
//    public TWMasterSmithingRecipeCategory(IGuiHelper guiHelper) {
//        background = guiHelper.createDrawable(TWMasterSmithingScreen.TEXTURE_LOCATION, 4, 4, 167, 77);
//        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TWBlocks.MASTER_SMITHING_TABLE.get()));
//    }
//
//    @Override
//    public @NotNull RecipeType<TWMasterSmithingRecipe> getRecipeType() { return TWJEIPlugin.MASTER_SMITHING; }
//
//    @Override
//    public @NotNull Component getTitle() { return TWMasterSmithingTableBlock.TextComponent; }
//
//    @Override
//    public @NotNull IDrawable getBackground() {return background;}
//
//    @Override
//    public @NotNull IDrawable getIcon() { return icon; }
//
//    @Override @ParametersAreNonnullByDefault
//    public void setRecipe(IRecipeLayoutBuilder builder, TWMasterSmithingRecipe recipe, IFocusGroup focuses) {
//        builder.addSlot(RecipeIngredientRole.INPUT, 40, 35).addIngredients(recipe.getIngredient());
//
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 112, 35).addIngredients(Ingredient.of(recipe.output));
//    }
//}
