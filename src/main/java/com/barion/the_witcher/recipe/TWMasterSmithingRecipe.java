package com.barion.the_witcher.recipe;

import com.barion.the_witcher.registry.TWBlocks;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingRecipe implements Recipe<TWMasterSmithingMenu> {
    private final ItemStack output;
    private final Ingredient ingredient;
    private final int xpCost;

    public TWMasterSmithingRecipe(Ingredient ingredient, ItemStack output, int xpCost) {
        this.ingredient = ingredient;
        this.output = output;
        this.xpCost = xpCost;
    }

    @Override @ParametersAreNonnullByDefault
    public boolean matches(TWMasterSmithingMenu container, Level level) {
        return ingredient.test(container.getItem(TWMasterSmithingMenu.INPUT_SLOT_ID));
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull ItemStack assemble(TWMasterSmithingMenu container, HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return true; }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull HolderLookup.Provider provider) {
        return output.copy();
    }

    public int getXpCost() { return xpCost; }

    @Override
    public @NotNull ItemStack getToastSymbol() {return TWBlocks.MASTER_SMITHING_TABLE.get().asItem().getDefaultInstance();}

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {return Serializer.INSTANCE;}
    public Ingredient getIngredient() {return ingredient;}
    @Override
    public @NotNull RecipeType<?> getType() {return Type.INSTANCE;}

    public static class Type implements RecipeType<TWMasterSmithingRecipe> {
        private Type() { }
        public static final RecipeType<TWMasterSmithingRecipe> INSTANCE = new Type();
        public static final String ID = "master_smithing";
    }

    public static class Serializer implements RecipeSerializer<TWMasterSmithingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = TWUtil.location("master_smithing");

        public static final MapCodec<TWMasterSmithingRecipe> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter((recipe) -> recipe.ingredient),
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
        public MapCodec<TWMasterSmithingRecipe> codec() { return CODEC; }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, TWMasterSmithingRecipe> streamCodec() { return STREAM_CODEC; }
    }
}
