package de.pommes.challenges.challenge.ccs;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import de.pommes.challenges.challenge.ChallengeType;
import de.pommes.challenges.challenge.ListenerType;
import de.pommes.challenges.events.Events;
import org.bukkit.Material;

import java.util.*;

public class RandomBlockDrops extends Challenge {

    private Map<Material, Material> map = new HashMap<>();

    public RandomBlockDrops(ChallengeType type) {
        super(type);

        List<Material> randomItems = new ArrayList<>(Arrays.asList(Material.values()));

        for(Material mat : randomItems){
            Random random = new Random();
            int rnd = random.nextInt(randomItems.size());
            map.put(mat, randomItems.get(rnd));
        }


    }

    @Override
    public void enableBehavior(ListenerType type) {
        Challenges.getInstance().events.addChallengeType(type);
    }

    public Map<Material, Material> getMap() {
        return map;
    }
}
