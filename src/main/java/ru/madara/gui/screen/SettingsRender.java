package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.config.ModConfigMy;

public class SettingsRender extends AbstractScreen {
    public static boolean renderEffects = ModConfigMy.renderEffects.get();

    public SettingsRender(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        font.drawShadow(matrixStack, "Ололлошка", 50, 50, 0x40cfff);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        super.init();

        int toggleButtonWidth = 10;
        int toggleButtonHeight = 10;
        int toggleButtonX = (this.width - toggleButtonWidth) / 2;
        int toggleButtonY = this.height / 2 + 70;

        Button toggleButton = new Button(toggleButtonX, toggleButtonY, toggleButtonWidth, toggleButtonHeight, new TranslationTextComponent("button.render.effect"), button -> {
            renderEffects = !renderEffects;
            ModConfigMy.renderEffects.set(renderEffects);
            ModConfigMy.saveConfig();
        });

        this.addButton(toggleButton);

    }

}
