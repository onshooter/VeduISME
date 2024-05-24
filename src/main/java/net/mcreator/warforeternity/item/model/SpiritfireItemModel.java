package net.mcreator.warforeternity.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.warforeternity.item.SpiritfireItem;

public class SpiritfireItemModel extends GeoModel<SpiritfireItem> {
	@Override
	public ResourceLocation getAnimationResource(SpiritfireItem animatable) {
		return new ResourceLocation("war_for_eternity", "animations/spiritfire.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpiritfireItem animatable) {
		return new ResourceLocation("war_for_eternity", "geo/spiritfire.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpiritfireItem animatable) {
		return new ResourceLocation("war_for_eternity", "textures/item/texture.png");
	}
}
