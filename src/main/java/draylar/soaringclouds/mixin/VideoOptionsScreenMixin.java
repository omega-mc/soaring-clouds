package draylar.soaringclouds.mixin;

import draylar.soaringclouds.client.CloudHeightOption;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin {

    @Shadow private ButtonListWidget list;
    @Unique private static final CloudHeightOption CLOUDS = new CloudHeightOption();

    @Inject(
            method = "init",
            at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z")
    )
    private void addOption(CallbackInfo ci) {
        this.list.addSingleOptionEntry(CLOUDS);
    }
}
