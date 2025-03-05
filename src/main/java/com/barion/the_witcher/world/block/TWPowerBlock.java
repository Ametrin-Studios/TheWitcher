package com.barion.the_witcher.world.block;

import com.barion.the_witcher.attachment.TWSignStrengthWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWPowerBlock extends Block {
    public static final BooleanProperty HAS_POWER = BooleanProperty.create("has_power");
    private static final Component needUnlock = Component.translatable("message.the_witcher.sign.need_unlock");

    public TWPowerBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(HAS_POWER, true));
    }

    @Override
    @ParametersAreNonnullByDefault
    protected @NotNull InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (blockState.getValue(HAS_POWER)) {
                var signStrengthWrapper = new TWSignStrengthWrapper((ServerPlayer) player);
                if (signStrengthWrapper.get() == 0) {
                    player.displayClientMessage(needUnlock, true);
                    return InteractionResult.FAIL;
                }

                if (signStrengthWrapper.canUpgrade()) {
                    signStrengthWrapper.increase();
                    level.setBlock(pos, blockState.setValue(HAS_POWER, false), 2);
                    level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.2f, level.random.nextFloat() * 0.1f + 0.9f);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.useWithoutItem(blockState, level, pos, player, hitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HAS_POWER);
    }
}