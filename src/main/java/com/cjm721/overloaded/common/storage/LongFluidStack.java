package com.cjm721.overloaded.common.storage;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by CJ on 4/9/2017.
 */
public class LongFluidStack {

    public static final LongFluidStack EMPTY_STACK = new LongFluidStack(null, 0L);

    public long amount;
    public FluidStack fluidStack;

    public LongFluidStack(FluidStack fluidStack, long amount) {
        this.fluidStack = fluidStack;
        this.amount = amount;
    }

}
