package com.ditoxsoft.ditoxfirstmod.world

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature

object ModWorldGeneration {
    val LEMON_TREE_CONFIGURED_KEY: ResourceKey<ConfiguredFeature<*, *>> = ResourceKey.create(
        Registries.CONFIGURED_FEATURE,
        DitoxFirstMod.id("lemon_tree"),
    )

    private val LEMON_TREE_PLACED_KEY: ResourceKey<PlacedFeature> = ResourceKey.create(
        Registries.PLACED_FEATURE,
        DitoxFirstMod.id("lemon_tree"),
    )

    fun initialize() {
        val citrusBiomes = BiomeSelectors.tag(BiomeTags.IS_FOREST)
            .or(BiomeSelectors.tag(BiomeTags.IS_JUNGLE))
            .or(
                BiomeSelectors.includeByKey(
                    Biomes.PLAINS,
                    Biomes.SUNFLOWER_PLAINS,
                    Biomes.MEADOW,
                ),
            )

        BiomeModifications.addFeature(
            citrusBiomes,
            GenerationStep.Decoration.VEGETAL_DECORATION,
            LEMON_TREE_PLACED_KEY,
        )

        DitoxFirstMod.LOGGER.info("Generacion natural de limoneros registrada.")
    }
}
