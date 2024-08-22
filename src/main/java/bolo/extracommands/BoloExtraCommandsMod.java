package bolo.extracommands;

import bolo.extracommands.commands.NearbyCraftingTileRangeCommand;
import bolo.extracommands.settings.Settings;
import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.annotations.ModEntry;

@ModEntry
public class BoloExtraCommandsMod {
    public static Settings settings;
    public void postInit() {
        System.out.println("Bolo's Extra Commands Mod post-initialization started...");
        CommandsManager.registerServerCommand(new NearbyCraftingTileRangeCommand());
    }

    public Settings initSettings() {
        settings = new Settings();
        return settings;
    }
}
