package de.tails.speedcommand.main;

import org.bukkit.plugin.java.JavaPlugin;

public class SpeedCommand extends JavaPlugin {

	private static SpeedCommand plugin;

	@Override
	public void onEnable() {
		plugin = this;
		getCommand("speed").setExecutor(new Speed());
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	public static SpeedCommand getPlugin() {
		return plugin;
	}
}