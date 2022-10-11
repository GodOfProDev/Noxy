package me.godofpro.noxy.core

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import net.minecraft.client.Minecraft
import java.io.File

object Config : Vigilant(File("./config/NoxyConfig.toml")){
    @Property(
        type = PropertyType.TEXT, name = "Hypixel API Key",
        description = "Hypixel Api Key",
        category = "General", subcategory = "API",
        protectedText = true
    )
    var apiKey = ""

    init {
        initialize()
    }
}