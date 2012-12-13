package com.oresome.OresomeDonor;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class OresomeDonor extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");

    public void onDisable() {

	PluginDescriptionFile pdfFile = getDescription();
	this.logger.info(pdfFile.getName() + "is now disabled");
    }

    public void onEnable() {

	PluginDescriptionFile pdfFile = getDescription();
	this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + "is now enabled");

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label,
	    String[] args) {

	ChatColor RED = ChatColor.RED;
	ChatColor AQUA = ChatColor.AQUA;
	ChatColor GREEN = ChatColor.GREEN;
	ChatColor GOLD = ChatColor.GOLD;

	if (cmd.getName().equalsIgnoreCase("donatorbroadcast")) {
	    if (args.length < 1) {
		sender.sendMessage(RED + "Please specify who the donor is!");
	    } else {
		Bukkit.broadcastMessage(GOLD + "[Donator] " + AQUA + args[0] + GREEN + " is now a Donator! Thanks for supporting us!");
	    }
	    return true;
	    
	} else if (cmd.getName().equalsIgnoreCase("donatorplusbroadcast")) {
	    if (args.length < 1) {
		sender.sendMessage(RED + "Please specify who the donor+ is!");
	    } else {
		Bukkit.broadcastMessage(GOLD + "[Donator+] " + AQUA + args[0] + GREEN+ " is now a Donator+! Thanks for supporting us!");
	    }
	    return true;
	}

	return false;

    }
}