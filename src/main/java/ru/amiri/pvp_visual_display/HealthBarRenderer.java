package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.overlay.PlayerTabOverlayGui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class HealthBarRenderer {


        @SubscribeEvent
        public static void onRenderGameOverlay (RenderGameOverlayEvent.Post event) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
                Minecraft mc = Minecraft.getInstance();
                MatrixStack matrixStack = event.getMatrixStack();
                matrixStack.pushPose();

                matrixStack.translate(0.0, 2.8, 0.0);
                matrixStack.mulPose(mc.getEntityRenderDispatcher().cameraOrientation());
                matrixStack.scale(-0.03f, -0.03f, 0.03f);


                PlayerEntity player = mc.player;
                FontRenderer fontRenderer = mc.font;

                float currentHealth = player.getHealth();
                String hp = String.valueOf(currentHealth);
                fontRenderer.drawShadow(matrixStack, hp, 0, 0, 0xFFFFFF);


            }

        }


}