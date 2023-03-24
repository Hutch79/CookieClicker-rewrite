package ch.hutch79.cookieclicker.util;

import ch.hutch79.cookieclicker.CookieClicker;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiBuilder {

    private final CookieClicker main = CookieClicker.getPlugin();
    public final ConfigManager configManager = main.getConfigManager();

    public List<String> readConfig(String path) {

        Set<String> guiSet = configManager.getConfig("GUI.yml").get().getConfigurationSection("layout").getKeys(false);
        List<String> guiList = new ArrayList<>(guiSet.size());
        guiList.addAll(guiSet);
        Bukkit.getConsoleSender().sendMessage(String.valueOf(guiList));


        return guiList;

    }

}