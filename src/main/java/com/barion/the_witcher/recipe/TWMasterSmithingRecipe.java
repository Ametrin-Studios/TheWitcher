package com.barion.the_witcher.recipe;

import com.barion.the_witcher.registry.recipe.TWRecipeBookCategories;
import com.barion.the_witcher.registry.recipe.TWRecipeSerializers;
import com.barion.the_witcher.registry.recipe.TWRecipeTypes;
import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public final class TWMasterSmithingRecipe implements Recipe<TWMasterSmithingMenu> {
    public static final String ID = "master_smithing";
    public final ItemStack output;
    private final Ingredient ingredient;
    private final int xpCost;
    private PlacementInfo placementInfo;

    public TWMasterSmithingRecipe(Ingredient ingredient, ItemStack output, int xpCost) {
        this.ingredient = ingredient;
        this.output = output;
        this.xpCost = xpCost;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean matches(TWMasterSmithingMenu container, Level level) {
        return ingredient.test(container.getItem(TWMasterSmithingMenu.INPUT_SLOT_ID));
    }

    @Override
    @ParametersAreNonnullByDefault
    public @NotNull ItemStack assemble(TWMasterSmithingMenu container, HolderLookup.Provider provider) {
        return getResultItem(provider);
    }

    public @NotNull ItemStack getResultItem(@NotNull HolderLookup.Provider provider) {
        return output.copy();
    }

    public int getXpCost() {
        return xpCost;
    }

    @Override
    public @NotNull RecipeSerializer<? extends Recipe<TWMasterSmithingMenu>> getSerializer() {
        return TWRecipeSerializers.MASTER_SMITHING.get();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public @NotNull RecipeType<? extends Recipe<TWMasterSmithingMenu>> getType() {
        return TWRecipeTypes.MASTER_SMITHING.get();
    }

    @Override
    public @NotNull PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(this.ingredient);
        }

        return this.placementInfo;
    }

    @Override
    public @NotNull RecipeBookCategory recipeBookCategory() {
        return TWRecipeBookCategories.MASTER_SMITHING.get();
    }

    public static class Type implements RecipeType<TWMasterSmithingRecipe> {
        public Type() { }
    }

    public static class Serializer implements RecipeSerializer<TWMasterSmithingRecipe> {
        public static final MapCodec<TWMasterSmithingRecipe> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter((recipe) -> recipe.ingredient),
                ItemStack.STRICT_CODEC.fieldOf("output").forGetter((recipe) -> recipe.output),
                Codec.INT.fieldOf("xp").forGetter((recipe) -> recipe.xpCost)
        ).apply(builder, TWMasterSmithingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, TWMasterSmithingRecipe> STREAM_CODEC = StreamCodec.of(TWMasterSmithingRecipe.Serializer::toNetwork, TWMasterSmithingRecipe.Serializer::fromNetwork);

        private static TWMasterSmithingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            var ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            var output = ItemStack.STREAM_CODEC.decode(buffer);
            var xp = buffer.readInt();
            return new TWMasterSmithingRecipe(ingredient, output, xp);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, TWMasterSmithingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.getIngredient());
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            buffer.writeInt(recipe.getXpCost());
        }

        @Override
        public @NotNull MapCodec<TWMasterSmithingRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, TWMasterSmithingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
