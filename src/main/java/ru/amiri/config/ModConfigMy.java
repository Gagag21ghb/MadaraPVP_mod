package ru.amiri.config;

import net.minecraftforge.common.ForgeConfigSpec;
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
    public static void saveConfig() {
        CONFIG.save();
    }
}
