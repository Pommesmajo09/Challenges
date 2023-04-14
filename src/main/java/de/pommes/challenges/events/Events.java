package de.pommes.challenges.events;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.GuIInventories.WorldChallenges;
import de.pommes.challenges.challenge.ChallengeType;
import de.pommes.challenges.challenge.ListenerType;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class Events implements Listener {

    private ArrayList<ListenerType> activeChallenges = new ArrayList<>();

    @EventHandler
    public void onGuiInteraction(InventoryClickEvent e){
        if(e.getView().getTitle().equals("§cChallenges")){
            if(Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2World Challenges"))
            {
                e.getWhoClicked().openInventory(WorldChallenges.get());
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Challenges.players.add(e.getPlayer());
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(activeChallenges.contains(ListenerType.randomDrops)) {
            Location loc = e.getBlock().getLocation();
            e.getBlock().getDrops().clear();
            loc.getWorld().dropItemNaturally(loc, new ItemStack(Challenges.getInstance().blockDrops.getMap().get(e.getBlock().getType())));
        }
    }

    public void addChallengeType(ListenerType type){
        activeChallenges.add(type);
    }
}
