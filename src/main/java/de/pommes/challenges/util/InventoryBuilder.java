package de.pommes.challenges.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private Inventory inv;

    public InventoryBuilder(String name, int size){
        inv = Bukkit.createInventory(null, size, name);
    }
    public InventoryBuilder addItem(ItemStack item, int slot){
        inv.setItem(slot, item);
        return this;
    }
    public Inventory build(){
        return inv;
    }

}
