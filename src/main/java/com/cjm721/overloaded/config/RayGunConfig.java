package com.cjm721.overloaded.config;

import com.cjm721.overloaded.config.syncer.SyncToClient;
import net.minecraftforge.common.config.Config;

public class RayGunConfig {
    @Config.Comment("Energy used per shot. [Default: 100000]")
    public int energyPerShot = 100000;
    @SyncToClient
    @Config.Comment("Max range to shoot. [Default: 128]")
    public int maxRange = 128;
}
