package net.fabricmc.example.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class Names {
    @Shadow @Nullable private String splashText;

    @Inject(at = @At("TAIL"), method = "init()V")
    private void init(CallbackInfo info) {
        splashText = "For our lord and saviour Graham!";
    }
}
