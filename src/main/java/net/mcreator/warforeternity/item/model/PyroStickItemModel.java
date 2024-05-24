package net.mcreator.warforeternity.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.warforeternity.item.PyroStickItem;

public class PyroStickItemModel extends GeoModel<PyroStickItem> {
	@Override
	public ResourceLocation getAnimationResource(PyroStickItem animatable) {
		return new ResourceLocation("war_for_eternity", "animations/stick.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PyroStickItem animatable) {
		return new ResourceLocation("war_for_eternity", "geo/stick.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PyroStickItem animatable) {
		return new ResourceLocation("war_for_eternity", "textures/item/rtm.png");
	}
}
