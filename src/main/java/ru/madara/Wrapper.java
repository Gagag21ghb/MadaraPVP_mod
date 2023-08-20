package ru.madara;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
public interface Wrapper {

    Minecraft mc = Minecraft.getInstance();
    FontRenderer fontRenderer = mc.font;
}