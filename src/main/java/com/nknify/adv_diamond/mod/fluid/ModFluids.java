package com.nknify.adv_diamond.mod.fluid;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.block.ModBlocks;
import com.nknify.adv_diamond.mod.item.ModItems;
import com.nknify.adv_diamond.mod.universal.custom.fluid.DiamondLavaBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, AdvancedDiamond.MOD_ID);

    public static final Supplier<FlowingFluid> SOURCE_DIAMOND_LAVA = FLUIDS.register("source_d_lava",
            () -> new BaseFlowingFluid.Source(ModFluids.DIAMOND_LAVA_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_DIAMOND_LAVA = FLUIDS.register("flowing_d_lava",
            () -> new BaseFlowingFluid.Flowing(ModFluids.DIAMOND_LAVA_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> DIAMOND_LAVA_BLOCK = ModBlocks.BLOCKS.register("d_lava_block",
            () -> new DiamondLavaBlock(ModFluids.SOURCE_DIAMOND_LAVA.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredItem<Item> DIAMOND_LAVA_BUCKET = ModItems.ITEMS.registerItem("d_lava_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_DIAMOND_LAVA.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties DIAMOND_LAVA_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.DIAMOND_LAVA_FLUID_TYPE, SOURCE_DIAMOND_LAVA, FLOWING_DIAMOND_LAVA)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModFluids.DIAMOND_LAVA_BLOCK).bucket(ModFluids.DIAMOND_LAVA_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}