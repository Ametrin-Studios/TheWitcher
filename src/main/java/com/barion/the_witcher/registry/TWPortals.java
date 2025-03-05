package com.barion.the_witcher.registry;

import com.ametrinstudios.ametrin.world.dimension.portal.PortalData;
import com.barion.the_witcher.registry.block.TWBlocks;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.world.level.Level;

public final class TWPortals {
    public static final PortalData WHITE_FROST =
            PortalData.builder(Level.OVERWORLD, TWLevels.WHITE_FROST)
                    .poi(TWPOIs.WHITE_FROST_PORTAL)
                    .portal(TWBlocks.WHITE_FROST_PORTAL)
                    .defaultFrame(TWBlocks.WHITE_FROST_PORTAL_FRAME)
                    .validFrames(TWTags.Blocks.WHITE_FROST_PORTAL_FRAME)
                    .build();
}
