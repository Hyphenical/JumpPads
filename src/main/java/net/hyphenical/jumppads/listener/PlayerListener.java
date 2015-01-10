package net.hyphenical.jumppads.listener;

import net.hyphenical.jumppads.JumpConfiguration;
import net.hyphenical.jumppads.JumpPads;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {

	/** The plugin instance */
	private JumpPads plugin;
	private JumpConfiguration jconf;

	/**
	 * Construct a new PlayerListener object. This object will listen in on
	 * Player events.
	 * 
	 * @param plugin - the plugin instance
	 */
	public PlayerListener(JumpPads plugin) {
		this.plugin = plugin;
		this.jconf = plugin.getJconf();

		// register this class as a listener
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		// get who moved
		Player p = e.getPlayer();

		// get the block underneath the player
		Location standLoc = p.getWorld().getBlockAt(p.getLocation().clone().add(0, -0.5, 0)).getLocation();
		Block block = standLoc.getBlock();

		// if this block is a launch block
		if (block.getType() == plugin.getJconf().getLaunchType()) {

			int yblock = -1;
			double xvel = p.getLocation().getDirection().getX();
			double yvel = p.getLocation().getDirection().getY();
			double zvel = p.getLocation().getDirection().getZ();

			// while the block under the launch block is an enhance block
			while (block.getLocation().clone().add(0.0D, yblock, 0.0D).getBlock().getType() == this.jconf.getEnhanceType()) {

				Vector v = p.getLocation().getDirection().multiply(this.jconf.getHorizVel());
				xvel = v.getX();
				yvel += v.getY() * (0.25 * this.jconf.getVertVel());
				zvel = v.getZ();

				// keep going down
				yblock--;
			}

			// if enhance block is under launch, then it's a valid jump pad.
			if (block.getLocation().clone().add(0.0D, -1.0D, 0.0D).getBlock().getType() == this.jconf.getEnhanceType()) {

				// launch them
				p.setVelocity(new Vector(xvel, yvel, zvel));
				p.playSound(p.getLocation(), Sound.STEP_LADDER, 10, 5);
				p.playEffect(p.getLocation(), Effect.STEP_SOUND, this.jconf.getLaunchType().getId());
			}
		}

	}

}
