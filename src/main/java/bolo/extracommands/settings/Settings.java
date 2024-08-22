package bolo.extracommands.settings;

import necesse.engine.modLoader.ModSettings;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.inventory.container.object.CraftingStationContainer;

public class Settings extends ModSettings {

    public int savedNearbyCraftingTilesRange = 9;

    @Override
    public void addSaveData(SaveData saveData) {
        System.out.println("Saving nearby crafting tile range...");
        saveData.addInt("savedNearbyCraftingTilesRange", savedNearbyCraftingTilesRange);
    }

    @Override
    public void applyLoadData(LoadData loadData) {
        System.out.println("Loading saved nearby crafting tile range...");
        try {
            savedNearbyCraftingTilesRange = loadData.getInt("savedNearbyCraftingTilesRange");
            CraftingStationContainer.nearbyCraftTileRange = savedNearbyCraftingTilesRange;
            System.out.println("Loaded nearby crafting tile range: " + CraftingStationContainer.nearbyCraftTileRange);
        }
        catch (Exception e) {
            System.out.println("Failed to load nearby crafting tile range, using default value: 9");
        }
    }
}
