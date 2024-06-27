package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.util.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public final class TWItemTagsProvider extends ItemTagsProvider {
    public TWItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper){
        super(output, lookupProvider, blockTagsProvider, TheWitcher.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        copy(TWTags.Blocks.STORAGE_BLOCKS_SILVER, TWTags.Items.STORAGE_BLOCKS_SILVER);
        copy(TWTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, TWTags.Items.STORAGE_BLOCKS_RAW_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);

        tag(TWTags.Items.RAW_MATERIALS_SILVER).add(TWItems.RAW_SILVER.get());
        tag(TWTags.Items.SILVER_INGOTS).add(TWItems.SILVER_INGOT.get());
        tag(TWTags.Items.SILVER_NUGGETS).add(TWItems.SILVER_NUGGET.get());
        tag(TWTags.Items.STEEL_INGOTS).add(TWItems.STEEL_INGOT.get());
        tag(TWTags.Items.STEEL_NUGGETS).add(TWItems.STEEL_NUGGET.get());
        tag(TWTags.Items.STEEL_NUGGETS).add(TWItems.STEEL_NUGGET.get());

        tag(Tags.Items.INGOTS)
                .addTag(TWTags.Items.SILVER_INGOTS)
                .addTag(TWTags.Items.STEEL_INGOTS);

        tag(Tags.Items.NUGGETS)
                .addTag(TWTags.Items.SILVER_NUGGETS)
                .addTag(TWTags.Items.STEEL_NUGGETS);

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                TWBlocks.FROSTED_STONE.get().asItem(),
                TWBlocks.FROSTED_COBBLESTONE.get().asItem(),
                TWBlocks.DeepFrostedStone.get().asItem(),
                TWBlocks.DeepFrostedCobblestone.get().asItem(),
                TWBlocks.HALLUCINATED_STONE.get().asItem()
        );

        tag(ItemTags.FREEZE_IMMUNE_WEARABLES).add(
                TWItems.REINFORCED_LEATHER_HELMET.get(),
                TWItems.REINFORCED_LEATHER_CHESTPLATE.get(),
                TWItems.REINFORCED_LEATHER_LEGGINGS.get(),
                TWItems.REINFORCED_LEATHER_BOOTS.get()
        );

        tag(TWTags.Items.BREW_BEER).add(
                Items.WHEAT,
                Items.BROWN_MUSHROOM
        );

        tag(Tags.Items.RAW_MATERIALS).addTag(TWTags.Items.RAW_MATERIALS_SILVER);
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TWItems.SILVER_INGOT.get(), TWItems.STEEL_INGOT.get());
    }
}