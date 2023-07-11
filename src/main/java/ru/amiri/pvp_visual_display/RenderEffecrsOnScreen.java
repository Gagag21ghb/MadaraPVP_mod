package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber
public class RenderEffecrsOnScreen {
    static ResourceLocation texturePo = new ResourceLocation("minecraft", "textures/mob_effect/invisibility.png");

    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.POTION_ICONS)
            return;

        Minecraft mc = Minecraft.getInstance();
        Collection<EffectInstance> effects = mc.player.getActiveEffects();
        FontRenderer fontRenderer = mc.font;
        MatrixStack matrixStack = event.getMatrixStack();
        ClientPlayerEntity player = mc.player;

        mc.getTextureManager().bind(texturePo);

        int x = 10; // X-координата для рендеринга эффектов
        int y = 10; // Y-координата для рендеринга эффектов
        int yOffset = 20; // Отступ между каждым эффектом

            for (EffectInstance effectInstance : effects) {

                Effect effect = effectInstance.getEffect();
                int duration = effectInstance.getDuration();
                String effectName = effect.getDisplayName().getString();

                AbstractGui.blit(matrixStack, 20, 20, 20, 20, 20, 20, 20, 20);
                fontRenderer.drawShadow(matrixStack,  getTimeRemaining(duration), x, y, effect.getColor());

                y += yOffset;
            }
    }
    private static String getTimeRemaining(int duration) {
        int seconds = duration / 20;
        int minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
