package net.mcreator.warforeternity.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AxesProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == false && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == false
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode == false && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == false) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = true;
				_vars.syncPlayerVariables(entity);
			}
		}
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode;
	}
}
