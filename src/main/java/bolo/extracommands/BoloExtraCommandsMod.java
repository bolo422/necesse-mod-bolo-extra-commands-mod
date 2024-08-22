package bolo.extracommands;

import bolo.extracommands.commands.NearbyCraftingTileRangeCommand;
import bolo.extracommands.config.NearbyCraftingTileRangeConfig;
import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.ModSettings;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.inventory.container.object.CraftingStationContainer;

import java.util.Optional;

@ModEntry
public class BoloExtraCommandsMod {

    public void postInit() {
        System.out.println("Bolo's Extra Commands Mod post-initialization started...");
        CommandsManager.registerServerCommand(new NearbyCraftingTileRangeCommand());
    }

    public ModSettings initSettings() {
        return new ModSettings() {
            @Override
            public void addSaveData(SaveData saveData) {
                NearbyCraftingTileRangeConfig.addSaveData(saveData);
            }

            @Override
            public void applyLoadData(LoadData loadData) {
                NearbyCraftingTileRangeConfig.applyLoadData(loadData);
            }
        };
    }
}
