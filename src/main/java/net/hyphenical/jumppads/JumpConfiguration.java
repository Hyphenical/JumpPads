package net.hyphenical.jumppads;

import net.hyphenical.jumppads.util.Log;

import org.bukkit.Material;
import org.bukkit.configuration.Configuration;

public class JumpConfiguration {

	/** The plugin instance */
	private JumpPads plugin;
	/** File configuration of this plugin */
	private Configuration config;

	/** Running over this type launches you */
	private Material launchType;
	/** Placing this under the launchType increases the effects */
	private Material enhanceType;
	/** The horizontal velocity modifier */
	private double horizVel;
	/** The vertical velocity modifier */
	private double vertVel;

	/**
	 * Construct a new JumpConfiguration object.
	 * 
	 * @param plugin - the plugin instance.
	 */
	public JumpConfiguration(JumpPads plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}

	/**
	 * Forcefully loads the global settings from the config.yml to this object.
	 */
	public void loadGlobalSettings() {

		Log.info("Loading global settings...");

		this.launchType = Material.getMaterial(config.getInt("global-settings.launchID", 19));
		Log.info("Launch block material is " + this.launchType);

		this.enhanceType = Material.getMaterial(config.getInt("global-settings.enhanceID", 33));
		Log.info("Enhance block material is " + this.enhanceType);

		this.horizVel = config.getDouble("global-settings.h-velocity", 2.0);
		Log.info("Horizontal velocity modifier is " + this.horizVel);

		this.vertVel = config.getDouble("global-settings.v-velocity", 1.0);
		Log.info("Vertical velocity modifier is " + this.vertVel);

		Log.info("Global settings successfully loaded!");
	}

	/**
	 * Forcefully saves the global settings to the config.yml file.
	 */
	public void saveGlobalSettings() {
		Log.info("Saving global settings...");

		config.set("global-settings.launchID", this.launchType.getId());
		config.set("global-settings.enhanceID", this.enhanceType.getId());
		config.set("global-settings.h-velocity", this.horizVel);
		config.set("global-settings.y-velocity", this.vertVel);

		plugin.saveConfig();

		Log.info("Global settings successfully saved!");
	}

	/**
	 * Reloads the basic settings of this plugin.
	 */
	public void reload() {
		loadGlobalSettings();
	}

	/**
	 * Get the launch type.
	 * 
	 * @return The material that represents the launch type.
	 */
	public Material getLaunchType() {
		return this.launchType;
	}

	/**
	 * Get the enhance type.
	 * 
	 * @return The material that represents the enhance type.
	 */
	public Material getEnhanceType() {
		return this.enhanceType;
	}

	/**
	 * Get the horizontal velocity multiplier.
	 * 
	 * @return The horizontal velocity multiplier.
	 */
	public double getHorizVel() {
		return this.horizVel;
	}

	/**
	 * Get the vertical velocity multiplier.
	 * 
	 * @return The vertical velocity multiplier.
	 */
	public double getVertVel() {
		return this.vertVel;
	}
}
