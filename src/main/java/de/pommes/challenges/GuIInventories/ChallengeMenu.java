package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.util.InventoryBuilder;
import de.pommes.challenges.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChallengeMenu {

    public static Inventory inv = new InventoryBuilder("§cChallenges", 9)
            .addItem(new ItemBuilder("§2World Challenges", Material.GRASS_BLOCK, 1).addLore("Open a List of Challenges that change the World").build(), 1)
            .addItem(new ItemBuilder("§2Player Challenges", Material.PLAYER_HEAD, 1).addLore("Open a List of Challenges that modify the Player").build(), 3)
            .addItem(new ItemBuilder("§2Timer settings", Material.CLOCK, 1).addLore("Open Timer settings (Coming Soon)").build(), 5)
            .build();
    public static Inventory get(){
        return inv;
    }
}
