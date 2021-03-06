package com.cjm721.overloaded.storage.energy;

import com.cjm721.overloaded.storage.LongEnergyStack;
import com.cjm721.overloaded.util.IDataUpdate;
import com.cjm721.overloaded.util.NumberUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;

public class LongEnergyStorage implements IEnergyStorage, IHyperHandlerEnergy, INBTSerializable<NBTTagCompound> {

    @Nonnull
    private final IDataUpdate dataUpdate;
    @Nonnull
    private LongEnergyStack energy;

    public LongEnergyStorage(@Nonnull IDataUpdate dataUpdate) {
        energy = new LongEnergyStack(0);
        this.dataUpdate = dataUpdate;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setLong("Count", energy.amount);
        return compound;
    }

    @Override
    public void deserializeNBT(@Nonnull NBTTagCompound compound) {
        energy = new LongEnergyStack(compound.hasKey("Count") ? compound.getLong("Count") : 0L);
    }

    /**
     * Adds energy to the storage. Returns quantity of energy that was accepted.
     *
     * @param maxReceive Maximum amount of energy to be inserted.
     * @param simulate   If TRUE, the insertion will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) accepted by the storage.
     */
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        LongEnergyStack result = give(new LongEnergyStack(maxReceive), !simulate);

        return (int) (maxReceive - result.amount);
    }

    /**
     * Removes energy from the storage. Returns quantity of energy that was removed.
     *
     * @param maxExtract Maximum amount of energy to be extracted.
     * @param simulate   If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted from the storage.
     */
    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        LongEnergyStack result = take(new LongEnergyStack(maxExtract), !simulate);

        return (int) result.amount;
    }

    /**
     * Returns the amount of energy currently stored.
     */
    @Override
    public int getEnergyStored() {
        return (int) (((double) energy.amount / (double) Long.MAX_VALUE) * Integer.MAX_VALUE);
    }

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    @Override
    public int getMaxEnergyStored() {
        return Integer.MAX_VALUE;
    }

    /**
     * Returns if this storage can have energy extracted.
     * If this is false, then any calls to extractEnergy will return 0.
     */
    @Override
    public boolean canExtract() {
        return true;
    }

    /**
     * Used to determine if this storage can receive energy.
     * If this is false, then any calls to receiveEnergy will return 0.
     */
    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    @Nonnull
    public LongEnergyStack status() {
        return energy;
    }

    @Override
    @Nonnull
    public LongEnergyStack give(@Nonnull LongEnergyStack stack, boolean doAction) {
        NumberUtil.AddReturn<Long> longAddReturn = NumberUtil.addToMax(energy.amount, stack.amount);

        if (doAction) {
            energy.amount = longAddReturn.result;
            dataUpdate.dataUpdated();
        }

        return new LongEnergyStack(longAddReturn.overflow);
    }

    @Override
    @Nonnull
    public LongEnergyStack take(@Nonnull LongEnergyStack stack, boolean doAction) {
        long newStoredAmount = Math.max(energy.amount - stack.amount, 0);
        LongEnergyStack result = new LongEnergyStack(Math.min(energy.amount, stack.amount));

        if (doAction) {
            energy.amount = newStoredAmount;
            dataUpdate.dataUpdated();
        }

        return result;
    }
}
