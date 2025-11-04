package io.gitlab.shdima.tnt.listeners

import io.gitlab.shdima.tnt.InstantTnt
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPistonExtendEvent
import org.bukkit.event.block.BlockPistonRetractEvent

class InstantTntMoveListener(private val plugin: InstantTnt) : Listener {
    @EventHandler
    private fun onPistonPush(event: BlockPistonExtendEvent) {
        val direction = event.direction
        val manager = plugin.instantTntManager

        event.blocks.forEach {
            if (!manager.isInstantTnt(it)) return@forEach

            val newBlock = it.getRelative(direction)

            manager.removeInstantTnt(it)
            manager.addInstantTnt(newBlock)
        }
    }

    @EventHandler
    private fun onPistonPull(event: BlockPistonRetractEvent) {
        if (!event.isSticky) return

        val direction = event.direction
        val manager = plugin.instantTntManager

        event.blocks.forEach {
            if (!manager.isInstantTnt(it)) return@forEach

            val newBlock = it.getRelative(direction)

            manager.removeInstantTnt(it)
            manager.addInstantTnt(newBlock)
        }
    }
}
