package ru.madara.gui.screen.common;

import com.google.common.io.ByteSource;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.madara.Madara;
import ru.madara.gui.screen.common.font.*;

import java.awt.*;

@Mod.EventBusSubscriber
public class TestRender {
    public static final String FONT_DIR = "/assets/" + Madara.MOD_ID + "/font/";
    private static StyledFont font = new StyledFont("Comfortaa.ttf", 35, 0.0f, 2.0f, 0.5f, Lang.ENG_RU);

    @SubscribeEvent
    public static void ttes(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {

            StyledFontRenderer.drawString(event.getMatrixStack(), font, "mimi маму иуу", 60, 120 - font.getFontHeight(), Color.WHITE);


        }
    }
}
