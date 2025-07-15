package com.nknify.adv_diamond.mod.universal.custom.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record EssenceGrinderRecipe(Ingredient inputItem, ItemStack output) implements Recipe<EssenceGrinderRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // GrowthChamberRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(EssenceGrinderRecipeInput growthChamberRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(growthChamberRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(EssenceGrinderRecipeInput growthChamberRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ESSENCE_GRINDER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ESSENCE_GRINDER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<EssenceGrinderRecipe> {
        public static final MapCodec<EssenceGrinderRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(EssenceGrinderRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(EssenceGrinderRecipe::output)
        ).apply(inst, EssenceGrinderRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, EssenceGrinderRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, EssenceGrinderRecipe::inputItem,
                        ItemStack.STREAM_CODEC, EssenceGrinderRecipe::output,
                        EssenceGrinderRecipe::new);

        @Override
        public MapCodec<EssenceGrinderRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, EssenceGrinderRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}