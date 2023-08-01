package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import ru.amiri.Madara;

import static ru.amiri.settings.AddSettings.MY_KEY_FIRST;

public class MainSettingsScreen extends AbstractScreen {
    private static final ITextComponent clickableText = new StringTextComponent("test").withStyle();

    public MainSettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        Button myButton = new ButtonCustom(x, y, buttonWidth, buttonHeight, clickableText, button -> {
            Minecraft.getInstance().setScreen(new CollorSettingsScreen(new StringTextComponent("collor screen")));
        });

        this.addButton(myButton);
    }
    static class ButtonCustom extends Button {
        public ButtonCustom(int p_i232255_1_, int p_i232255_2_, int p_i232255_3_, int p_i232255_4_, ITextComponent p_i232255_5_, IPressable p_i232255_6_) {
            super(p_i232255_1_, p_i232255_2_, p_i232255_3_, p_i232255_4_, p_i232255_5_, p_i232255_6_);
        }

        @Override
        public void renderButton(MatrixStack p_230431_1_, int mouseX, int mouseY, float partialTicks) {
            super.renderButton(p_230431_1_, mouseX, mouseY, partialTicks);

        }

    }
}