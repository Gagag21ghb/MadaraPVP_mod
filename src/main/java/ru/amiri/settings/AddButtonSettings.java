package ru.amiri.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;
import ru.amiri.Madara;
import ru.amiri.gui.screen.SettingsScreen;

import java.time.chrono.MinguoEra;

@Mod.EventBusSubscriber(modid = Madara.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddButtonSettings {
    private static final String CATEGORY = "Madara";
    public static final KeyBinding MY_KEY_FIRST = new KeyBinding("key.open.screen", GLFW.GLFW_KEY_G, CATEGORY);

    @SubscribeEvent
    public static void setRegister(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(MY_KEY_FIRST);
    }

    @Mod.EventBusSubscriber(modid = Madara.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class AddingFunctionality {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (MY_KEY_FIRST.isDown()) {
                if (Minecraft.getInstance().screen == null){
                    Minecraft.getInstance().setScreen(new SettingsScreen(new StringTextComponent("Text")));
                }
            }
        }
    }

}
