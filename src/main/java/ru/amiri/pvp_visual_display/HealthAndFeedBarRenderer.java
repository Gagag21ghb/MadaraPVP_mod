package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class HealthAndFeedBarRenderer {
    static ResourceLocation textureLocation = new ResourceLocation("minecraft", "textures/particle/heart.png");
    static ResourceLocation textureLocationFeed = new ResourceLocation("minecraft", "textures/item/cooked_beef.png");

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

        int textureWidth = 11;
        int textureHeight = 11;
        int textureX = startX - 3 - textureWidth;
        int textureXFeed = startX + healthWidth + 3;

        int yPosition = -fontRenderer.lineHeight + 2;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        mc.getTextureManager().bind(textureLocation);
        AbstractGui.blit(matrixStack, textureX, yPosition, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
        mc.getTextureManager().bind(textureLocationFeed);
        AbstractGui.blit(matrixStack, textureXFeed, yPosition, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);

        RenderSystem.disableDepthTest();

        int textX = startX + (totalWidth - (healthWidth + feedWidth + 6)) / 2;
        fontRenderer.drawShadow(matrixStack, String.valueOf(currentHealth), textX, yPosition, 0xDC143C);
        fontRenderer.drawShadow(matrixStack, String.valueOf(currentFeed), textX + healthWidth + 15, yPosition, 0xE9967A);

        RenderSystem.enableDepthTest();

        matrixStack.popPose();
    }
}