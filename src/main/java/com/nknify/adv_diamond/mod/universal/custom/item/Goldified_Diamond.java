package com.nknify.adv_diamond.mod.universal.custom.item;

import com.mojang.blaze3d.platform.InputConstants;
import com.nknify.adv_diamond.mod.universal.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class Goldified_Diamond extends Item {
    public Goldified_Diamond(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        long handle = Minecraft.getInstance().getWindow().getWindow();
        if (InputConstants.isKeyDown(handle, KeyBinding.ALPHA_KEY.getKey().getValue())) {
            tooltipComponents.add(Component.literal("Tools: Camouflage 0 | Armor: Camouflage 0.5"));
        } else {
            tooltipComponents.add(Component.literal("Press the §6Alpha Key§r to view STATS"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
