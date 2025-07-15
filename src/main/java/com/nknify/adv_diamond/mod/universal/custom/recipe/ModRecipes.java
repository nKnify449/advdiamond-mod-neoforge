package com.nknify.adv_diamond.mod.universal.custom.recipe;

import com.nknify.adv_diamond.AdvancedDiamond;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, AdvancedDiamond.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, AdvancedDiamond.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EssenceGrinderRecipe>> ESSENCE_GRINDER_SERIALIZER =
            SERIALIZERS.register("essence_grinder", EssenceGrinderRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<EssenceGrinderRecipe>> ESSENCE_GRINDER_TYPE =
            TYPES.register("essence_grinder", () -> new RecipeType<EssenceGrinderRecipe>() {
                @Override
                public String toString() {
                    return "essence_grinder";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
