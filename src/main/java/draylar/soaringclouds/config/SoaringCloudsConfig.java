package draylar.soaringclouds.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;

import java.util.HashMap;
import java.util.Map;

@Config(name = "soaring-clouds")
public class SoaringCloudsConfig implements ConfigData {

    @Comment(value = "Configures cloud height for each dimension type.\nOverworld: minecraft:overworld\nEnd: minecraft:the_end\nNether: minecraft:the_nether")
    public Map<String, Integer> cloudHeights = create();

    public static Map<String, Integer> create() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(Registry.DIMENSION_TYPE.getId(DimensionType.OVERWORLD).toString(), 200);
        return map;
    }
}
