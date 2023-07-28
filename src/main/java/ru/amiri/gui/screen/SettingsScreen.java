package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class SettingsScreen extends Screen {
    private static final int SQUARE_SIZE = 50; // Размер квадрата в пикселях

    protected SettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);

        }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        int x = this.width / 2 - SQUARE_SIZE / 2;
        int y = this.height / 2 - SQUARE_SIZE / 2;

        // Рисуем черный квадрат на экране
        AbstractGui.fill(matrixStack, x, y, x + SQUARE_SIZE, y + SQUARE_SIZE, 0xFF000000);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
