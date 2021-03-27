package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.mutable.MutableInt;
import org.lwjgl.system.CallbackI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class RealLifeInventory implements ModInitializer {
	// an instance of our new item
	public static final Wand WAND = new Wand();
	public static final DocumentBlock DOCUMENT_BLOCK = new DocumentBlock();
	public static final DocumentItem DOCUMENT_ITEM = new DocumentItem();
	public static final String dir = "C:\\Users\\Marc\\Documents\\hackathon\\Real-Life-Inventory\\Test Folder";
	public static BlockEntityType<DocumentBlockEntity> DOCUMENT_BLOCK_ENTITY;

	// item state
	public static ArrayList<File> contents = null;
	public static int contentsPositionRender = 0;
	public static int contentsPositionServer = 0;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("graham", "wand"), WAND);
		Registry.register(Registry.BLOCK, new Identifier("graham", "document_block"), DOCUMENT_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("graham", "document_block"), DOCUMENT_ITEM);
		DOCUMENT_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "modid:document", BlockEntityType.Builder.create(DocumentBlockEntity::new, DOCUMENT_BLOCK).build(null));

		// Load directory
		File directory = new File(dir);
		contents = new ArrayList<>(Arrays.asList(directory.listFiles()));
		System.out.println(contents);

		System.out.println("Hello Fabric world!");
	}
}
