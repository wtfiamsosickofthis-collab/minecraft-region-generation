package com.minecraft.region;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegionGenerationMod implements ModInitializer {
    public static final String MOD_ID = "region-generation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[Region Generation] Mod initialized!");
        RegionConfig.load();
        LOGGER.info("[Region Generation] Config loaded: " + RegionConfig.getRegions().size() + " regions configured");
    }
}