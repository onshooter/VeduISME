package net.mcreator.warforeternity.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.item.SpiritfireItem;
import net.mcreator.warforeternity.init.WarForEternityModEntities;
import net.mcreator.warforeternity.entity.SniperBulletprojEntity;
import net.mcreator.warforeternity.entity.ShotgunBulletprojEntity;
import net.mcreator.warforeternity.entity.RpgbulletprojEntity;

public class SpiritfireRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).shotgun == true) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new ShotgunBulletprojEntity(WarForEternityModEntities.SHOTGUN_BULLETPROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setSecondsOnFire(100);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 25, 1);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (itemstack.getItem() instanceof SpiritfireItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "shotgunshooting");
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).sniper == true) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new SniperBulletprojEntity(WarForEternityModEntities.SNIPER_BULLETPROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							entityToSpawn.setSecondsOnFire(100);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 20, 1, (byte) 10);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (itemstack.getItem() instanceof SpiritfireItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "shotgunshooting");
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg == true) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new RpgbulletprojEntity(WarForEternityModEntities.RPGBULLETPROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setSecondsOnFire(100);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 25, 15);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 15, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (itemstack.getItem() instanceof SpiritfireItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "shotgunshooting");
		}
	}
}
