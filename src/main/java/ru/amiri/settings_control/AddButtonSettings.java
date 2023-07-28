package ru.amiri.settings_control;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;
@Mod.EventBusSubscriber
public class AddButtonSettings {
    public static final String CATEGORY_NAME = "key.categories.movement"; // Категория "движения"

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        // Создание новой кнопки с именем "My Custom Key" и кодом GLFW.GLFW_KEY_M
        KeyBinding myKey = new KeyBinding("key.mymod.mykey", GLFW.GLFW_KEY_M, CATEGORY_NAME);

        // Регистрация кнопки
        ClientRegistry.registerKeyBinding(myKey);


    }
}
