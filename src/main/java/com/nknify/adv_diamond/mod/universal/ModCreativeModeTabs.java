package com.nknify.adv_diamond.mod.universal;

import com.nknify.adv_diamond.Config;
import com.nknify.adv_diamond.mod.block.ModBlocks;
import com.nknify.adv_diamond.mod.enchantment.ModEnchantments;
import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.nknify.adv_diamond.AdvancedDiamond.MOD_ID;

public class ModCreativeModeTabs {
    public static final DeferredRegister CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, MOD_ID);

    public static final Supplier<CreativeModeTab> ADVANCED_DIAMONDS_TAB = CREATIVE_TABS.register("adv_diamonds_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("Advanced Diamonds"))
            .icon(() -> new ItemStack(Items.DIAMOND))
            .displayItems((params, output) -> {

                if (!Config.REMOVE_ITEM_FROM_TAB.get()) {
                    output.accept(Items.DIAMOND);
                    output.accept(Items.DIAMOND_PICKAXE);
                    output.accept(Items.DIAMOND_AXE);
                    output.accept(Items.DIAMOND_SWORD);
                    output.accept(Items.DIAMOND_SHOVEL);
                    output.accept(Items.DIAMOND_HOE);

                    output.accept(Items.DIAMOND_HELMET);
                    output.accept(Items.DIAMOND_CHESTPLATE);
                    output.accept(Items.DIAMOND_LEGGINGS);
                    output.accept(Items.DIAMOND_BOOTS);
                }

                output.accept(ModItems.IRONIFIED_DIAMOND);
                output.accept(ModItems.IRON_ESSENCE);

                output.accept(ModItems.IRONIFIED_DIAMOND_PICKAXE);
                output.accept(ModItems.IRONIFIED_DIAMOND_AXE);
                output.accept(ModItems.IRONIFIED_DIAMOND_SWORD);
                output.accept(ModItems.IRONIFIED_DIAMOND_SHOVEL);
                output.accept(ModItems.IRONIFIED_DIAMOND_HOE);

                output.accept(ModItems.IRONIFIED_DIAMOND_HELMET);
                output.accept(ModItems.IRONIFIED_DIAMOND_CHESTPLATE);
                output.accept(ModItems.IRONIFIED_DIAMOND_LEGGINGS);
                output.accept(ModItems.IRONIFIED_DIAMOND_BOOTS);

                output.accept(ModItems.GOLDIFIED_DIAMOND);
                output.accept(ModItems.GOLD_ESSENCE);

                output.accept(ModItems.GOLDIFIED_DIAMOND_PICKAXE);
                output.accept(ModItems.GOLDIFIED_DIAMOND_AXE);
                output.accept(ModItems.GOLDIFIED_DIAMOND_SWORD);
                output.accept(ModItems.GOLDIFIED_DIAMOND_SHOVEL);
                output.accept(ModItems.GOLDIFIED_DIAMOND_HOE);

                output.accept(ModItems.GOLDIFIED_DIAMOND_HELMET);
                output.accept(ModItems.GOLDIFIED_DIAMOND_CHESTPLATE);
                output.accept(ModItems.GOLDIFIED_DIAMOND_LEGGINGS);
                output.accept(ModItems.GOLDIFIED_DIAMOND_BOOTS);

                output.accept(ModItems.SUPERMOND);
                output.accept(ModItems.NETHERITE_ESSENCE);

                output.accept(ModItems.SUPERMOND_PICKAXE);
                output.accept(ModItems.SUPERMOND_AXE);
                output.accept(ModItems.SUPERMOND_SWORD);
                output.accept(ModItems.SUPERMOND_SHOVEL);
                output.accept(ModItems.SUPERMOND_HOE);

                output.accept(ModItems.SUPERMOND_HELMET);
                output.accept(ModItems.SUPERMOND_CHESTPLATE);
                output.accept(ModItems.SUPERMOND_LEGGINGS);
                output.accept(ModItems.SUPERMOND_BOOTS);

                output.accept(ModItems.ENDERMOND);

                output.accept(ModBlocks.ESSENCE_GRINDER);
                output.accept(ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE);

            })
            .build()
    );

    public static void register(IEventBus eventBus){
        CREATIVE_TABS.register(eventBus);
    }
}
