package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;

public class Backhit2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).Backhit;
	}
}
