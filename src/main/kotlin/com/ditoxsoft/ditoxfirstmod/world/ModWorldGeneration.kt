package com.ditoxsoft.ditoxfirstmod.world

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import java.util.function.Predicate

object ModWorldGeneration {
    val LEMON_TREE_CONFIGURED_KEY: ResourceKey<ConfiguredFeature<*, *>> = ResourceKey.create(
        Registries.CONFIGURED_FEATURE,
        DitoxFirstMod.id("lemon_tree"),
    )

    val ORANGE_TREE_CONFIGURED_KEY = configuredKey("orange_tree")
    val GREEN_APPLE_TREE_CONFIGURED_KEY = configuredKey("green_apple_tree")
    val COCONUT_PALM_TREE_CONFIGURED_KEY = configuredKey("coconut_palm_tree")
    val BANANA_TREE_CONFIGURED_KEY = configuredKey("banana_tree")
    val CHERRY_TREE_CONFIGURED_KEY = configuredKey("cherry_tree")
    val MANGO_TREE_CONFIGURED_KEY = configuredKey("mango_tree")

    private val LEMON_TREE_PLACED_KEY: ResourceKey<PlacedFeature> = ResourceKey.create(
        Registries.PLACED_FEATURE,
        DitoxFirstMod.id("lemon_tree"),
    )

    private val GRAPE_VINE_PLACED_KEY = placedKey("grape_vine_patch")
    private val PINEAPPLE_PLANT_PLACED_KEY = placedKey("pineapple_plant_patch")
    private val STRAWBERRY_BUSH_PLACED_KEY = placedKey("strawberry_bush_patch")
    private val BLUEBERRY_BUSH_PLACED_KEY = placedKey("blueberry_bush_patch")
    private val ORANGE_TREE_PLACED_KEY = placedKey("orange_tree")
    private val GREEN_APPLE_TREE_PLACED_KEY = placedKey("green_apple_tree")
    private val COCONUT_PALM_TREE_PLACED_KEY = placedKey("coconut_palm_tree")
    private val BANANA_TREE_PLACED_KEY = placedKey("banana_tree")
    private val CHERRY_TREE_PLACED_KEY = placedKey("cherry_tree")
    private val MANGO_TREE_PLACED_KEY = placedKey("mango_tree")

    fun initialize() {
        val forests = BiomeSelectors.tag(BiomeTags.IS_FOREST)
        val jungles = BiomeSelectors.tag(BiomeTags.IS_JUNGLE)
        val savannas = BiomeSelectors.tag(BiomeTags.IS_SAVANNA)
        val taigas = BiomeSelectors.tag(BiomeTags.IS_TAIGA)
        val beaches = BiomeSelectors.tag(BiomeTags.IS_BEACH)
        val plainsAndMeadows = BiomeSelectors.includeByKey(
            Biomes.PLAINS,
            Biomes.SUNFLOWER_PLAINS,
            Biomes.MEADOW,
        )

        val citrusBiomes = forests
            .or(jungles)
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

        addFruitTree(ORANGE_TREE_PLACED_KEY, forests.or(savannas).or(plainsAndMeadows))
        addFruitTree(GREEN_APPLE_TREE_PLACED_KEY, forests.or(plainsAndMeadows))
        addFruitTree(COCONUT_PALM_TREE_PLACED_KEY, beaches.or(BiomeSelectors.includeByKey(Biomes.DESERT)))
        addFruitTree(BANANA_TREE_PLACED_KEY, jungles)
        addFruitTree(CHERRY_TREE_PLACED_KEY, BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST, Biomes.MEADOW))
        addFruitTree(MANGO_TREE_PLACED_KEY, jungles.or(savannas))

        addFruitPatch(GRAPE_VINE_PLACED_KEY, forests.or(plainsAndMeadows))
        addFruitPatch(PINEAPPLE_PLANT_PLACED_KEY, jungles.or(beaches).or(savannas))
        addFruitPatch(STRAWBERRY_BUSH_PLACED_KEY, plainsAndMeadows.or(forests))
        addFruitPatch(BLUEBERRY_BUSH_PLACED_KEY, taigas.or(forests))

        DitoxFirstMod.LOGGER.info("Generacion natural de frutas registrada.")
    }

    private fun addFruitTree(
        placedKey: ResourceKey<PlacedFeature>,
        biomes: Predicate<BiomeSelectionContext>,
    ) {
        BiomeModifications.addFeature(
            biomes,
            GenerationStep.Decoration.VEGETAL_DECORATION,
            placedKey,
        )
    }

    private fun addFruitPatch(
        placedKey: ResourceKey<PlacedFeature>,
        biomes: Predicate<BiomeSelectionContext>,
    ) {
        BiomeModifications.addFeature(
            biomes,
            GenerationStep.Decoration.VEGETAL_DECORATION,
            placedKey,
        )
    }

    private fun placedKey(name: String): ResourceKey<PlacedFeature> = ResourceKey.create(
        Registries.PLACED_FEATURE,
        DitoxFirstMod.id(name),
    )

    private fun configuredKey(name: String): ResourceKey<ConfiguredFeature<*, *>> = ResourceKey.create(
        Registries.CONFIGURED_FEATURE,
        DitoxFirstMod.id(name),
    )
}
