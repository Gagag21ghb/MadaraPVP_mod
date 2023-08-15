package ru.madara.gui.button;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import ru.madara.Wrapper;
import ru.madara.font.styled.StyledFontRenderer;
import ru.madara.gui.screen.SettingsRender;

import java.awt.*;

public class ButtonStringRender extends Widget implements Wrapper {
    public ButtonStringRender(int p_i232254_1_, int p_i232254_2_, int p_i232254_3_, int p_i232254_4_, ITextComponent p_i232254_5_) {
        super(p_i232254_1_, p_i232254_2_, p_i232254_3_, p_i232254_4_, p_i232254_5_);
    }

    @Override
    public void onClick(double p_230982_1_, double p_230982_3_) {
        super.onClick(p_230982_1_, p_230982_3_);
        mc.setScreen(new SettingsRender(new StringTextComponent("Settings render")));
    }

    @Override
    public void renderButton(MatrixStack matrixStack, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
        StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, getMessage(), x + (double) width / 2 - (double) mc.font.width(getMessage()) / 2, y + (double) (height - 8) / 2, Color.WHITE);

     // super.renderButton(matrixStack, p_230431_2_,  p_230431_3_, p_230431_4_ );

    }
}
