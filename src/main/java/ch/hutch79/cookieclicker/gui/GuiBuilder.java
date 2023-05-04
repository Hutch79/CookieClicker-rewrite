package ch.hutch79.cookieclicker.gui;

import ch.hutch79.cookieclicker.CookieClicker;
import ch.hutch79.cookieclicker.util.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class GuiBuilder {

    private CookieClicker main;
    public ConfigManager configManager;

    private static HashMap<Player, Inventory> playerGuis = new HashMap<>();
    private static HashMap<String, StoreGui> GUIs = new HashMap<>();

    public void GuiBuilderInit() {
        main = CookieClicker.getPlugin();
        configManager = main.getConfigManager();
//        readConfig("GUI.yml");
    }

    public List<String> readConfig(String path) {

        Set<String> guiSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout").getKeys(false);
        List<String> guiIDList = new ArrayList<>(guiSet.size());
        guiIDList.addAll(guiSet);

        List<Inventory> guiList = null;

        for (int i = 0; i < guiIDList.size(); i++) { // Going through all GUIs

            int guiSize = configManager.getConfig("GUI.yml").get().getInt("layout." + guiIDList.get(i) + ".rowCount");
            guiSize = guiSize * 9;
            String guiName = configManager.getConfig("GUI.yml").get().getString("layout." + guiIDList.get(i) + ".name");
            guiList = new ArrayList<>(guiSet.size());

            Set<String> itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots").getKeys(false);
            List<String> itemList = new ArrayList<>(itemSet.size());
            itemList.addAll(itemSet);

            ItemStack[] itemStack = new ItemStack[guiSize];

            for (int j = 0; j < itemList.size(); j++) { // Going through all configured Items

                itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots." + itemList.get(j)).getKeys(true);
                List<String> itemList2 = new ArrayList<>(itemSet.size());
                itemList2.addAll(itemSet);
                Bukkit.getConsoleSender().sendMessage(String.valueOf(itemList2));



                ItemStack test = new ItemStack(Material.STONE);

                itemStack[1] = test;
                itemStack[1].setType(Material.GRASS);


                //for (int y = 0; y < itemList2.size(); y++) {

                //}


            }
            Bukkit.getConsoleSender().sendMessage("Locked and Loaded");
            GUIs.put(guiIDList.get(i), new StoreGui(guiIDList.get(i), guiSize, itemStack));
            Bukkit.getConsoleSender().sendMessage(String.valueOf(GUIs));
        }


        return guiIDList;
    }

    public void openGUI(Player player, String gui) {
        Bukkit.getConsoleSender().sendMessage(String.valueOf(GUIs));
        if (playerGuis.containsKey(player)) {
            player.sendMessage("if");
            player.sendMessage("playerGuis.get(player)");
            player.openInventory(playerGuis.get(player));
        }
        else {
            player.sendMessage("else");

            Inventory inv = Bukkit.createInventory(player, GUIs.get("main").getSize());
            inv.setContents(GUIs.get(gui).getItems());
            playerGuis.put(player, inv);

            player.openInventory(inv);
        }
    }
}
