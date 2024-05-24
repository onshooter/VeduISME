
package net.mcreator.warforeternity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SniperbulletItem extends Item {
	public SniperbulletItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
