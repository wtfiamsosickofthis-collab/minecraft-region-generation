# Region Generation Mod

A Fabric mod for Minecraft 1.21.1+ that generates custom world regions with unique terrain, biomes, and features.

## Features

### Region 0 (Blocks 0-7999)
- Standard Minecraft generation
- Normal mob spawning, villages, all features

### Region 1 (Blocks 8000-10999)
- Advanced generation
- No villages
- Bedrock layers at top and bottom with lava coverage

### Region 2 (Blocks 11000-13999)
- Desert and Mesa landscape
- Lava lakes (no water)
- No natural mob spawning

### Region 3 (Blocks 14000-15999)
- Ocean biome
- Beach transitions (first/last 100 blocks)
- No structures generate

### Region 4 (Blocks 16000-17999)
- Sparse forests
- Fewer trees, rare caves, reduced ores
- Smooth terrain generation

### Region X (Blocks 18000-20000)
- Vertical stone wall (18000-19000)
- Complete void (19000-20000)

## Installation

1. Download Fabric Loader for Minecraft 1.21.1
2. Download Fabric API for 1.21.1
3. Place this mod in your `mods` folder
4. Launch Minecraft with Fabric

## Building

```bash
./gradlew build
```

The compiled mod will be in `build/libs/`

## Configuration

Region boundaries and types can be modified in `RegionConfig.java`

## License

MIT