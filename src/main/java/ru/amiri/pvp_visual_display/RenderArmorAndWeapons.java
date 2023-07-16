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

import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber
public class RenderArmorAndWeapons {
    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft mc = Minecraft.getInstance();
            PlayerEntity playerEntity = mc.player;
            FontRenderer fontRenderer = mc.font;

            int screenWidth = event.getWindow().getGuiScaledWidth();
            int screenHeight = event.getWindow().getGuiScaledHeight();
            int textureWidth = 17; // Ширина текстуры
            int textureHeight = 16; // Высота текстуры
            int barHeight = 3; // Высота полоски прочности

            int x = (screenWidth - fontRenderer.width("100 (100%)") - textureWidth) + 15; // X-координата текста
            int y = (screenHeight - playerEntity.inventory.armor.size() * (textureHeight + barHeight))- 3; // Y-координата первого элемента

            event.getMatrixStack().pushPose();
            List<ItemStack> armorStacks = new ArrayList<>();
            for (int i = playerEntity.inventory.armor.size() - 1; i >= 0; i--) {
                ItemStack stack = playerEntity.inventory.armor.get(i);
                if (!stack.isEmpty() && (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof ElytraItem)) {
                    armorStacks.add(stack);
                }
            }
            for (ItemStack stack : armorStacks) {
                int maxDamage = stack.getMaxDamage();
                int currentDamage = maxDamage - stack.getDamageValue();
                int percent = (int) ((float) currentDamage / (float) maxDamage * 100);
                String strengthAndPercent = currentDamage + " (" + percent + "%)";

                mc.getItemRenderer().renderAndDecorateItem(stack, x - textureWidth, y + barHeight); // Текстура

                RenderHelper.setupForFlatItems();
                mc.getItemRenderer().renderGuiItemDecorations(mc.font, stack, x - textureWidth - 1, y + barHeight + 1); // Полоска

                fontRenderer.drawShadow(event.getMatrixStack(), strengthAndPercent, x, y + barHeight + (textureHeight - fontRenderer.lineHeight) / 2, 0x40cfff); // Текст

                y += textureHeight + barHeight; // Увеличиваем Y-координату для следующего элемента
            }
            event.getMatrixStack().popPose();
        }
    }
}