package com.barion.the_witcher.network;

import com.barion.the_witcher.TheWitcher;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record TWEnergyS2C(float value) implements CustomPacketPayload {
    public static final Type<TWEnergyS2C> TYPE = new Type<>(TheWitcher.locate("energy"));

    public static final StreamCodec<ByteBuf, TWEnergyS2C> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT,
            TWEnergyS2C::value,
            TWEnergyS2C::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
