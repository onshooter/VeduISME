package net.mcreator.warforeternity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.item.PyroStickItem;

public class PyroStickItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String COOOldown = "";
		if ((entity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) == 0) {
			if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true
					&& ((((PyroStickItem) itemstack.getItem()).animationprocedure).equals("STICK-AXE") || (((PyroStickItem) itemstack.getItem()).animationprocedure).equals("SWORD-AXE"))) {
				if (itemstack.getItem() instanceof PyroStickItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "SWORD");
			} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == true
					&& ((((PyroStickItem) itemstack.getItem()).animationprocedure).equals("SWORD") || (((PyroStickItem) itemstack.getItem()).animationprocedure).equals("SWORD"))) {
				if (itemstack.getItem() instanceof PyroStickItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "SWORD-AXE");
			} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == true
					&& ((((PyroStickItem) itemstack.getItem()).animationprocedure).equals("AXE-HAMMER") || (((PyroStickItem) itemstack.getItem()).animationprocedure).equals("STICK"))) {
				if (itemstack.getItem() instanceof PyroStickItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "STICK-AXE");
			} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true
					&& ((((PyroStickItem) itemstack.getItem()).animationprocedure).equals("STICK-AXE") || (((PyroStickItem) itemstack.getItem()).animationprocedure).equals("SWORD-AXE"))) {
				if (itemstack.getItem() instanceof PyroStickItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "AXE-HAMMER");
			} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode == true
					&& ((((PyroStickItem) itemstack.getItem()).animationprocedure).equals("AXE-HAMMER") || (((PyroStickItem) itemstack.getItem()).animationprocedure).equals("AXE-STICK"))) {
				if (itemstack.getItem() instanceof PyroStickItem)
					itemstack.getOrCreateTag().putString("geckoAnim", "AXE-STICK");
			}
		}
	}
}
