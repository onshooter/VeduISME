package net.mcreator.warforeternity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.init.WarForEternityModItems;

public class SpiritfirehudDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean hud = false;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.SPIRITFIRE.get())) : false) {
			hud = true;
		} else {
			hud = false;
		}
		return hud;
	}
}
