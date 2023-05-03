package ch.hutch79.cookieclicker.util;

import ch.hutch79.cookieclicker.CookieClicker;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiBuilder {

    private CookieClicker main;
    public ConfigManager configManager;

    private List<List<ItemStack[]>> GUIs = new ArrayList<>();

    public void GuiBuilderInit() {
        main = CookieClicker.getPlugin();
        configManager = main.getConfigManager();
    }

    public List<String> readConfig(String path) {

        Set<String> guiSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout").getKeys(false);
        List<String> guiIDList = new ArrayList<>(guiSet.size());
        guiIDList.addAll(guiSet);

        List<Inventory> guiList = null;
        ItemStack[] itemStack = new ItemStack[0];
        for (int i = 0; i < guiIDList.size(); i++) {

            int guiSize = configManager.getConfig("GUI.yml").get().getInt("layout." + guiIDList.get(i) + ".rowCount");
            guiSize = guiSize * 9;
            String guiName = configManager.getConfig("GUI.yml").get().getString("layout." + guiIDList.get(i) + ".name");
            guiList = new ArrayList<>(guiSet.size());

            Set<String> itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots").getKeys(false);
            List<String> itemList = new ArrayList<>(itemSet.size());
            itemList.addAll(itemSet);
//            Bukkit.getConsoleSender().sendMessage(String.valueOf(itemList));

            for (int j = 0; j < itemList.size(); j++) {
                itemSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout." + guiIDList.get(i) + ".slots." + itemList.get(j)).getKeys(true);
                List<String> itemList2 = new ArrayList<>(itemSet.size());
                itemList2.addAll(itemSet);
                Bukkit.getConsoleSender().sendMessage(String.valueOf(itemList2));


                itemStack = new ItemStack[36];

                ItemStack test = new ItemStack(Material.STONE);

                itemStack[1] = test;
                itemStack[1].setType(Material.GRASS);


                //for (int y = 0; y < itemList2.size(); y++) {

                //}

                // GUIs.get(0).add(itemStack);

            }

        }
        // guiList.get(0).getContents();

        Player player = Bukkit.getPlayer("Hutch79");
        Inventory inv = Bukkit.createInventory(player, 36);
        inv.setContents(itemStack);

        player.openInventory(inv);
        return guiIDList;
    }

}
