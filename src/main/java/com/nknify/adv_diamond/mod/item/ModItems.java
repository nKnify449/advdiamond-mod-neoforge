package com.nknify.adv_diamond.mod.item;

import com.mojang.blaze3d.platform.InputConstants;
import com.nknify.adv_diamond.mod.universal.ModArmorMaterials;
import com.nknify.adv_diamond.mod.universal.ModToolTiers;
import com.nknify.adv_diamond.mod.universal.custom.item.Endermond;
import com.nknify.adv_diamond.mod.universal.custom.item.Goldified_Diamond;
import com.nknify.adv_diamond.mod.universal.custom.item.Ironified_Diamond;
import com.nknify.adv_diamond.mod.universal.custom.item.Supermond;
import com.nknify.adv_diamond.mod.universal.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static com.nknify.adv_diamond.AdvancedDiamond.MOD_ID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> IRONIFIED_DIAMOND = ITEMS.register("ironified_diamond",
            () -> new Ironified_Diamond(new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> IRON_ESSENCE = ITEMS.register("iron_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredItem<SwordItem> IRONIFIED_DIAMOND_SWORD = ITEMS.register("ironified_diamond_sword",
            () -> new SwordItem(ModToolTiers.IRONIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(SwordItem.createAttributes(ModToolTiers.IRONIFIED_DIAMOND, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> IRONIFIED_DIAMOND_PICKAXE = ITEMS.register("ironified_diamond_pickaxe",
            () -> new PickaxeItem(ModToolTiers.IRONIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.IRONIFIED_DIAMOND, 2.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> IRONIFIED_DIAMOND_SHOVEL = ITEMS.register("ironified_diamond_shovel",
            () -> new ShovelItem(ModToolTiers.IRONIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.IRONIFIED_DIAMOND, 2.5F, -3.0F))));
    public static final DeferredItem<AxeItem> IRONIFIED_DIAMOND_AXE = ITEMS.register("ironified_diamond_axe",
            () -> new AxeItem(ModToolTiers.IRONIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(AxeItem.createAttributes(ModToolTiers.IRONIFIED_DIAMOND, 9F, -3.0F))));
    public static final DeferredItem<HoeItem> IRONIFIED_DIAMOND_HOE = ITEMS.register("ironified_diamond_hoe",
            () -> new HoeItem(ModToolTiers.IRONIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(HoeItem.createAttributes(ModToolTiers.IRONIFIED_DIAMOND, -4F, 0.0F))));


    public static final DeferredItem<ArmorItem> IRONIFIED_DIAMOND_HELMET = ITEMS.register("ironified_diamond_helmet",
            () -> new ArmorItem(ModArmorMaterials.IRONIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.HELMET.getDurability(47))));
    public static final DeferredItem<ArmorItem> IRONIFIED_DIAMOND_CHESTPLATE = ITEMS.register("ironified_diamond_chestplate",
            () -> new ArmorItem(ModArmorMaterials.IRONIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.CHESTPLATE.getDurability(47))));
    public static final DeferredItem<ArmorItem> IRONIFIED_DIAMOND_LEGGINGS = ITEMS.register("ironified_diamond_leggings",
            () -> new ArmorItem(ModArmorMaterials.IRONIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.LEGGINGS.getDurability(47))));
    public static final DeferredItem<ArmorItem> IRONIFIED_DIAMOND_BOOTS = ITEMS.register("ironified_diamond_boots",
            () -> new ArmorItem(ModArmorMaterials.IRONIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.BOOTS.getDurability(47))));


    public static final DeferredItem<Item> GOLDIFIED_DIAMOND = ITEMS.register("goldified_diamond",
            () -> new Goldified_Diamond(new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> GOLD_ESSENCE = ITEMS.register("gold_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredItem<SwordItem> GOLDIFIED_DIAMOND_SWORD = ITEMS.register("goldified_diamond_sword",
            () -> new SwordItem(ModToolTiers.GOLDIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(SwordItem.createAttributes(ModToolTiers.GOLDIFIED_DIAMOND, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> GOLDIFIED_DIAMOND_PICKAXE = ITEMS.register("goldified_diamond_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLDIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.GOLDIFIED_DIAMOND, 2.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> GOLDIFIED_DIAMOND_SHOVEL = ITEMS.register("goldified_diamond_shovel",
            () -> new ShovelItem(ModToolTiers.GOLDIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.GOLDIFIED_DIAMOND, 2.5F, -3.0F))));
    public static final DeferredItem<AxeItem> GOLDIFIED_DIAMOND_AXE = ITEMS.register("goldified_diamond_axe",
            () -> new AxeItem(ModToolTiers.GOLDIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(AxeItem.createAttributes(ModToolTiers.GOLDIFIED_DIAMOND, 9F, -3.0F))));
    public static final DeferredItem<HoeItem> GOLDIFIED_DIAMOND_HOE = ITEMS.register("goldified_diamond_hoe",
            () -> new HoeItem(ModToolTiers.GOLDIFIED_DIAMOND, new Item.Properties().rarity(Rarity.RARE)
                    .attributes(HoeItem.createAttributes(ModToolTiers.GOLDIFIED_DIAMOND, -4F, 0.0F))));

    public static final DeferredItem<ArmorItem> GOLDIFIED_DIAMOND_HELMET = ITEMS.register("goldified_diamond_helmet",
            () -> new ArmorItem(ModArmorMaterials.GOLDIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.HELMET.getDurability(48))){
                @Override
                public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> GOLDIFIED_DIAMOND_CHESTPLATE = ITEMS.register("goldified_diamond_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GOLDIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.CHESTPLATE.getDurability(48))){
                @Override
                public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> GOLDIFIED_DIAMOND_LEGGINGS = ITEMS.register("goldified_diamond_leggings",
            () -> new ArmorItem(ModArmorMaterials.GOLDIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.LEGGINGS.getDurability(48))){
                @Override
                public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> GOLDIFIED_DIAMOND_BOOTS = ITEMS.register("goldified_diamond_boots",
            () -> new ArmorItem(ModArmorMaterials.GOLDIFIED_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().rarity(Rarity.RARE).durability(ArmorItem.Type.BOOTS.getDurability(48))){
                @Override
                public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                    return true;
                }
            });

    public static final DeferredItem<Item> SUPERMOND = ITEMS.register("supermond",
            () -> new Supermond(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> NETHERITE_ESSENCE = ITEMS.register("netherite_essence",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<SwordItem> SUPERMOND_SWORD = ITEMS.register("supermond_sword",
            () -> new SwordItem(ModToolTiers.SUPERMOND, new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .attributes(SwordItem.createAttributes(ModToolTiers.SUPERMOND, 5, -2.4f))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<PickaxeItem> SUPERMOND_PICKAXE = ITEMS.register("supermond_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SUPERMOND, new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SUPERMOND, 2.0F, -2.8F))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ShovelItem> SUPERMOND_SHOVEL = ITEMS.register("supermond_shovel",
            () -> new ShovelItem(ModToolTiers.SUPERMOND, new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SUPERMOND, 2.5F, -3.0F))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<AxeItem> SUPERMOND_AXE = ITEMS.register("supermond_axe",
            () -> new AxeItem(ModToolTiers.SUPERMOND, new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .attributes(AxeItem.createAttributes(ModToolTiers.SUPERMOND, 9F, -3.0F))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<HoeItem> SUPERMOND_HOE = ITEMS.register("supermond_hoe",
            () -> new HoeItem(ModToolTiers.SUPERMOND, new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .attributes(HoeItem.createAttributes(ModToolTiers.SUPERMOND, -4F, 0.0F))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });

    public static final DeferredItem<ArmorItem> SUPERMOND_HELMET = ITEMS.register("supermond_helmet",
            () -> new ArmorItem(ModArmorMaterials.SUPERMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.HELMET.getDurability(55))) {
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> SUPERMOND_CHESTPLATE = ITEMS.register("supermond_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SUPERMOND_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.CHESTPLATE.getDurability(55))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> SUPERMOND_LEGGINGS = ITEMS.register("supermond_leggings",
            () -> new ArmorItem(ModArmorMaterials.SUPERMOND_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.LEGGINGS.getDurability(55))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> SUPERMOND_BOOTS = ITEMS.register("supermond_boots",
            () -> new ArmorItem(ModArmorMaterials.SUPERMOND_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().rarity(Rarity.EPIC).durability(ArmorItem.Type.BOOTS.getDurability(55))){
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });

    public static final DeferredItem<Item> ENDERMOND = ITEMS.register("endermond",
            () -> new Endermond(new Item.Properties().durability(3)));

    public static final DeferredItem<Item> ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("adv_diamond_upg_sm_temp",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    long handle = Minecraft.getInstance().getWindow().getWindow();
                    if (InputConstants.isKeyDown(handle, KeyBinding.ALPHA_KEY.getKey().getValue())) {
                        tooltipComponents.add(Component.literal("Ability: Can upgrade and advance diamond"));
                    } else {
                        tooltipComponents.add(Component.literal("Press the §6Alpha Key§r to view STATS"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
