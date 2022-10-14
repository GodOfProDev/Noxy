package me.godofpro.noxy;

import gg.essential.elementa.markdown.MarkdownComponent;
import me.godofpro.noxy.commands.ConfigCommand;
import me.godofpro.noxy.commands.PrintAPI;
import me.godofpro.noxy.core.Config;
import me.godofpro.noxy.listeners.ChatListener;
import gg.essential.api.utils.GuiUtil;
import me.godofpro.noxy.listeners.RenderWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Noxy.MODID, version = Noxy.VERSION, clientSideOnly = true)
public class Noxy {

    public static final String MODID = "noxy";
    public static final String VERSION = "1.0.0";

    public static final Logger LOGGER = LogManager.getLogger("Noxy");

    public static Noxy INSTANCE = null;

    private final Config config = Config.INSTANCE;

    public Config getConfig() {
        return this.config;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        INSTANCE = this;
        ClientCommandHandler.instance.registerCommand(new ConfigCommand());
        ClientCommandHandler.instance.registerCommand(new PrintAPI());
        MinecraftForge.EVENT_BUS.register(new ChatListener());
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new RenderWorld());
    }
}
