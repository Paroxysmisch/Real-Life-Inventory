package net.fabricmc.example;

import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DocumentBlock extends Block implements BlockEntityProvider {

    public DocumentBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        System.out.println("PLACED!");
        DocumentBlockEntity entity = (DocumentBlockEntity) world.getBlockEntity(pos);
        JsonElement partial = Text.Serializer.toJsonTree(itemStack.getName());
        entity.setFilename(partial.getAsJsonObject().get("translate").getAsString());

        ArmorStandEntity ae = new ArmorStandEntity(world, pos.getX() + 0.5, pos.getY() - 0.5, pos.getZ() + 0.5);
        ae.setCustomName(itemStack.getName());
        ae.setCustomNameVisible(true);
        ae.setNoGravity(true);
        ae.setInvisible(true);
        ae.setInvulnerable(true);

        entity.setArmorStandID(ae.getEntityId());

        world.spawnEntity(ae);

        world.markDirty(pos, entity);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        System.out.println("BROKEN!");
        DocumentBlockEntity entity = (DocumentBlockEntity) blockEntity;
        PlayerEntity pe = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 1000, false);
        ArmorStandEntity ae = (ArmorStandEntity) world.getEntityById(entity.getArmorStandID());
        //FIX - ae is null
        ItemStack itemStack = new ItemStack(new DocumentItem()).setCustomName(ae.getName());
        ae.kill();
        pe.giveItemStack(itemStack);
    }

    @Override
    public void onLandedUpon(World world, BlockPos pos, Entity _entity, float distance) {
        DocumentBlockEntity entity = (DocumentBlockEntity) world.getBlockEntity(pos);
        assert entity != null;
        System.out.println("start \"graham\" \"" + RealLifeInventory.dir + "\\" + entity.getFilename() + "\"");
        try {
            Runtime.getRuntime().exec("cmd.exe /c start \"graham\" \"" + RealLifeInventory.dir + "\\" + entity.getFilename() + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new DocumentBlockEntity();
    }
}
