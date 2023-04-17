package de.pommes.challenges.challenge.ccs;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import org.bukkit.entity.Player;

public class limitedHearths implements Challenge {

    public int health;

    public limitedHearths(){
        health = 20;
    }

    @Override
    public void toggleBehavior() {
        health --;
        if(health == 0){
            health = 20;
        }
        for (Player p : Challenges.players) {
            p.setMaxHealth(health);
        }
    }
}
