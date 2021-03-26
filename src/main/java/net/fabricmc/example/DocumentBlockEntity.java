package net.fabricmc.example;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

public class DocumentBlockEntity extends BlockEntity {

    private String filename = null;
    private int armorStandID = -1;

    public DocumentBlockEntity() {
        super(RealLifeInventory.DOCUMENT_BLOCK_ENTITY);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getArmorStandID() {
        return armorStandID;
    }

    public void setArmorStandID(int armorStandID) {
        this.armorStandID = armorStandID;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        // Save the current value of the number to the tag
        tag.putString("filename", filename);
        tag.putInt("armorStandID", armorStandID);

        System.out.println(filename);
        System.out.println(armorStandID);
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        filename = tag.getString("filename");
        armorStandID = tag.getInt("armorStandID");

        System.out.println(filename);
        System.out.println(armorStandID);
    }
}
