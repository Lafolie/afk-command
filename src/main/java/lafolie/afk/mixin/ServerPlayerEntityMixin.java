package lafolie.afk.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import lafolie.afk.AFKPlayer;
import lafolie.afk.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements AFKPlayer
{
	private boolean afkStatus = false;

	@Shadow
	protected abstract long getLastActionTime();

	public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile)
	{
		super(world, pos, yaw, gameProfile);
	}

	@Override
	public boolean getAFKStatus()
	{
		return afkStatus;
	}

	@Override
	public void setAFKStatus(boolean status)
	{
		afkStatus = status;
	}

	@Inject(at = @At("TAIL"), method = "updateLastActionTime()V")
	public void tailUpdateLastActionTime(CallbackInfo ci)
	{
		if(getAFKStatus())
		{
			setAFKStatus(false);
			getServer().getPlayerManager().broadcast(Text.of(getEntityName() + "is no longer AFK"), true);
		}
	}

	@Inject(at = @At("TAIL"), method = "tick()V")
	public void tailTick(CallbackInfo ci)
	{
		if(Util.getMeasuringTimeMs() - getLastActionTime() > Config.AUTO_AFK_TIME)
		{
			setAFKStatus(true);
		}
	}
}
