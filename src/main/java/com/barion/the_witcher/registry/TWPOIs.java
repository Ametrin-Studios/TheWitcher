package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TWPOIs {
    public static final DeferredRegister<PoiType> REGISTER = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, TheWitcher.MOD_ID);

    public static final Supplier<PoiType> WHITE_FROST_PORTAL = REGISTER.register("white_frost_portal", ()-> new PoiType(ImmutableSet.copyOf(TWBlocks.WHITE_FROST_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
    public static final Supplier<PoiType> MASTER_SMITH = REGISTER.register("master_smith", ()-> new PoiType(ImmutableSet.copyOf(TWBlocks.MASTER_SMITHING_TABLE.get().getStateDefinition().getPossibleStates()), 0, 1));
}