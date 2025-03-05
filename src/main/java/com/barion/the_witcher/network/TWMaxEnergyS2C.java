package com.barion.the_witcher.network;

import com.barion.the_witcher.TheWitcher;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record TWMaxEnergyS2C(int value) implements CustomPacketPayload {
    public static final Type<TWMaxEnergyS2C> TYPE = new Type<>(TheWitcher.locate("max_energy"));

    public static final StreamCodec<ByteBuf, TWMaxEnergyS2C> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            TWMaxEnergyS2C::value,
            TWMaxEnergyS2C::new
    );

    @Override
    public @NotNull Type<TWMaxEnergyS2C> type() {
        return TYPE;
    }
}
