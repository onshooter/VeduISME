package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;

public class SpiritfireShotgunDCProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean ops = false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).shotgun == true) {
			ops = false;
		} else {
			ops = true;
		}
		return ops;
	}
}
