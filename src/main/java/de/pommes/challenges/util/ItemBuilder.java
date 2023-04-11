package de.pommes.challenges.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(String name, Material material, int amount){
        item = new ItemStack(material, amount);
        meta = item.getItemMeta();
        meta.setDisplayName(name);
    }

    public ItemBuilder addLore(String... strings){
        List<String> lore = Arrays.stream(strings).toList();
        meta.setLore(lore);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchantment, int strength, boolean ignoreLimit){
        meta.addEnchant(enchantment, strength, ignoreLimit);
        return this;
    }

    public ItemStack build(){
        item.setItemMeta(meta);
        return item;
    }

}
