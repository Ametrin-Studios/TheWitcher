package com.barion.the_witcher.util;

import com.ametrinstudios.ametrin.world.gen.util.StructurePieces;
import com.barion.the_witcher.TheWitcher;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public final class TWUtil {
    public static final Logger Logger = LogUtils.getLogger();
    public static StructurePieces.Builder pieceBuilder() { return new StructurePieces.Builder(); }
    public static ResourceLocation locate(String key) { return ResourceLocation.fromNamespaceAndPath(TheWitcher.MOD_ID, key); }
}