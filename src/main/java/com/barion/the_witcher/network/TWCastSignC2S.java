package com.barion.the_witcher.network;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWRegistries;
import com.barion.the_witcher.world.TWSignType;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.NotNull;

public record TWCastSignC2S(ResourceKey<TWSignType> signType) implements CustomPacketPayload {
    public static final Type<TWCastSignC2S> TYPE = new Type<>(TheWitcher.locate("cast_sign"));

    public static final StreamCodec<ByteBuf, TWCastSignC2S> STREAM_CODEC = StreamCodec.composite(
            ResourceKey.streamCodec(TWRegistries.Keys.SIGN_TYPE),
            TWCastSignC2S::signType,
            TWCastSignC2S::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
