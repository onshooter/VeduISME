package net.mcreator.warforeternity.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import net.mcreator.warforeternity.WarForEternityMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WarForEternityModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, WarForEternityMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		WarForEternityMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.PyroStickPyro = original.PyroStickPyro;
			clone.AxeMode = original.AxeMode;
			clone.HammerMode = original.HammerMode;
			clone.SwordMode = original.SwordMode;
			clone.StickMode = original.StickMode;
			clone.AxeThrown = original.AxeThrown;
			clone.Backhit = original.Backhit;
			clone.lefthit = original.lefthit;
			clone.righthit = original.righthit;
			clone.shotgun = original.shotgun;
			clone.sniper = original.sniper;
			clone.rpg = original.rpg;
			clone.TutorialOnOf = original.TutorialOnOf;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean PyroStickPyro = false;
		public boolean AxeMode = false;
		public boolean HammerMode = false;
		public boolean SwordMode = false;
		public boolean StickMode = false;
		public boolean AxeThrown = false;
		public boolean Backhit = false;
		public boolean lefthit = false;
		public boolean righthit = false;
		public boolean shotgun = false;
		public boolean sniper = false;
		public boolean rpg = false;
		public boolean TutorialOnOf = false;

		@Override
		public CompoundTag serializeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("PyroStickPyro", PyroStickPyro);
			nbt.putBoolean("AxeMode", AxeMode);
			nbt.putBoolean("HammerMode", HammerMode);
			nbt.putBoolean("SwordMode", SwordMode);
			nbt.putBoolean("StickMode", StickMode);
			nbt.putBoolean("AxeThrown", AxeThrown);
			nbt.putBoolean("Backhit", Backhit);
			nbt.putBoolean("lefthit", lefthit);
			nbt.putBoolean("righthit", righthit);
			nbt.putBoolean("shotgun", shotgun);
			nbt.putBoolean("sniper", sniper);
			nbt.putBoolean("rpg", rpg);
			nbt.putBoolean("TutorialOnOf", TutorialOnOf);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			PyroStickPyro = nbt.getBoolean("PyroStickPyro");
			AxeMode = nbt.getBoolean("AxeMode");
			HammerMode = nbt.getBoolean("HammerMode");
			SwordMode = nbt.getBoolean("SwordMode");
			StickMode = nbt.getBoolean("StickMode");
			AxeThrown = nbt.getBoolean("AxeThrown");
			Backhit = nbt.getBoolean("Backhit");
			lefthit = nbt.getBoolean("lefthit");
			righthit = nbt.getBoolean("righthit");
			shotgun = nbt.getBoolean("shotgun");
			sniper = nbt.getBoolean("sniper");
			rpg = nbt.getBoolean("rpg");
			TutorialOnOf = nbt.getBoolean("TutorialOnOf");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(WarForEternityMod.MODID, "player_variables_sync");

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this(new PlayerVariables());
			this.data.deserializeNBT(buffer.readNbt());
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeNbt(data.serializeNBT());
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> Minecraft.getInstance().player.getData(PLAYER_VARIABLES).deserializeNBT(message.data.serializeNBT())).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
