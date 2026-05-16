package com.ditoxsoft.ditoxfirstmod.entity

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.item.ModItems
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.entity.vehicle.boat.Boat
import net.minecraft.world.level.Level

object ModEntityTypes {
    val LEMON_BOAT: EntityType<Boat> = register(
        name = "lemon_boat",
        builder = EntityType.Builder.of(
            { entityType: EntityType<Boat>, level: Level ->
                Boat(entityType, level) { ModItems.LEMON_BOAT }
            },
            MobCategory.MISC,
        )
            .sized(1.375f, 0.5625f)
            .clientTrackingRange(10)
            .updateInterval(3),
    )

    fun initialize() {
        DitoxFirstMod.LOGGER.info("Registrando entidades de ${DitoxFirstMod.MOD_ID}.")
    }

    private fun <T : Boat> register(name: String, builder: EntityType.Builder<T>): EntityType<T> {
        val entityKey = ResourceKey.create(Registries.ENTITY_TYPE, DitoxFirstMod.id(name))
        val entityType = builder.build(entityKey)

        return Registry.register(BuiltInRegistries.ENTITY_TYPE, entityKey, entityType)
    }
}
