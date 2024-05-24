
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.warforeternity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.warforeternity.WarForEternityMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WarForEternityModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WarForEternityMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(WarForEternityModItems.PYRO_STICK.get());
			tabData.accept(WarForEternityModItems.RPGBULLET.get());
			tabData.accept(WarForEternityModItems.SHOTGUNBULLET.get());
			tabData.accept(WarForEternityModItems.SNIPERBULLET.get());
			tabData.accept(WarForEternityModItems.GRENADE.get());
			tabData.accept(WarForEternityModItems.SPIRITFIRE.get());
		}
	}
}
