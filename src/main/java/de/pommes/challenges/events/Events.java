package de.pommes.challenges.events;

import de.pommes.challenges.Challenges;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Challenges.players.add(e.getPlayer());
    }
}
