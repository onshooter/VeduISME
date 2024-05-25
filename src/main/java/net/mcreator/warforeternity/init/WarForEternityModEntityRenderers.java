
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.warforeternity.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WarForEternityModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(WarForEternityModEntities.RPGBULLETPROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(WarForEternityModEntities.SHOTGUN_BULLETPROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(WarForEternityModEntities.SNIPER_BULLETPROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(WarForEternityModEntities.GRENADEPROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(WarForEternityModEntities.ANIMATED.get(), ThrownItemRenderer::new);
	}
}
