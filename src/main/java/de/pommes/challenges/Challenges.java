package de.pommes.challenges;

import de.pommes.challenges.Timer.Timer;
import de.pommes.challenges.commands.Test;
import de.pommes.challenges.commands.timercommands;
import de.pommes.challenges.events.Events;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Challenges extends JavaPlugin {

    public static ArrayList<Player> players = new ArrayList<>();

    public static Challenges instance;

    public Timer ChallengeTimer;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
        instance = this;
        ChallengeTimer = new Timer();
        saveConfig();
        if(!getConfig().contains(".config")){
            getConfig().set(".timer" + ".settings" + ".reset_on_reload", true);
            getConfig().set(".timer" + ".sec", 0);
            getConfig().set(".timer" + ".min", 0);
            getConfig().set(".timer" + ".h", 0);
            getConfig().set(".config", "done");
        }
        saveConfig();
        ChallengeTimer.startTimerExecutable();
        getCommand("timer").setExecutor(new timercommands());
        getCommand("timer").setTabCompleter(new timercommands());
        getCommand("test").setExecutor(new Test());
    }

    @Override
    public void onDisable() {
        getConfig().set(".timer" + ".sec", ChallengeTimer.getSec());
        getConfig().set(".timer" + ".min", ChallengeTimer.getMin());
        getConfig().set(".timer" + ".h", ChallengeTimer.getH());
        saveConfig();
    }

    public static Challenges getInstance() {
        return instance;
    }
}
