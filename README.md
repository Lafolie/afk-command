# AFK Command

### AFK Command is a [Fabric mod](https://www.fabricmc.net/) for [Minecraft](https://www.minecraft.net/en-us) 1.20.1

# Features

AFK Command adds Away-From-Keyboard (AFK) functionality to Minecraft.

There are 2 ways to gain AFK status:
* Players can use the `/afk` command to mark themselves as AFK
* Idle players can be automatically set to AFK status. This is configurable and can be disabled

AFK status is automatically disabled by the following configurable methods:
* Moving
* Chatting
* Looking (moving the mouse)
* Other actions such as attacking, using/placing blocks & items, opening inventory, etc

Each method can be toggled separately in the config.

AFK status can be configured to:
* Ignore AFK players when calculating `playersSleepingPercentage` gamerule
* Suspend hunger depletion
* Marked as AFK in chat & scoreboard
* Broadcast a message when a player becomes AFK
* Broadcast a message when a player returns

AFK Command is a **Fabric Mod** and is developed exclusively for the Fabric mod loader. The LGPL license means that you are free to port AFK Command to another mod loader, such as NeoForge.

Official builds can be found on Modrinth, or the github repo.

# Client / Server

AFK Command is a server-side mod. It does not need to be installed on clients to work.

# Dependencies

**Minecraft version:** 1.20.1

|                    Name | Version | Modrinth Page     | GitHub Repository | Client/Server |
|------------------------:|:-------:|:-----------------:|:-----------------:|:-------------:|
|              Fabric API | 0.85.0+ | [link][fabric_MR] | [link][fabric_GH] | **Both**      |

# Building

Clone the repo and follow the standard Fabric setup.

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

Once setup, run the `build` gradle task. You will find the compiled jar file in `build/libs/`.

# Authors

Lafolie - developer.

# License

AFK Command is licensed under the GNU Lesser General Public License v3.

[fabric_MR]: https://modrinth.com/mod/fabric-api
[fabric_GH]: https://github.com/FabricMC/fabric