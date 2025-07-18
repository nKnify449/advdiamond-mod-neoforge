package com.nknify.adv_diamond.mod.datagen;

import com.nknify.adv_diamond.AdvancedDiamond;
import com.nknify.adv_diamond.mod.fluid.ModFluids;
import com.nknify.adv_diamond.mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdvancedDiamond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.IRONIFIED_DIAMOND.get());
        basicItem(ModItems.GOLDIFIED_DIAMOND.get());
        basicItem(ModItems.SUPERMOND.get());
        basicItem(ModItems.IRON_ESSENCE.get());
        basicItem(ModItems.GOLD_ESSENCE.get());
        basicItem(ModItems.NETHERITE_ESSENCE.get());
        basicItem(ModItems.ADVANCED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ModItems.ENDERMOND.get());
        basicItem(ModFluids.DIAMOND_LAVA_BUCKET.get());

        basicItem(ModItems.INACTIVE_IRONIFIED_DIAMOND.get());
        basicItem(ModItems.INACTIVE_GOLDIFIED_DIAMOND.get());
        basicItem(ModItems.INACTIVE_SUPERMOND.get());

        handheldItem(ModItems.IRONIFIED_DIAMOND_PICKAXE);
        handheldItem(ModItems.IRONIFIED_DIAMOND_AXE);
        handheldItem(ModItems.IRONIFIED_DIAMOND_SWORD);
        handheldItem(ModItems.IRONIFIED_DIAMOND_SHOVEL);
        handheldItem(ModItems.IRONIFIED_DIAMOND_HOE);

        trimmedArmorItem(ModItems.IRONIFIED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.IRONIFIED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.IRONIFIED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.IRONIFIED_DIAMOND_BOOTS);

        trimmedArmorItem(ModItems.GOLDIFIED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.GOLDIFIED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLDIFIED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.GOLDIFIED_DIAMOND_BOOTS);

        trimmedArmorItem(ModItems.SUPERMOND_HELMET);
        trimmedArmorItem(ModItems.SUPERMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.SUPERMOND_LEGGINGS);
        trimmedArmorItem(ModItems.SUPERMOND_BOOTS);

        handheldItem(ModItems.GOLDIFIED_DIAMOND_PICKAXE);
        handheldItem(ModItems.GOLDIFIED_DIAMOND_AXE);
        handheldItem(ModItems.GOLDIFIED_DIAMOND_SWORD);
        handheldItem(ModItems.GOLDIFIED_DIAMOND_SHOVEL);
        handheldItem(ModItems.GOLDIFIED_DIAMOND_HOE);

        handheldItem(ModItems.SUPERMOND_PICKAXE);
        handheldItem(ModItems.SUPERMOND_AXE);
        handheldItem(ModItems.SUPERMOND_SWORD);
        handheldItem(ModItems.SUPERMOND_SHOVEL);
        handheldItem(ModItems.SUPERMOND_HOE);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AdvancedDiamond.MOD_ID,"item/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = AdvancedDiamond.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
}