package de.pommes.challenges.events;

import de.pommes.challenges.Challenges;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void onGuiInteraction(InventoryClickEvent e){
        if(e.getView().getTitle().equals("§cChallenges")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§2World Challenges"))
            {
                e.getWhoClicked().closeInventory();
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Challenges.players.add(e.getPlayer());
    }
}
