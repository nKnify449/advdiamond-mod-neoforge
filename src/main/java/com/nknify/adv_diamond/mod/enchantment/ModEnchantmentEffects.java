package com.nknify.adv_diamond.mod.enchantment;

import com.mojang.serialization.MapCodec;
import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.universal.custom.enchantment.DiamondShardsEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, AdvancedDiamond.MOD_ID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> DIAMOND_SHARDS =
            ENTITY_ENCHANTMENT_EFFECTS.register("diamond_shards", () -> DiamondShardsEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
