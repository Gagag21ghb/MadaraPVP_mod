package ru.madara.gui.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Wrapper;
import ru.madara.config.ModConfigMy;
import ru.madara.font.styled.StyledFontRenderer;

import java.awt.*;
import java.util.function.Consumer;


public class RenderSmallToggle extends Widget implements Wrapper {
    private final Consumer<Widget> onPress;
    boolean toggleButton;
    TranslationTextComponent TextInButton;

    public RenderSmallToggle(int p_i232254_1_, int p_i232254_2_, int p_i232254_3_, int p_i232254_4_,
                             ITextComponent p_i232254_5_, TranslationTextComponent text, Consumer<Widget> onPress) {
        super(p_i232254_1_, p_i232254_2_, p_i232254_3_, p_i232254_4_, p_i232254_5_);

        TextInButton = text;
        this.onPress = onPress;

    }

    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, TextInButton, 40, 60 - font.getFontHeight(), Color.WHITE); // настраивать текст!

        int buttonWidth = this.getWidth();
        int buttonHeight = this.getHeight();
        int buttonX = this.x;
        int buttonY = this.y;

        int red = toggleButton ? 0 : 255;
        int green = toggleButton ? 255 : 0;
        int blue = 0;
        int alpha = 255;
        int argbColor = (alpha << 24) | (red << 16) | (green << 8) | blue;

        AbstractGui.fill(matrixStack, buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, argbColor);

    }

    @Override
    public void onClick(double p_230982_1_, double p_230982_3_) {
        super.onClick(p_230982_1_, p_230982_3_);
        if (onPress != null) {
            onPress.accept(this);
            toggleButton = !toggleButton;
        }
    }
}
