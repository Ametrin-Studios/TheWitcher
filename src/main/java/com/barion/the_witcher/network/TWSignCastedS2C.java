package com.barion.the_witcher.network;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWRegistries;
import com.barion.the_witcher.world.TWSignType;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.NotNull;

public record TWSignCastedS2C(ResourceKey<TWSignType> signType) implements CustomPacketPayload {
    public static final Type<TWSignCastedS2C> TYPE = new Type<>(TheWitcher.locate("sign_casted"));

    public static final StreamCodec<ByteBuf, TWSignCastedS2C> STREAM_CODEC = StreamCodec.composite(
            ResourceKey.streamCodec(TWRegistries.Keys.SIGN_TYPE),
            TWSignCastedS2C::signType,
            TWSignCastedS2C::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
