package ru.madara;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import ru.madara.common.Lang;
import ru.madara.config.ModConfig;
import ru.madara.font.styled.StyledFont;

@Mod("madara")
public class Madara {
    public static final String MOD_ID = "madara";
    public static StyledFont font = new StyledFont("Greycliff.ttf", 15, 0.0f, 1.0f, 0.5f, Lang.ENG_RU);

    public Madara() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, ModConfig.CONFIG);

    }
}
