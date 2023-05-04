package ch.hutch79.cookieclicker.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class GuiBuilder {

    private JavaPlugin main;

    private static HashMap<Player, Inventory> playerGuis = new HashMap<>();
    private static HashMap<String, StoreGui> GUIs = new HashMap<>();

    public void GuiBuilderInit(JavaPlugin mainClass) {
        main = mainClass;

//        readConfig("GUI.yml");
    }

    private GuiConfigManager configManager = main.getGuiConfigManager();

    public void readConfig(String path) {

        Set<String> guiSet = configManager.getCustomConfig("GUI.yml").getKeys(true);
        Bukkit.getConsoleSender().sendMessage("GuiBuilder!!!!!");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(guiSet));
        return;
        /*
                // configManager.getConfig("GUI.yml").get().getConfigurationSection("layout").getKeys(false);
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
            GUIs.put(guiIDList.get(i), new StoreGui(guiIDList.get(i), guiSize, itemStack));
        }


        return guiIDList;
    }

    public void openGUI(Player player, String gui) {
        if (playerGuis.containsKey(player)) {
            player.sendMessage("if");
            player.sendMessage("playerGuis.get(player)");
            player.openInventory(playerGuis.get(player));
        }
        else {

            Inventory inv = Bukkit.createInventory(player, GUIs.get("main").getSize());
            inv.setContents(GUIs.get(gui).getItems());
            playerGuis.put(player, inv);

            player.openInventory(inv);
        }*/
    }
}
