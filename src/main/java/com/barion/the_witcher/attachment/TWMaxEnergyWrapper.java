package com.barion.the_witcher.attachment;

import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.minecraft.world.entity.player.Player;

public record TWMaxEnergyWrapper(Player player) {
    public int get() {
        return player.getData(TWAttachmentTypes.MAX_ENERGY);
    }

    public void set(int energy) {
        player.setData(TWAttachmentTypes.MAX_ENERGY, energy);
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