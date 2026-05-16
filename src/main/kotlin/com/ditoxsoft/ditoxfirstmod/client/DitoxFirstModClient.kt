package com.ditoxsoft.ditoxfirstmod.client

import com.ditoxsoft.ditoxfirstmod.DitoxFirstMod
import com.ditoxsoft.ditoxfirstmod.entity.ModEntityTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry
import net.minecraft.client.model.`object`.boat.BoatModel
import net.minecraft.client.renderer.entity.BoatRenderer
import net.minecraft.client.renderer.entity.EntityRenderers

object DitoxFirstModClient : ClientModInitializer {
    override fun onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.LEMON_BOAT, BoatModel::createBoatModel)
        EntityRenderers.register(ModEntityTypes.LEMON_BOAT) { context ->
            BoatRenderer(context, ModEntityModelLayers.LEMON_BOAT)
        }

        // Punto de entrada para pantallas, HUDs, teclas y logica solo cliente.
        DitoxFirstMod.LOGGER.info("RiserJuices inicializo el entrypoint cliente.")
    }
}
