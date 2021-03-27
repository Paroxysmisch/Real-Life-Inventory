package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static net.fabricmc.example.RealLifeInventory.DOCUMENT_ITEM;

public class Wand extends Item {
    public Wand() {
        super(new FabricItemSettings().group(ItemGroup.MISC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        //very weird thread stuff!
        if (Thread.currentThread().getName().equals("Render thread")) {
            if (RealLifeInventory.contentsPositionRender < RealLifeInventory.contents.size()) {
                ItemStack itemStack = new ItemStack(DOCUMENT_ITEM).setCustomName(new TranslatableText(RealLifeInventory.contents.get(RealLifeInventory.contentsPositionRender).getName()));
                playerEntity.giveItemStack(itemStack);
                System.out.println(RealLifeInventory.contents.get(RealLifeInventory.contentsPositionRender).getName());
                RealLifeInventory.contentsPositionRender++;
            }
        }
        else {
            if (RealLifeInventory.contentsPositionServer < RealLifeInventory.contents.size()) {
                ItemStack itemStack = new ItemStack(DOCUMENT_ITEM).setCustomName(new TranslatableText(RealLifeInventory.contents.get(RealLifeInventory.contentsPositionServer).getName()));
                playerEntity.giveItemStack(itemStack);
                System.out.println(RealLifeInventory.contents.get(RealLifeInventory.contentsPositionServer).getName());
                RealLifeInventory.contentsPositionServer++;
            }
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
