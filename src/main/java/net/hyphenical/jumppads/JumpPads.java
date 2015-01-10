package net.hyphenical.jumppads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

import net.hyphenical.jumppads.command.CommandHandler;
import net.hyphenical.jumppads.listener.PlayerListener;
import net.hyphenical.jumppads.util.Log;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class JumpPads extends JavaPlugin implements Listener {

	/** The configuration of this plugin */
	private JumpConfiguration jconf;

	// When server is enabled, do this...
	public void onEnable() {

		// If config.yml is missing or incomplete, values will be saved.
		this.saveDefaultConfig();
		this.saveExampleConfig();

		// register command
		getCommand("jp").setExecutor(new CommandHandler(this));

		// set this plugin as a minecraft plugin
		getServer().getPluginManager().registerEvents(this, this);

		this.jconf = new JumpConfiguration(this);
		this.jconf.loadGlobalSettings();

		// register plugin specific listeners
		registerListeners();
	}

	// When server is disabled, do this...
	public void onDisable() {

	}

	/**
	 * Writes to a file in the plugin directory the file "example-config.yml"
	 * and overwrites it if something is already there.
	 */
	public void saveExampleConfig() {
		File exampleConfig = new File(getDataFolder(), "example-config.yml");
		if (exampleConfig.exists()) {
			exampleConfig.delete();
			exampleConfig = new File(getDataFolder(), "example-config.yml");
		}

		try {
			// reader from the defaults in the jar.
			BufferedReader br = new BufferedReader(new InputStreamReader(this.getResource("example-config.yml"), "UTF8"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(exampleConfig, true));

			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}

			// do not forget to close the buffer reader
			br.close();

			// close buffer writer
			bw.close();
		}
		catch (Exception e) {
			Log.info("Exception while writing example-config.yml " + e);
		}
	}

	/**
	 * Register plugin specific listeners.
	 */
	private void registerListeners() {

		new PlayerListener(this);
	}

	/**
	 * Get the plugin's configuration instance.
	 * 
	 * @return The JumpPads configuration object that holds information about
	 *         the plugin variables.
	 */
	public JumpConfiguration getJconf() {
		return this.jconf;
	}
}
