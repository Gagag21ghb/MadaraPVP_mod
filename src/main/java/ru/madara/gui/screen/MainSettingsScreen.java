package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

public class MainSettingsScreen extends AbstractScreen {

    public MainSettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        int textureWidth = 140;
        int textureHeight = 150;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        Minecraft.getInstance().textureManager.bind(LOLOLOSHKA);
        blit(matrixStack, x, y, 0, 0, 140, 150);

        font.drawShadow(matrixStack, "Ортем", x, y, 0x40cfff);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}