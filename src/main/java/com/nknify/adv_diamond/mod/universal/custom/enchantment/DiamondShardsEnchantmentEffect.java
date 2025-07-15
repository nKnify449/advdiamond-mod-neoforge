package com.nknify.adv_diamond.mod.universal.custom.enchantment;

import com.mojang.serialization.MapCodec;
import com.nknify.adv_diamond.mod.universal.util.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record DiamondShardsEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<DiamondShardsEnchantmentEffect> CODEC = MapCodec.unit(DiamondShardsEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(enchantmentLevel == 1 && entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
            if (!living.isAlive()) {
                serverLevel.playSound(
                        null,
                        living.blockPosition(),
                        ModSounds.DIAMOND_SHARDS_FININSHER.get(),
                        SoundSource.PLAYERS,
                        1.0F, 1.0F
                );
            }
        }

        if(enchantmentLevel == 2 && entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
            if (!living.isAlive()) {
                serverLevel.playSound(
                        null,
                        living.blockPosition(),
                        ModSounds.DIAMOND_SHARDS_FININSHER.get(),
                        SoundSource.PLAYERS,
                        1.0F, 1.0F
                );
            }
        }

        if(enchantmentLevel == 3 && entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3));
            if (!living.isAlive()) {
                serverLevel.playSound(
                        null,
                        living.blockPosition(),
                        ModSounds.DIAMOND_SHARDS_FININSHER.get(),
                        SoundSource.PLAYERS,
                        1.0F, 1.0F
                );
            }
        }

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
