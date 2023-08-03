package ru.madara.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Madara;

import static ru.madara.settings.AddSettings.MY_KEY_FIRST;


public abstract class AbstractScreen extends Screen {
    public static final ResourceLocation LOLOLOSHKA = new ResourceLocation(Madara.MOD_ID, "textures/gui/lololoshka.jpg");
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

        Button onOfRender = new Button(x, y, buttonWidth, buttonHeight, new TranslationTextComponent("button.on.of.render"), button -> {
            Minecraft.getInstance().setScreen(new SettingsRender(new StringTextComponent("Settings render")));
        });

        this.addButton(onOfRender);
    }
}
