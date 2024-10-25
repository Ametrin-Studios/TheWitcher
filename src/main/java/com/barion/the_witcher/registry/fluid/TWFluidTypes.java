package com.barion.the_witcher.registry.fluid;

import com.barion.the_witcher.TheWitcher;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class TWFluidTypes {
    public static final DeferredRegister<FluidType> REGISTER = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, TheWitcher.MOD_ID);

    public static final Supplier<FluidType> ACID = register("acid", FluidType.Properties.create().canConvertToSource(true).lightLevel(5).supportsBoating(true));

    private static Supplier<FluidType> register(String name, FluidType.Properties properties) {
        return REGISTER.register(name, () -> new FluidType(properties));
    }
}