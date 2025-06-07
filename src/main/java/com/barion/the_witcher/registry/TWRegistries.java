package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWSignType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.RegistryBuilder;

public final class TWRegistries {
    public static final Registry<TWSignType> SIGN_TYPE = new RegistryBuilder<>(Keys.SIGN_TYPE).create();

    public interface Keys{
        ResourceKey<Registry<TWSignType>> SIGN_TYPE = ResourceKey.createRegistryKey(TheWitcher.locate("sign_type"));
    }
}
