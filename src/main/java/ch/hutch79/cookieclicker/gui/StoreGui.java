package ch.hutch79.cookieclicker.gui;

import org.bukkit.inventory.ItemStack;


public class StoreGui {
    public String name;
    public int size;
    public ItemStack[] items;

    StoreGui(String name, int size, ItemStack[] items) {
        this.name = name;
        this.size = size;
        this.items = items;
    }

    public String getName() {
        return this.name;
    }

    public Integer getSize() {
        return this.size;
    }

    public ItemStack[] getItems() {
        return this.items;
    }
}
