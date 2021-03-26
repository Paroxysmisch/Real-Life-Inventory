package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Wand extends Item {
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (RealLifeInventory.contentsPosition < RealLifeInventory.contents.size()) {
            playerEntity.giveItemStack(new ItemStack(Items.IRON_HOE).setCustomName(new TranslatableText(String.valueOf(RealLifeInventory.contents.get(RealLifeInventory.contentsPosition)))));
            RealLifeInventory.contentsPosition++;
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
