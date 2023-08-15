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
import ru.madara.gui.button.ButtonStringRender;
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
        int buttonHeight = 10;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        ButtonStringRender onOfRender = new ButtonStringRender(x, y, buttonWidth, buttonHeight, new TranslationTextComponent("button.on.of.render"));
        this.addButton(onOfRender);

    }

}
