package com.barion.the_witcher.data.provider;

import com.ametrinstudios.ametrin.data.provider.ExtendedItemModelProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.item.TWItems;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class TWItemModelProvider extends ExtendedItemModelProvider {
    private final ModelFile bigHandheldModel = getExistingFile(modLoc("item/big_sword"));

    public TWItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheWitcher.MOD_ID, existingFileHelper);
    }

    {
        priorityItemModelProviderRules.add((item, name, texture)->{
           if(!(item instanceof SwordItem)) {return false;}
            item(name, bigHandheldModel, texture);
           return true;
        });

        blockItemModelProviderRules.add((item, block, name, texture)->{
           if(!(block instanceof TWIcicleBlock)) {return false;}
           blockItem(name, getExistingFile(mcLoc("item/pointed_dripstone")), texture + "/down/tip");
           return true;
        });
        blockItemModelProviderRules.add((item, block, name, texture)->{
           if(!(block instanceof TWPowerBlock)) {return false;}
           withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name + "/on"));
           return true;
        });
    }

    @Override
    protected void registerModels() {
        runProviderRules(TWItems.getAllItems());
    }
}