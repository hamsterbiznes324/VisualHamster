package com.visualhamster.mixin;

import com.visualhamster.VisualHamsterClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class FireOverlayMixin {
	@Inject(method = "renderFireOverlay", at = @At("HEAD"), cancellable = true)
	private void onRenderFireOverlay(CallbackInfo ci) {
		if (VisualHamsterClient.config.lowFire && VisualHamsterClient.config.fireHeight < 10) {
			ci.cancel();
		}
	}
}
