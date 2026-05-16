package com.ditoxsoft.ditoxfirstmod.block

import net.minecraft.world.level.block.ButtonBlock
import net.minecraft.world.level.block.DoorBlock
import net.minecraft.world.level.block.PressurePlateBlock
import net.minecraft.world.level.block.StairBlock
import net.minecraft.world.level.block.TrapDoorBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.BlockSetType

class LemonStairsBlock(baseBlockState: BlockState, settings: BlockBehaviour.Properties) :
    StairBlock(baseBlockState, settings)

class LemonDoorBlock(blockSetType: BlockSetType, settings: BlockBehaviour.Properties) :
    DoorBlock(blockSetType, settings)

class LemonTrapDoorBlock(blockSetType: BlockSetType, settings: BlockBehaviour.Properties) :
    TrapDoorBlock(blockSetType, settings)

class LemonButtonBlock(blockSetType: BlockSetType, pressTicks: Int, settings: BlockBehaviour.Properties) :
    ButtonBlock(blockSetType, pressTicks, settings)

class LemonPressurePlateBlock(blockSetType: BlockSetType, settings: BlockBehaviour.Properties) :
    PressurePlateBlock(blockSetType, settings)
