//package com.barion.the_witcher.util.integration;
//
//import com.barion.the_witcher.client.screen.TWMasterSmithingScreen;
//import com.barion.the_witcher.registry.block.TWBlocks;
//import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
//import com.barion.the_witcher.util.TWUtil;
//import dev.emi.emi.api.EmiEntrypoint;
//import dev.emi.emi.api.EmiPlugin;
//import dev.emi.emi.api.EmiRegistry;
//import dev.emi.emi.api.recipe.EmiRecipeCategory;
//import dev.emi.emi.api.render.EmiTexture;
//import dev.emi.emi.api.stack.EmiStack;
//
//@EmiEntrypoint
//public final class TWEmiPlugin implements EmiPlugin {
//    public static final EmiStack MASTER_SMITHING_TABLE = EmiStack.of(TWBlocks.MASTER_SMITHING_TABLE);
//    public static final EmiRecipeCategory MASTER_SMITHING_CATEGORY
//            = new EmiRecipeCategory(TWUtil.locate("master_smithing_table"), MASTER_SMITHING_TABLE, new EmiTexture(TWMasterSmithingScreen.TEXTURE_LOCATION, 4, 4, 167, 77));
//
//
//    @Override
//    public void register(EmiRegistry registry) {
//        registry.addCategory(MASTER_SMITHING_CATEGORY);
//        registry.addWorkstation(MASTER_SMITHING_CATEGORY, MASTER_SMITHING_TABLE);
//
//        var manager = registry.getRecipeManager();
//        for (var recipe : manager.getAllRecipesFor(TWRecipeTypes.MASTER_SMITHING.get())) {
//            registry.addRecipe(new TWMasterSmithingEmiRecipe(recipe.id(), recipe.signType()));
//        }
//    }
//}
