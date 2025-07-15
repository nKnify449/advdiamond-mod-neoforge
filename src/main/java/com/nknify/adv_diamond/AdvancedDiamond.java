package com.nknify.adv_diamond;

import com.nknify.adv_diamond.mod.block.ModBlocks;
import com.nknify.adv_diamond.mod.component.ModDataComponents;
import com.nknify.adv_diamond.mod.enchantment.ModEnchantmentEffects;
import com.nknify.adv_diamond.mod.item.ModItems;
import com.nknify.adv_diamond.mod.screen.ModMenuTypes;
import com.nknify.adv_diamond.mod.universal.ModCreativeModeTabs;
import com.nknify.adv_diamond.mod.universal.custom.block.entity.ModBlockEntities;
import com.nknify.adv_diamond.mod.universal.custom.loot.ModLootModifiers;
import com.nknify.adv_diamond.mod.universal.custom.recipe.ModRecipes;
import com.nknify.adv_diamond.mod.universal.util.ArmorCheckUtility;
import com.nknify.adv_diamond.mod.universal.util.sound.ModSounds;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;

@Mod(AdvancedDiamond.MOD_ID)
public class AdvancedDiamond {
    public static final String MOD_ID = "adv_diamond";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AdvancedDiamond(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModDataComponents.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);

        ModSounds.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }


}
