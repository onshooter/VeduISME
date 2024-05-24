package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.init.WarForEternityModItems;

public class CooldownprocProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double cooldown = 0;
		String COOOldown = "";
		if ((entity instanceof Player _plrCldRem0 ? _plrCldRem0.getCooldowns().getCooldownPercent(WarForEternityModItems.PYRO_STICK.get(), 0f) * 100 : 0) == 10) {
			COOOldown = "10% cooldown remaining";
		} else if ((entity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(WarForEternityModItems.PYRO_STICK.get(), 0f) * 100 : 0) == 5) {
			COOOldown = "5% cooldown remaining";
		} else if ((entity instanceof Player _plrCldRem2 ? _plrCldRem2.getCooldowns().getCooldownPercent(WarForEternityModItems.PYRO_STICK.get(), 0f) * 100 : 0) == 3) {
			COOOldown = "3% cooldown remaining";
		}
		return COOOldown;
	}
}
