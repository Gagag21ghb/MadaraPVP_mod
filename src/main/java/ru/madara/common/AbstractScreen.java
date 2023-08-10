package ru.madara.common;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Madara;
import ru.madara.Wrapper;
import ru.madara.gui.screen.SettingsRender;

import java.awt.*;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;


public abstract class AbstractScreen extends Screen implements Wrapper {
    public static final ResourceLocation BLACK = new ResourceLocation(Madara.MOD_ID, "textures/gui/background.png");
    protected AbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        Minecraft.getInstance().textureManager.bind(BLACK);

        int textureWidth = 135;
        int textureHeight = 170;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        blit(matrixStack, x, y, 0, 0, 135, 170);
        super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);
    }

    @Override
    public boolean keyPressed(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        if (p_231046_1_ == MY_KEY_FIRST.getKey().getValue() || p_231046_1_ == Minecraft.getInstance().options.keyInventory.getKey().getValue()) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(p_231046_1_, p_231046_2_, p_231046_3_);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        Button onOfRender = new ButtonTest(x, y, buttonWidth, buttonHeight, new TranslationTextComponent("button.on.of.render"), button -> {
            Minecraft.getInstance().setScreen(new SettingsRender(new StringTextComponent("Settings render")));
        });
        this.addButton(onOfRender);

    }
    static class ButtonTest extends Button implements Wrapper {
        public ButtonTest(int p_i232255_1_, int p_i232255_2_, int p_i232255_3_, int p_i232255_4_, ITextComponent p_i232255_5_, IPressable p_i232255_6_) {
            super(p_i232255_1_, p_i232255_2_, p_i232255_3_, p_i232255_4_, p_i232255_5_, p_i232255_6_);
        }

        @Override
        protected void renderBg(MatrixStack p_230441_1_, Minecraft p_230441_2_, int p_230441_3_, int p_230441_4_) {
            fill(p_230441_1_, x, y, x + width, y + height, 0xffffff	);
            super.renderBg(p_230441_1_, p_230441_2_, p_230441_3_, p_230441_4_);
        }
    }
}
