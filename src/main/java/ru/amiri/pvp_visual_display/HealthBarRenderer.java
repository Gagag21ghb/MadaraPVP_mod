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
        matrixStack.translate(0,  2.6, 0);
        matrixStack.mulPose(mc.getEntityRenderDispatcher().cameraOrientation());
        matrixStack.scale(-0.025f, -0.025f, 0.025f);

        int feedWidth = fontRenderer.width(String.valueOf(currentFeed));
        int healthWidth = fontRenderer.width(String.valueOf(currentHealth));
        int totalWidth = feedWidth + healthWidth + 5;

        int startX = -totalWidth / 2;

        fontRenderer.drawShadow(matrixStack, String.valueOf(currentHealth), startX, 0, 0xDC143C);
        startX += feedWidth + 10;
        fontRenderer.drawShadow(matrixStack, String.valueOf(currentFeed), startX, 0, 0xE9967A);
        matrixStack.popPose();
    }
}