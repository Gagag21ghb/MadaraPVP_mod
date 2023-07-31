package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import ru.amiri.Madara;
import ru.amiri.settings.AddButtonSettings;

import static ru.amiri.settings.AddButtonSettings.MY_KEY_FIRST;

@Mod.EventBusSubscriber
public class SettingsScreen extends Screen {
    private static final ResourceLocation LOLOLOSHKA = new ResourceLocation(Madara.MOD_ID, "textures/gui/lololoshka.jpg");
    private static final ITextComponent clickableText = new StringTextComponent("test").withStyle();

    public SettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int p_231046_1_, int p_231046_2_, int p_231046_3_) {
        if (p_231046_1_ == MY_KEY_FIRST.getKey().getValue()) {
            Minecraft.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(p_231046_1_, p_231046_2_, p_231046_3_);
    }

    @Override
    public void render(MatrixStack matrixStack,  int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        int textureWidth = 200;
        int textureHeight = 180;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        Minecraft.getInstance().textureManager.bind(LOLOLOSHKA);
        blit(matrixStack, x, y, 0, 0, 200, 160);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 100;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height / 2 + 40;

        Button myButton = new ButtonCustom(x, y, buttonWidth, buttonHeight, clickableText, button -> {

        });

        this.addButton(myButton);
    }

    static class ButtonCustom extends Button{

        public ButtonCustom(int p_i232255_1_, int p_i232255_2_, int p_i232255_3_, int p_i232255_4_, ITextComponent p_i232255_5_, IPressable p_i232255_6_) {
            super(p_i232255_1_, p_i232255_2_, p_i232255_3_, p_i232255_4_, p_i232255_5_, p_i232255_6_);
        }

        @Override
        public void renderButton(MatrixStack p_230431_1_, int mouseX, int mouseY, float partialTicks) {
            super.renderButton(p_230431_1_, mouseX, mouseY, partialTicks); // Рендерим только текст

        }
    }
}