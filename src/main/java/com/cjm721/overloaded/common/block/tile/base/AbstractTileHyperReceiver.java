package com.cjm721.overloaded.common.block.tile.base;

import com.cjm721.overloaded.common.storage.IHyperHandler;
import com.cjm721.overloaded.common.storage.IHyperType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by CJ on 4/10/2017.
 */
public abstract class AbstractTileHyperReceiver<Type extends IHyperType, C extends Capability<? extends IHyperHandler<Type>>> extends TileEntity {

    private final C capability;

    public AbstractTileHyperReceiver(C capability) {
        this.capability = capability;
    }
    
    public Type receive(Type stack) {
        for(EnumFacing side: EnumFacing.values()) {
            TileEntity te = this.getWorld().getTileEntity(this.getPos().add(side.getDirectionVec()));

            if(te == null || !te.hasCapability(capability, side.getOpposite()))
                continue;

            IHyperHandler<Type> temp = te.getCapability(capability, side.getOpposite());
            stack = temp.give(stack, true);

            if(stack.getAmount() == 0L)
                return stack;
        }
        return stack;
    }
}
