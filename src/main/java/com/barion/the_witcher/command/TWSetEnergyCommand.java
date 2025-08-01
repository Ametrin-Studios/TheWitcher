package com.barion.the_witcher.command;

import com.barion.the_witcher.attachment.TWEnergyWrapper;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public final class TWSetEnergyCommand {
    private static final String success = "command.the_witcher.energy.set.success";

    public TWSetEnergyCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("energy")
                        .then(Commands.literal("set").requires((sourceStack)-> sourceStack.hasPermission(4))
                                .then(Commands.argument("amount", IntegerArgumentType.integer(0))
                                        .executes((command)-> setEnergy(command.getSource(), IntegerArgumentType.getInteger(command, "amount")))
                                        .then(Commands.argument("targets", EntityArgument.players())
                                                .executes((command)-> setEnergy(command.getSource(), EntityArgument.getPlayers(command, "targets"), IntegerArgumentType.getInteger(command, "amount")))
        )))));
    }

    private int setEnergy(CommandSourceStack source, Collection<ServerPlayer> targets, int value) {
        for(ServerPlayer target : targets) {
            setEnergyInternal(source, target, value);
        }

        return 0;
    }

    private int setEnergy(CommandSourceStack source, int value) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        setEnergyInternal(source, source.getPlayer(), value);
        return 0;
    }

    private void setEnergyInternal(CommandSourceStack source, ServerPlayer target, int value){
        var wrapper = new TWEnergyWrapper(target);
        wrapper.set(value);
        source.sendSuccess(() -> Component.translatable(success, target.getDisplayName(), value), true);
    }
}