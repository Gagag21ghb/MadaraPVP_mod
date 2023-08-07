package ru.madara.gui.screen.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;

public interface Wrapper {
    Minecraft mc = Minecraft.getInstance();
    PlayerEntity playerEntity = mc.player;
    FontRenderer fontRenderer = mc.font;

}
