package ru.madara.gui.screen.common.font;

import java.awt.Color;

import org.lwjgl.opengl.GL30;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.util.math.vector.Matrix4f;

public class SimplifiedFontRenderer {
    public static float drawString(MatrixStack matrices, TextFont font, String text, double x, double y, Color color) {
        return renderString(matrices, font, text, x, y, color);
    }
    private static float renderStringWithShadow(MatrixStack matrices, TextFont font, String text, double x, double y, Color color, Color shadowColor) {
        renderString(matrices, font, text, x + 1.0F, y, shadowColor);
        return renderString(matrices, font, text, x, y -= 1.0f, color) + 1.0f;
    }

    // returns string width
    private static float renderString(MatrixStack matrices, TextFont font, String text, double x, double y, Color color) {
        y -= font.getLifting();

        float startPos = (float) x * 2f;
        float posX = startPos;
        float posY = (float) y * 2f;
        float red = color.getRed() / 255.0f;
        float green = color.getGreen() / 255.0f;
        float blue = color.getBlue() / 255.0f;
        float alpha = color.getAlpha() / 255.0f;

        GlStateManager._enableBlend();
        GlStateManager._blendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
        matrices.pushPose();
        matrices.scale(0.5f, 0.5f, 1f);

        Matrix4f matrix = matrices.last().pose();

        font.bindTex();

        for (int i = 0; i < text.length(); i++) {
            posX += font.renderGlyph(matrix, text.charAt(i), posX, posY, red, green, blue, alpha);
        }

        font.unbindTex();

        matrices.popPose();
        GlStateManager._disableBlend();

        return (posX - startPos) / 2.0f;
    }

    public static Color getShadowColor(Color color) {
        return new Color((color.getRGB() & 16579836) >> 2 | color.getRGB()  & -16777216);
    }
}
