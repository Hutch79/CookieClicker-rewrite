package ch.hutch79.cookieclicker.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnInventoryClick {

    public static void execute(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

    }

}
