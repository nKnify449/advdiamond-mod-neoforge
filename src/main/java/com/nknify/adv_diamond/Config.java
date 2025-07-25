package com.nknify.adv_diamond;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public enum VerLabelMode {
        MC_AND_MOD,
        MC,
        MOD,
        OFF;
    }

    public static final ModConfigSpec.BooleanValue REMOVE_ITEM_FROM_TAB;
    static {
        REMOVE_ITEM_FROM_TAB = BUILDER
                .comment("If true, the vanilla items will be removed from the creative tab.")
                .define("removeItemFromTab", false);
    }

    public static final ModConfigSpec.EnumValue<VerLabelMode> MINECRAFT_VERSION_LABEL;
    static {
        MINECRAFT_VERSION_LABEL = BUILDER
                .comment("Changes the label at the top of the screen which contains the mod and MC version")
                .defineEnum("mc_version_label", VerLabelMode.OFF);
    }

    public static final ModConfigSpec.BooleanValue PACIFY_IRON_GOLEM_WITH_ARMOR;
    static {
        PACIFY_IRON_GOLEM_WITH_ARMOR = BUILDER
                .comment("If true, it will pacify iron golems when wearing the correct armor set.")
                .define("pacifyIronGolem", true);
    }

    public static final ModConfigSpec.BooleanValue PACIFY_PHANTOM_WITH_ARMOR;
    static {
        PACIFY_PHANTOM_WITH_ARMOR = BUILDER
                .comment("If true, it will pacify phantoms when wearing the correct armor set.")
                .define("pacifyPhantom", true);
    }

    public static final ModConfigSpec.BooleanValue PACIFY_ENDERMAN_WITH_ARMOR;
    static {
        PACIFY_ENDERMAN_WITH_ARMOR = BUILDER
                .comment("If true, it will pacify endermen when wearing the correct armor set.")
                .define("pacifyEnderman", true);
    }

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
