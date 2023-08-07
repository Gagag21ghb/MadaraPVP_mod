package ru.madara;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import ru.madara.config.ModConfigMy;
import ru.madara.gui.screen.common.font.Lang;
import ru.madara.gui.screen.common.font.StyledFont;

@Mod("madara")
public class Madara {
    public static StyledFont font = new StyledFont("FTR.ttf", 35, 0.0f, 2.0f, 0.5f, Lang.ENG_RU);
    public static String FONT_DIR = "/assets/" + Madara.MOD_ID + "/font/";
    public static final String MOD_ID = "madara";
    public Madara() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigMy.CONFIG);

    }
}
