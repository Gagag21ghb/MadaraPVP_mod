package ru.madara.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.util.text.ITextComponent;
import ru.madara.Wrapper;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public class RedactorMode extends Screen implements Wrapper {

    private boolean isDragging = false;
    private int dragOffsetX = 0;
    private int dragOffsetY = 0;
    private int draggedRectX = 6;
    private int draggedRectY = 10;
    private final int rectWidth = 92;
    private final int rectHeight = 40;

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

        fill(matrixStack, draggedRectX, draggedRectY, draggedRectX + rectWidth, draggedRectY + rectHeight, 0xFFFFFF00);

    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0 && mouseX >= draggedRectX && mouseX <= draggedRectX + rectWidth &&
                mouseY >= draggedRectY && mouseY <= draggedRectY + rectHeight) {
            isDragging = true;
            dragOffsetX = (int) mouseX - draggedRectX;
            dragOffsetY = (int) mouseY - draggedRectY;
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            isDragging = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (isDragging) {
            draggedRectX = (int) mouseX - dragOffsetX;
            draggedRectY = (int) mouseY - dragOffsetY;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }


}