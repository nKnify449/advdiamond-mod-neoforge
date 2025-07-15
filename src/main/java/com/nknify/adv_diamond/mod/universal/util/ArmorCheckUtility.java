package com.nknify.adv_diamond.mod.universal.util;

import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ArmorCheckUtility {
    public static boolean isWearingFullIronifiedDiamondArmor(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return head.getItem() == ModItems.IRONIFIED_DIAMOND_HELMET.get()
                && chest.getItem() == ModItems.IRONIFIED_DIAMOND_CHESTPLATE.get()
                && legs.getItem() == ModItems.IRONIFIED_DIAMOND_LEGGINGS.get()
                && feet.getItem() == ModItems.IRONIFIED_DIAMOND_BOOTS.get();
    }

    public static boolean isWearingFullGoldifiedDiamondArmor(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return head.getItem() == ModItems.GOLDIFIED_DIAMOND_HELMET.get()
                && chest.getItem() == ModItems.GOLDIFIED_DIAMOND_CHESTPLATE.get()
                && legs.getItem() == ModItems.GOLDIFIED_DIAMOND_LEGGINGS.get()
                && feet.getItem() == ModItems.GOLDIFIED_DIAMOND_BOOTS.get();
    }

    public static boolean isWearingFullSupermondArmor(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return head.getItem() == ModItems.SUPERMOND_HELMET.get()
                && chest.getItem() == ModItems.SUPERMOND_CHESTPLATE.get()
                && legs.getItem() == ModItems.SUPERMOND_LEGGINGS.get()
                && feet.getItem() == ModItems.SUPERMOND_BOOTS.get();
    }

}
