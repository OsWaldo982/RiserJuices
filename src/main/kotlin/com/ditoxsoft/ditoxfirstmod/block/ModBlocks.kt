package com.ditoxsoft.ditoxfirstmod.block

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.item.ModItems
import com.ditoxsoft.ditoxfirstmod.world.ModWorldGeneration
import net.fabricmc.fabric.api.registry.CompostableRegistry
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.fabricmc.fabric.api.registry.FuelValueEvents
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.DoubleHighBlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.FenceBlock
import net.minecraft.world.level.block.FenceGateBlock
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.UntintedParticleLeavesBlock
import net.minecraft.world.level.block.grower.TreeGrower
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.BlockSetType
import net.minecraft.world.level.block.state.properties.WoodType
import java.util.Optional

object ModBlocks {
    private val LEMON_TREE_GROWER = TreeGrower(
        "lemon",
        Optional.empty(),
        Optional.of(ModWorldGeneration.LEMON_TREE_CONFIGURED_KEY),
        Optional.empty(),
    )

    val LEMON_LOG: Block = register(
        name = "lemon_log",
        factory = ::RotatedPillarBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_WOOD: Block = register(
        name = "lemon_wood",
        factory = ::RotatedPillarBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val STRIPPED_LEMON_LOG: Block = register(
        name = "stripped_lemon_log",
        factory = ::RotatedPillarBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val STRIPPED_LEMON_WOOD: Block = register(
        name = "stripped_lemon_wood",
        factory = ::RotatedPillarBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_PLANKS: Block = register(
        name = "lemon_planks",
        factory = ::Block,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_STAIRS: Block = register(
        name = "lemon_stairs",
        factory = { settings -> LemonStairsBlock(LEMON_PLANKS.defaultBlockState(), settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_SLAB: Block = register(
        name = "lemon_slab",
        factory = ::SlabBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_FENCE: Block = register(
        name = "lemon_fence",
        factory = ::FenceBlock,
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_FENCE_GATE: Block = register(
        name = "lemon_fence_gate",
        factory = { settings -> FenceGateBlock(WoodType.OAK, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_DOOR: Block = register(
        name = "lemon_door",
        factory = { settings -> LemonDoorBlock(BlockSetType.OAK, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
        itemFactory = ::DoubleHighBlockItem,
    )

    val LEMON_TRAPDOOR: Block = register(
        name = "lemon_trapdoor",
        factory = { settings -> LemonTrapDoorBlock(BlockSetType.OAK, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_BUTTON: Block = register(
        name = "lemon_button",
        factory = { settings -> LemonButtonBlock(BlockSetType.OAK, 30, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_PRESSURE_PLATE: Block = register(
        name = "lemon_pressure_plate",
        factory = { settings -> LemonPressurePlateBlock(BlockSetType.OAK, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
            .sound(SoundType.WOOD),
        shouldRegisterItem = true,
    )

    val LEMON_LEAVES: Block = register(
        name = "lemon_leaves",
        factory = { settings ->
            UntintedParticleLeavesBlock(0.02f, ParticleTypes.FALLING_NECTAR, settings)
        },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
            .sound(SoundType.GRASS),
        shouldRegisterItem = true,
    )

    val LEMON_SAPLING: Block = register(
        name = "lemon_sapling",
        factory = { settings -> LemonSaplingBlock(LEMON_TREE_GROWER, settings) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
            .sound(SoundType.GRASS),
        shouldRegisterItem = true,
    )

    val GRAPE_VINE: Block = fruitCrop("grape_vine") { ModItems.GRAPES }
    val ORANGE_SAPLING: Block = fruitCrop("orange_sapling") { ModItems.ORANGE }
    val GREEN_APPLE_SAPLING: Block = fruitCrop("green_apple_sapling") { ModItems.GREEN_APPLE }
    val COCONUT_PALM_SAPLING: Block = fruitCrop("coconut_palm_sapling") { ModItems.COCONUT }
    val PINEAPPLE_PLANT: Block = fruitCrop("pineapple_plant") { ModItems.PINEAPPLE }
    val STRAWBERRY_BUSH: Block = fruitCrop("strawberry_bush") { ModItems.STRAWBERRY }
    val BLUEBERRY_BUSH: Block = fruitCrop("blueberry_bush") { ModItems.BLUEBERRIES }
    val BANANA_SAPLING: Block = fruitCrop("banana_sapling") { ModItems.BANANA }
    val CHERRY_SAPLING: Block = fruitCrop("cherry_sapling") { ModItems.CHERRIES }
    val MANGO_SAPLING: Block = fruitCrop("mango_sapling") { ModItems.MANGO }

    fun initialize() {
        val flammableBlocks = FlammableBlockRegistry.getDefaultInstance()
        listOf(LEMON_LOG, LEMON_WOOD, STRIPPED_LEMON_LOG, STRIPPED_LEMON_WOOD).forEach { block ->
            flammableBlocks.add(block, 5, 5)
        }
        listOf(
            LEMON_PLANKS,
            LEMON_STAIRS,
            LEMON_SLAB,
            LEMON_FENCE,
            LEMON_FENCE_GATE,
            LEMON_DOOR,
            LEMON_TRAPDOOR,
        ).forEach { block ->
            flammableBlocks.add(block, 5, 20)
        }
        flammableBlocks.add(LEMON_LEAVES, 30, 60)

        StrippableBlockRegistry.registerCopyState(LEMON_LOG, STRIPPED_LEMON_LOG)
        StrippableBlockRegistry.registerCopyState(LEMON_WOOD, STRIPPED_LEMON_WOOD)

        FuelValueEvents.BUILD.register { builder, _ ->
            builder.add(LEMON_LOG, 300)
            builder.add(LEMON_WOOD, 300)
            builder.add(STRIPPED_LEMON_LOG, 300)
            builder.add(STRIPPED_LEMON_WOOD, 300)
            builder.add(LEMON_PLANKS, 300)
            builder.add(LEMON_STAIRS, 300)
            builder.add(LEMON_SLAB, 150)
            builder.add(LEMON_FENCE, 300)
            builder.add(LEMON_FENCE_GATE, 300)
            builder.add(LEMON_DOOR, 200)
            builder.add(LEMON_TRAPDOOR, 300)
            builder.add(LEMON_BUTTON, 100)
            builder.add(LEMON_PRESSURE_PLATE, 300)
            builder.add(LEMON_SAPLING, 100)
        }

        CompostableRegistry.INSTANCE.add(LEMON_LEAVES.asItem(), 0.3f)
        CompostableRegistry.INSTANCE.add(LEMON_SAPLING.asItem(), 0.3f)
        listOf(
            GRAPE_VINE,
            ORANGE_SAPLING,
            GREEN_APPLE_SAPLING,
            COCONUT_PALM_SAPLING,
            PINEAPPLE_PLANT,
            STRAWBERRY_BUSH,
            BLUEBERRY_BUSH,
            BANANA_SAPLING,
            CHERRY_SAPLING,
            MANGO_SAPLING,
        ).forEach { block ->
            CompostableRegistry.INSTANCE.add(block.asItem(), 0.3f)
        }

        DitoxFirstMod.LOGGER.info("Registrando bloques de ${DitoxFirstMod.MOD_ID}.")
    }

    private fun fruitCrop(name: String, seedSupplier: () -> Item): Block = register(
        name = name,
        factory = { settings -> FruitCropBlock(settings, seedSupplier) },
        settings = BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)
            .sound(SoundType.CROP),
        shouldRegisterItem = true,
        itemFactory = ::BlockItem,
    )

    private fun register(
        name: String,
        factory: (BlockBehaviour.Properties) -> Block,
        settings: BlockBehaviour.Properties,
        shouldRegisterItem: Boolean,
        itemFactory: (Block, Item.Properties) -> Item = ::BlockItem,
    ): Block {
        val blockKey = keyOfBlock(name)
        val block = factory(settings.setId(blockKey))

        if (shouldRegisterItem) {
            val itemKey = keyOfItem(name)
            val blockItem = itemFactory(
                block,
                Item.Properties()
                    .setId(itemKey)
                    .useBlockDescriptionPrefix(),
            )

            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem)
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block)
    }

    private fun keyOfBlock(name: String): ResourceKey<Block> =
        ResourceKey.create(Registries.BLOCK, DitoxFirstMod.id(name))

    private fun keyOfItem(name: String): ResourceKey<Item> =
        ResourceKey.create(Registries.ITEM, DitoxFirstMod.id(name))
}
