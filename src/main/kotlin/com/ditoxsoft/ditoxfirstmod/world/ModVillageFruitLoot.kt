package com.ditoxsoft.ditoxfirstmod.world

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.block.ModBlocks
import com.ditoxsoft.ditoxfirstmod.item.ModItems
import net.fabricmc.fabric.api.loot.v3.LootTableEvents
import net.minecraft.world.level.storage.loot.BuiltInLootTables
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator

object ModVillageFruitLoot {
    private val VILLAGE_HOUSE_TABLES = setOf(
        BuiltInLootTables.VILLAGE_DESERT_HOUSE,
        BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
        BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
        BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
    )

    fun initialize() {
        LootTableEvents.MODIFY.register { key, tableBuilder, source, _ ->
            if (!source.isBuiltin || key !in VILLAGE_HOUSE_TABLES) {
                return@register
            }

            tableBuilder.withPool(
                LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0f))
                    .add(
                        LootItem.lootTableItem(ModItems.GRAPES)
                            .setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 6.0f))),
                    )
                    .add(
                        LootItem.lootTableItem(ModBlocks.GRAPE_VINE)
                            .setWeight(2)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))),
                    ),
            )
        }

        DitoxFirstMod.LOGGER.info("Loot de uvas para aldeas registrado.")
    }
}
