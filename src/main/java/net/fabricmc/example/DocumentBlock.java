package net.fabricmc.example;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DocumentBlock extends Block {

    public DocumentBlock(Settings settings) {
        super(settings);
    }
}
