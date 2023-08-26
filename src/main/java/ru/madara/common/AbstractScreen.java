package ru.madara.common;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import ru.madara.Wrapper;
import ru.madara.gui.button.LinesButtonRender;

public abstract class AbstractScreen extends BaseAbstractScreen {
    protected AbstractScreen(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 10;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        LinesButtonRender onOfRender = new LinesButtonRender(x, y, buttonWidth, buttonHeight, new TranslationTextComponent("button.on.of.render"));
        this.addButton(onOfRender);

    }

}
