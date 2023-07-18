package ru.amiri.pvp_visual_display;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.renderer.texture.PotionSpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber
public class RenderEffecrsOnScreen {

    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.POTION_ICONS)
            return;
        Minecraft mc = Minecraft.getInstance();
        Collection<EffectInstance> effects = mc.player.getActiveEffects();
        FontRenderer fontRenderer = mc.font;


        int x = 100;
        int y = 100;
        int yOffset = 20;

        for (EffectInstance effectInstance : effects) {
            Effect effect = effectInstance.getEffect();
            int duration = effectInstance.getDuration();
            effectInstance.getCurativeItems();

            PotionSpriteUploader potionspriteuploader = mc.getMobEffectTextures();
            TextureAtlasSprite sprite = potionspriteuploader.get(effect);
            mc.getTextureManager().bind(sprite.atlas().location());
            int k = event.getWindow().getGuiScaledWidth();
            int k1 = 1;



            String timeRemaining = getTimeRemaining(duration);
            int textWidth = fontRenderer.width(timeRemaining);
            int textX = x + (sprite.getWidth() - textWidth) / 2;
            int textY = y + sprite.getHeight() + 2;
            AbstractGui.blit(event.getMatrixStack(), textX, textY, 0, 18, 18, sprite);
            fontRenderer.drawShadow(event.getMatrixStack(), timeRemaining, textX, textY, effect.getColor());

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
