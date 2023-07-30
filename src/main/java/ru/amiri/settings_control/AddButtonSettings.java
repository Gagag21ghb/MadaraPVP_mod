package ru.amiri.settings_control;

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

@Mod.EventBusSubscriber(modid = Madara.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddButtonSettings {
    private static final String CATEGORY = "Madara";
    public static final KeyBinding MY_KEY_FIRST = new KeyBinding("key.open.screen", GLFW.GLFW_KEY_G, CATEGORY);
    public static SettingsScreen screen;
    @SubscribeEvent
    public static void setRegister(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(MY_KEY_FIRST);
    }
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (MY_KEY_FIRST.isDown()) {
            if (screen == null) {
                screen = new SettingsScreen(new StringTextComponent("text"));
                Minecraft.getInstance().setScreen(screen);
            }
        } else {
            screen = null;
        }
    }
}
