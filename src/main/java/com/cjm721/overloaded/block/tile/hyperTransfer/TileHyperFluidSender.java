package com.cjm721.overloaded.block.tile.hyperTransfer;

import com.cjm721.overloaded.block.tile.hyperTransfer.base.AbstractTileHyperSender;
import com.cjm721.overloaded.storage.LongFluidStack;
import com.cjm721.overloaded.storage.fluid.IHyperHandlerFluid;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;

import static com.cjm721.overloaded.util.CapabilityHyperFluid.HYPER_FLUID_HANDLER;

public class TileHyperFluidSender extends AbstractTileHyperSender<LongFluidStack, IHyperHandlerFluid> {

    public TileHyperFluidSender() {
        super(HYPER_FLUID_HANDLER);
    }

    @Override
    @Nonnull
    protected LongFluidStack generate(long amount) {
        return new LongFluidStack(null, amount);
    }

    @Override
    protected boolean isCorrectPartnerType(TileEntity te) {
        return te instanceof TileHyperFluidReceiver;
    }
}
