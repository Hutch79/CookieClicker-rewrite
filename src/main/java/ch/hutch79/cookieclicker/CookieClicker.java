package ch.hutch79.cookieclicker;

import ch.hutch79.cookieclicker.listener.Listener;
import ch.hutch79.cookieclicker.util.ConfigManager;
import ch.hutch79.cookieclicker.util.DatabaseManager;
import ch.hutch79.cookieclicker.util.GuiBuilder;
import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import com.jeff_media.updatechecker.UserAgentBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class CookieClicker extends JavaPlugin {

    private static CookieClicker plugin;
    private ConfigManager configManager;
    private PluginDescriptionFile pdf;
    private final GuiBuilder guiBuilder = new GuiBuilder();

    private boolean isPlaceholderApiInstalled = false;

    @Override
    public void onEnable() {
        plugin = this;
        pdf = plugin.getDescription();
        configManager = new ConfigManager(plugin);


        Bukkit.getPluginManager().registerEvents(new Listener(), this);

        final int SPIGOT_RESOURCE_ID = 105878; // Update checker
        Metrics metrics = new Metrics(this, 16433); // bStats

        configManager.getConfig("GUI.yml").copyDefaults(true).save();
        configManager.getConfig("config.yml").copyDefaults(true).save();
        configManager.getConfig("messages.yml").copyDefaults(true).save();

        new UpdateChecker(this, UpdateCheckSource.SPIGET, "" + SPIGOT_RESOURCE_ID + "")
                .setDownloadLink("https://www.spigotmc.org/resources/105878/")
                .setChangelogLink("https://www.spigotmc.org/resources/105878/updates")
                .setColoredConsoleOutput(true)
                .setNotifyOpsOnJoin(true)
                .setNotifyByPermissionOnJoin("cookieclicker.admin")
                .setUserAgent(new UserAgentBuilder().addPluginNameAndVersion().addServerVersion())
                .checkEveryXHours(12) //Warn people every 12 hours
                .checkNow();

        if (pdf.getVersion().contains("Beta")) {
            getLogger().warning("It seems you're using a dev Build");
            getLogger().warning("You can use this Build on Production Servers but for some reasons i would not recommend that.");
            getLogger().warning("Mostly i added some new features or have changed some things and need feedback before releasing.");
            getLogger().warning("So if you want to provide Feedback for this Version, don't hesitate to do so on GitHub");
            getLogger().warning("and if you find any Bugs, please report them: https://github.com/Hutch79/CookieClicker");
        }

        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8< §5Loaded GUI's: §7" + guiBuilder.readConfig("GUI.yml"));

        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5======================================================");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §6" + pdf.getName() + " " + pdf.getVersion() + " §bby Hutch79");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §7Has been §2Enabled");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §cIf you find any Bugs, please report them on GitHub");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §6https://github.com/Hutch79/CookieClicker");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §9Discord: §6https://dc.hutch79.ch");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5======================================================");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §6Database: " + DatabaseManager.isConnected());

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §aPlaceholderAPI §7has been found, hooking into it now.");
            isPlaceholderApiInstalled = true;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        DatabaseManager.Disconnect();
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5======================================================");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §6" + pdf.getName() + " " + pdf.getVersion() + " §bby Hutch79");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §7Has been §cDisabled");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §cIf you found any Bugs, please report them on GitHub");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §6https://github.com/Hutch79/CookieClicker");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5| §9Discord: §6https://dc.hutch79.ch");
        Bukkit.getConsoleSender().sendMessage("§d" + pdf.getName() + " §8> §5======================================================");

    }

    public static CookieClicker getPlugin(){return plugin;}
    public ConfigManager getConfigManager(){
        return configManager;
    }


    public String replacePlaceholders(Player player, String input) {
        if(isPlaceholderApiInstalled) {
            return me.clip.placeholderapi.PlaceholderAPI.setPlaceholders(player, input);
        }
        return input;
    }
}
