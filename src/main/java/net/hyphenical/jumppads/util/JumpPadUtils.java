package net.hyphenical.jumppads.util;

import org.bukkit.ChatColor;

public class JumpPadUtils {

	/**
	 * Get the plugin prefix for chat formatting.
	 * 
	 * @return The plugin prefix for chat formatting.
	 */
	public static String getPluginPrefix() {
		return ChatColor.GOLD + "" + ChatColor.BOLD + "JP" + ChatColor.RESET + ChatColor.WHITE + " ♦ " + ChatColor.GREEN;
	}
}
