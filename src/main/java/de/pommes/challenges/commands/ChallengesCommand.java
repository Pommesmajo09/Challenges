package de.pommes.challenges.commands;

import de.pommes.challenges.GuIInventories.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChallengesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player p)) return false;

        WorldChallenges.create();
        PlayerChallenges.create();
        TimerMenu.create();
        GoalsMenu.create();

        p.openInventory(ChallengeMenu.get());

        return false;
    }
}
