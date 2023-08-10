package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import ru.madara.common.Lang;
import ru.madara.config.ModConfigMy;
import ru.madara.common.AbstractScreen;

import ru.madara.Wrapper;
import ru.madara.font.styled.StyledFont;
import ru.madara.font.styled.StyledFontRenderer;

import java.awt.Color;

public class SettingsRender extends AbstractScreen {
    public static boolean renderEffects = ModConfigMy.renderEffectsConfig.get();
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

        SmallToggleButton toggleButton = new SmallToggleButton(toggleButtonX, toggleButtonY, toggleButtonSize , toggleButtonSize, StringTextComponent.EMPTY);


        this.addButton(toggleButton);

    }
    public static class SmallToggleButton extends Widget implements Wrapper{
        private final ResourceLocation buttonTextureOn = new ResourceLocation("minecraft", "textures/block/dirt.png");
        private final ResourceLocation buttonTextureOff = new ResourceLocation("minecraft", "textures/block/grass_block.png");



        public SmallToggleButton(int p_i232254_1_, int p_i232254_2_, int p_i232254_3_, int p_i232254_4_, ITextComponent p_i232254_5_) {
            super(p_i232254_1_, p_i232254_2_, p_i232254_3_, p_i232254_4_, p_i232254_5_);
        }

        @Override
        public void onClick(double mouseX, double mouseY) {
            renderEffects = !renderEffects;
            ModConfigMy.renderEffectsConfig.set(renderEffects);
            ModConfigMy.saveConfig();
        }

        @Override
        public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {

            mc.getTextureManager().bind(isHovered() ? buttonTextureOn : buttonTextureOff);
            StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, new TranslationTextComponent("button.render.effect"), 40, 60 - font.getFontHeight(), Color.WHITE);
            int textureWidth = 16;
            int textureHeight = 16;
            int textureX = 0; // начальная координата X текстуры на текстурном атласе
            int textureY = 0; // начальная координата Y текстуры на текстурном атласе

            // Определите размеры и координаты кнопки
            int buttonWidth = this.getWidth();
            int buttonHeight = this.getHeight();
            int buttonX = this.x;
            int buttonY = this.y;

            // Отрисовка текстуры на кнопке
            AbstractGui.blit(matrixStack, buttonX, buttonY, textureX, textureY, buttonWidth, buttonHeight, textureWidth, textureHeight);




        }
    }
}
