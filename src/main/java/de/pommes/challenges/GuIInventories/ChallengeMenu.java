package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.util.InventoryBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChallengeMenu {

    public static Inventory inv = new InventoryBuilder("§cChallenges", 9)
            .addItem(new ItemStack(Material.ACACIA_BUTTON), 1)
            .build();
    public static Inventory get(){
        return inv;
    }
}
