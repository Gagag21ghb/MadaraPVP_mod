package ru.madara.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import ru.madara.Wrapper;
import ru.madara.common.BaseAbstractScreen;

import java.util.UUID;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public class RedactorMode extends BaseAbstractScreen implements Wrapper {
    private boolean isDraggingRect1 = false;
    private int dragOffsetXRect1 = 0;
    private int dragOffsetYRect1 = 0;
    private int draggedRect1X = 6;
    private int draggedRect1Y = 10;
    private final int rect1Width = 92;
    private final int rect1Height = 40;

    private boolean isDraggingRect2 = false;
    private int dragOffsetXRect2 = 0;
    private int dragOffsetYRect2 = 0;
    private final int rect2Width = 72; // ширина второго прямоугольника
    private final int rect2Height = 73; // высота второго прямоугольника
    private int draggedRect2X = this.width - rect2Width; // начальные координаты второго прямоугольника
    private int draggedRect2Y = this.height - rect2Height;

    public RedactorMode(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

        fill(matrixStack, draggedRect1X, draggedRect1Y, draggedRect1X + rect1Width, draggedRect1Y + rect1Height, 0xFFFFFF00);
        fill(matrixStack, draggedRect2X, draggedRect2Y, draggedRect2X + rect2Width, draggedRect2Y + rect2Height, 0xFFFFFF00);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0 && mouseX >= draggedRect1X && mouseX <= draggedRect1X + rect1Width &&
                mouseY >= draggedRect1Y && mouseY <= draggedRect1Y + rect1Height) {
            isDraggingRect1 = true;
            dragOffsetXRect1 = (int) mouseX - draggedRect1X;
            dragOffsetYRect1 = (int) mouseY - draggedRect1Y;
            return true;
        }
        if (button == 0 && mouseX >= draggedRect2X && mouseX <= draggedRect2X + rect2Width &&
                mouseY >= draggedRect2Y && mouseY <= draggedRect2Y + rect2Height) {
            isDraggingRect2 = true;
            dragOffsetXRect2 = (int) mouseX - draggedRect2X;
            dragOffsetYRect2 = (int) mouseY - draggedRect2Y;
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            isDraggingRect1 = false;
            isDraggingRect2 = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (isDraggingRect1) {
            draggedRect1X = (int) mouseX - dragOffsetXRect1;
            draggedRect1Y = (int) mouseY - dragOffsetYRect1;
            return true;
        }
        if (isDraggingRect2) {
            draggedRect2X = (int) mouseX - dragOffsetXRect2;
            draggedRect2Y = (int) mouseY - dragOffsetYRect2;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }
}