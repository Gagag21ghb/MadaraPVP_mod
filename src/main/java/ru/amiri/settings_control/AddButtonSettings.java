package ru.amiri.settings_control;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber
public class AddButtonSettings {
    private static final String CATEGORY = "Madara";
    public static final KeyBinding
            MY_KEY_FIRST = new KeyBinding("key.open.screen", GLFW.GLFW_KEY_G, CATEGORY);

    public static void register() {
        setRegister(MY_KEY_FIRST);
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent  event) {
        AddButtonSettings.register();
    }

    private static void setRegister(KeyBinding binding) {
        ClientRegistry.registerKeyBinding(binding);
    }
}
