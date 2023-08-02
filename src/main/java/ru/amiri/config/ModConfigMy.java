package ru.amiri.config;

import net.minecraftforge.common.ForgeConfigSpec;
import ru.amiri.gui.screen.SettingsRender;

public class ModConfigMy {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    public static ForgeConfigSpec.BooleanValue renderEffects;

    static {
        BUILDER.comment("General settings").push("general");

        renderEffects = BUILDER
                .comment("Enable or disable effects rendering")
                .define("render_effects", true);

        BUILDER.pop();

        CONFIG = BUILDER.build();
    }

    public static void loadConfigValues() {
        renderEffects.set(SettingsRender.renderEffects);
    }
}
