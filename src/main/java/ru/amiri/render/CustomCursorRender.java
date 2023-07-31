package ru.amiri.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.amiri.Madara;

@Mod.EventBusSubscriber
public class CustomCursorRender {
    private static final ResourceLocation LOLOLOSHKA = new ResourceLocation(Madara.MOD_ID, "textures/gui/lololoshka.jpg");
    private static final int CROSSHAIR_SIZE = 16;
    @SubscribeEvent
    public static void addCursor(RenderGameOverlayEvent.Pre event){
     //   if(event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) event.setCanceled(true);
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            Minecraft.getInstance().getTextureManager().bind(LOLOLOSHKA);

            int centerX = (event.getWindow().getScreenWidth() - event.getWindow().getWidth()) ;
            int centerY = (event.getWindow().getScreenHeight() -event.getWindow().getScreenHeight()) ;

            //  AbstractGui.blit(event.getMatrixStack(), centerX, centerY, 0, 0, CROSSHAIR_SIZE, CROSSHAIR_SIZE, CROSSHAIR_SIZE, CROSSHAIR_SIZE);

        }

    }
}