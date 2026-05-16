package com.ditoxsoft.ditoxfirstmod

import com.ditoxsoft.ditoxfirstmod.block.ModBlocks
import com.ditoxsoft.ditoxfirstmod.entity.ModEntityTypes
import com.ditoxsoft.ditoxfirstmod.item.ModItemGroups
import com.ditoxsoft.ditoxfirstmod.item.ModItems
import com.ditoxsoft.ditoxfirstmod.recipe.ModRecipes
import com.ditoxsoft.ditoxfirstmod.world.ModWorldGeneration
import net.fabricmc.api.ModInitializer
import net.minecraft.resources.Identifier
import org.slf4j.LoggerFactory

object DitoxFirstMod : ModInitializer {
    const val MOD_ID = "ditox_first_mod"

    val LOGGER = LoggerFactory.getLogger("RiserJuices")

    fun id(path: String): Identifier = Identifier.fromNamespaceAndPath(MOD_ID, path)

    override fun onInitialize() {
        ModRecipes.initialize()
        ModEntityTypes.initialize()
        ModItems.initialize()
        ModBlocks.initialize()
        ModItemGroups.initialize()
        ModWorldGeneration.initialize()

        LOGGER.info("RiserJuices cargo correctamente con Kotlin y Fabric.")
    }
}
