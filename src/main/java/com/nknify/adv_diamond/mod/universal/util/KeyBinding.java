package com.nknify.adv_diamond.mod.universal.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_ADV_DIAMOND = "key.category.adv_diamond.keybinds";
    public static final String KEY_ALPHA_KEY = "key.adv_diamond.key_alpha_key";

    public static final KeyMapping ALPHA_KEY = new KeyMapping(KEY_ALPHA_KEY, KeyConflictContext.GUI,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_ADV_DIAMOND);
}
