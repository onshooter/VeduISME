
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.warforeternity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.warforeternity.item.SpiritfireItem;
import net.mcreator.warforeternity.item.SniperbulletItem;
import net.mcreator.warforeternity.item.ShotgunbulletItem;
import net.mcreator.warforeternity.item.RpgbulletItem;
import net.mcreator.warforeternity.item.PyroStickItem;
import net.mcreator.warforeternity.item.GrenadeItem;
import net.mcreator.warforeternity.WarForEternityMod;

public class WarForEternityModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, WarForEternityMod.MODID);
	public static final DeferredHolder<Item, Item> PYRO_STICK = REGISTRY.register("pyro_stick", () -> new PyroStickItem());
	public static final DeferredHolder<Item, Item> RPGBULLET = REGISTRY.register("rpgbullet", () -> new RpgbulletItem());
	public static final DeferredHolder<Item, Item> SHOTGUNBULLET = REGISTRY.register("shotgunbullet", () -> new ShotgunbulletItem());
	public static final DeferredHolder<Item, Item> SNIPERBULLET = REGISTRY.register("sniperbullet", () -> new SniperbulletItem());
	public static final DeferredHolder<Item, Item> GRENADE = REGISTRY.register("grenade", () -> new GrenadeItem());
	public static final DeferredHolder<Item, Item> SPIRITFIRE = REGISTRY.register("spiritfire", () -> new SpiritfireItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}
}
