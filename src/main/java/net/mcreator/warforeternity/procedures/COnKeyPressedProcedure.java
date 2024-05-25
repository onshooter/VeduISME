package net.mcreator.warforeternity.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.init.WarForEternityModItems;

import java.util.Comparator;

public class COnKeyPressedProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.SwordMode = true;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true) {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
				ItemStack _setstack = new ItemStack(WarForEternityModItems.PYRO_STICK.get()).copy();
				_setstack.setCount(1);
				_modHandlerEntSetSlot.setStackInSlot(0, _setstack);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeThrown = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(WarForEternityModItems.PYRO_STICK.get(), 300);
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true) {
			((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).setSecondsOnFire(60);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(WarForEternityModItems.PYRO_STICK.get(), 300);
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.PyroStickPyro = false;
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == WarForEternityModItems.SPIRITFIRE.get()) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.shotgun = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.sniper = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.rpg = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).PyroStickPyro
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).shotgun
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).sniper;
	}
}
