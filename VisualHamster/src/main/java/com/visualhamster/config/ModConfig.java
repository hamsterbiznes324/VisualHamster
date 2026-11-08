package com.visualhamster.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
	// Fire overlay
	public boolean lowFire = true;
	public int fireHeight = 50; // percentage

	// Fullbright
	public boolean fullbright = true;

	// Sky
	public boolean customSky = true;
	public int skyColor = 0x87CEEB; // light blue

	// Block ESP
	public boolean blockESP = true;
	public float espLineWidth = 2.0f;

	// PvP features
	public boolean showHitboxes = false;
	public boolean showHealthBar = true;
	public boolean showArmorBar = true;

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final File CONFIG_FILE = new File(
		FabricLoader.getInstance().getConfigDir().toFile(),
		"visualhamster.json"
	);

	public static ModConfig load() {
		if (CONFIG_FILE.exists()) {
			try (FileReader reader = new FileReader(CONFIG_FILE)) {
				return GSON.fromJson(reader, ModConfig.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ModConfig config = new ModConfig();
		config.save();
		return config;
	}

	public void save() {
		try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
			GSON.toJson(this, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
