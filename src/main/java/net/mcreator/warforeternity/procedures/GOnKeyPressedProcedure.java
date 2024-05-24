package net.mcreator.warforeternity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.warforeternity.world.inventory.GrenadesMenu;

import io.netty.buffer.Unpooled;

public class GOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Grenades");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new GrenadesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}
