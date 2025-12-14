package io.gitlab.shdima.tnt.data

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.block.Block

data class BlockLocation(val x: Int, val y: Int, val z: Int, val world: String) {
    val location: Location get() = Location(Bukkit.getWorld(world), x.toDouble(), y.toDouble(), z.toDouble())
    val block: Block get() = location.block

    constructor(location: Location) : this(location.x.toInt(), location.y.toInt(), location.z.toInt(), location.world.name)
}
