package com.nknify.adv_diamond.mod.universal.custom.block.entity;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AdvancedDiamond.MOD_ID);

    public static final Supplier<BlockEntityType<EssenceGrinderBlockEntity>> ESSENCE_GRINDER_BE =
            BLOCK_ENTITIES.register("essence_grinder_be", () -> BlockEntityType.Builder.of(
                    EssenceGrinderBlockEntity::new, ModBlocks.ESSENCE_GRINDER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}