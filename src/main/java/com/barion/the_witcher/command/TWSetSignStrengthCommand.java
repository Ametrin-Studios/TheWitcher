package com.barion.the_witcher.command;

import com.barion.the_witcher.attachment.TWSignStrengthWrapper;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public final class TWSetSignStrengthCommand {
    private static final String success = "command.the_witcher.sign_strength.set.success";

    public TWSetSignStrengthCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("sign_strength")
                        .then(Commands.literal("set").requires((sourceStack)-> sourceStack.hasPermission(4))
                                .then(Commands.argument("level", IntegerArgumentType.integer(TWSignStrengthWrapper.MIN_STRENGTH, TWSignStrengthWrapper.MAX_STRENGTH))
                                        .executes((command)-> setSignStrength(command.getSource(), IntegerArgumentType.getInteger(command, "level")))
                                        .then(Commands.argument("targets", EntityArgument.players())
                                                .executes((command)-> setSignStrength(command.getSource(), EntityArgument.getPlayers(command, "targets"), IntegerArgumentType.getInteger(command, "level")))
        )))));
    }

    private int setSignStrength(CommandSourceStack source, Collection<ServerPlayer> targets, int value) {
        for(ServerPlayer target : targets){
            setSignStrengthInternal(source, target, value);
        }

        return 1;
    }

    private int setSignStrength(CommandSourceStack source, int value) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        setSignStrengthInternal(source, source.getPlayer(), value);
        return 0;
    }

    private void setSignStrengthInternal(CommandSourceStack source, ServerPlayer target, int value) {
        var wrapper = new TWSignStrengthWrapper(target);
        wrapper.set(value);
        source.sendSuccess(()-> Component.translatable(success, target.getDisplayName(), value), true);
    }
}