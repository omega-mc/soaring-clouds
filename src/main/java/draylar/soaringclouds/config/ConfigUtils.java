package draylar.soaringclouds.config;

import draylar.soaringclouds.SoaringCloudsClient;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigManager;
import me.sargunvohra.mcmods.autoconfig1u.serializer.ConfigSerializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ConfigUtils {

    private ConfigUtils() {
        // NO-OP
    }

    public static void serializeConfig() {
        try {
            ((ConfigManager<SoaringCloudsConfig>) AutoConfig.getConfigHolder(SoaringCloudsConfig.class)).getSerializer().serialize(SoaringCloudsClient.CONFIG);
        } catch (ConfigSerializer.SerializationException serializeException) {
            SoaringCloudsClient.LOGGER.error("Failed to serialize " + SoaringCloudsClient.LOGGER.getName() + "'s config!", serializeException);
        }
    }
}
