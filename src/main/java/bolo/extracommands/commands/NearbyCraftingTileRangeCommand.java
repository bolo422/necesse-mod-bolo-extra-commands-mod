package bolo.extracommands.commands;

import bolo.extracommands.BoloExtraCommandsMod;
import bolo.extracommands.config.NearbyCraftingTileRangeConfig;
import necesse.engine.commands.CmdParameter;
import necesse.engine.commands.CommandLog;
import necesse.engine.commands.ModularChatCommand;
import necesse.engine.commands.PermissionLevel;
import necesse.engine.commands.parameterHandlers.IntParameterHandler;
import necesse.engine.commands.parameterHandlers.PresetStringParameterHandler;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.inventory.container.object.CraftingStationContainer;

public class NearbyCraftingTileRangeCommand extends ModularChatCommand {

    public NearbyCraftingTileRangeCommand() {
        super("nearbycraftingtilesrange", "Get or set nearby crafting range for workstation, in tiles", PermissionLevel.ADMIN, false,
                new CmdParameter("command", new PresetStringParameterHandler("set", "get"), false),
                new CmdParameter("range", new IntParameterHandler(15), true));
    }

    @Override
    public void runModular(Client client, Server server, ServerClient serverClient, Object[] args, String[] errors, CommandLog commandLog) {
        try {
            String command = (String) args[0];
            Integer range;

            try {
                range = (Integer) args[1];
                if(range == null) {
                    throw new Exception("Error at execution of {nearbycraftingtilesrangerange} chat command, parameter {range} is null");
                }
                if (range < 0) {
                    throw new Exception("Error at execution of {nearbycraftingtilesrangerange} chat command, parameter {range} is negative");
                }
            } catch (Exception e) {
                commandLog.add("Invalid range, must be an valid integer");
                return;
            }

            if (command.equals("set")) {
                CraftingStationContainer.nearbyCraftTileRange = range;
                NearbyCraftingTileRangeConfig.savedNearbyCraftingTilesRange = range;
                commandLog.add("Set nearby crafting tile range to " + range);
            } else if (command.equals("get")) {
                commandLog.add("Nearby crafting tile range is " + CraftingStationContainer.nearbyCraftTileRange);
            } else {
                commandLog.add("Invalid command, accepted commands are {set, get}");
            }
        } catch (Exception e) {
            commandLog.add("Invalid command");
        }
    }
}
