package ch.hutch79.cookieclicker.commands;

import ch.hutch79.guibuilder.GuiBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Root {

    private final GuiBuilder guiBuilder = new GuiBuilder();

    public void command(CommandSender sender) {

        Player player = (Player) sender;

        sender.sendMessage("Huiii");
        guiBuilder.openGUI(player, "main");

    }
}
