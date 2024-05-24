
package net.mcreator.warforeternity.client.screens;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.warforeternity.procedures.RighthitProcedure;
import net.mcreator.warforeternity.procedures.LefthitProcedure;
import net.mcreator.warforeternity.procedures.EntityproviderProcedure;
import net.mcreator.warforeternity.procedures.Backhit2Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CrosshairOverlay {
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
		if (true) {
			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/crosshair2.png"), w / 2 + -15, h / 2 + -13, 0, 0, 32, 32, 32, 32);

			if (Backhit2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/backhit2.png"), w / 2 + -30, h / 2 + -24, 0, 0, 64, 64, 64, 64);
			}
			if (LefthitProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/lefthit2.png"), w / 2 + -40, h / 2 + -26, 0, 0, 64, 64, 64, 64);
			}
			if (RighthitProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/righthit2.png"), w / 2 + -24, h / 2 + -26, 0, 0, 64, 64, 64, 64);
			}
			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/health1.png"), w - 129, 1, 0, 0, 128, 128, 128, 128);

			event.getGuiGraphics().blit(new ResourceLocation("war_for_eternity:textures/screens/stamina.png"), 0, 0, 0, 0, 128, 128, 128, 128);

			if (EntityproviderProcedure.execute(entity) instanceof LivingEntity livingEntity) {
				renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), 11, h - 0, 30, 0f, 0, livingEntity);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

	private static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
