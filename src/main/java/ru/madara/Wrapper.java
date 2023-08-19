package ru.madara;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import ru.madara.common.Lang;
import ru.madara.font.styled.StyledFont;

public interface Wrapper {
    StyledFont font = new StyledFont("Greycliff.ttf", 20, 0.0f, 1.0f, 0.5f, Lang.ENG_RU);
    Minecraft mc = Minecraft.getInstance();
    FontRenderer fontRenderer = mc.font;


}