package com.barion.the_witcher.client.screen;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public final class TWMasterSmithingScreen extends AbstractContainerScreen<TWMasterSmithingMenu> {
    public static final ResourceLocation TEXTURE_LOCATION = TWUtil.locate("textures/gui/master_smithing.png");

    public TWMasterSmithingScreen(TWMasterSmithingMenu menu, Inventory playerInventory, Component tile) {
        super(menu, playerInventory, tile);
    }

    @Override
    public void renderBg(@NotNull GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
//        RenderSystem.setShader(GameRenderer::get);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blitSprite(RenderType::guiTextured, TEXTURE_LOCATION, x, y, imageWidth, imageHeight);

        if (menu.getSlot(0).hasItem() && (menu.getSelectedRecipe() == null || !menu.enoughXP())) {
            //TODO: this is most likely wrong
            graphics.blitSprite(RenderType::guiTextured, TEXTURE_LOCATION, 28, 20, 28, 20, x + 74, y + 37, 0, 0);
        }
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
//        renderBackground(graphics, mouseX, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
//        renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderLabels(graphics, mouseX, mouseY);
        if (menu.getSelectedRecipe() != null) {
            graphics.drawString(font, menu.getSelectedRecipe().getXpCost() + " XP", 77, 56, menu.enoughXP() ? 8453920 : 16736352, true);
        }
    }
}