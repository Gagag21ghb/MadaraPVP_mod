package ru.madara.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import ru.madara.common.AbstractScreen;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;

public class RedactorMode extends Screen {

    private int draggingStartX;
    private int draggingStartY;
    private boolean isDragging = false;

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

//    @Override
//    public boolean mouseDragged(double mouseX, double mouseY, int button, double p_231045_6_, double p_231045_8_) {
//        if (isDragging) {
//        } else {
//            if (button == 0) {
//                // Проверка, что клик был на рендере брони
//                if (armorRenderer.isMouseOver((int) mouseX, (int) mouseY)) {
//                    isDragging = true;
//                    draggingStartX = (int) mouseX;
//                    draggingStartY = (int) mouseY;
//                }
//                return super.mouseDragged(mouseX, mouseY, button, p_231045_6_, p_231045_8_);
//            }
//        }
//    }
//
//    @Override
//    public boolean isMouseOver(double mouseX, double armorRenderY) {
//
//        return mouseX >= armorRenderX && mouseX <= armorRenderX + armorRenderWidth
//                && mouseY >= armorRenderY && mouseY <= armorRenderY + armorRenderHeight;
//
//    }

    @Override
    public boolean mouseReleased(double p_231048_1_, double p_231048_3_, int button) {
        if (button == 0) {
            if (isDragging) {
                isDragging = false;
            }
        }
        return super.mouseReleased(p_231048_1_, p_231048_3_, button);
    }
}