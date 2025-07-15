package com.nknify.adv_diamond.mod.datagen;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AdvancedDiamond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.PICKAXES)
                .add(ModItems.IRONIFIED_DIAMOND_PICKAXE.get())
                .add(ModItems.GOLDIFIED_DIAMOND_PICKAXE.get())
                .add(ModItems.SUPERMOND_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.IRONIFIED_DIAMOND_AXE.get())
                .add(ModItems.GOLDIFIED_DIAMOND_AXE.get())
                .add(ModItems.SUPERMOND_AXE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.IRONIFIED_DIAMOND_SWORD.get())
                .add(ModItems.GOLDIFIED_DIAMOND_SWORD.get())
                .add(ModItems.SUPERMOND_SWORD.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.IRONIFIED_DIAMOND_SHOVEL.get())
                .add(ModItems.GOLDIFIED_DIAMOND_SHOVEL.get())
                .add(ModItems.SUPERMOND_SHOVEL.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.IRONIFIED_DIAMOND_HOE.get())
                .add(ModItems.GOLDIFIED_DIAMOND_HOE.get())
                .add(ModItems.SUPERMOND_HOE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.IRONIFIED_DIAMOND_HELMET.get())
                .add(ModItems.GOLDIFIED_DIAMOND_HELMET.get())
                .add(ModItems.SUPERMOND_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.IRONIFIED_DIAMOND_CHESTPLATE.get())
                .add(ModItems.GOLDIFIED_DIAMOND_CHESTPLATE.get())
                .add(ModItems.SUPERMOND_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.IRONIFIED_DIAMOND_LEGGINGS.get())
                .add(ModItems.GOLDIFIED_DIAMOND_LEGGINGS.get())
                .add(ModItems.SUPERMOND_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.IRONIFIED_DIAMOND_BOOTS.get())
                .add(ModItems.GOLDIFIED_DIAMOND_BOOTS.get())
                .add(ModItems.SUPERMOND_BOOTS.get());
    }
}
