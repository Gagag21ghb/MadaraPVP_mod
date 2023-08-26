package ru.madara.common;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import ru.madara.Madara;
import ru.madara.Wrapper;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public abstract class BaseAbstractScreen extends Screen implements Wrapper {
    public static final ResourceLocation BLACK = new ResourceLocation(Madara.MOD_ID, "textures/gui/background.png");

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

    protected BaseAbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        if (p_231046_1_ == MY_KEY_FIRST.getKey().getValue() || p_231046_1_ == Minecraft.getInstance().options.keyInventory.getKey().getValue()) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(p_231046_1_, p_231046_2_, p_231046_3_);
    }
}
