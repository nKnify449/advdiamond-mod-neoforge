package com.nknify.adv_diamond.mod.datagen;

import com.nknify.adv_diamond.mod.fluid.ModFluids;
import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModFluids.DIAMOND_LAVA_BUCKET.getId(), new FurnaceFuel(50000), false);

        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.INACTIVE_IRONIFIED_DIAMOND.getId(), new FurnaceFuel(14000), false);

        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.INACTIVE_GOLDIFIED_DIAMOND.getId(), new FurnaceFuel(15000), false);

        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.INACTIVE_SUPERMOND.getId(), new FurnaceFuel(16000), false);
    }
}
