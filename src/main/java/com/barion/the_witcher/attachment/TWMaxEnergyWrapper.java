package com.barion.the_witcher.attachment;

import com.barion.the_witcher.network.TWMaxEnergyS2C;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public record TWMaxEnergyWrapper(ServerPlayer player) {
    public int get() {
        return player.getData(TWAttachmentTypes.MAX_ENERGY);
    }

    public void set(int energy) {
        player.setData(TWAttachmentTypes.MAX_ENERGY, energy);
        PacketDistributor.sendToPlayer(player, new TWMaxEnergyS2C(energy));

        updateEnergy();
    }

    private void updateEnergy() {
        var energyWrapper = new TWEnergyWrapper(player);
        var maxEnergy = get();
        if (energyWrapper.get() > maxEnergy) {
            energyWrapper.set(maxEnergy);
        }
    }
}