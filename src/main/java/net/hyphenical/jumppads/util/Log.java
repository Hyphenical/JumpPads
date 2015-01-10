package net.hyphenical.jumppads.util;

import java.util.logging.Level;

import org.bukkit.Bukkit;

public class Log {

	/**
	 * Log an error message. This will show up in the console as "[SEVERE] args"
	 * 
	 * @param args - Arguments to log in an error message.
	 */
	public static void error(String... args) {
		log(Level.SEVERE, args);
	}

	/**
	 * Log an info message. This will show up in the console as [INFO] [message]
	 * 
	 * @param args - Arguments to log with the prefix of "[INFO]".
	 */
	public static void info(String... args) {
		log(Level.INFO, args);
	}

	/**
	 * Logs the error message
	 * 
	 * @param level - Level in which to log the arguments.
	 * @param args - Arguments to log.
	 */
	private static void log(Level level, String... args) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < args.length; i++) {
			buffer.append(args[i]);
		}

		Bukkit.getLogger().log(level, String.format("[Jump Pads] %s", buffer.toString()));
	}

}
