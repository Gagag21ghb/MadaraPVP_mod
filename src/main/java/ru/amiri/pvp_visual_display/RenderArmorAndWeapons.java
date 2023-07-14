package ru.amiri.pvp_visual_display;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class RenderArmorAndWeapons {
    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity playerEntity = mc.player;
        FontRenderer fontRenderer = mc.font;

        int x = 50;
        int y = 50;

        assert playerEntity != null;
        for (ItemStack stack : playerEntity.inventory.armor) {
            if (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof ElytraItem) {
                int maxDamage = stack.getMaxDamage();
                int currentDamage = maxDamage - stack.getDamageValue();
                int percent = (int) ((float) currentDamage / (float) maxDamage * 100);
                String strengthAndPercent = currentDamage + " (" + percent + "%)";

                fontRenderer.drawShadow(event.getMatrixStack(), strengthAndPercent, x, y, 0x40cfff);
                y -= 10;
            }
        }
    }
}
