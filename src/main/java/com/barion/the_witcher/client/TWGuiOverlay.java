package com.barion.the_witcher.client;

import com.barion.the_witcher.TheWitcher;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public final class TWGuiOverlay {
    private static final ResourceLocation SIGN_STRENGTH_INFO = TheWitcher.locate("textures/gui/sign/info.png");
    private static final ResourceLocation ENERGY_BAR_TEXTURE = TheWitcher.locate("textures/gui/sign/energy.png");

    public static final LayeredDraw.Layer EnergyLevel = ((graphics, tracker) -> {
        if (Minecraft.getInstance().player.isSpectator() || Minecraft.getInstance().player.isCreative()) {
            return;
        }


        int x = graphics.guiWidth() / 2 - 92;
        int y = graphics.guiHeight() - 30;

        RenderSystem.setShaderTexture(0, ENERGY_BAR_TEXTURE);
        RenderSystem.setShaderColor(1, 1, 0, 1f);
        graphics.blitSprite(RenderType::guiTextured, ENERGY_BAR_TEXTURE, x, y, (int) (184 * TWPlayerEnergyData.getPercent()), 7);
    });
}