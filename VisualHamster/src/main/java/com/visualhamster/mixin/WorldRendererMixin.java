package com.visualhamster.mixin;

import com.visualhamster.VisualHamsterClient;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
	@Inject(method = "render", at = @At("RETURN"))
	private void onRender(CallbackInfo ci) {
		if (VisualHamsterClient.config.showHitboxes) {
			// Custom hitbox rendering would go here
		}
	}
}
