
package net.mcreator.warforeternity.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.warforeternity.procedures.SpiritfirehudDisplayOverlayIngameProcedure;
import net.mcreator.warforeternity.procedures.SpiritfireSniperDCProcedure;
import net.mcreator.warforeternity.procedures.SpiritfireShotgunDCProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SpiritfirehudOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (SpiritfirehudDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/rpgb.png"), w - 61, h - 115, 0, 0, 64, 64, 64, 64);

			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/c.png"), w - 142, h - -55, 0, 0, 64, 64, 64, 64);

			if (SpiritfireSniperDCProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/sniper.png"), w - 115, h - 61, 0, 0, 64, 64, 64, 64);
			}
			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/v.png"), w - 61, h - 61, 0, 0, 64, 64, 64, 64);

			if (SpiritfireShotgunDCProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/shotgun.png"), w - 61, h - 61, 0, 0, 64, 64, 64, 64);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
