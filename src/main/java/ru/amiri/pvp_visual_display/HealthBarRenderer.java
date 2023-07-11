package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.overlay.PlayerTabOverlayGui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class HealthBarRenderer {
    static ResourceLocation textureLocation =new ResourceLocation ("your_mod_id", "textures/gui/your_texture.png");
    static ResourceLocation textureLocationFeed =new ResourceLocation ("your_mod_id", "textures/gui/your_texture.png");

    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent.Post<?, ?> event) {
        if (!(event.getEntity() instanceof PlayerEntity) || event.isCanceled()) {
            return;
        }
        PlayerEntity player = (PlayerEntity) event.getEntity();
        Minecraft mc = Minecraft.getInstance();
        FontRenderer fontRenderer = mc.font;
        MatrixStack matrixStack = event.getMatrixStack();

        int currentHealth = (int) Math.ceil(player.getHealth());
        int currentFeed = player.getFoodData().getFoodLevel();

        matrixStack.pushPose();
        matrixStack.translate(0, 2.6, 0);
        matrixStack.mulPose(mc.getEntityRenderDispatcher().cameraOrientation());
        matrixStack.scale(-0.025f, -0.025f, 0.025f);

        int feedWidth = fontRenderer.width(String.valueOf(currentFeed));
        int healthWidth = fontRenderer.width(String.valueOf(currentHealth));

        int totalWidth = feedWidth + healthWidth + 5;
        int startX = -totalWidth / 2;

        int textureWidth = 9; // Ширина текстуры
        int textureHeight = 9; // Высота текстуры
        int textureX = startX - 2 - textureWidth; // X-координата текстуры здоровья (слева от текста здоровья)
        int textureXFeed = startX + healthWidth + 27; // X-координата текстуры питания (справа от текста здоровья)

        mc.getTextureManager().bind(textureLocation);
        AbstractGui.blit(matrixStack, textureX, 0, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
        mc.getTextureManager().bind(textureLocationFeed);
        AbstractGui.blit(matrixStack, textureXFeed, 0, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);

        int textX = startX + (totalWidth - (healthWidth + feedWidth)) / 2;
        fontRenderer.drawShadow(matrixStack, String.valueOf(currentHealth), textX, 0, 0xDC143C);
        fontRenderer.drawShadow(matrixStack, String.valueOf(currentFeed), textX + healthWidth + 10, 0, 0xE9967A);

        matrixStack.popPose();
    }
}