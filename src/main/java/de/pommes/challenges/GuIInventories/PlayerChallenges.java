package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.util.InventoryBuilder;
import de.pommes.challenges.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class PlayerChallenges {
    public static Inventory inv;

    public static void create(){
        InventoryBuilder builder = new InventoryBuilder("§cPlayer Challenges", 9);

        builder.addItem(new ItemBuilder("§2Player health", Material.APPLE, 1).addLore("Limit Player health!", "§2" + Challenges.getInstance().hearths.health + " Health").build(), 1);
        builder.addItem(new ItemBuilder("§cBack", Material.DARK_OAK_DOOR, 1).build(), 8);

        inv = builder.build();


        //inv = new InventoryBuilder("§cWorld Challenges", 9)
        //        .addItem(new ItemBuilder("§2Item Drop Randomizer", Material.GRASS_BLOCK, 1).addLore("Every Block drops a Random Item!").build(), 1)
        //        .addItem(new ItemBuilder("§2 Player Challenges", Material.PLAYER_HEAD, 1).addLore("Open a List of Challenges that modify the Player").build(), 3)
        //        .addItem(new ItemBuilder("§2Timer settings", Material.CLOCK, 1).addLore("Open Timer settings").build(), 5)
        //        .build();
    }

    public static Inventory get(){
        return inv;
    }
}
