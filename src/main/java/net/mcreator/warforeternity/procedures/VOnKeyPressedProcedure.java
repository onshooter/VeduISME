package net.mcreator.warforeternity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.warforeternity.network.WarForEternityModVariables;
import net.mcreator.warforeternity.init.WarForEternityModItems;
import net.mcreator.warforeternity.init.WarForEternityModEntities;
import net.mcreator.warforeternity.entity.AnimatedEntity;

public class VOnKeyPressedProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode == true && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false)) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new AnimatedEntity(WarForEternityModEntities.ANIMATED.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 17, 1);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 15, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode == true && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false)) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.AxeMode = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.StickMode = true;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode == true && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.PYRO_STICK.get())) : false)) {
			(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CRAMMING)), 25);
		} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WarForEternityModItems.SPIRITFIRE.get())) : false) {
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.rpg = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.sniper = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				WarForEternityModVariables.PlayerVariables _vars = entity.getData(WarForEternityModVariables.PLAYER_VARIABLES);
				_vars.shotgun = true;
				_vars.syncPlayerVariables(entity);
			}
		}
		return entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).HammerMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).SwordMode
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).StickMode && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).AxeThrown && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).shotgun
				&& entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).sniper && entity.getData(WarForEternityModVariables.PLAYER_VARIABLES).rpg;
	}
}
