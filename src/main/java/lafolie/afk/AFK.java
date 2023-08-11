package lafolie.afk;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.brigadier.CommandDispatcher;

public class AFK implements DedicatedServerModInitializer
{
	public static final String MODID = "afk-command";
	public static final Logger LOGGER = LoggerFactory.getLogger("afk-command");

	@Override
	public void onInitializeServer()
	{
		LOGGER.info("Hello Fabric world!");
		CommandRegistrationCallback.EVENT.register(AFK::Command);
	}

	private static void Command(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment environment)
	{
		dispatcher.register(CommandManager.literal("afk")
		// .requires(source -> source.hasPermissionLevel(0))
		.executes(context ->
		{
			// if(environment.dedicated)
			{
				ServerPlayerEntity player = context.getSource().getPlayer();
				((AFKPlayer)player).setAFKStatus(true);
				context.getSource().getServer().getPlayerManager().broadcast(Text.of(player.getEntityName() + " is now AFK"), false);
			}

			return 1;
		}));
	}
}