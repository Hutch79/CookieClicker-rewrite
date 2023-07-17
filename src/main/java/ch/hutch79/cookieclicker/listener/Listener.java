package ch.hutch79.cookieclicker.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.ArrayList;

public class Listener implements org.bukkit.event.Listener {

    private final ArrayList<String> guis = new ArrayList<String>();


    public Listener() {

        guis.add("CookieClicker");
        guis.add("CookieClicker - Upgrades");
    }


    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        if (!guis.contains(event.getView().getTitle())) {
            return;
        }
        for (int i : event.getRawSlots()) {
            if (i <= 53) {
                event.setCancelled(true);
                break;
            }
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
//        if (!guis.contains(event.getView().getTitle())) {
//            return;
//        }

        OnInventoryClick.execute(event);
//        event.setCancelled(true);


    }

}
