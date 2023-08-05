package ru.madara.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.ITextComponent;
import ru.madara.gui.screen.common.AbstractScreen;

public class MainSettingsScreen extends AbstractScreen {

    public MainSettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);
    }
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);


        font.drawShadow(matrixStack, "Ортем", 70, 50, 0x40cfff);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}