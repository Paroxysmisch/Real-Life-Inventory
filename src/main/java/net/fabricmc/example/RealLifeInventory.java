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
	public static final Wand FABRIC_ITEM = new Wand(new FabricItemSettings().group(ItemGroup.MISC));
	public static final DocumentBlock EXAMPLE_BLOCK = new DocumentBlock();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("graham", "wand"), FABRIC_ITEM);

		Registry.register(Registry.BLOCK, new Identifier("graham", "document_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("graham", "document_item"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		System.out.println("Hello Fabric world!");
	}
}
