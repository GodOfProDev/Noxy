package me.godofpro.noxy.commands;

import gg.essential.api.EssentialAPI;
import me.godofpro.noxy.Noxy;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ConfigCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "config";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "config";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        EssentialAPI.getGuiUtil().openScreen(Noxy.INSTANCE.getConfig().gui());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
