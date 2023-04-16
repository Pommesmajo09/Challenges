package de.pommes.challenges.challenge.ccs;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import de.pommes.challenges.challenge.ChallengeType;
import de.pommes.challenges.challenge.ListenerType;
import de.pommes.challenges.events.Events;
import org.bukkit.Material;

import java.util.*;

public class RandomBlockDrops implements Challenge {

    private Map<Material, Material> map = new HashMap<>();

    private ChallengeType type;

    private Boolean activated;

    public RandomBlockDrops() {
        List<Material> randomItems = new ArrayList<>(Arrays.asList(Material.values()));
        type = ChallengeType.world;
        activated = false;
        for(Material mat : randomItems){
            Random random = new Random();
            int rnd = random.nextInt(randomItems.size());
            map.put(mat, randomItems.get(rnd));
        }
    }

    public Map<Material, Material> getMap() {
        return map;
    }

    @Override
    public void toggleBehavior() {
        if(activated){
            Challenges.getInstance().events.deleteChallengeType(ListenerType.randomDrops);
            activated = false;
        }else {
            Challenges.getInstance().events.addChallengeType(ListenerType.randomDrops);
            activated = true;
        }
    }

    public Boolean isActivated() {
        return activated;
    }
}
