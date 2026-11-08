package com.visualhamster.hud;

import com.visualhamster.VisualHamsterClient;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Formatting;

public class CustomHud implements HudRenderCallback {
	@Override
	public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player == null) return;

		PlayerEntity player = client.player;
		int width = client.getWindow().getScaledWidth();
		int height = client.getWindow().getScaledHeight();

		if (VisualHamsterClient.config.showHealthBar) {
			renderHealthInfo(drawContext, player, 10, height - 60);
		}

		if (VisualHamsterClient.config.showArmorBar) {
			renderArmorInfo(drawContext, player, 10, height - 40);
		}

		renderCoordinates(drawContext, player, 10, 10);
		renderFPS(drawContext, client, width - 80, 10);
	}

	private void renderHealthInfo(DrawContext ctx, PlayerEntity player, int x, int y) {
		float health = player.getHealth();
		float maxHealth = player.getMaxHealth();
		String healthText = String.format("HP: %.1f/%.1f", health, maxHealth);

		int color = health > maxHealth * 0.5f ? 0x55FF55 :
		            health > maxHealth * 0.25f ? 0xFFFF55 : 0xFF5555;

		ctx.drawTextWithShadow(
			MinecraftClient.getInstance().textRenderer,
			healthText, x, y, color
		);
	}

	private void renderArmorInfo(DrawContext ctx, PlayerEntity player, int x, int y) {
		int armor = player.getArmor();
		String armorText = "Armor: " + armor;
		ctx.drawTextWithShadow(
			MinecraftClient.getInstance().textRenderer,
			armorText, x, y, 0xAAAAAA
		);
	}

	private void renderCoordinates(DrawContext ctx, PlayerEntity player, int x, int y) {
		String coords = String.format("XYZ: %d %d %d",
			(int)player.getX(),
			(int)player.getY(),
			(int)player.getZ()
		);
		ctx.drawTextWithShadow(
			MinecraftClient.getInstance().textRenderer,
			coords, x, y, 0xFFFFFF
		);
	}

	private void renderFPS(DrawContext ctx, MinecraftClient client, int x, int y) {
		String fps = client.getCurrentFps() + " FPS";
		ctx.drawTextWithShadow(
			client.textRenderer,
			fps, x, y, 0xFFFF00
		);
	}
}
