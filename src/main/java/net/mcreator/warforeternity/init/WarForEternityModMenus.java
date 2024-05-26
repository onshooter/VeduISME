
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.warforeternity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.warforeternity.world.inventory.StartMenuMenu;
import net.mcreator.warforeternity.world.inventory.GrenadesMenu;
import net.mcreator.warforeternity.WarForEternityMod;

public class WarForEternityModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, WarForEternityMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<GrenadesMenu>> GRENADES = REGISTRY.register("grenades", () -> IMenuTypeExtension.create(GrenadesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StartMenuMenu>> START_MENU = REGISTRY.register("start_menu", () -> IMenuTypeExtension.create(StartMenuMenu::new));
}
