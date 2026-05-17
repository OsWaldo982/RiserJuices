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
    private const val SHORT_DURATION_TICKS = 20 * 20
    private const val MEDIUM_DURATION_TICKS = 45 * 20
    private const val LONG_DURATION_TICKS = 90 * 20

    private val BASIC_FRUIT_FOOD_COMPONENT: FoodProperties = FoodProperties.Builder()
        .nutrition(2)
        .saturationModifier(0.2f)
        .build()

    private val LEMONADE_FOOD_COMPONENT: FoodProperties = FoodProperties.Builder()
        .nutrition(3)
        .saturationModifier(0.5f)
        .alwaysEdible()
        .build()

    private val HEARTY_DRINK_FOOD_COMPONENT: FoodProperties = FoodProperties.Builder()
        .nutrition(4)
        .saturationModifier(0.7f)
        .alwaysEdible()
        .build()

    val LEMON: Item = register(
        name = "lemon",
        factory = ::Item,
        settings = Item.Properties()
            .food(BASIC_FRUIT_FOOD_COMPONENT),
    )

    val LEMONADE: Item = register(
        name = "lemonade",
        factory = ::Item,
        settings = Item.Properties()
            .stacksTo(16)
            .food(
                LEMONADE_FOOD_COMPONENT,
                drinkEffect(MobEffectInstance(MobEffects.HASTE, LEMONADE_HASTE_DURATION_TICKS, 0)),
            )
            .usingConvertsTo(Items.GLASS_BOTTLE),
    )

    val GRAPES: Item = fruit("grapes")
    val GRAPE_JUICE: Item = drink(
        name = "grape_juice",
        effect = MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 0),
    )
    val WINE: Item = drink(
        name = "wine",
        factory = ::WineItem,
        effect = MobEffectInstance(MobEffects.STRENGTH, MEDIUM_DURATION_TICKS, 0),
    )

    val ORANGE: Item = fruit("orange")
    val ORANGE_JUICE: Item = drink(
        name = "orange_juice",
        effect = MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION_TICKS, 0),
    )

    val GREEN_APPLE: Item = fruit("green_apple")
    val CIDER: Item = drink(
        name = "cider",
        effect = MobEffectInstance(MobEffects.SPEED, 60 * 20, 0),
    )

    val COCONUT: Item = fruit("coconut")
    val COCONUT_WATER: Item = drink(
        name = "coconut_water",
        effect = MobEffectInstance(MobEffects.SATURATION, 1 * 20, 0),
        food = HEARTY_DRINK_FOOD_COMPONENT,
    )

    val PINEAPPLE: Item = fruit("pineapple")
    val TROPICAL_JUICE: Item = drink(
        name = "tropical_juice",
        effects = listOf(
            MobEffectInstance(MobEffects.SPEED, MEDIUM_DURATION_TICKS, 0),
            MobEffectInstance(MobEffects.HUNGER, 15 * 20, 0),
        ),
    )

    val STRAWBERRY: Item = fruit("strawberry")
    val STRAWBERRY_SMOOTHIE: Item = drink(
        name = "strawberry_smoothie",
        effect = MobEffectInstance(MobEffects.REGENERATION, 6 * 20, 1),
        food = HEARTY_DRINK_FOOD_COMPONENT,
    )

    val BLUEBERRIES: Item = fruit("blueberries")
    val BLUEBERRY_SMOOTHIE: Item = drink(
        name = "blueberry_smoothie",
        effect = MobEffectInstance(MobEffects.NIGHT_VISION, LONG_DURATION_TICKS, 0),
        food = HEARTY_DRINK_FOOD_COMPONENT,
    )

    val BANANA: Item = fruit("banana")
    val BANANA_SMOOTHIE: Item = drink(
        name = "banana_smoothie",
        effects = listOf(
            MobEffectInstance(MobEffects.HASTE, 60 * 20, 0),
            MobEffectInstance(MobEffects.SATURATION, 1 * 20, 0),
        ),
        food = HEARTY_DRINK_FOOD_COMPONENT,
    )

    val CHERRIES: Item = fruit("cherries")
    val CHERRY_JUICE: Item = drink(
        name = "cherry_juice",
        effect = MobEffectInstance(MobEffects.LUCK, LONG_DURATION_TICKS, 0),
    )

    val MANGO: Item = fruit("mango")
    val MANGO_JUICE: Item = drink(
        name = "mango_juice",
        effect = MobEffectInstance(MobEffects.ABSORPTION, 60 * 20, 0),
    )

    val LEMON_BOAT: Item = register(
        name = "lemon_boat",
        factory = { settings -> BoatItem(ModEntityTypes.LEMON_BOAT, settings) },
        settings = Item.Properties()
            .stacksTo(1),
    )

    fun initialize() {
        listOf(
            LEMON,
            GRAPES,
            ORANGE,
            GREEN_APPLE,
            COCONUT,
            PINEAPPLE,
            STRAWBERRY,
            BLUEBERRIES,
            BANANA,
            CHERRIES,
            MANGO,
        ).forEach { item ->
            CompostableRegistry.INSTANCE.add(item, 0.65f)
        }

        FuelValueEvents.BUILD.register { builder, _ ->
            builder.add(LEMON_BOAT, 1200)
        }

        DitoxFirstMod.LOGGER.info("Registrando items de ${DitoxFirstMod.MOD_ID}.")
    }

    private fun fruit(name: String): Item = register(
        name = name,
        factory = ::Item,
        settings = Item.Properties()
            .food(BASIC_FRUIT_FOOD_COMPONENT),
    )

    private fun drink(
        name: String,
        effect: MobEffectInstance,
        food: FoodProperties = LEMONADE_FOOD_COMPONENT,
        factory: (Item.Properties) -> Item = ::Item,
    ): Item = drink(name, listOf(effect), food, factory)

    private fun drink(
        name: String,
        effects: List<MobEffectInstance>,
        food: FoodProperties = LEMONADE_FOOD_COMPONENT,
        factory: (Item.Properties) -> Item = ::Item,
    ): Item = register(
        name = name,
        factory = factory,
        settings = Item.Properties()
            .stacksTo(16)
            .food(food, drinkEffects(effects))
            .usingConvertsTo(Items.GLASS_BOTTLE),
    )

    private fun drinkEffect(effect: MobEffectInstance): Consumable = drinkEffects(listOf(effect))

    private fun drinkEffects(effects: List<MobEffectInstance>): Consumable {
        val builder = Consumables.defaultDrink()
        effects.forEach { effect ->
            builder.onConsume(ApplyStatusEffectsConsumeEffect(effect, 1.0f))
        }
        return builder.build()
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
