package ru.madara.common;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Madara;
import ru.madara.Wrapper;
import ru.madara.gui.button.LinesButtonRender;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;


public abstract class AbstractScreen extends BaseAbstractScreen implements Wrapper {
    public static final ResourceLocation BLACK = new ResourceLocation(Madara.MOD_ID, "textures/gui/background.png");

    protected AbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    @Override
    public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
       mc.textureManager.bind(BLACK);

        int textureWidth = 135;
        int textureHeight = 170;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        blit(matrixStack, x, y, 0, 0, 135, 170);
        super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 10;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        LinesButtonRender onOfRender = new LinesButtonRender(x, y, buttonWidth, buttonHeight, new TranslationTextComponent("button.on.of.render"));
        this.addButton(onOfRender);

    }

}
