package com.ditoxsoft.ditoxfirstmod.block

import net.minecraft.world.item.Item
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockBehaviour

class FruitCropBlock(
    settings: BlockBehaviour.Properties,
    private val seedSupplier: () -> Item,
) : CropBlock(settings) {
    override fun getBaseSeedId(): ItemLike = seedSupplier()
}
