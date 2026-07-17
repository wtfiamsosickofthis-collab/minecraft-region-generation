| Step | Action | Details |
|------|--------|---------|
| 1 | Install Java 21 | Required for Minecraft 1.21.1 |
| 2 | Download Fabric Installer | Get the installer executable |
| 3 | Run Fabric Installer | Install Fabric Loader |
| 4 | Download Fabric API | Get the mod file |
| 5 | Download Region Generation Mod | Get the compiled JAR |
| 6 | Place mods in folder | Copy files to `.minecraft/mods/` |
| 7 | Launch Minecraft | Start with Fabric profile |
| 8 | Create/Load World | Generate new world with custom regions |

---

# Complete Installation Guide - Region Generation Mod for Minecraft 1.21.1

## ✅ Requirements

- **Windows, Mac, or Linux**
- **Java 21 or higher** (required for Minecraft 1.21.1)
- **Minecraft Launcher** (Java Edition)
- **~500 MB free disk space**

---

## Step 1: Install/Verify Java 21

### Windows:
1. Go to https://www.oracle.com/java/technologies/downloads/#java21
2. Download **Java 21 JDK (Windows x64)**
3. Run the installer and follow the prompts
4. Click **Next → Install → Close**

**Verify installation:**
- Open Command Prompt (Win+R, type `cmd`)
- Type: `java -version`
- Should show: `java version \"21.x.x\"`

### macOS:
1. Go to https://www.oracle.com/java/technologies/downloads/#java21
2. Download **Java 21 JDK (macOS x64)** or **macOS ARM64** (for M1/M2/M3)
3. Run the `.dmg` installer
4. Follow the prompts

**Verify installation:**
- Open Terminal
- Type: `java -version`
- Should show: `java version \"21.x.x\"`

### Linux:
```bash
sudo apt update
sudo apt install openjdk-21-jdk
java -version
```

---

## Step 2: Download & Install Fabric Loader

### Option A: Using Fabric Installer (Easiest)

1. **Go to:** https://fabricmc.net/use/installer/
2. **Download:** Click the download button for your OS (Windows/macOS/Linux)
3. **Run the installer:**
   - **Windows:** Double-click `fabric-installer-x.x.exe`
   - **macOS:** Double-click `fabric-installer-x.x.jar`
   - **Linux:** Run `java -jar fabric-installer-x.x.jar`

4. **In the Installer Window:**
   - Game Directory: (leave default)
   - Loader Version: Select latest (should auto-select)
   - **Installer Profile:** `fabric-loader-1.21.1` (must be 1.21.1)
   - Click **Install**

5. **After installation:** Close the installer

### Option B: Manual Installation

Skip if you used Option A.

---

## Step 3: Download Fabric API Mod

1. Go to: https://modrinth.com/mod/fabric-api
2. Click **Download** on the right side
3. Select version **1.21.1** (latest)
4. Save the file (name will be like `fabric-api-0.100.0+1.21.1.jar`)
5. **Keep this file** - you'll need it next

---

## Step 4: Download Region Generation Mod

### Option A: From GitHub (Recommended)

1. Go to: https://github.com/wtfiamsosickofthis-collab/minecraft-region-generation
2. Click the green **Code** button → **Releases** (or scroll down)
3. Look for version **1.0.0**
4. Download `region-generation-1.0.0.jar`

### Option B: Build from Source

```bash
git clone https://github.com/wtfiamsosickofthis-collab/minecraft-region-generation.git
cd minecraft-region-generation
./gradlew build
```

The JAR will be in `build/libs/region-generation-1.0.0.jar`

---

## Step 5: Locate Your Minecraft Mods Folder

