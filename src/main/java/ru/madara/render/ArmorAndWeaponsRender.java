package ru.madara.render;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.madara.Wrapper;

import java.util.UUID;

@Mod.EventBusSubscriber
public class ArmorAndWeaponsRender implements Wrapper {
    static int x;
    static int y;

    @SubscribeEvent
    public static void onPostRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {

            int screenWidth = event.getWindow().getGuiScaledWidth();
            int screenHeight = event.getWindow().getGuiScaledHeight();
            int textureWidth = 17;
            int textureHeight = 16;
            int barHeight = 3;

            x = (screenWidth - fontRenderer.width("100 (100%)") - textureWidth) + 15;
            y = (screenHeight - playerEntity.inventory.armor.size() * (textureHeight + barHeight)) - 3;

            event.getMatrixStack().pushPose();
            for (int i = playerEntity.inventory.armor.size() - 1; i >= 0; i--) {
                ItemStack stack = playerEntity.inventory.armor.get(i);
                if (stack.isEmpty()) {
                    mc.getItemRenderer().renderAndDecorateItem(ItemStack.EMPTY, x - textureWidth, y + barHeight);
                } else if (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof ElytraItem) {
                    int maxDamage = stack.getMaxDamage();
                    int currentDamage = maxDamage - stack.getDamageValue();
                    int percent = (int) ((float) currentDamage / (float) maxDamage * 100);
                    String strengthAndPercent = currentDamage + " (" + percent + "%)";

                    mc.getItemRenderer().renderAndDecorateItem(stack, x - textureWidth, y + barHeight);

                    RenderHelper.setupForFlatItems();
                    mc.getItemRenderer().renderGuiItemDecorations(mc.font, stack, x - textureWidth - 1, y + barHeight + 1);

                    fontRenderer.drawShadow(event.getMatrixStack(), strengthAndPercent, x, y + barHeight + (float) (textureHeight - fontRenderer.lineHeight) / 2, 0x40cfff);
                }

                y += textureHeight + barHeight;
            }
            event.getMatrixStack().popPose();
        }
    }
}