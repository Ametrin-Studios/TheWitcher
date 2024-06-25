package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public final class TWAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> REGISTER = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, TheWitcher.MOD_ID);

    public static final Supplier<AttachmentType<Integer>> SIGN_STRENGTH = REGISTER.register("sign_strength", ()-> AttachmentType.builder(()-> 0).serialize(Codec.INT).copyOnDeath().build());
    public static final Supplier<AttachmentType<Integer>> MAX_ENERGY = REGISTER.register("max_energy", ()-> AttachmentType.builder(()-> 0).serialize(Codec.INT).copyOnDeath().build());
    public static final Supplier<AttachmentType<Float>> ENERGY = REGISTER.register("energy", ()-> AttachmentType.builder(()-> 0f).serialize(Codec.FLOAT).build());
}
