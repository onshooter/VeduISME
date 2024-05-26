package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HealthprocProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String health = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 20) {
			health = "%100";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 19) {
			health = "%95";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 20) {
			health = "%90";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 18) {
			health = "%85";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 17) {
			health = "%80";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 16) {
			health = "%75";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 15) {
			health = "%70";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 14) {
			health = "%65";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 13) {
			health = "%60";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 12) {
			health = "%55";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 11) {
			health = "%50";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 10) {
			health = "%45";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 9) {
			health = "%40";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 8) {
			health = "%35";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 7) {
			health = "%30";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 6) {
			health = "%25";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 5) {
			health = "%25";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 4) {
			health = "%20";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 3) {
			health = "%15";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 2) {
			health = "%10";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 1) {
			health = "%5";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 0) {
			health = "%0";
		}
		return health;
	}
}
