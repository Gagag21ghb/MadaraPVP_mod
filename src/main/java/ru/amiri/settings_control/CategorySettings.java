package ru.amiri.settings_control;

import net.minecraftforge.client.settings.IKeyConflictContext;

public class CategorySettings implements IKeyConflictContext {
    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public boolean conflicts(IKeyConflictContext other) {
        return false;
    }

}
