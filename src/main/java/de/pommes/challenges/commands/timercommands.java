package de.pommes.challenges.commands;

import de.pommes.challenges.Challenges;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.*;

public class timercommands implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if((strings.length == 1)){
            if(Objects.equals(strings[0], "start")){
                Challenges.getInstance().ChallengeTimer.setPaused(false);
            } else if(Objects.equals(strings[0], "pause")){
                Challenges.getInstance().ChallengeTimer.setPaused(true);
            }else {
                commandSender.sendMessage("Usage: /timer <start/pause>");
            }
            return false;
        }
        commandSender.sendMessage("Usage: /timer <start/pause>");
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> list = new ArrayList<>();
        list.add("start");
        list.add("pause");
        return list;
    }
}
