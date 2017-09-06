package com.cjm721.overloaded.block.basic.hyperTransfer;

import com.cjm721.overloaded.OverloadedCreativeTabs;
import com.cjm721.overloaded.block.basic.hyperTransfer.base.AbstractBlockHyperSender;
import com.cjm721.overloaded.block.tile.hyperTransfer.TileHyperEnergySender;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

import static com.cjm721.overloaded.Overloaded.MODID;

public class BlockHyperEnergySender extends AbstractBlockHyperSender implements ITileEntityProvider {

    public BlockHyperEnergySender() {
        super(Material.ROCK);

        setRegistryName("hyper_energy_sender");
        setUnlocalizedName("hyper_energy_sender");

        GameRegistry.registerTileEntity(TileHyperEnergySender.class, MODID + ":hyper_energy_sender");
    }

    @Override
    @Nonnull
    public String getType() {
        return "Energy";
    }

    @Override
    @Nonnull
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new TileHyperEnergySender();
    }
}
