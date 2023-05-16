package de.pommes.challenges.events;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.GuIInventories.ChallengeMenu;
import de.pommes.challenges.GuIInventories.PlayerChallenges;
import de.pommes.challenges.GuIInventories.TimerMenu;
import de.pommes.challenges.GuIInventories.WorldChallenges;
import de.pommes.challenges.Timer.Timer;
import de.pommes.challenges.challenge.ListenerType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class Events implements Listener {

    private ArrayList<ListenerType> activeChallenges = new ArrayList<>();

    @EventHandler
    public void onGuiInteraction(InventoryClickEvent e){
        try {


            if (e.getView().getTitle().equals("§cChallenges")) {
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2World Challenges")) {
                    e.getWhoClicked().openInventory(WorldChallenges.get());
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2Player Challenges")) {
                    e.getWhoClicked().openInventory(PlayerChallenges.get());
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2Timer Settings")) {
                    e.getWhoClicked().openInventory(TimerMenu.get());
                }
                e.setCancelled(true);
            }
            if (e.getView().getTitle().equals("§cWorld Challenges")) {
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2Item Drop Randomizer")) {
                    Challenges.getInstance().blockDrops.toggleBehavior();
                    WorldChallenges.create();
                    e.getWhoClicked().openInventory(WorldChallenges.get());
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§cBack")) {
                    e.getWhoClicked().openInventory(ChallengeMenu.get());
                }
                e.setCancelled(true);
            }
            if (e.getView().getTitle().equals("§cPlayer Challenges")) {
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2Player health")) {
                    Challenges.getInstance().hearths.toggleBehavior();
                    PlayerChallenges.create();
                    e.getWhoClicked().openInventory(PlayerChallenges.get());
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§cBack")) {
                    e.getWhoClicked().openInventory(ChallengeMenu.get());
                }
                e.setCancelled(true);
            }
            if (e.getView().getTitle().equals("§cTimer Settings")) {
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§2Start/Stop Timer")) {
                    Challenges.getInstance().ChallengeTimer.toggle();
                    TimerMenu.create();
                    e.getWhoClicked().openInventory(TimerMenu.get());
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("§cBack")) {
                    e.getWhoClicked().openInventory(ChallengeMenu.get());
                }
                e.setCancelled(true);
            }
        }
        catch (Exception ignored){

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
            ItemStack item = new ItemStack(Challenges.getInstance().blockDrops.getMap().get(e.getBlock().getType()));
            Bukkit.broadcastMessage(item.getType().name());
            loc.getWorld().dropItemNaturally(loc, new ItemStack(Challenges.getInstance().blockDrops.getMap().get(e.getBlock().getType())));
        }
    }

    @EventHandler
    public void onMonsterDeath(EntityDeathEvent e){
        if(e.getEntityType().equals(EntityType.ENDER_DRAGON)){
            Timer timer = Challenges.getInstance().ChallengeTimer;
            if(!timer.isPaused()) {
                Challenges.getInstance().ChallengeTimer.setPaused(true);
                Bukkit.broadcastMessage("§2Challenge Finished in " + timer.getH() + ":" + timer.getMin() + ":" + timer.getSec());
            }
        }
    }

    public void addChallengeType(ListenerType type){
        activeChallenges.add(type);
    }
    public void deleteChallengeType(ListenerType type){activeChallenges.remove(type);}
}
