package ch.hutch79.cookieclicker.listener;

import ch.hutch79.guibuilder.GuiBuilder;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static ch.hutch79.cookieclicker.CookieClicker.getPlugin;

public class OnInventoryClick {
    private static final GuiBuilder guiBuilder = new GuiBuilder(getPlugin());
    public static void execute(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null){
            return;
        }

        if (guiBuilder.getTag(event.getCurrentItem()).contains("hutch79")) {
            Bukkit.getLogger().info("Tag Success!!!");
        }
        Bukkit.getLogger().warning("Tag: " + guiBuilder.getTag(event.getCurrentItem()));

    }

}
