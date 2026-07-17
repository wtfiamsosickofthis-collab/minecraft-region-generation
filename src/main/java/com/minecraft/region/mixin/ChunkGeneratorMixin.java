package com.minecraft.region.mixin;

import com.minecraft.region.RegionConfig;
import com.minecraft.region.world.RegionTerrainGenerator;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.HeightAccessor;
import net.minecraft.world.gen.noise.NoiseConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {

    @Inject(
        method = "carve",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onChunkGenerate(long seed, NoiseConfig noiseConfig, Chunk chunk, CallbackInfo ci) {
        int chunkX = chunk.getPos().getStartX();
        RegionConfig.Region region = RegionConfig.getRegionAt(chunkX);

        if (region != null) {
            // Check if we need custom generation
            if (region.getType() != RegionConfig.RegionType.STANDARD) {
                RegionTerrainGenerator.generateRegionTerrain(chunk, region, noiseConfig);
            }
        }
    }
}