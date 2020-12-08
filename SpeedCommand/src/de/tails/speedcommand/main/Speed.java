package de.tails.speedcommand.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player))
			return true;
		Player player = (Player) sender;
		if(!(player.hasPermission("speed.use"))) {
			player.sendMessage("§cDazu hast du keine Rechte!");
			return true;
		}
		if(args.length == 1) {
			if(isInteger(args[0])) {
				double speed = Double.parseDouble(args[0]);
				if(speed >= 0 && speed <= 10) {
					speed = speed / 10;
					player.setFlySpeed((float) speed);
					player.setWalkSpeed((float) speed);
					player.sendMessage("§aDein Speed wurde versetzt!");
				} else {
					player.sendMessage("§cBitte verwende /speed 1-10");
				}
			} else {
				player.sendMessage("§cBitte verwende /speed 1-10");
			}
		} else {
			player.sendMessage("§cBitte verwende /speed 1-10");
		}
		return false;
	}

	public static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}