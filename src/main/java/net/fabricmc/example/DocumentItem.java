package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class DocumentItem extends BlockItem {

    public DocumentItem() {
        super(RealLifeInventory.DOCUMENT_BLOCK, new FabricItemSettings().group(ItemGroup.MISC));
    }
}
