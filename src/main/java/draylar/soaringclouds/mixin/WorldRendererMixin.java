package draylar.soaringclouds.mixin;

import draylar.soaringclouds.SoaringCloudsClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Redirect(
            method = "renderClouds(Lnet/minecraft/client/util/math/MatrixStack;FDDD)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/dimension/Dimension;getCloudHeight()F")
    )
    private float getCloudHeight(Dimension dimension) {
        Identifier thisDimensionID = Registry.DIMENSION_TYPE.getId(dimension.getType());

        if(thisDimensionID != null) {
            String stringID = thisDimensionID.toString();

            if(SoaringCloudsClient.CONFIG.cloudHeights.containsKey(stringID)) {
                return SoaringCloudsClient.CONFIG.cloudHeights.get(stringID);
            }
        }

        return dimension.getCloudHeight();
    }
}
