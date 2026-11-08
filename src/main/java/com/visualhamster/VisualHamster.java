package com.visualhamster;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisualHamster implements ModInitializer {
	public static final String MOD_ID = "visualhamster";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("VisualHamster mod initialized!");
	}
}
