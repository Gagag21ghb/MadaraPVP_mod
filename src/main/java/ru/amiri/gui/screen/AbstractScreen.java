package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import ru.amiri.Madara;
import ru.amiri.gui.screen.CollorSettingsScreen;
import ru.amiri.gui.screen.MainSettingsScreen;

import static ru.amiri.settings.AddSettings.MY_KEY_FIRST;


public abstract class AbstractScreen extends Screen {
    private static final ITextComponent clickableText = new StringTextComponent("Открыть гл");
    private static final ITextComponent clickableText2 = new StringTextComponent("Открыть коллло");

    protected AbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        if (p_231046_1_ == MY_KEY_FIRST.getKey().getValue() || p_231046_1_ == Minecraft.getInstance().options.keyInventory.getKey().getValue()) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(p_231046_1_, p_231046_2_, p_231046_3_);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        Button myButton = new Button(x, y, buttonWidth, buttonHeight, clickableText, button -> {
            Minecraft.getInstance().setScreen(new MainSettingsScreen(new StringTextComponent("collor screen")));
        });
        Button myButton2 = new Button(x, +10, buttonWidth, buttonHeight, clickableText2, button -> {
            Minecraft.getInstance().setScreen(new CollorSettingsScreen(new StringTextComponent("collor screen")));
        });

        this.addButton(myButton);
        this.addButton(myButton2);
    }
}
