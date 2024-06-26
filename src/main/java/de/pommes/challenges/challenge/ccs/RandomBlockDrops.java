package de.pommes.challenges.challenge.ccs;

import de.pommes.challenges.Challenges;
import de.pommes.challenges.challenge.Challenge;
import de.pommes.challenges.challenge.ListenerType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomBlockDrops implements Challenge {

    private Map<Material, Material> map = new HashMap<>();

    private Boolean activated;

    public ArrayList<Material> exclude = new ArrayList<>();

    public RandomBlockDrops() {
        //exclude.add(Material.POTTED_MANGROVE_PROPAGULE);
        //exclude.add(Material.POTTED_WITHER_ROSE);
        //exclude.add(Material.WALL_TORCH);
        //exclude.add(Material.POTTED_ALLIUM);
        //exclude.add(Material.POTTED_BAMBOO);
        //exclude.add(Material.POTTE);
        exclude.add(Material.LAVA_CAULDRON);

        for (Material m : Material.values()) {
            if(m.name().startsWith("POTTED_") | m.name().startsWith("TUBE_")){
                exclude.add(m);
            }
        }

        List<Material> randomItems = new ArrayList<>();
        for (Material m:Material.values()) {
            if(!m.isAir() & !exclude.contains(m) & m.isItem()){
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
