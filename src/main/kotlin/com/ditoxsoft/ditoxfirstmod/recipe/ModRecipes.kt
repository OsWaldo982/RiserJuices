package com.ditoxsoft.ditoxfirstmod.recipe

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.crafting.RecipeSerializer

object ModRecipes {
    val LEMONADE_SQUEEZING_SERIALIZER: RecipeSerializer<LemonadeRecipe> = Registry.register(
        BuiltInRegistries.RECIPE_SERIALIZER,
        DitoxFirstMod.id("lemonade_squeezing"),
        LemonadeRecipe.SERIALIZER,
    )

    fun initialize() {
        DitoxFirstMod.LOGGER.info("Registrando recetas especiales de ${DitoxFirstMod.MOD_ID}.")
    }
}
