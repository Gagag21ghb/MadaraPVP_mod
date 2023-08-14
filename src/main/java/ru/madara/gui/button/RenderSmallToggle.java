    package ru.madara.gui.button;

    import com.mojang.blaze3d.matrix.MatrixStack;
    import net.minecraft.client.gui.AbstractGui;
    import net.minecraft.client.gui.widget.Widget;
    import net.minecraft.util.ResourceLocation;
    import net.minecraft.util.text.ITextComponent;
    import net.minecraft.util.text.TranslationTextComponent;
    import net.minecraftforge.common.ForgeConfigSpec;
    import ru.madara.Madara;
    import ru.madara.Wrapper;
    import ru.madara.config.ModConfigMy;
    import ru.madara.font.styled.StyledFontRenderer;

    import java.awt.*;
    import java.util.function.Consumer;

    public class RenderSmallToggle extends Widget implements Wrapper {

        private final Consumer<Widget> onPress;
        private TranslationTextComponent TextInButton;
        boolean loadedToggleButtonState;
        private ForgeConfigSpec.BooleanValue toggleButtonConfig; // Поле для хранения настройки кнопки


        public RenderSmallToggle(int x, int y, int width, int height,
                                 ITextComponent title, TranslationTextComponent text, Consumer<Widget> onPress, ForgeConfigSpec.BooleanValue toggleButtonConfig) {
            super(x, y, width, height, title);

            TextInButton = text;
            this.onPress = onPress;

            this.toggleButtonConfig = toggleButtonConfig; // Принимаем настройку кнопки извне
            loadedToggleButtonState = toggleButtonConfig.get(); // Инициализируем состояние кнопки из настроек

        }
        @Override
        public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
            StyledFontRenderer.drawShadowedCenteredYString(matrixStack, font, TextInButton, 0, 0 - font.getFontHeight(), Color.WHITE);

            int buttonWidth = this.getWidth();
            int buttonHeight = this.getHeight();
            int buttonX = this.x;
            int buttonY = this.y;
            int argbColor =  loadedToggleButtonState ? Color.red.getRGB() : Color.green.getRGB();

            AbstractGui.fill(matrixStack, buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, argbColor);
        }

        @Override
        public void onClick(double mouseX, double mouseY) {
            super.onClick(mouseX, mouseY);
            if (onPress != null) {
                onPress.accept(this);
                loadedToggleButtonState = !loadedToggleButtonState;

                toggleButtonConfig.set(loadedToggleButtonState); // Сохраняем состояние в настройках
                ModConfigMy.saveConfig(); // Сохраняем настройки

            }
        }


    }