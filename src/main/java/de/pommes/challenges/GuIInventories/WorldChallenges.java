package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import de.pommes.challenges.util.InventoryBuilder;
import de.pommes.challenges.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class WorldChallenges {
    public static Inventory inv;

    public static void create(){
        InventoryBuilder builder = new InventoryBuilder("§cWorld Challenges", 9);

        if(Challenges.getInstance().blockDrops.isActivated()){
            builder.addItem(new ItemBuilder("§2Item Drop Randomizer", Material.GRASS_BLOCK, 1).addLore("Every Block drops a Random Item!", "§2Enabled").build(), 1);
        }else {
            builder.addItem(new ItemBuilder("§2Item Drop Randomizer", Material.GRASS_BLOCK, 1).addLore("Every Block drops a Random Item!", "§cDisabled").build(), 1);
        }

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
