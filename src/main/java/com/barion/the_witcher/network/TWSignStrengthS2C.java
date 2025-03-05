package com.barion.the_witcher.network;

import com.barion.the_witcher.TheWitcher;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record TWSignStrengthS2C(int value) implements CustomPacketPayload {
    public static final Type<TWSignStrengthS2C> TYPE = new Type<>(TheWitcher.locate("sign_strength"));

    public static final StreamCodec<ByteBuf, TWSignStrengthS2C> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            TWSignStrengthS2C::value,
            TWSignStrengthS2C::new
    );

    @Override
    public @NotNull Type<TWSignStrengthS2C> type() {
        return TYPE;
    }
}
