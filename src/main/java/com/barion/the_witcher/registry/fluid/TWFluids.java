package com.barion.the_witcher.registry.fluid;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.block.TWBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TWFluids {
    public static final DeferredRegister<Fluid> REGISTER = DeferredRegister.create(BuiltInRegistries.FLUID, TheWitcher.MOD_ID);

    public static final Supplier<FlowingFluid> SOURCE_ACID = REGISTER.register("source_acid",
            () -> new BaseFlowingFluid.Source(TWFluids.ACID_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_ACID = REGISTER.register("flowing_acid",
            () -> new BaseFlowingFluid.Flowing(TWFluids.ACID_PROPERTIES));

    private static final BaseFlowingFluid.Properties ACID_PROPERTIES = new BaseFlowingFluid.Properties(
            TWFluidTypes.ACID, SOURCE_ACID, FLOWING_ACID)
            .slopeFindDistance(4).levelDecreasePerBlock(1).block(TWBlocks.ACID);
//            .bucket(TWItems.AcidBucket);
}