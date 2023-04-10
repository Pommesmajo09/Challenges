package de.pommes.challenges.commands;

import de.pommes.challenges.GuIInventories.ChallengeMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        p.openInventory(ChallengeMenu.get());

        return false;
    }
}
