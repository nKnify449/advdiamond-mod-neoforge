package com.nknify.adv_diamond.mod.universal.events;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.block.ModBlocks;
import com.nknify.adv_diamond.mod.universal.util.ArmorCheckUtility;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = AdvancedDiamond.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addVillagerTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.MASON){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 45),
                    new ItemStack(ModBlocks.ESSENCE_GRINDER.get(), 1), 1, 3, 0.05f));
        }
    }

    @SubscribeEvent
    public static void onIronGolemTargetChange(LivingChangeTargetEvent event) {
        if (event.getEntity().level().isClientSide()) return;
        if (!(event.getEntity() instanceof IronGolem ironGolem)) return;
        if (!(event.getNewAboutToBeSetTarget() instanceof Player player)) return;

        if (ArmorCheckUtility.isWearingFullIronifiedDiamondArmor(player)) {
            event.setNewAboutToBeSetTarget(null); // cancel targeting
            ironGolem.setRemainingPersistentAngerTime(0); // clear anger
            ironGolem.setTarget(null);
        }
    }

    @SubscribeEvent
    public static void onPhantomTargetChange(LivingChangeTargetEvent event) {
        if (event.getEntity().level().isClientSide()) return;
        if (!(event.getEntity() instanceof Phantom phantom)) return;
        if (!(event.getNewAboutToBeSetTarget() instanceof Player player)) return;

        if (ArmorCheckUtility.isWearingFullIronifiedDiamondArmor(player)) {
            event.setNewAboutToBeSetTarget(null); // cancel targeting
            phantom.setTarget(null);
        }
    }

    @SubscribeEvent
    public static void onEndermanTargetChange(LivingChangeTargetEvent event) {
        if (event.getEntity().level().isClientSide()) return;
        if (!(event.getEntity() instanceof EnderMan enderMan)) return;
        if (!(event.getNewAboutToBeSetTarget() instanceof Player player)) return;

        if (ArmorCheckUtility.isWearingFullGoldifiedDiamondArmor(player)) {
            event.setNewAboutToBeSetTarget(null);// cancel targeting
            enderMan.setRemainingPersistentAngerTime(0);
            enderMan.setTarget(null);
        }
    }
}
