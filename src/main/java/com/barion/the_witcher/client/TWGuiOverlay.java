package com.barion.the_witcher.client;

import com.barion.the_witcher.util.TWUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;

public final class TWGuiOverlay {
    private static final ResourceLocation SIGN_STRENGTH_INFO = TWUtil.location("textures/gui/sign/info.png");
    private static final ResourceLocation ENERGY_BAR_TEXTURE = TWUtil.location("textures/gui/sign/energy.png");

    public static final LayeredDraw.Layer EnergyLevel = ((graphics, tracker)-> {
        if(Minecraft.getInstance().player.isSpectator() || Minecraft.getInstance().player.isCreative()) { return; }


        int x = graphics.guiWidth()/2-92;
        int y = graphics.guiHeight()-30;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, ENERGY_BAR_TEXTURE);
        RenderSystem.setShaderColor(1, 1, 0, 1f);
        graphics.blitSprite(ENERGY_BAR_TEXTURE, x, y, (int) (184*TWPlayerEnergyData.getPercent()), 7);
    });
}