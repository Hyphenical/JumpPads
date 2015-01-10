package net.hyphenical.jumppads.command;

import net.hyphenical.jumppads.JumpPads;
import net.hyphenical.jumppads.util.JumpPadUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class CommandHandler implements CommandExecutor {

	/** The plugin instance */
	private JumpPads plugin;

	/**
	 * Construct a new CommandHandler object.
	 * 
	 * @param plugin - the plugin instance
	 */
	public CommandHandler(JumpPads plugin) {
		this.plugin = plugin;

		plugin.getCommand("jp").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String commandName = command.getName();

		if (commandName.equalsIgnoreCase("jp")) {

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("versiondump") || args[0].equalsIgnoreCase("v") || args[0].equalsIgnoreCase("vd")) {
					// Displays the info about this plugin.
					return handleVersionCommand(sender);
				}
				else if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r")) {
					// Purges plugin configuration and reloads it.
					return handleReloadCommand(sender);
				}
			}

			handleHelpCommand(sender);
		}

		return true;
	}

	/**
	 * Handles the help command.
	 * 
	 * @param sender - the command sender
	 */
	private boolean handleHelpCommand(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "---" + ChatColor.GOLD + " Jump Pad Commands " + ChatColor.GREEN + "" + ChatColor.BOLD + "---");
		sender.sendMessage(ChatColor.WHITE + "► " + ChatColor.GOLD + "/jp version|versiondump|v|vd" + ChatColor.GRAY + " (Display the info about this plugin)");
		sender.sendMessage(ChatColor.WHITE + "► " + ChatColor.GOLD + "/jp reload" + ChatColor.GRAY + " (Reloads plugin configuration)");

		return true;
	}

	/**
	 * Handles the version command.
	 * 
	 * @param sender - the command sender
	 */
	private boolean handleVersionCommand(CommandSender sender) {
		PluginDescriptionFile pdf = plugin.getDescription();

		sender.sendMessage(JumpPadUtils.getPluginPrefix() + "Jump Pads v" + pdf.getVersion() + " by " + pdf.getAuthors().get(0) + " (" + pdf.getWebsite() + ")");

		return true;
	}

	/**
	 * Handles the reload command.
	 * 
	 * @param sender - the command sender
	 */
	private boolean handleReloadCommand(CommandSender sender) {
		plugin.reloadConfig();

		PluginDescriptionFile pdf = plugin.getDescription();

		sender.sendMessage(JumpPadUtils.getPluginPrefix() + "Reloading Jump Pads v" + pdf.getVersion());
		sender.sendMessage(JumpPadUtils.getPluginPrefix() + "Author: " + ChatColor.BLUE + pdf.getAuthors().get(0));
		sender.sendMessage(JumpPadUtils.getPluginPrefix() + "Website: " + ChatColor.YELLOW + pdf.getWebsite());

		plugin.getJconf().reload();

		return true;
	}
}
