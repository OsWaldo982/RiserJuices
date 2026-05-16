package com.ditoxsoft.ditoxfirstmod.mixin

import com.ditoxsoft.ditoxfirstmod.recipe.ModJuiceRecipes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.CraftingContainer
import net.minecraft.world.inventory.ResultSlot
import net.minecraft.world.item.ItemStack
import org.spongepowered.asm.mixin.Final
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(ResultSlot::class)
abstract class ResultSlotMixin {
    @Shadow
    @Final
    private lateinit var craftSlots: CraftingContainer

    @Inject(method = ["onTake"], at = [At("TAIL")])
    private fun riserJuicesConsumeSecondLemon(player: Player, stack: ItemStack, ci: CallbackInfo) {
        ModJuiceRecipes.byOutput(stack)?.consumeStackedFruitRemainder(craftSlots)
    }
}
