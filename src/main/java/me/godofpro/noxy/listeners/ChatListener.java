package me.godofpro.noxy.listeners;

import me.godofpro.noxy.Noxy;
import me.godofpro.noxy.utils.StringUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String unformatted = StringUtil.cleanColor(event.message.getUnformattedText());

        if (unformatted.startsWith("Your new API key is ")) {
            Noxy.INSTANCE.getConfig().setApiKey(unformatted.substring("Your new API key is".length()).substring(
                    0,
                    36
            ));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                    EnumChatFormatting.AQUA + "[NXY] Api key automatically configured"
            ));
            Noxy.INSTANCE.getConfig().markDirty();
            Noxy.INSTANCE.getConfig().writeData();
        }
    }
}
