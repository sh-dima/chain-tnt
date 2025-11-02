package io.gitlab.shdima.tnt

import de.exlll.configlib.Configuration

@Configuration
class Config {
    var enabled = true
    var minimumCollisionDetonationSpeed = 0.75

    var power = 2.0
    var breaksBlocks = false
    var setsFire = false
    var spreadRadiusBlocks = 8.0
    var blocksPerTickDelay = 0.0
}
