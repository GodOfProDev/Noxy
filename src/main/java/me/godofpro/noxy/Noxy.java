package me.godofpro.noxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Noxy.MODID, version = Noxy.VERSION, clientSideOnly = true)
public class Noxy {

    public static final String MODID = "noxy";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger("Noxy");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Hello From Noxy Mod");
    }
}
