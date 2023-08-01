package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import ru.amiri.Madara;

import static ru.amiri.settings.AddSettings.MY_KEY_FIRST;


public abstract class AbstractScreen extends Screen {
    private static final ResourceLocation LOLOLOSHKA = new ResourceLocation(Madara.MOD_ID, "textures/gui/lololoshka.jpg");
    protected AbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
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
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        int textureWidth = 140;
        int textureHeight = 150;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        Minecraft.getInstance().textureManager.bind(LOLOLOSHKA);
        blit(matrixStack, x, y, 0, 0, 140, 150);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

}
