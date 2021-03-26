package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RealLifeInventory implements ModInitializer {
	// an instance of our new item
	public static final Wand WAND = new Wand(new FabricItemSettings().group(ItemGroup.MISC));
	public static final DocumentBlock DOCUMENT_BLOCK = new DocumentBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("graham", "Wand"), WAND);
		Registry.register(Registry.BLOCK, new Identifier("graham", "Document Block"), DOCUMENT_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("graham", "Document Block"), new BlockItem(DOCUMENT_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		System.out.println("Hello Fabric world!");
	}
}
