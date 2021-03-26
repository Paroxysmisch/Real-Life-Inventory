package net.fabricmc.example;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DocumentBlock extends Block {

    ArmorStandEntity ae = null;

    public DocumentBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        System.out.println("PLACED!");
        ae = new ArmorStandEntity(world, pos.getX() + 0.5, pos.getY() - 0.5, pos.getZ() + 0.5);
        ae.setCustomName(itemStack.getName());
        ae.setCustomNameVisible(true);
        ae.setNoGravity(true);
        ae.setInvisible(true);
        ae.noClip = true;
        world.spawnEntity(ae);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        System.out.println("BROKEN!");
        ae.kill();
        PlayerEntity pe = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 1000, false);
        ItemStack itemStack = new ItemStack(new DocumentItem()).setCustomName(ae.getName());
        assert pe != null;
        pe.giveItemStack(itemStack);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        try {
            Desktop.getDesktop().open(new File(RealLifeInventory.dir + "\\" + ae.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
