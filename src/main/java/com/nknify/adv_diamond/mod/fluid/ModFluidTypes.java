package com.nknify.adv_diamond.mod.fluid;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.universal.custom.fluid.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation LAVA_STILL_RL = ResourceLocation.fromNamespaceAndPath(AdvancedDiamond.MOD_ID, "block/d_lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(AdvancedDiamond.MOD_ID, "block/d_lava_flow");
    public static final ResourceLocation LAVA_OVERLAY_RL = ResourceLocation.parse("block/lava_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, AdvancedDiamond.MOD_ID);

    public static final Supplier<FluidType> DIAMOND_LAVA_FLUID_TYPE = registerFluidType("d_lava_fluid",
            new BaseFluidType(LAVA_STILL_RL, LAVA_FLOWING_RL, LAVA_OVERLAY_RL, 0xFF80D8FF,
                    new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
                    FluidType.Properties.create()));



    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
