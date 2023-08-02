package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class SettingsRender extends AbstractScreen {
    public static boolean renderEffects = true;

    public SettingsRender(ITextComponent p_i51108_1_) {
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
        font.drawShadow(matrixStack, "Ололлошка", x, y, 0x40cfff);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        super.init();

        int toggleButtonWidth = 100;
        int toggleButtonHeight = 20;
        int toggleButtonX = (this.width - toggleButtonWidth) / 2;
        int toggleButtonY = this.height / 2 + 70;

        Button toggleButton = new Button(toggleButtonX, toggleButtonY, toggleButtonWidth, toggleButtonHeight, new StringTextComponent("Переключить эффекты"), button -> {
            renderEffects = !renderEffects;
        });

        this.addButton(toggleButton);

    }
}
