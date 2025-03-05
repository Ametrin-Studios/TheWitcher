package com.barion.the_witcher.attachment;

import com.barion.the_witcher.network.TWSignStrengthS2C;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public record TWSignStrengthWrapper(ServerPlayer player) {
    public static final int MAX_STRENGTH = 5;
    public static final int MIN_STRENGTH = 0;

    public int get() {
        return player.getData(TWAttachmentTypes.SIGN_STRENGTH);
    }

    public void set(int data) {
        player.setData(TWAttachmentTypes.SIGN_STRENGTH, data);
        PacketDistributor.sendToPlayer(player, new TWSignStrengthS2C(data));
        updateMaxEnergy();
    }

    public void increase() {
        set(Math.min(get() + 1, MAX_STRENGTH));
    }

    private void updateMaxEnergy() {
        var maxEnergyWrapper = new TWMaxEnergyWrapper(player);
        var signStrength = get();

        if (signStrength == 0) {
            maxEnergyWrapper.set(0);
            return;
        }

        maxEnergyWrapper.set(90 + (signStrength * 10));
    }

    public boolean isMax() {
        return get() == MAX_STRENGTH;
    }

    public boolean canUpgrade() {
        return !isMax();
    }
}