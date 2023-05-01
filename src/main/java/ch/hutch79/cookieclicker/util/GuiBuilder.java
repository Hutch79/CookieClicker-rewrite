package ch.hutch79.cookieclicker.util;

import ch.hutch79.cookieclicker.CookieClicker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiBuilder {

    private CookieClicker main;
    public ConfigManager configManager;

    public void GuiBuilderInit() {
        main = CookieClicker.getPlugin();
        configManager = main.getConfigManager();
    }

    public List<String> readConfig(String path) {

        Set<String> guiSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout").getKeys(false);
        List<String> guiIDList = new ArrayList<>(guiSet.size());
        guiIDList.addAll(guiSet);

        Player player = Bukkit.getPlayer("ea0076d8-6297-4b8b-a8ec-544409f35c27");

        List<Inventory> guiList = null;
        for (int i = 0; i < guiIDList.size(); i++) {

            int guiSize = configManager.getConfig("GUI.yml").get().getInt("layout." + guiIDList.get(i) + ".rowCount");
            guiSize = guiSize * 9;
            String guiName = configManager.getConfig("GUI.yml").get().getString("layout." + guiIDList.get(i) + ".name");
            guiList = new ArrayList<>(guiSet.size());
            guiList.add(Bukkit.createInventory(player, guiSize, guiName));

            Set<String> itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots").getKeys(false);
            List<String> itemList = new ArrayList<>(itemSet.size());
            itemList.addAll(itemSet);
//            Bukkit.getConsoleSender().sendMessage(String.valueOf(itemList));

            for (int j = 0; j < itemList.size(); j++) {
                itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots." + itemList.get(j)).getKeys(true);
                List<String> itemList2 = new ArrayList<>(itemSet.size());
                itemList2.addAll(itemSet);
                Bukkit.getConsoleSender().sendMessage(String.valueOf(itemList2));

            }

        }
        guiList.get(0).getContents();
        player.openInventory(guiList.get(0));
        return guiIDList;
    }

}
