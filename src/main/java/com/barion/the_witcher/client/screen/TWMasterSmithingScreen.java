package com.barion.the_witcher.client.screen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.inventory.TWMasterSmithingMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public final class TWMasterSmithingScreen extends AbstractContainerScreen<TWMasterSmithingMenu> {
    public static final ResourceLocation TEXTURE_LOCATION = TheWitcher.locate("master_smithing");

    public TWMasterSmithingScreen(TWMasterSmithingMenu menu, Inventory playerInventory, Component tile) {
        super(menu, playerInventory, tile);
    }

    @Override
    public void renderBg(@NotNull GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blitSprite(RenderType::guiTextured, TEXTURE_LOCATION, 256, 256, 0, 0, x, y, imageWidth, imageHeight);

        if (menu.getSlot(0).hasItem() && (menu.getSelectedRecipe() == null || !menu.enoughXP())) {
            graphics.blitSprite(RenderType::guiTextured, TEXTURE_LOCATION, 28, 20, 28, 20, x + 74, y + 37, 0, 0);
        }
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderLabels(graphics, mouseX, mouseY);
        if (menu.getXPCost() != -1) {
            graphics.drawString(font, menu.getXPCost() + " XP", 77, 56, menu.enoughXP() ? 8453920 : 16736352, true);
        }
    }
}