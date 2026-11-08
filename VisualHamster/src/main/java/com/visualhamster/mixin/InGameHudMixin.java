package com.visualhamster.mixin;

import com.visualhamster.VisualHamsterClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(InGameHud.class)
public class InGameHudMixin {
	@ModifyVariable(
		method = "renderOverlay",
		at = @At("HEAD"),
		ordinal = 0,
		argsOnly = true
	)
	private float modifyFireHeight(float original) {
		if (VisualHamsterClient.config.lowFire) {
			return original * (VisualHamsterClient.config.fireHeight / 100.0f);
		}
		return original;
	}
}
