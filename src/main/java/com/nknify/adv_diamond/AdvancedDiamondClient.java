package com.nknify.adv_diamond;

import com.nknify.adv_diamond.mod.fluid.ModFluidTypes;
import com.nknify.adv_diamond.mod.fluid.ModFluids;
import com.nknify.adv_diamond.mod.screen.ModMenuTypes;
import com.nknify.adv_diamond.mod.universal.custom.fluid.BaseFluidType;
import com.nknify.adv_diamond.mod.universal.custom.screen.EssenceGrinderScreen;
import com.nknify.adv_diamond.mod.universal.util.KeyBinding;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = AdvancedDiamond.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = AdvancedDiamond.MOD_ID, value = Dist.CLIENT)
public class AdvancedDiamondClient {
    public AdvancedDiamondClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Font font = mc.font;
        GuiGraphics graphics = event.getGuiGraphics();

        String mcVersion = SharedConstants.getCurrentVersion().getName();
        String modVersion = "1.0.0-1.21.1";

        Config.VerLabelMode mode = Config.MINECRAFT_VERSION_LABEL.get();

        if(mode == Config.VerLabelMode.MC_AND_MOD){
            String text = "Minecraft " + mcVersion + " - Advanced Diamonds " + modVersion;
            graphics.drawString(font, text, 2, 2, 0xFFFFFF, false);
        }
        if(mode == Config.VerLabelMode.MC){
            String text = "Minecraft " + mcVersion;
            graphics.drawString(font, text, 2, 2, 0xFFFFFF, false);
        }
        if(mode == Config.VerLabelMode.MOD) {
            String text = "Advanced Diamonds " + modVersion;
            graphics.drawString(font, text, 2, 2, 0xFFFFFF, false);
        }
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.GROWTH_CHAMBER_MENU.get(), EssenceGrinderScreen::new);
    }

    @SubscribeEvent
    public static void OnKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.ALPHA_KEY);
    }

    @SubscribeEvent
    public static void OnKeyInput(InputEvent.Key event){
        if(KeyBinding.ALPHA_KEY.consumeClick()){
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Alpha Key Pressed!!"));
        }
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_DIAMOND_LAVA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_DIAMOND_LAVA.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void onClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(((BaseFluidType) ModFluidTypes.DIAMOND_LAVA_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                ModFluidTypes.DIAMOND_LAVA_FLUID_TYPE.get());
    }
}