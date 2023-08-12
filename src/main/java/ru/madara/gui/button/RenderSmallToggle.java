package ru.madara.gui.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Wrapper;
import ru.madara.config.ModConfigMy;
import ru.madara.font.styled.StyledFontRenderer;

import java.awt.*;
import java.util.function.Consumer;


public class RenderSmallToggle extends Widget implements Wrapper {
    private final Consumer<Widget> onPress;
    private TranslationTextComponent TextInButton;
    boolean  loadedToggleButtonState = ModConfigMy.toggleButton.get();
    int toggleID = 1;

    public RenderSmallToggle(int x, int y, int width, int height,
                             ITextComponent title, TranslationTextComponent text, Consumer<Widget> onPress) {
        super(x, y, width, height, title);

        TextInButton = text;
        this.onPress = onPress;

    }

    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, TextInButton, 40, 60 - font.getFontHeight(), Color.WHITE);

        int buttonWidth = this.getWidth();
        int buttonHeight = this.getHeight();
        int buttonX = this.x;
        int buttonY = this.y;


        int red =  loadedToggleButtonState ? 0 : 255;
        int green = loadedToggleButtonState ? 255 : 0;
        int blue = 0;
        int alpha = 255;
        int argbColor = (alpha << 24) | (red << 16) | (green << 8) | blue;

        AbstractGui.fill(matrixStack, buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, argbColor);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);
        if (onPress != null) {
            onPress.accept(this);
            loadedToggleButtonState = !loadedToggleButtonState;

            ModConfigMy.toggleButton.set(loadedToggleButtonState);
            ModConfigMy.saveConfig();
        }
    }


}