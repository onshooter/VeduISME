
package net.mcreator.warforeternity.item.inventory;

import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;

import net.mcreator.warforeternity.init.WarForEternityModItems;
import net.mcreator.warforeternity.client.gui.GrenadesScreen;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class SpiritfireInventoryCapability extends ItemStackHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == WarForEternityModItems.SPIRITFIRE.get()) {
			if (Minecraft.getInstance().screen instanceof GrenadesScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public SpiritfireInventoryCapability() {
		super(4);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != WarForEternityModItems.SPIRITFIRE.get();
	}

	@Override
	public void setSize(int size) {
	}
}
