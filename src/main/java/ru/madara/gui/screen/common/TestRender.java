package ru.madara.gui.screen.common;

import com.google.common.io.ByteSource;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.madara.Madara;
import ru.madara.gui.screen.common.font.Lang;
import ru.madara.gui.screen.common.font.SimplifiedFontRenderer;
import ru.madara.gui.screen.common.font.TextFont;

import java.awt.*;

@Mod.EventBusSubscriber
public class TestRender {
    public static final String FONT_DIR = "/assets/" + Madara.MOD_ID + "/font/";


    @SubscribeEvent
    public static void ttes(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            TextFont font2 = new TextFont("SSi.ttf", 30, 0.0f, 2.0f, 0.5f, Lang.ENG_RU);

         SimplifiedFontRenderer.drawString(event.getMatrixStack(), font2, "Testing CUSTOMFONT renderer font Minecraft 1.16", 50, 50, Color.WHITE);
        }
    }
}
