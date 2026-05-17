package com.ditoxsoft.ditoxfirstmod.block

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class FruitCropBlock(
    settings: BlockBehaviour.Properties,
    private val seedSupplier: () -> Item,
) : CropBlock(settings) {
    override fun getBaseSeedId(): ItemLike = seedSupplier()

    override fun mayPlaceOn(floor: BlockState, level: BlockGetter, pos: BlockPos): Boolean =
        floor.`is`(Blocks.FARMLAND) ||
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

    override fun useWithoutItem(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hitResult: BlockHitResult,
    ): InteractionResult {
        if (!isMaxAge(state)) {
            return InteractionResult.PASS
        }

        if (level is ServerLevel) {
            val fruitCount = 1 + level.random.nextInt(3)
            Block.popResource(level, pos, ItemStack(seedSupplier(), fruitCount))
            level.setBlock(pos, getStateForAge(3), Block.UPDATE_CLIENTS)
        }

        return InteractionResult.SUCCESS
    }
}
