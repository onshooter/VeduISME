package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;

public class PyroHudSwordDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean axemode = false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).TutorialOnOf == true) {
			axemode = true;
		}
		return axemode;
	}
}
