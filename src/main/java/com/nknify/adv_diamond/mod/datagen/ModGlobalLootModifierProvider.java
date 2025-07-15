package com.nknify.adv_diamond.mod.datagen;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.item.ModItems;
import com.nknify.adv_diamond.mod.universal.custom.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, AdvancedDiamond.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("adv_diamond_upg_sm_temp_from_end_city_treasure",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build()
                }, ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()));

        this.add("netherite_essence_from_treasure_bastion",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build()
                }, ModItems.NETHERITE_ESSENCE.get()));

        this.add("netherite_essence_from_other_bastion",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_other")).build(),
                        LootItemRandomChanceCondition.randomChance(0.10f).build()
                }, ModItems.NETHERITE_ESSENCE.get()));

    }
}
