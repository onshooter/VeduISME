
package net.mcreator.warforeternity.entity;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.warforeternity.procedures.RpgbulletprojProjectileHitsBlockProcedure;
import net.mcreator.warforeternity.init.WarForEternityModItems;
import net.mcreator.warforeternity.init.WarForEternityModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class RpgbulletprojEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(WarForEternityModItems.RPGBULLET.get());

	public RpgbulletprojEntity(EntityType<? extends RpgbulletprojEntity> type, Level world) {
		super(type, world, PROJECTILE_ITEM);
	}

	public RpgbulletprojEntity(EntityType<? extends RpgbulletprojEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world, PROJECTILE_ITEM);
	}

	public RpgbulletprojEntity(EntityType<? extends RpgbulletprojEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world, PROJECTILE_ITEM);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		RpgbulletprojProjectileHitsBlockProcedure.execute(this.level(), this);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		RpgbulletprojProjectileHitsBlockProcedure.execute(this.level(), this);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static RpgbulletprojEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 15f, 25, 5);
	}

	public static RpgbulletprojEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		RpgbulletprojEntity entityarrow = new RpgbulletprojEntity(WarForEternityModEntities.RPGBULLETPROJ.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static RpgbulletprojEntity shoot(LivingEntity entity, LivingEntity target) {
		RpgbulletprojEntity entityarrow = new RpgbulletprojEntity(WarForEternityModEntities.RPGBULLETPROJ.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 15f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(25);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
