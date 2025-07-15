package com.nknify.adv_diamond.mod.universal;

import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModToolTiers implements Tier {
    IRONIFIED_DIAMOND(1748, 12.0f, 4.0f, 20, () -> ModItems.IRONIFIED_DIAMOND, BlockTags.INCORRECT_FOR_NETHERITE_TOOL),
    GOLDIFIED_DIAMOND(1585, 17.0f, 5.0f, 26, () -> ModItems.GOLDIFIED_DIAMOND, BlockTags.INCORRECT_FOR_NETHERITE_TOOL),
    SUPERMOND(3502, 20.0f, 7.0f, 30, () -> ModItems.SUPERMOND, BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;
    private final TagKey<Block> requiredBlocks;

    ModToolTiers(int uses, float speed, float damage, int enchantability, Supplier<ItemLike> repairItem, TagKey<Block> requiredBlocks) {
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantability = enchantability;
        this.repairIngredient = Lazy.of(() -> Ingredient.of(repairItem.get()));
        this.requiredBlocks = requiredBlocks;
    }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return damage; }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return requiredBlocks;
    }

    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public @NotNull Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
