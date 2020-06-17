package draylar.soaringclouds;

import draylar.soaringclouds.config.SoaringCloudsConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class SoaringCloudsClient implements ClientModInitializer {

    public static final SoaringCloudsConfig CONFIG = AutoConfig.register(SoaringCloudsConfig.class, JanksonConfigSerializer::new).getConfig();

    @Override
    public void onInitializeClient() {

    }
}
