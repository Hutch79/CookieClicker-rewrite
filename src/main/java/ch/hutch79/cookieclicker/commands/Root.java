package ch.hutch79.cookieclicker.commands;

import ch.hutch79.guibuilder.GuiBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static ch.hutch79.cookieclicker.CookieClicker.getPlugin;

public class Root {

    private final GuiBuilder guiBuilder = new GuiBuilder(getPlugin());

    public void command(CommandSender sender) {

        Player player = (Player) sender;

        sender.sendMessage("Huiii");
        ItemStack itemStack = new ItemStack(Material.DIAMOND_AXE);
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Test1");
        tags.add("TestAccount666");
        tags.add("hutch79");
        tags.add("Baeumchen");
        tags.add("Typeeyy");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("heya §6%player_name%");
        itemStack.setItemMeta(itemMeta);
//        Bukkit.getLogger().info("Tags to set: " + tags);
        guiBuilder.setItem("main", 8, itemStack, tags);
        guiBuilder.updateItem("main", 3, player);
        guiBuilder.openGui(player, "main");

    }
}
