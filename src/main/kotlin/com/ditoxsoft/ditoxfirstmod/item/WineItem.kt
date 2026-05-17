package com.ditoxsoft.ditoxfirstmod.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class WineItem(settings: Properties) : Item(settings) {
    override fun finishUsingItem(stack: ItemStack, level: Level, livingEntity: LivingEntity): ItemStack {
        val alreadyEmpowered = livingEntity.hasEffect(MobEffects.STRENGTH)
        val result = super.finishUsingItem(stack, level, livingEntity)

        if (!level.isClientSide && alreadyEmpowered) {
            livingEntity.addEffect(MobEffectInstance(MobEffects.NAUSEA, 15 * 20, 0))
        }

        return result
    }
}
