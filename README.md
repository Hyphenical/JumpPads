## Introduction to Jump Pads
Jump Pads is a Minecraft Utility extension that hooks into player movement 
in order to edit player velocity to mimic a player jumping. Players that move
over these specific jump pad blocks will notice an increase in velocity.

## Purpose
Jump Pads is a Java based utility extension to Minecraft that allows players 
to construct jump pads for use in travel around the game.

The following are example usages of Jump Pads:
- Players can build their own jump pads in order to create significantly faster ways to get around their home.
- Players can use these jump pads in adventure maps in order to make a more difficulty parkour course.
- Server owners can populate their hub networks with these to increase travel time between points of interest.

### Snapshots
Below is a screenshot of the default Jump Pad. The block a player runs over is the sponge. The piston is a modifier. 
- ![alt text](http://i.imgur.com/4z7jvCkl.png "Default Jump Pad")

By increasing the amount of pistons, we can increase the jump height of the player.
- ![alt text](http://i.imgur.com/vjaRIpzl.png "Multiple pistons increases velocity")

You can hide a Jump Pad like this:
- ![alt text](http://i.imgur.com/EYlNlGWl.png "Hidden Jump Pad")

Here's two quick screenshots of what happens when a player runs over it:
- ![alt text](http://i.imgur.com/DJHe6OZl.png "Before")
- ![alt text](http://i.imgur.com/fmWoODXl.png "After")

As the server owner, you can specify which block would be the 'launch' block and which would be the modifier.
- Default launch block: Sponge (ID: 19)
- Default modifier block Piston (ID: 33)

You can also set a double modifier for the horizontal and vertical velocity components that increase for a player's velocity.

### Commands:
JumpPads comes with a set of commands, only available to players that have op or the permission node:
```
- jumppads.jp
```

Users can access the help screen by typing:
```
/jp help
```

An extended description is provided below:
```
- /pc version
Displays the version of this plugin.

- /pc reload
Reloads the config.yml into the JumpPads plugin.

```

### Configuration:
When JumpPads is loaded for the first time, two config.ymls are created.
```
config.yml
and
example-config.yml
```
The config.yml is the actual configuration file that is read from the plugin, 
whereas the example-config.yml provides comments for how to edit the config.yml
and what values stand for what.

Below is the example-config.yml with extended comments:
```
# ---------------------------
# Example Jump Pads Configuration
# ---------------------------
#
# ---------------------------
# Product by Hyphenical Technologies
# Website: http://hyphenical.net
# ---------------------------
#
# - Note about editing -
# Make sure to check the YAML syntax against a YAML parser. 
# Ex: http://yaml-online-parser.appspot.com/
#
# ---------------------------
# -  Example  configuration -
# -----  DO NOT EDIT    -----
# ---------------------------
#
#
# Version of this config, do not edit this.
# config-version: 1
# global-settings:
# # The ID that the players can see and walk over.
#   launchID: 19
# # The ID that is under the launch ID to concatenate player velocity
#   enhanceID: 33
# # The horizontal velocity written as a double
#   h-velocity: 2.0
# # The vertical velocity written as a double
#   v-velocity: 1.0
#
#
# ---------------------------
# End of Example Configuration
# ---------------------------
```


### License
A copy of the JumpPads' license can be found [here](https://github.com/Hyphenical/JumpPads/blob/master/LICENSE).
