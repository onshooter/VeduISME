
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.warforeternity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.warforeternity.entity.SniperBulletprojEntity;
import net.mcreator.warforeternity.entity.ShotgunBulletprojEntity;
import net.mcreator.warforeternity.entity.RpgbulletprojEntity;
import net.mcreator.warforeternity.entity.GrenadeprojEntity;
import net.mcreator.warforeternity.entity.AnimatedEntity;
import net.mcreator.warforeternity.WarForEternityMod;

public class WarForEternityModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, WarForEternityMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<RpgbulletprojEntity>> RPGBULLETPROJ = register("rpgbulletproj",
			EntityType.Builder.<RpgbulletprojEntity>of(RpgbulletprojEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShotgunBulletprojEntity>> SHOTGUN_BULLETPROJ = register("shotgun_bulletproj",
			EntityType.Builder.<ShotgunBulletprojEntity>of(ShotgunBulletprojEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SniperBulletprojEntity>> SNIPER_BULLETPROJ = register("sniper_bulletproj",
			EntityType.Builder.<SniperBulletprojEntity>of(SniperBulletprojEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GrenadeprojEntity>> GRENADEPROJ = register("grenadeproj",
			EntityType.Builder.<GrenadeprojEntity>of(GrenadeprojEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AnimatedEntity>> ANIMATED = register("animated",
			EntityType.Builder.<AnimatedEntity>of(AnimatedEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
