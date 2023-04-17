package de.pommes.challenges.challenge.ccs;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import de.pommes.challenges.challenge.ListenerType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomBlockDrops implements Challenge {

    private Map<Material, Material> map = new HashMap<>();

    private Boolean activated;

    public RandomBlockDrops() {
        List<Material> randomItems = new ArrayList<>();
        for (Material m:Material.values()) {
            if(!(m == Material.AIR)){
                randomItems.add(m);
            }
        }
        activated = false;
        for(Material mat : randomItems){
            if(mat.isBlock()) {
                Random random = new Random();
                int rnd = random.nextInt(randomItems.size());
                Material rndItem = randomItems.get(rnd);
                map.put(mat, rndItem);
            }
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
