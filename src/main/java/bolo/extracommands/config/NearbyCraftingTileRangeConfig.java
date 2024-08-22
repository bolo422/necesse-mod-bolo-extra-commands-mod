package bolo.extracommands.config;

import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.inventory.container.object.CraftingStationContainer;

public abstract class NearbyCraftingTileRangeConfig {

    private static final int DEFAULT_NEARBY_CRAFTING_TILES_RANGE = 9;
    public static int savedNearbyCraftingTilesRange = DEFAULT_NEARBY_CRAFTING_TILES_RANGE;

    public static void addSaveData(SaveData saveData) {
        System.out.println("Saving nearby crafting tile range...");
        saveData.addInt("savedNearbyCraftingTilesRange", savedNearbyCraftingTilesRange);
    }

    public static void applyLoadData(LoadData loadData) {
        System.out.println("Loading saved nearby crafting tile range...");
        try {
            CraftingStationContainer.nearbyCraftTileRange = loadData.getInt("savedInt", DEFAULT_NEARBY_CRAFTING_TILES_RANGE, true);
            System.out.println("Loaded nearby crafting tile range: " + CraftingStationContainer.nearbyCraftTileRange);
        }
        catch (Exception e) {
            System.out.println("Failed to load nearby crafting tile range, using default value: " + DEFAULT_NEARBY_CRAFTING_TILES_RANGE);
        }
    }
}
