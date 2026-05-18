package com.ditoxsoft.ditoxfirstmod.block

import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SaplingBlock
import net.minecraft.world.level.block.grower.TreeGrower
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

class FruitSaplingBlock(
    treeGrower: TreeGrower,
    settings: BlockBehaviour.Properties,
) : SaplingBlock(treeGrower, settings) {
    override fun mayPlaceOn(floor: BlockState, level: BlockGetter, pos: BlockPos): Boolean =
        floor.`is`(Blocks.GRASS_BLOCK) ||
            floor.`is`(Blocks.DIRT) ||
            floor.`is`(Blocks.COARSE_DIRT) ||
            floor.`is`(Blocks.ROOTED_DIRT) ||
            floor.`is`(Blocks.PODZOL) ||
            floor.`is`(Blocks.MYCELIUM) ||
            floor.`is`(Blocks.MOSS_BLOCK) ||
            floor.`is`(Blocks.MUD) ||
            floor.`is`(Blocks.SAND) ||
            floor.`is`(Blocks.RED_SAND)
}
