package com.ditoxsoft.ditoxfirstmod.item

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.block.ModBlocks
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object ModItemGroups {
    private val RISERJUICES_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        BuiltInRegistries.CREATIVE_MODE_TAB.key(),
        DitoxFirstMod.id("item_group"),
    )

    private val RISERJUICES_GROUP: CreativeModeTab = FabricCreativeModeTab.builder()
        .icon { ItemStack(ModItems.TROPICAL_JUICE) }
        .title(Component.translatable("creativeTab.${DitoxFirstMod.MOD_ID}"))
        .displayItems { _, output ->
            output.accept(ModItems.LEMON)
            output.accept(ModItems.LEMONADE)
            output.accept(ModItems.GRAPES)
            output.accept(ModItems.GRAPE_JUICE)
            output.accept(ModItems.WINE)
            output.accept(ModItems.ORANGE)
            output.accept(ModItems.ORANGE_JUICE)
            output.accept(ModItems.GREEN_APPLE)
            output.accept(ModItems.CIDER)
            output.accept(ModItems.COCONUT)
            output.accept(ModItems.COCONUT_WATER)
            output.accept(ModItems.PINEAPPLE)
            output.accept(ModItems.TROPICAL_JUICE)
            output.accept(ModItems.STRAWBERRY)
            output.accept(ModItems.STRAWBERRY_SMOOTHIE)
            output.accept(ModItems.BLUEBERRIES)
            output.accept(ModItems.BLUEBERRY_SMOOTHIE)
            output.accept(ModItems.BANANA)
            output.accept(ModItems.BANANA_SMOOTHIE)
            output.accept(ModItems.CHERRIES)
            output.accept(ModItems.CHERRY_JUICE)
            output.accept(ModItems.MANGO)
            output.accept(ModItems.MANGO_JUICE)
            output.accept(ModBlocks.LEMON_LOG.asItem())
            output.accept(ModBlocks.LEMON_WOOD.asItem())
            output.accept(ModBlocks.STRIPPED_LEMON_LOG.asItem())
            output.accept(ModBlocks.STRIPPED_LEMON_WOOD.asItem())
            output.accept(ModBlocks.LEMON_PLANKS.asItem())
            output.accept(ModBlocks.LEMON_STAIRS.asItem())
            output.accept(ModBlocks.LEMON_SLAB.asItem())
            output.accept(ModBlocks.LEMON_FENCE.asItem())
            output.accept(ModBlocks.LEMON_FENCE_GATE.asItem())
            output.accept(ModBlocks.LEMON_DOOR.asItem())
            output.accept(ModBlocks.LEMON_TRAPDOOR.asItem())
            output.accept(ModBlocks.LEMON_BUTTON.asItem())
            output.accept(ModBlocks.LEMON_PRESSURE_PLATE.asItem())
            output.accept(ModItems.LEMON_BOAT)
            output.accept(ModBlocks.LEMON_LEAVES.asItem())
            output.accept(ModBlocks.LEMON_SAPLING.asItem())
            output.accept(ModBlocks.ORANGE_LEAVES.asItem())
            output.accept(ModBlocks.GREEN_APPLE_LEAVES.asItem())
            output.accept(ModBlocks.COCONUT_PALM_LEAVES.asItem())
            output.accept(ModBlocks.BANANA_LEAVES.asItem())
            output.accept(ModBlocks.CHERRY_LEAVES.asItem())
            output.accept(ModBlocks.MANGO_LEAVES.asItem())
            output.accept(ModBlocks.GRAPE_VINE.asItem())
            output.accept(ModBlocks.ORANGE_SAPLING.asItem())
            output.accept(ModBlocks.GREEN_APPLE_SAPLING.asItem())
            output.accept(ModBlocks.COCONUT_PALM_SAPLING.asItem())
            output.accept(ModBlocks.PINEAPPLE_PLANT.asItem())
            output.accept(ModBlocks.STRAWBERRY_BUSH.asItem())
            output.accept(ModBlocks.BLUEBERRY_BUSH.asItem())
            output.accept(ModBlocks.BANANA_SAPLING.asItem())
            output.accept(ModBlocks.CHERRY_SAPLING.asItem())
            output.accept(ModBlocks.MANGO_SAPLING.asItem())
        }
        .build()

    fun initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RISERJUICES_GROUP_KEY, RISERJUICES_GROUP)
        DitoxFirstMod.LOGGER.info("Registrando pestana creativa de ${DitoxFirstMod.MOD_ID}.")
    }
}
