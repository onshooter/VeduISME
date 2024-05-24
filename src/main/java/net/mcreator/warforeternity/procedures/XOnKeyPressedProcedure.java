package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.init.WarForEternityModItems;

public class XOnKeyPressedProcedure {
	public static boolean execute(Entity entity) {
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
				_vars.HammerMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.SwordMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 17, false, false));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(WarForEternityModItems.PYRO_STICK.get(), 300);
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.StickMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode;
		}
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode;
	}
}
