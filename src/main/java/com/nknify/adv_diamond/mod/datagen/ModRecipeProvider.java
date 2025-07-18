package com.nknify.adv_diamond.mod.datagen;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.block.ModBlocks;
import com.nknify.adv_diamond.mod.fluid.ModFluids;
import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ESSENCE_GRINDER.get())
                .pattern("SIS")
                .pattern("IMI")
                .pattern("SIS")
                .define('S', Items.STONE)
                .define('I', Items.IRON_BLOCK)
                .define('M', Items.MACE)
                .unlockedBy("has_mace", has(Items.MACE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DSD")
                .pattern("DBD")
                .pattern("DDD")
                .define('S', ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE)
                .define('D', Items.DIAMOND)
                .define('B', Items.DRAGON_BREATH)
                .unlockedBy("has_adv_diamond_upg_sm_temp", has(ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModFluids.DIAMOND_LAVA_BUCKET.get())
                .pattern("DDD")
                .pattern("DBD")
                .pattern("DDD")
                .define('D', Items.DIAMOND)
                .define('B', Items.LAVA_BUCKET)
                .unlockedBy("has_lava_bucket", has(Items.LAVA_BUCKET)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRONIFIED_DIAMOND.get(), 1)
                .requires(ModItems.IRON_ESSENCE)
                .requires(Items.DIAMOND)
                .unlockedBy("has_iron_essence", has(ModItems.IRON_ESSENCE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDIFIED_DIAMOND.get(), 1)
                .requires(ModItems.GOLD_ESSENCE)
                .requires(Items.DIAMOND)
                .unlockedBy("has_gold_essence", has(ModItems.GOLD_ESSENCE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUPERMOND.get(), 1)
                .requires(ModItems.NETHERITE_ESSENCE)
                .requires(Items.DIAMOND)
                .unlockedBy("has_netherite_essence", has(ModItems.NETHERITE_ESSENCE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERMOND.get(), 1)
                .requires(Items.DIAMOND)
                .requires(Items.ENDER_EYE)
                .unlockedBy("has_ender_eye", has(Items.ENDER_EYE)).save(recipeOutput);

        Smithing(Items.DIAMOND_PICKAXE, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_PICKAXE.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_pickaxe_smithing");
        Smithing(Items.DIAMOND_AXE, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_AXE.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_axe_smithing");
        Smithing(Items.DIAMOND_SWORD, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_SWORD.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_sword_smithing");
        Smithing(Items.DIAMOND_SHOVEL, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_SHOVEL.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_shovel_smithing");
        Smithing(Items.DIAMOND_HOE, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_HOE.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_hoe_smithing");

        Smithing(Items.DIAMOND_HELMET, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_HELMET.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_helmet_smithing");
        Smithing(Items.DIAMOND_CHESTPLATE, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_CHESTPLATE.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_chestplate_smithing");
        Smithing(Items.DIAMOND_LEGGINGS, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_LEGGINGS.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_leggings_smithing");
        Smithing(Items.DIAMOND_BOOTS, ModItems.IRONIFIED_DIAMOND.get(), ModItems.IRONIFIED_DIAMOND_BOOTS.get(), "has_ironified_diamond", ModItems.IRONIFIED_DIAMOND.get(), recipeOutput, "ironified_diamond_boots_smithing");



        Smithing(Items.DIAMOND_PICKAXE, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_PICKAXE.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_pickaxe_smithing");
        Smithing(Items.DIAMOND_AXE, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_AXE.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_axe_smithing");
        Smithing(Items.DIAMOND_SWORD, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_SWORD.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_sword_smithing");
        Smithing(Items.DIAMOND_SHOVEL, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_SHOVEL.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_shovel_smithing");
        Smithing(Items.DIAMOND_HOE, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_HOE.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_hoe_smithing");

        Smithing(Items.DIAMOND_HELMET, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_HELMET.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_helmet_smithing");
        Smithing(Items.DIAMOND_CHESTPLATE, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_CHESTPLATE.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_chestplate_smithing");
        Smithing(Items.DIAMOND_LEGGINGS, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_LEGGINGS.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_leggings_smithing");
        Smithing(Items.DIAMOND_BOOTS, ModItems.GOLDIFIED_DIAMOND.get(), ModItems.GOLDIFIED_DIAMOND_BOOTS.get(), "has_goldified_diamond", ModItems.GOLDIFIED_DIAMOND.get(), recipeOutput, "goldified_diamond_boots_smithing");



        Smithing(Items.DIAMOND_PICKAXE, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_PICKAXE.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_pickaxe_smithing");
        Smithing(Items.DIAMOND_AXE, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_AXE.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_axe_smithing");
        Smithing(Items.DIAMOND_SWORD, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_SWORD.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_sword_smithing");
        Smithing(Items.DIAMOND_SHOVEL, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_SHOVEL.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_shovel_smithing");
        Smithing(Items.DIAMOND_HOE, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_HOE.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_hoe_smithing");

        Smithing(Items.DIAMOND_HELMET, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_HELMET.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_helmet_smithing");
        Smithing(Items.DIAMOND_CHESTPLATE, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_CHESTPLATE.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_chestplate_smithing");
        Smithing(Items.DIAMOND_LEGGINGS, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_LEGGINGS.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_leggings_smithing");
        Smithing(Items.DIAMOND_BOOTS, ModItems.SUPERMOND.get(), ModItems.SUPERMOND_BOOTS.get(), "has_supermond", ModItems.SUPERMOND.get(), recipeOutput, "supermond_boots_smithing");

    }

    public static void Smithing(Item base, Item addition, Item result, String key, Item has, RecipeOutput output, String path){
        SmithingTransformRecipeBuilder
                .smithing(Ingredient.of(ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(base), Ingredient.of(addition), RecipeCategory.MISC, result)
                .unlocks(key, has(has))
                .save(output, ResourceLocation.fromNamespaceAndPath(AdvancedDiamond.MOD_ID, path));
    }
}
