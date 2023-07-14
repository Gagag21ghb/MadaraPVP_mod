package ru.amiri.pvp_visual_display;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
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

        int x = 10;
        int y = event.getWindow().getScreenHeight() - 20;

        for (ItemStack stack : playerEntity.getArmorSlots()) {
            if (stack.getItem() instanceof ArmorItem) {
                ArmorItem armorItem = (ArmorItem) stack.getItem();
                int maxDamage = armorItem.getMaxDamage(stack);
                int currentDamage = maxDamage - stack.getDamageValue();

                String armorName = stack.getDisplayName().getString();
                String armorText = String.format("%s: %d/%d", armorName, currentDamage, maxDamage);

                fontRenderer.drawShadow(event.getMatrixStack(), String.valueOf(maxDamage), 50, 50, -1);
                y -= 10;
            }
        }
    }
}
