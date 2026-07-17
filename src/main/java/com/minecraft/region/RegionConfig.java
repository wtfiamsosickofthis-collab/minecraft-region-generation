package com.minecraft.region;

import java.util.HashMap;
import java.util.Map;

public class RegionConfig {
    private static final Map<Integer, Region> regions = new HashMap<>();

    public static void load() {
        // Region 0: Standard generation (0-7999)
        regions.put(0, new Region(0, 7999, RegionType.STANDARD));

        // Region 1: Advanced generation, no villages (8000-10999)
        regions.put(1, new Region(8000, 10999, RegionType.ADVANCED));

        // Region 2: Desert/Mesa with lava lakes, no mobs (11000-13999)
        regions.put(2, new Region(11000, 13999, RegionType.DESERT));

        // Region 3: Ocean with beaches, no structures (14000-15999)
        regions.put(3, new Region(14000, 15999, RegionType.OCEAN));

        // Region 4: Sparse forests, smooth terrain (16000-17999)
        regions.put(4, new Region(16000, 17999, RegionType.SPARSE));

        // Region X: Wall and void (18000-20000)
        regions.put(5, new Region(18000, 20000, RegionType.WALL));
    }

    public static Region getRegionAt(int x) {
        for (Region region : regions.values()) {
            if (x >= region.getStart() && x < region.getEnd()) {
                return region;
            }
        }
        return null;
    }

    public static Map<Integer, Region> getRegions() {
        return regions;
    }

    public static class Region {
        private final int start;
        private final int end;
        private final RegionType type;

        public Region(int start, int end, RegionType type) {
            this.start = start;
            this.end = end;
            this.type = type;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public RegionType getType() {
            return type;
        }
    }

    public enum RegionType {
        STANDARD,      // Normal generation
        ADVANCED,      // Advanced with bedrock layers and lava
        DESERT,        // Desert/Mesa with lava lakes
        OCEAN,         // Ocean biome
        SPARSE,        // Sparse forests, smooth terrain
        WALL           // Vertical wall and void
    }
}