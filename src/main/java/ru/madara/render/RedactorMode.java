package ru.madara.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.util.text.ITextComponent;
import java.awt.*;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public class RedactorMode extends Screen {
//    private boolean isDragging = false;
//    private int draggedX;
//    private int draggedY;
//
//    private int armorRenderX = 100;
//    private int armorRenderY = 100;

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

        fill(matrixStack, rectangleX, rectangleY, screenWidth, screenHeight, 0xFFFFFF00); // Yellow color
    }

    //    @Override
//    public boolean mouseReleased(double p_231048_1_, double p_231048_3_, int button) {
//        if (button == 0) {
//            if (isDragging) {
//                isDragging = false;
//            }
//        }
//        return super.mouseReleased(p_231048_1_, p_231048_3_, button);
//    }
//    @Override
//    public boolean mouseClicked(double mouseX, double mouseY, int button) {
//        if (button == 0) {
//            // Проверяем, попал ли клик в область рендера брони
//            if (mouseX >= armorRenderX && mouseX <= armorRenderX + 16 &&
//                    mouseY >= armorRenderY && mouseY <= armorRenderY + 16) {
//                isDragging = true;
//                // Запоминаем начальные координаты клика
//                draggedX = (int) mouseX - armorRenderX;
//                draggedY = (int) mouseY - armorRenderY;
//                return true;
//            }
//        }
//        return super.mouseClicked(mouseX, mouseY, button);
//    }
//
//    @Override
//    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
//        if (isDragging) {
//            // Обновляем координаты рендера брони в соответствии с смещением мыши
//            armorRenderX = (int) mouseX - draggedX;
//            armorRenderY = (int) mouseY - draggedY;
//            return true;
//        }
//        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
//    }
}