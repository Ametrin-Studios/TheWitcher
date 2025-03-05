package com.barion.the_witcher.attachment;

import com.barion.the_witcher.network.TWEnergyS2C;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public record TWEnergyWrapper(ServerPlayer player) {
    private static final int MIN_ENERGY = 0;
    public static final String NBT_ID = "energy";


    public float get() {
        return player.getData(TWAttachmentTypes.ENERGY);
    }

    public void set(float energy) {
        player.setData(TWAttachmentTypes.ENERGY, energy);
        PacketDistributor.sendToPlayer(player, new TWEnergyS2C(energy));
    }

    public void increase(float energy) {
        set(Math.min(get() + energy, getMax()));
    }

    public void decrease(float energy) {
        set(Math.max(MIN_ENERGY, get() - energy));
    }

    public int getMax() {
        return player.getData(TWAttachmentTypes.MAX_ENERGY);
    }

    public boolean isFull() {
        return get() >= getMax();
    }

    public float getPercent() {
        return get() / getMax();
    }
}