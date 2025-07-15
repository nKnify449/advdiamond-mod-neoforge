package com.nknify.adv_diamond.mod.universal.custom.item;

import com.mojang.blaze3d.platform.InputConstants;
import com.nknify.adv_diamond.mod.component.ModDataComponents;
import com.nknify.adv_diamond.mod.universal.util.KeyBinding;
import com.nknify.adv_diamond.mod.universal.util.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class Endermond extends Item {
    public Endermond(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if(!level.isClientSide()) {
            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                    item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, context.getClickedPos(), ModSounds.ENDERMOND_LINK.get(), SoundSource.BLOCKS);

            context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && stack.get(ModDataComponents.COORDINATES) != null) {
            BlockPos savedPos = stack.get(ModDataComponents.COORDINATES);

            if (savedPos != null && level instanceof ServerLevel serverLevel) {
                player.teleportTo(savedPos.getX() + 0.5, savedPos.getY() + 1, savedPos.getZ() + 0.5);
                level.playSound(null, savedPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        long handle = Minecraft.getInstance().getWindow().getWindow();
        if (InputConstants.isKeyDown(handle, KeyBinding.ALPHA_KEY.getKey().getValue())) {
            tooltipComponents.add(Component.literal("Ability: It can save any blocks location"));
        } else {
            tooltipComponents.add(Component.literal("Press the §6Alpha Key§r to view STATS"));
        }
        if(stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Connected Block at " + stack.get(ModDataComponents.COORDINATES)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
