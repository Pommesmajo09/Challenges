package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.util.InventoryBuilder;
import de.pommes.challenges.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChallengeMenu {

    public static Inventory inv = new InventoryBuilder("§cChallenges", 9)
            .addItem(new ItemBuilder("§2World Challenges", Material.GRASS_BLOCK, 1).addLore("Open a List of Challenges that change the World").build(), 1)
            .build();
    public static Inventory get(){
        return inv;
    }
}
