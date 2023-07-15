package ru.amiri.pvp_visual_display;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class RenderArmorAndWeapons {
    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL){
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity playerEntity = mc.player;
        FontRenderer fontRenderer = mc.font;
        int x = 50;
        int y = 30;
         event.getMatrixStack().pushPose();
        for (int i = 0; i < playerEntity.inventory.armor.size(); i++) {
            ItemStack stack = playerEntity.inventory.armor.get(i);
            if (!stack.isEmpty() && (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof ElytraItem)) {
                int maxDamage = stack.getMaxDamage();
                int currentDamage = maxDamage - stack.getDamageValue();
                int percent = (int) ((float) currentDamage / (float) maxDamage * 100);
                String strengthAndPercent = currentDamage + " (" + percent + "%)";

                mc.getItemRenderer().renderAndDecorateItem(stack, x - 20, y - 10);

                RenderHelper.setupForFlatItems();
                mc.getItemRenderer().renderGuiItemDecorations(mc.font, stack, x - 20, y - 10);

                fontRenderer.drawShadow(event.getMatrixStack(), strengthAndPercent, x, y, 0x40cfff);
            }
            y -= 15;
        }
         event.getMatrixStack().popPose();
        }
    }
}