### Windows:
1. Press **Win + R**
2. Type: `%appdata%`
3. Open `.minecraft` folder
4. Open `mods` folder (create it if it doesn't exist)

**Path:** `C:\Users\YourUsername\AppData\Roaming\.minecraft\mods\`

### macOS:
1. Open **Finder**
2. Press **Cmd + Shift + G** (Go to Folder)
3. Type: `~/Library/Application Support/minecraft`
4. Open `mods` folder (create it if it doesn't exist)

**Path:** `~/Library/Application Support/minecraft/mods/`

### Linux:
Open Terminal and navigate to:
```bash
~/.minecraft/mods/
```

Create the `mods` folder if it doesn't exist:
```bash
mkdir -p ~/.minecraft/mods/
```

---

## Step 6: Install the Mods

You should have 2 files ready:
1. `fabric-api-0.100.0+1.21.1.jar`
2. `region-generation-1.0.0.jar`

**Copy both files into the `mods` folder:**

### Windows:
- Open File Explorer
- Navigate to `.minecraft\mods\`
- Drag and drop both JAR files into this folder

### macOS/Linux:
```bash
# Navigate to mods folder
cd ~/.minecraft/mods/

# Copy files (replace paths with your download location)
cp ~/Downloads/fabric-api-0.100.0+1.21.1.jar .
cp ~/Downloads/region-generation-1.0.0.jar .

# Verify files are there
ls -la
```

---

## Step 7: Launch Minecraft with Fabric

1. **Open Minecraft Launcher**
2. **Click the dropdown** next to "Play" (top-left)
3. **Select `fabric-loader-1.21.1`** profile
4. **Click Play**
5. **Wait for Minecraft to load** (~30-60 seconds first time)

**You should see in the bottom-left:**
```
[Fabric Loader 0.15.11]
[Region Generation]
```

---

## Step 8: Create or Load a World

### Creating a New World:
1. Click **Singleplayer**
2. Click **Create New World**
3. Choose **World Type: Default**
4. Set any custom settings
5. Click **Create New World**

### Expected Features:
- **Blocks 0-7999:** Normal Minecraft terrain
- **Blocks 8000-10999:** Bedrock layers with lava
- **Blocks 11000-13999:** Desert/Mesa landscape
- **Blocks 14000-15999:** Ocean biome
- **Blocks 16000-17999:** Sparse forests
- **Blocks 18000-19000:** Stone wall
- **Blocks 19000-20000:** Void

---

## ✅ Troubleshooting

### Issue: Mod doesn't appear in launcher
**Solution:**
1. Verify Fabric profile is selected
2. Check mods folder contains both JAR files
3. Restart Minecraft Launcher
4. Delete `.minecraft/launcher_profiles.json` and reopen launcher

### Issue: Game crashes on startup
**Solution:**
1. Make sure Java 21 is installed: `java -version`
2. Check Fabric API version matches (1.21.1)
3. Check mod JAR files aren't corrupted
4. Read crash log in `.minecraft/crash-reports/`

### Issue: Regions not generating correctly
**Solution:**
1. Create a NEW world (old worlds won't have new regions)
2. Travel to coordinates past 8000 blocks to see custom regions
3. Check mod is loaded (look for \"[Region Generation]\" in startup logs)

### Issue: \"Can't download resources\"
**Solution:**
1. Launcher needs internet connection
2. Try launching vanilla 1.21.1 first to verify setup
3. Then switch to Fabric profile

---

## 🎮 Testing Your Installation

Once in-game:

1. **Open Chat (T key)**
2. **Type:** `/tp 8000 100 0`
3. **Press Enter**

You should be teleported to Region 1 (Advanced generation). Walk around to verify the mod is working.

---

## 📝 Advanced: Modifying Regions

If you want to customize regions:

1. Clone the repository
2. Edit `src/main/java/com/minecraft/region/RegionConfig.java`
3. Modify region boundaries or types
4. Build: `./gradlew build`
5. Copy new JAR to mods folder

---

## 🆘 Need Help?

- **Minecraft won't start?** Check Java 21 is installed
- **Mods not loading?** Verify `.minecraft/mods/` folder exists and files are there
- **Issues with regions?** Create a NEW world (old worlds don't use new generation)
- **Report bugs:** https://github.com/wtfiamsosickofthis-collab/minecraft-region-generation/issues

---

## 📋 Quick Checklist

- [ ] Java 21 installed (`java -version` shows 21.x)
- [ ] Fabric Installer run for 1.21.1
- [ ] Fabric API JAR downloaded
- [ ] Region Generation JAR downloaded
- [ ] Both JARs in `.minecraft/mods/` folder
- [ ] Minecraft Launcher set to `fabric-loader-1.21.1` profile
- [ ] Launcher restarted
- [ ] New world created
- [ ] Regions generating at correct coordinates

---

**Enjoy your custom world!** 🎮✨
