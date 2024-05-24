package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;

public class PyroHudHammerDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean hammermode = false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true) {
			hammermode = true;
		}
		return hammermode;
	}
}
