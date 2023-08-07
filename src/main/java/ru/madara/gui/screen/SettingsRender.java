package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.*;
import ru.madara.Madara;
import ru.madara.config.ModConfigMy;
import ru.madara.gui.screen.common.AbstractScreen;

import ru.madara.gui.screen.common.font.StyledFontRenderer;

import java.awt.Color;

public class SettingsRender extends AbstractScreen {
    public static boolean renderEffects = ModConfigMy.renderEffects.get();
    public SettingsRender(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        super.init();

        int toggleButtonSize = 7;

        int toggleButtonX = (this.width - toggleButtonSize ) / 2;
        int toggleButtonY = this.height / 2;

        Button toggleButton = new RenderButton(toggleButtonX, toggleButtonY, toggleButtonSize , toggleButtonSize,
                 StringTextComponent.EMPTY, button -> {
            renderEffects = !renderEffects;
            ModConfigMy.renderEffects.set(renderEffects);
            ModConfigMy.saveConfig();

        });
        this.addButton(toggleButton);

    }
    public static class RenderButton extends Button {
        public RenderButton(int p_i232255_1_, int p_i232255_2_, int p_i232255_3_, int p_i232255_4_, ITextComponent p_i232255_5_, IPressable p_i232255_6_) {
            super(p_i232255_1_, p_i232255_2_, p_i232255_3_, p_i232255_4_, p_i232255_5_, p_i232255_6_);
        }
        @Override
        public void renderButton(MatrixStack matrixStack, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
            float textScale = 0.7f;
            matrixStack.pushPose();

            matrixStack.scale(textScale, textScale, 1.0f);
            StyledFontRenderer.drawShadowedCenteredYString(matrixStack, Madara.font, "ON/OFF отображение эффектов", 40, 60 - Madara.font.getFontHeight(), Color.WHITE);

            matrixStack.popPose();

            super.renderButton(matrixStack, p_230431_2_, p_230431_3_, p_230431_4_);
        }

    }
}
