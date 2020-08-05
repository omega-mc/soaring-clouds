package draylar.soaringclouds.client;

import draylar.soaringclouds.SoaringCloudsClient;
import draylar.soaringclouds.config.ConfigUtils;
import net.minecraft.client.options.DoubleOption;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class CloudHeightOption extends DoubleOption {

    public CloudHeightOption() {
        super("cloudheight", 0, 255, 1, gameOptions -> {
            return (double) SoaringCloudsClient.CONFIG.cloudHeights.get("minecraft:overworld");
        }, (gameOptions, aDouble) -> {
            SoaringCloudsClient.CONFIG.cloudHeights.put("minecraft:overworld", (int) aDouble.doubleValue());
            ConfigUtils.serializeConfig();
        }, (gameOptions, doubleOption) -> {
            return new TranslatableText("soaring-clouds.overworldcloudheight").append(new LiteralText((int) doubleOption.get(gameOptions) + ""));
        });
    }
}
