package com.visualhamster.mixin;

import com.visualhamster.VisualHamsterClient;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
	@Inject(method = "getBrightness", at = @At("RETURN"), cancellable = true)
	private static void onGetBrightness(CallbackInfoReturnable<Float> cir) {
		if (VisualHamsterClient.config.fullbright) {
			cir.setReturnValue(1.0f);
		}
	}
}
