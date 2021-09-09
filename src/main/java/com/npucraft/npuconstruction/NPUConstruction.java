package com.npucraft.npuconstruction;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NPUConstruction.MOD_ID)
public class NPUConstruction {
    public static final String MOD_ID = "npuconstruction";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("This is a patch for BuildTheWorldForNPU Mod");
    }
}
