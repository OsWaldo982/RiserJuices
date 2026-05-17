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

    val GRAPE_JUICE: JuiceRecipeDefinition = bottledJuice(ModItems.GRAPE_JUICE, ModItems.GRAPES)
    val WINE: JuiceRecipeDefinition = JuiceRecipeDefinition(
        output = ModItems.WINE,
        fruit = ModItems.GRAPES,
        fruitCount = 3,
        requiredSingleStackItems = listOf(Items.SUGAR, Items.GLASS_BOTTLE),
    )
    val ORANGE_JUICE: JuiceRecipeDefinition = bottledJuice(ModItems.ORANGE_JUICE, ModItems.ORANGE)
    val CIDER: JuiceRecipeDefinition = bottledJuice(ModItems.CIDER, ModItems.GREEN_APPLE)
    val COCONUT_WATER: JuiceRecipeDefinition = bottledJuice(ModItems.COCONUT_WATER, ModItems.COCONUT)
    val TROPICAL_JUICE: JuiceRecipeDefinition = JuiceRecipeDefinition(
        output = ModItems.TROPICAL_JUICE,
        fruit = ModItems.PINEAPPLE,
        fruitCount = 2,
        requiredSingleStackItems = listOf(ModItems.MANGO, Items.SUGAR, Items.GLASS_BOTTLE),
    )
    val STRAWBERRY_SMOOTHIE: JuiceRecipeDefinition = smoothie(ModItems.STRAWBERRY_SMOOTHIE, ModItems.STRAWBERRY)
    val BLUEBERRY_SMOOTHIE: JuiceRecipeDefinition = smoothie(ModItems.BLUEBERRY_SMOOTHIE, ModItems.BLUEBERRIES)
    val BANANA_SMOOTHIE: JuiceRecipeDefinition = smoothie(ModItems.BANANA_SMOOTHIE, ModItems.BANANA)
    val CHERRY_JUICE: JuiceRecipeDefinition = bottledJuice(ModItems.CHERRY_JUICE, ModItems.CHERRIES)
    val MANGO_JUICE: JuiceRecipeDefinition = bottledJuice(ModItems.MANGO_JUICE, ModItems.MANGO)

    private val all: List<JuiceRecipeDefinition> = listOf(
        LEMONADE,
        GRAPE_JUICE,
        WINE,
        ORANGE_JUICE,
        CIDER,
        COCONUT_WATER,
        TROPICAL_JUICE,
        STRAWBERRY_SMOOTHIE,
        BLUEBERRY_SMOOTHIE,
        BANANA_SMOOTHIE,
        CHERRY_JUICE,
        MANGO_JUICE,
    )

    fun byOutput(stack: ItemStack): JuiceRecipeDefinition? =
        all.firstOrNull { stack.`is`(it.output) }

    private fun bottledJuice(output: Item, fruit: Item): JuiceRecipeDefinition = JuiceRecipeDefinition(
        output = output,
        fruit = fruit,
        fruitCount = 2,
        requiredSingleStackItems = listOf(Items.SUGAR, Items.GLASS_BOTTLE),
    )

    private fun smoothie(output: Item, fruit: Item): JuiceRecipeDefinition = JuiceRecipeDefinition(
        output = output,
        fruit = fruit,
        fruitCount = 2,
        requiredSingleStackItems = listOf(Items.MILK_BUCKET, Items.SUGAR),
    )
}
