package net.mcreator.warforeternity.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.init.WarForEternityModItems;
import net.mcreator.warforeternity.init.WarForEternityModEntities;
import net.mcreator.warforeternity.entity.RpgbulletprojEntity;

public class XOnKeyPressedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == true && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false) == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.HammerMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false) == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.SwordMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false) == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 17, false, false));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(WarForEternityModItems.PYRO_STICK.get(), 300);
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode;
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode == true
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false) == true) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.StickMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = true;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode;
		} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.SPIRITFIRE.get())) : false) == true) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new RpgbulletprojEntity(WarForEternityModEntities.RPGBULLETPROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 15, 25, (byte) 5);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.rpg = false;
				_vars.syncPlayerVariables(entity);
			}
			return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg;
		}
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).sniper
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).shotgun;
	}
}
