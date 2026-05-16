package com.ditoxsoft.ditoxfirstmod.recipe

import com.ditoxsoft.ditoxfirstmod.item.ModItems
import net.minecraft.world.inventory.CraftingContainer
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.CraftingInput
import kotlin.math.min

data class JuiceRecipeDefinition(
    val output: Item,
    val fruit: Item,
    val fruitCount: Int,
    val requiredSingleStackItems: List<Item>,
) {
    fun matches(input: CraftingInput): Boolean {
        var fruitTotal = 0
        val remainingRequiredStacks = requiredSingleStackItems
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        for (index in 0 until input.size()) {
            val stack = input.getItem(index)

            if (stack.isEmpty) {
                continue
            }

            if (stack.`is`(fruit)) {
                fruitTotal += stack.count
                continue
            }

            val requiredStacks = remainingRequiredStacks[stack.item] ?: return false
            if (requiredStacks <= 0) {
                return false
            }
            remainingRequiredStacks[stack.item] = requiredStacks - 1
        }

        return fruitTotal >= fruitCount && remainingRequiredStacks.values.all { it == 0 }
    }

    fun consumeStackedFruitRemainder(craftSlots: CraftingContainer) {
        var remainingFruitToConsume = fruitCount - 1

        for (slot in 0 until craftSlots.containerSize) {
            if (remainingFruitToConsume <= 0) {
                return
            }

            val ingredient = craftSlots.getItem(slot)
            if (ingredient.`is`(fruit)) {
                val amount = min(remainingFruitToConsume, ingredient.count)
                craftSlots.removeItem(slot, amount)
                remainingFruitToConsume -= amount
            }
        }
    }
}

object ModJuiceRecipes {
    val LEMONADE: JuiceRecipeDefinition = JuiceRecipeDefinition(
        output = ModItems.LEMONADE,
        fruit = ModItems.LEMON,
        fruitCount = 2,
        requiredSingleStackItems = listOf(Items.SUGAR, Items.GLASS_BOTTLE),
    )

    private val all: List<JuiceRecipeDefinition> = listOf(LEMONADE)

    fun byOutput(stack: ItemStack): JuiceRecipeDefinition? =
        all.firstOrNull { stack.`is`(it.output) }
}
