package ru.madara.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.util.text.ITextComponent;

import java.awt.*;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public class RedactorMode extends Screen {
    public RedactorMode(ITextComponent p_i51108_1_) {
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

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

        int screenWidth = this.width;
        int screenHeight = this.height;

        int rectangleWidth = 72;
        int rectangleHeight = 73;

        int rectangleX = screenWidth - rectangleWidth;
        int rectangleY = screenHeight - rectangleHeight;

        fill(matrixStack, rectangleX, rectangleY, rectangleX + rectangleWidth, rectangleY + rectangleHeight, 0xFFFFFF00);


        int width = 92; // Ширина прямоугольника
        int height = 40; // Высота прямоугольника

        fill(matrixStack, 6, 10, width, height, 0xFFFFFF00);

    }


}