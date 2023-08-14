package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.*;
import ru.madara.config.ModConfigMy;
import ru.madara.common.AbstractScreen;

import ru.madara.gui.button.RenderSmallToggle;

import java.util.UUID;


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

        int toggleButtonSize = 5;

        int toggleButtonX = (this.width - toggleButtonSize) / 2;
        int toggleButtonY = this.height / 2;

        RenderSmallToggle toggleButton = new RenderSmallToggle(toggleButtonX, toggleButtonY, toggleButtonSize, toggleButtonSize, StringTextComponent.EMPTY,
                new TranslationTextComponent("button.render.effect"),
                onPress -> {
                    renderEffects = !renderEffects;
                    ModConfigMy.renderEffectsConfig.set(renderEffects);
                    ModConfigMy.saveConfig();
                }, ModConfigMy.renderEffectsConfig);
        this.addButton(toggleButton);


        RenderSmallToggle r2 = new RenderSmallToggle(toggleButtonX + 10, toggleButtonY, toggleButtonSize, toggleButtonSize, StringTextComponent.EMPTY,
                new TranslationTextComponent("s.render.effect"),
                onPress -> {
                    mc.player.sendMessage(new StringTextComponent("test"), UUID.randomUUID());

                }, ModConfigMy.renderArmorConfig);
        this.addButton(r2);

    }
}