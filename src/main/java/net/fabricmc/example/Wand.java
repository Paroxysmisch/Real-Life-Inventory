package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Wand extends Item {
    public Wand() {
        super(new FabricItemSettings().group(ItemGroup.MISC));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (RealLifeInventory.contentsPosition < RealLifeInventory.contents.size()) {
            playerEntity.giveItemStack(new ItemStack(new DocumentItem()).setCustomName(new TranslatableText(RealLifeInventory.contents.get(RealLifeInventory.contentsPosition).getName())));
            System.out.println(RealLifeInventory.contents.get(RealLifeInventory.contentsPosition).getName());
            RealLifeInventory.contentsPosition++;
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
