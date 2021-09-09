package com.npucraft.npuconstruction.mixin;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(net.minecraft.tileentity.TileEntity.class)
public abstract class MixinTileEntity {

//    /**
//     * @author SUPER2FH
//     * @reason change tileEntity render distance
//     */
//    @SideOnly(Side.CLIENT)
//    @Overwrite
//    public double getMaxRenderDistanceSquared()
//    {
//        return 4096.0D*64;
//    }

    /**
     * @author SUPER2FH
     * @reason cancel tileEntity render distance
     */
    @Overwrite
    public double getDistanceSq(double x, double y, double z)
    {
        return 0;
    }

}
