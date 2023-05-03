package ch.hutch79.cookieclicker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandManager implements CommandExecutor {

    private final Root root = new Root();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) { // Root command
            root.command(sender);
            return true;
        }

        return false;
    }
}
