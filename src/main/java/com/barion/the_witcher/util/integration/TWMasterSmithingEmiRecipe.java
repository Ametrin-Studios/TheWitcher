//package com.barion.the_witcher.util.integration;
//
//import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
//import dev.emi.emi.api.recipe.BasicEmiRecipe;
//import dev.emi.emi.api.stack.EmiIngredient;
//import dev.emi.emi.api.stack.EmiStack;
//import dev.emi.emi.api.widget.WidgetHolder;
//import net.minecraft.resources.ResourceLocation;
//
//public final class TWMasterSmithingEmiRecipe extends BasicEmiRecipe {
//    public TWMasterSmithingEmiRecipe(ResourceLocation id, TWMasterSmithingRecipe recipe) {
//        super(TWEmiPlugin.MASTER_SMITHING_CATEGORY, id, 167, 77);
//        inputs.add(EmiIngredient.of(recipe.getIngredient()));
//        outputs.add(EmiStack.of(recipe.output));
//    }
//
//    @Override
//    public void addWidgets(WidgetHolder widgets) {
//        widgets.addSlot(inputs.getFirst(), 40, 35);
//        widgets.addSlot(outputs.getFirst(), 112, 35);
//    }
//}
