package com.ditoxsoft.ditoxfirstmod.item

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.entity.ModEntityTypes
import net.fabricmc.fabric.api.registry.CompostableRegistry
import net.fabricmc.fabric.api.registry.FuelValueEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BoatItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.component.Consumable
import net.minecraft.world.item.component.Consumables
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect

object ModItems {
    private const val LEMONADE_HASTE_DURATION_TICKS = 60 * 20

    private val LEMON_FOOD_COMPONENT: FoodProperties = FoodProperties.Builder()
        .nutrition(2)
        .saturationModifier(0.2f)
        .build()

    private val LEMONADE_FOOD_COMPONENT: FoodProperties = FoodProperties.Builder()
        .nutrition(3)
        .saturationModifier(0.5f)
        .alwaysEdible()
        .build()

    private val LEMONADE_CONSUMABLE_COMPONENT: Consumable = Consumables.defaultDrink()
        .onConsume(
            ApplyStatusEffectsConsumeEffect(
                MobEffectInstance(MobEffects.HASTE, LEMONADE_HASTE_DURATION_TICKS, 0),
                1.0f,
            ),
        )
        .build()

    val LEMON: Item = register(
        name = "lemon",
        factory = ::Item,
        settings = Item.Properties()
            .food(LEMON_FOOD_COMPONENT),
    )

    val LEMONADE: Item = register(
        name = "lemonade",
        factory = ::Item,
        settings = Item.Properties()
            .stacksTo(16)
            .food(LEMONADE_FOOD_COMPONENT, LEMONADE_CONSUMABLE_COMPONENT)
            .usingConvertsTo(Items.GLASS_BOTTLE),
    )

    val LEMON_BOAT: Item = register(
        name = "lemon_boat",
        factory = { settings -> BoatItem(ModEntityTypes.LEMON_BOAT, settings) },
        settings = Item.Properties()
            .stacksTo(1),
    )

    fun initialize() {
        CompostableRegistry.INSTANCE.add(LEMON, 0.65f)
        FuelValueEvents.BUILD.register { builder, _ ->
            builder.add(LEMON_BOAT, 1200)
        }

        DitoxFirstMod.LOGGER.info("Registrando items de ${DitoxFirstMod.MOD_ID}.")
    }

    private fun <T : Item> register(
        name: String,
        factory: (Item.Properties) -> T,
        settings: Item.Properties,
    ): T {
        val itemKey = ResourceKey.create(Registries.ITEM, DitoxFirstMod.id(name))
        val item = factory(settings.setId(itemKey))

        return Registry.register(BuiltInRegistries.ITEM, itemKey, item)
    }
}
