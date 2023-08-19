package ru.madara;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import ru.madara.common.Lang;
import ru.madara.font.styled.StyledFont;

public interface Wrapper {

    Minecraft mc = Minecraft.getInstance();
    FontRenderer fontRenderer = mc.font;


}