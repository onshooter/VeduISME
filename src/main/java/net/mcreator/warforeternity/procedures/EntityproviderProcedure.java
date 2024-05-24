package net.mcreator.warforeternity.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class EntityproviderProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		Entity nearestenenmy = null;
		nearestenenmy = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		return nearestenenmy;
	}
}
