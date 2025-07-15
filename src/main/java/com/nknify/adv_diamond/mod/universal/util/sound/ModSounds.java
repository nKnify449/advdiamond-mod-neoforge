package com.nknify.adv_diamond.mod.universal.util.sound;

import com.nknify.adv_diamond.AdvancedDiamond;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AdvancedDiamond.MOD_ID);

    public static final Supplier<SoundEvent> DIAMOND_SHARDS_FININSHER = registerSoundEvent("diamond_shards_finisher");
    public static final Supplier<SoundEvent> ENDERMOND_LINK = registerSoundEvent("endermond_link");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(AdvancedDiamond.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
