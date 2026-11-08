package com.visualhamster;

import com.visualhamster.config.ModConfig;
import com.visualhamster.hud.CustomHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class VisualHamsterClient implements ClientModInitializer {
	public static ModConfig config;

	@Override
	public void onInitializeClient() {
		config = ModConfig.load();

		HudRenderCallback.EVENT.register(new CustomHud());

		VisualHamster.LOGGER.info("VisualHamster client initialized!");
	}
}
