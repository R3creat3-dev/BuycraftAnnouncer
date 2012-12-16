package com.zachoz.BuycraftAnnouncer;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class BuycraftAnnouncer extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");

    public void onDisable() {

	PluginDescriptionFile pdfFile = getDescription();
	this.logger.info(pdfFile.getName() + "is now disabled");
    }

    public void onEnable() {

	PluginDescriptionFile pdfFile = getDescription();
	this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + "is now enabled");
	this.saveDefaultConfig();
	
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label,
	    String[] args) {

	ChatColor RED = ChatColor.RED;
	
	
      
	PluginDescriptionFile pdfFile = getDescription();
	if (cmd.getName().equalsIgnoreCase("donorbroadcast")) {
	    if (args.length < 2) {
		sender.sendMessage(RED + "Please specify a the broadcast to use and who the user is!");
		sender.sendMessage(RED + "Usage: /donorbroadcast <BroadcastName> <UserName>");
	    } else {
		
		String announcement = args[0];
		String message = getConfig().getString(announcement + ".message");
		String prefix = getConfig().getString(announcement + ".prefix");
		String usernamecolour = getConfig().getString(announcement + ".usernamecolour");
		
		if(getConfig().getString(args[0]) == null) {
		    sender.sendMessage(RED + "The broadcast " + args[0] + " is not defined in the configuration!");
	    } else {
		Bukkit.broadcastMessage(parseColour(prefix) + " " + parseColour(usernamecolour)+ args[1] + " " + parseColour(message));
		
	    }
	    }
	}else if (cmd.getName().equalsIgnoreCase("buycraftannouncer")) {
	    if (args.length < 1) {
	    sender.sendMessage(RED + "BuycraftAnnouncer version " + pdfFile.getVersion() + " by Zachoz" );
	} 
	    else if (args[0].equalsIgnoreCase("reload")) {
		  this.reloadConfig();
		  sender.sendMessage(ChatColor.GREEN + "Configuration reloaded.");
	    }
		    return true;
	}
	return true;

    }
    
    public static String parseColour(String s){
	String message = s;

	message = message.replaceAll("&0", ChatColor.BLACK + "");
	message = message.replaceAll("&1", ChatColor.DARK_BLUE + "");
	message = message.replaceAll("&2", ChatColor.DARK_GREEN + "");
	message = message.replaceAll("&3", ChatColor.DARK_AQUA + "");
	message = message.replaceAll("&4", ChatColor.DARK_RED + "");
	message = message.replaceAll("&5", ChatColor.DARK_PURPLE + "");
	message = message.replaceAll("&6", ChatColor.GOLD + "");
	message = message.replaceAll("&7", ChatColor.GRAY + "");
	message = message.replaceAll("&8", ChatColor.DARK_GRAY + "");
	message = message.replaceAll("&9", ChatColor.BLUE + "");
	message = message.replaceAll("&a", ChatColor.GREEN + "");
	message = message.replaceAll("&b", ChatColor.AQUA + "");
	message = message.replaceAll("&c", ChatColor.RED + "");
	message = message.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
	message = message.replaceAll("&e", ChatColor.YELLOW + "");
	message = message.replaceAll("&f", ChatColor.WHITE + "");
	message = message.replaceAll("&k", ChatColor.MAGIC + "");
	message = message.replaceAll("&m", ChatColor.MAGIC + "");
	message = message.replaceAll("&i", ChatColor.ITALIC + "");
	message = message.replaceAll("&u", ChatColor.UNDERLINE + "");
	message = message.replaceAll("&h", ChatColor.BOLD + "");
	message = message.replaceAll("&n", ChatColor.RESET + "");
	message = message.replaceAll("&r", ChatColor.RESET + "");

	return message;
}
}


