package com.barion.the_witcher.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

import java.util.List;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = TheWitcher.MOD_ID)
public final class RecipeEventHandler {
    private RecipeEventHandler() { }

    public static List<TWMasterSmithingRecipe> recipes = null;

    @SubscribeEvent
    private static void onRecipesReceived(final RecipesReceivedEvent event) {
        recipes = event.getRecipeMap().byType(TWRecipeTypes.MASTER_SMITHING.get()).stream().map(RecipeHolder::value).toList();
        System.out.println(recipes);
    }

    @SubscribeEvent
    private static void onClientDisconnect(final ClientPlayerNetworkEvent.LoggingOut event) {
        recipes = null;
    }

    @SubscribeEvent
    private static void onDataSync(final OnDatapackSyncEvent event) {
        event.sendRecipes(TWRecipeTypes.MASTER_SMITHING.get());
    }
}