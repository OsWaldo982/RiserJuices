package com.ditoxsoft.ditoxfirstmod.block

import net.minecraft.world.level.block.SaplingBlock
import net.minecraft.world.level.block.grower.TreeGrower
import net.minecraft.world.level.block.state.BlockBehaviour

class LemonSaplingBlock(
    treeGrower: TreeGrower,
    settings: BlockBehaviour.Properties,
) : SaplingBlock(treeGrower, settings)
