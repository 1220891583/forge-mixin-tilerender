package com.npucraft.npuconstruction.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import org.spongepowered.asm.mixin

@Mixin(net.minecraft.block.Block.class)
public abstract class MixinBlock {

    @Shadow
    private IBlockState defaultBlockState;

    @Final
    @Shadow
    protected Material material;

    @Shadow
    protected int lightValue;

    @Shadow
    protected int lightOpacity;

    @Shadow @Final public static RegistryNamespacedDefaultedByKey<ResourceLocation, Block> REGISTRY;

    @Shadow public abstract String getLocalizedName();

    /**
     * @author SUPER2FH
     * @reason change ROCK light
     */
//    @Overwrite
//    public Block(Material blockMaterialIn, MapColor blockMapColorIn){
//
//    }
//    @Inject(at = @At("RETURN"), method = "setLightLevel")
//    public void setLightLevel(float value, CallbackInfoReturnable<Block> cir)
//    {
//        if (material.equals(Material.ROCK)){
//            this.lightValue = 1;
//        }
//    }

    @Shadow public abstract Block setBlockUnbreakable();


    @Inject(at = @At("HEAD"), method = "setDefaultState")
    protected final void setDefaultState(IBlockState state, CallbackInfo ci)
    {
        if ("fctable4".equals(REGISTRY.getNameForObject(setBlockUnbreakable()).getPath())) {
            this.lightValue = 1;
        }
    }



//    @Overwrite
//    @Deprecated
//    @SideOnly(Side.CLIENT)
//    public float getAmbientOcclusionLightValue(IBlockState state)
//    {
//        if (material.equals(Material.ROCK) && this.lightValue == 0){
//            return 1.0F;
//        }
//        return state.isBlockNormalCube() ? 0.2F : 1.0F;
//    }
//}
}
