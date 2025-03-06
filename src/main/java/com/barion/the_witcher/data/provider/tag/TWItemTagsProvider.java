package com.barion.the_witcher.data.provider.tag;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public final class TWItemTagsProvider extends ItemTagsProvider {
    public TWItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagsProvider) {
        super(output, lookupProvider, blockTagsProvider, TheWitcher.MOD_ID);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {

        tag(TWTags.Items.RAW_MATERIALS_SILVER).add(TWItems.RAW_SILVER.get());
        tag(TWTags.Items.SILVER_INGOTS).add(TWItems.SILVER_INGOT.get());
        tag(TWTags.Items.SILVER_NUGGETS).add(TWItems.SILVER_NUGGET.get());
        tag(TWTags.Items.STEEL_INGOTS).add(TWItems.STEEL_INGOT.get());
        tag(TWTags.Items.STEEL_NUGGETS).add(TWItems.STEEL_NUGGET.get());
        tag(TWTags.Items.STEEL_NUGGETS).add(TWItems.STEEL_NUGGET.get());

        tag(Tags.Items.RAW_MATERIALS).addTag(TWTags.Items.RAW_MATERIALS_SILVER);

        tag(Tags.Items.INGOTS)
                .addTag(TWTags.Items.SILVER_INGOTS)
                .addTag(TWTags.Items.STEEL_INGOTS)
        ;

        tag(Tags.Items.NUGGETS)
                .addTag(TWTags.Items.SILVER_NUGGETS)
                .addTag(TWTags.Items.STEEL_NUGGETS)
        ;

        tag(ItemTags.SWORDS).add(
                TWItems.STEEL_SWORD.get(),
                TWItems.SILVER_SWORD.get(),
                TWItems.MASTERFUL_STEEL_SWORD.get(),
                TWItems.MASTERFUL_SILVER_SWORD.get()
        );

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                TWBlocks.FROSTED_STONE.asItem(),
                TWBlocks.FROSTED_COBBLESTONE.asItem(),
                TWBlocks.DEEP_FROSTED_STONE.asItem(),
                TWBlocks.DEEP_FROSTED_COBBLESTONE.asItem(),
                TWBlocks.HALLUCINATED_STONE.asItem()
        );

        tag(ItemTags.FREEZE_IMMUNE_WEARABLES).add(
                TWItems.REINFORCED_LEATHER_HELMET.get(),
                TWItems.REINFORCED_LEATHER_CHESTPLATE.get(),
                TWItems.REINFORCED_LEATHER_LEGGINGS.get(),
                TWItems.REINFORCED_LEATHER_BOOTS.get()
        );

        tag(TWTags.Items.BREWS_BEER).add(
                Items.WHEAT,
                Items.BROWN_MUSHROOM
        );

        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TWItems.SILVER_INGOT.get(), TWItems.STEEL_INGOT.get());

        copy(TWTags.Blocks.STORAGE_BLOCKS_SILVER, TWTags.Items.STORAGE_BLOCKS_SILVER);
        copy(TWTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, TWTags.Items.STORAGE_BLOCKS_RAW_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
    }
}