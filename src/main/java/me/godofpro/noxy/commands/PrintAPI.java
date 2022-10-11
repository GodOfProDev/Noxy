package me.godofpro.noxy.commands;

import me.godofpro.noxy.Noxy;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PrintAPI extends CommandBase {
    @Override
    public String getCommandName() {
        return "printapi";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "printapi";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                EnumChatFormatting.YELLOW + Noxy.INSTANCE.getConfig().getApiKey()
        ));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
