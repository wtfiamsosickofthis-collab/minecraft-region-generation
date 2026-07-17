package com.minecraft.region.world;

import com.minecraft.region.RegionConfig;
import net.minecraft.world.biome.BiomeCoordinateSet;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.HeightProvider;
import net.minecraft.world.gen.noise.NoiseConfig;

public class RegionTerrainGenerator {
    private static final int WORLD_HEIGHT = 384; // Y-level range
    private static final int MIN_Y = -64;
    private static final int MAX_Y = 320;

    public static void generateRegionTerrain(Chunk chunk, RegionConfig.Region region, NoiseConfig noiseConfig) {
        RegionConfig.RegionType type = region.getType();

        switch (type) {
            case STANDARD:
                generateStandard(chunk, noiseConfig);
                break;
            case ADVANCED:
                generateAdvanced(chunk, noiseConfig);
                break;
            case DESERT:
                generateDesert(chunk, noiseConfig);
                break;
            case OCEAN:
                generateOcean(chunk, noiseConfig);
                break;
            case SPARSE:
                generateSparse(chunk, noiseConfig);
                break;
            case WALL:
                generateWall(chunk, region);
                break;
        }
    }

    private static void generateStandard(Chunk chunk, NoiseConfig noiseConfig) {
        // Standard Minecraft generation - use default
    }

    private static void generateAdvanced(Chunk chunk, NoiseConfig noiseConfig) {
        // Advanced generation with bedrock layers and lava at top/bottom
        int chunkX = chunk.getPos().getStartX();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // Add bedrock at bottom layer
                for (int y = MIN_Y; y < MIN_Y + 3; y++) {
                    chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.BEDROCK.getDefaultState(), false);
                }

                // Add lava at top layer
                for (int y = MAX_Y - 3; y <= MAX_Y; y++) {
                    chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.LAVA.getDefaultState(), false);
                }
            }
        }
    }

    private static void generateDesert(Chunk chunk, NoiseConfig noiseConfig) {
        // Desert/Mesa with sand and lava lakes
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = MIN_Y; y < 62; y++) {
                    chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.SAND.getDefaultState(), false);
                }
            }
        }
    }

    private static void generateOcean(Chunk chunk, RegionConfig.Region region) {
        int chunkStartX = chunk.getPos().getStartX();
        int regionStart = region.getStart();
        int regionEnd = region.getEnd();
        int regionLength = regionEnd - regionStart;
        int localRegionX = chunkStartX - regionStart;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int globalX = chunkStartX + x;
                int regionRelativeX = globalX - regionStart;

                // First 100 blocks: beach transition
                if (regionRelativeX < 100) {
                    for (int y = MIN_Y; y < 64; y++) {
                        chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.SAND.getDefaultState(), false);
                    }
                }
                // Last 100 blocks: beach transition
                else if (regionRelativeX >= regionLength - 100) {
                    for (int y = MIN_Y; y < 64; y++) {
                        chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.SAND.getDefaultState(), false);
                    }
                }
                // Middle: deep ocean
                else {
                    for (int y = MIN_Y; y < 50; y++) {
                        chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.WATER.getDefaultState(), false);
                    }
                }
            }
        }
    }

    private static void generateSparse(Chunk chunk, NoiseConfig noiseConfig) {
        // Sparse forests with smooth terrain, fewer ores
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = MIN_Y; y < 64; y++) {
                    chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.STONE.getDefaultState(), false);
                }
            }
        }
    }

    private static void generateWall(Chunk chunk, RegionConfig.Region region) {
        int chunkX = chunk.getPos().getStartX();
        int regionStart = region.getStart();
        int wallStart = 18000;
        int wallEnd = 19000;

        // Wall: 18000-19000
        if (chunkX >= wallStart && chunkX < wallEnd) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = MIN_Y; y <= MAX_Y; y++) {
                        chunk.setBlockState(x, y, z, net.minecraft.block.Blocks.STONE.getDefaultState(), false);
                    }
                }
            }
        }
        // Void: 19000-20000
        else if (chunkX >= wallEnd) {
            // Leave empty (void)
        }
    }
}