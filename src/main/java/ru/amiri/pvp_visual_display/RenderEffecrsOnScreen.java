package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.PotionSpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber
public class RenderEffecrsOnScreen {


    static ResourceLocation textureLocation = new ResourceLocation("minecraft", "textures/mob_effect/invisibility.png");
    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.POTION_ICONS)
            return;
        Minecraft mc = Minecraft.getInstance();
        Collection<EffectInstance> effects = mc.player.getActiveEffects();
        FontRenderer fontRenderer = mc.font;
        PotionSpriteUploader spriteUploader = mc.getMobEffectTextures();

        int x = 100;
        int y = 100;
        int yOffset = 20;

        // Если ты читаешь этот код, то знай, что я пока не знаю как получать текстуру дейстующего эффекта, поэтому пока загружаю без него :3

        for (EffectInstance effectInstance : effects) {
            Effect effect = effectInstance.getEffect();
            int duration = effectInstance.getDuration();

            TextureAtlasSprite sprite = spriteUploader.get(effect);
            mc.getTextureManager().bind(sprite.atlas().location());
            AbstractGui.blit(event.getMatrixStack(), x, y, 0, 0, sprite.getWidth(), sprite.getHeight(), sprite.getWidth(), sprite.getHeight());

            String timeRemaining = getTimeRemaining(duration);
            int textWidth = fontRenderer.width(timeRemaining);
            int textX = x + (sprite.getWidth() - textWidth) / 2;
            int textY = y + sprite.getHeight() + 2;
            fontRenderer.drawShadow(event.getMatrixStack(), timeRemaining, textX, textY, -1);

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
