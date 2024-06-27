package de.pommes.challenges.Timer;

import de.pommes.challenges.Challenges;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class Timer {

    FileConfiguration config;

    private int sec;
    private int min;
    private int h;
    private boolean paused = true;
    public Timer(){
        config = Challenges.getInstance().getConfig();
        if(Objects.equals(config.get(".timer" + ".settings" + ".reset_on_reload"), true)){
            sec = 0;
            min = 0;
            h = 0;
        } else {
            sec = config.getInt(".timer" + ".sec");
            min = config.getInt(".timer" + ".min");
            h = config.getInt(".timer" + ".h");
        }
    }

    public void startTimerExecutable(){
        new BukkitRunnable() {
            @Override
            public void run() {
                if(!isPaused()) {
                    sec += 1;
                    if (sec == 60) {
                        sec = 0;
                        min += 1;
                    }
                    if (min == 60) {
                        h += 1;
                    }
                }
                for (Player p : Challenges.players) {
                    if(min == 0) {
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(sec + ""));
                    } else if (h > 0){
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(h + ":" + min + ":" +sec));
                    }else {
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(min + ":" + sec));
                    }
                }
            }
        }.runTaskTimer(Challenges.getInstance(), 5, 20);
    }



    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void toggle(){
        if(paused){
            paused = false;
        } else {
            paused = true;
        }
    }
}
