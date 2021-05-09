package dev.anhcraft.yumn.biomes.land;

import dev.anhcraft.yumn.generators.Context;
import dev.anhcraft.yumn.generators.WorldGenerator;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class OakForest extends LandBiomeT1 {
    public OakForest() {
        super(Biome.FOREST, 28, 1000);
    }

    @Override
    public void generate(Context context, int localX, int localZ, double noise) {
        WorldGenerator gen = context.getWorldGenerator();
        if (gen.getHeight(noise) <= gen.WATER_LEVEL) {
            super.generate(context, localX, localZ, noise);
        } else {
            context.newLayerBuilder().at(localX, localZ)
                    .to(gen.getHeight(noise) - 1).is(Material.STONE)
                    .up(1).is(Material.GRASS_BLOCK);
        }
    }
}
