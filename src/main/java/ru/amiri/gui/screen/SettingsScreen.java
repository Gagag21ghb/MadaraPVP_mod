package ru.amiri.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import ru.amiri.Madara;

@Mod.EventBusSubscriber
public class SettingsScreen extends Screen {
    private static final ResourceLocation LOLOLOSHKA = new ResourceLocation(Madara.MOD_ID, "textures/gui/lololoshka.jpg");


    protected SettingsScreen(ITextComponent p_i51108_1_) {
          super(p_i51108_1_);

        }
    @Override
    public void render(MatrixStack matrixStack,  int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(matrixStack);

        int textureWidth = 200;
        int textureHeight = 160;
        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        Minecraft.getInstance().textureManager.bind(LOLOLOSHKA);
        blit(matrixStack, x, y, 0, 0, 200, 160);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        int keyCode = event.getKey();

        if (keyCode == GLFW.GLFW_KEY_T) {

             Minecraft.getInstance().setScreen(new SettingsScreen(new StringTextComponent("Another Screen")));
        }

    }
}