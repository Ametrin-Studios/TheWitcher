package com.barion.the_witcher.client.renderer;

import com.barion.the_witcher.util.TWConfig;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public final class TWWhiteFrostSpecialEffects extends DimensionSpecialEffects {
    public TWWhiteFrostSpecialEffects() {
        super(192, true, SkyType.OVERWORLD, false, false);
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 fogColor, float brightness) {
        return fogColor;
    }

    @Override
    public boolean isFoggyAt(int x, int y) {
        return TWConfig.Client.ALWAYS_FOGGY.get();
    }
}
