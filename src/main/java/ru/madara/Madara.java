package ru.madara;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import ru.madara.common.Lang;
import ru.madara.config.ModConfigMy;
import ru.madara.font.styled.StyledFont;

@Mod("madara")
public class Madara {
    public static final String MOD_ID = "madara";
    public Madara() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigMy.CONFIG);

    }
}
