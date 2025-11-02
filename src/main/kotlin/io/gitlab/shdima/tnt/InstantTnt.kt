package io.gitlab.shdima.tnt

import de.exlll.configlib.NameFormatters
import de.exlll.configlib.YamlConfigurationProperties
import org.bstats.bukkit.Metrics
import de.exlll.configlib.YamlConfigurations
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Path

@Suppress("unused")
class InstantTnt : JavaPlugin() {

    private lateinit var config: Config

    override fun onEnable() {
        val properties = YamlConfigurationProperties.newBuilder().setNameFormatter(NameFormatters.LOWER_KEBAB_CASE).build()

        val configFile = Path.of(dataFolder.path, "config.yml")
        config = try {
            YamlConfigurations.load(configFile, Config::class.java, properties)
        } catch (e: Exception) {
            Config()
        }

        YamlConfigurations.save(configFile, Config::class.java, config, properties)

        try {
            Metrics(this, 27829)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}
