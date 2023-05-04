package ch.hutch79.cookieclicker.gui;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class GuiConfigManager{

    private static FileConfiguration customConfig;
    private static JavaPlugin mainClass;
    public GuiConfigManager(JavaPlugin main) {
        mainClass = main;
    }

    private static HashMap<String, FileConfiguration> configs = new HashMap<String, FileConfiguration>();

    public FileConfiguration getCustomConfig(String name) {
        Bukkit.getConsoleSender().sendMessage("I was here");
        return configs.get(name);
    }

    public void createCustomConfig(String name) {
        Bukkit.getConsoleSender().sendMessage("Me To");
        File customConfigFile = new File(mainClass.getDataFolder(), name);
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            mainClass.saveResource(name, true);
        }
                Bukkit.getConsoleSender().sendMessage("Me To");

        customConfig = new YamlConfiguration();

        YamlConfiguration.loadConfiguration(customConfigFile);

        configs.put(name, customConfig);
        Bukkit.getConsoleSender().sendMessage("Me To");

    }
}
