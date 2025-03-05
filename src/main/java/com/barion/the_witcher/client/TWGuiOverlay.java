package com.barion.the_witcher.client;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWAttachmentTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public final class TWGuiOverlay {
    private static final ResourceLocation SIGN_STRENGTH_INFO = TheWitcher.locate("sign/info");
    private static final ResourceLocation ENERGY_BAR_TEXTURE = TheWitcher.locate("sign/energy");

    public static final LayeredDraw.Layer ENERGY_LEVEL = ((graphics, tracker) -> {
        var player = Minecraft.getInstance().player;
        assert player != null;

        if (player.isSpectator() || player.isCreative()) {
            return;
        }

        int x = graphics.guiWidth() / 2 - 92;
        int y = graphics.guiHeight() - 30;


        var w = (int) (184 * player.getData(TWAttachmentTypes.ENERGY) / player.getData(TWAttachmentTypes.MAX_ENERGY));
        graphics.blitSprite(RenderType::guiTextured, ENERGY_BAR_TEXTURE, 184, 7, 0, 0, x, y, w, 7);
    });
}