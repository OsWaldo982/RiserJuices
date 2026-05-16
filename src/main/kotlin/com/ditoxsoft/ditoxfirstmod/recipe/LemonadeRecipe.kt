package com.ditoxsoft.ditoxfirstmod.recipe

import com.mojang.serialization.MapCodec
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.CraftingBookCategory
import net.minecraft.world.item.crafting.CraftingInput
import net.minecraft.world.item.crafting.CustomRecipe
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.Level

class LemonadeRecipe : CustomRecipe() {
    override fun matches(input: CraftingInput, level: Level): Boolean =
        ModJuiceRecipes.LEMONADE.matches(input)

    override fun assemble(input: CraftingInput): ItemStack = ItemStack(ModJuiceRecipes.LEMONADE.output)

    override fun getSerializer(): RecipeSerializer<out CustomRecipe> = SERIALIZER

    override fun category(): CraftingBookCategory = CraftingBookCategory.MISC

    companion object {
        val MAP_CODEC: MapCodec<LemonadeRecipe> = MapCodec.unit(::LemonadeRecipe)
        val STREAM_CODEC: StreamCodec<RegistryFriendlyByteBuf, LemonadeRecipe> = StreamCodec.unit(LemonadeRecipe())
        val SERIALIZER: RecipeSerializer<LemonadeRecipe> = RecipeSerializer(MAP_CODEC, STREAM_CODEC)
    }
}
