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

import static ru.madara.gui.screen.SettingsRender.renderEffects;

public class RenderSmallToggle extends Widget implements Wrapper {
    private final Consumer<Widget> onPress; // Поле onPress

    TranslationTextComponent TextInButton;
    public RenderSmallToggle(int p_i232254_1_, int p_i232254_2_, int p_i232254_3_, int p_i232254_4_, ITextComponent p_i232254_5_, TranslationTextComponent text, Consumer<Widget> onPress) {
        super(p_i232254_1_, p_i232254_2_, p_i232254_3_, p_i232254_4_, p_i232254_5_);

        TextInButton = text;

        this.onPress = onPress; // Присваиваем логику onPress

    }

    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {

        StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, TextInButton, 40, 60 - font.getFontHeight(), Color.WHITE);

        // Определите размеры и координаты кнопки
        int buttonWidth = this.getWidth();
        int buttonHeight = this.getHeight();
        int buttonX = this.x;
        int buttonY = this.y;

        int red = renderEffects ? 0 : 255;    // Красный цвет для выключенной кнопки
        int green = renderEffects ? 255 : 0;  // Зеленый цвет для включенной кнопки
        int blue = 0;
        int alpha = 255; // Непрозрачность

        int argbColor = (alpha << 24) | (red << 16) | (green << 8) | blue;

        // Заливка квадрата на кнопке соответствующим цветом
        AbstractGui.fill(matrixStack, buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, argbColor);

    }

    @Override
    public void onClick(double p_230982_1_, double p_230982_3_) {
        super.onClick(p_230982_1_, p_230982_3_);
        if (onPress != null) {
            onPress.accept(this);
        }
    }
}
