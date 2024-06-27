package de.pommes.challenges.GuIInventories;

import de.pommes.challenges.util.InventoryBuilder;
import de.pommes.challenges.util.ItemBuilder;

public class GoalsMenu extends GUIInv{

    public static void create(){
        inv = new InventoryBuilder("§cGoals", 9*5).build();
    }

}
