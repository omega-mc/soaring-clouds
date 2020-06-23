package draylar.soaringclouds.mixin;

import draylar.soaringclouds.SoaringCloudsClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow private ClientWorld world;

    @Redirect(
            method = "renderClouds(Lnet/minecraft/client/util/math/MatrixStack;FDDD)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/SkyProperties;getCloudsHeight()F")
    )
    private float getCloudHeight(SkyProperties skyProperties) {
        Identifier thisDimensionID =  world.getRegistryKey().getValue();

        if(thisDimensionID != null) {
            String stringID = thisDimensionID.toString();

            if(SoaringCloudsClient.CONFIG.cloudHeights.containsKey(stringID)) {
                return SoaringCloudsClient.CONFIG.cloudHeights.get(stringID);
            }
        }

        return skyProperties.getCloudsHeight();
    }
}
