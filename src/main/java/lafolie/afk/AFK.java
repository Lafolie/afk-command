package lafolie.afk;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AFK implements DedicatedServerModInitializer
{
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "afk-command";
	public static final Logger LOGGER = LoggerFactory.getLogger("afk-command");

	@Override
	public void onInitializeServer()
	{
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		//test lang server-only lang file
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) ->
		{
			if(entity instanceof PlayerEntity)
			{
				world.getServer().getPlayerManager().broadcast(Text.of(Text.translatable("afk-command.test").getString()), false); //works
				world.getServer().getPlayerManager().broadcast(Text.translatable("afk-command.test"), false); //doesn't work
			}
		});
	}
}