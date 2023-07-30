package ru.amiri.settings_control;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.amiri.gui.screen.SettingsScreen;

import static ru.amiri.settings_control.AddButtonSettings.MY_KEY_FIRST;

@Mod.EventBusSubscriber
public class Input {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (MY_KEY_FIRST.isDown()) {
            Minecraft.getInstance().setScreen(new SettingsScreen(new StringTextComponent("Text")));
        }
    }
}
