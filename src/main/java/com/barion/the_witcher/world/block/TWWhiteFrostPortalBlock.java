package com.barion.the_witcher.world.block;

import com.ametrinstudios.ametrin.world.block.PortalBlock;
import com.barion.the_witcher.registry.TWPortals;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

public final class TWWhiteFrostPortalBlock extends PortalBlock {
    public TWWhiteFrostPortalBlock(Properties properties) {
        super(TWPortals.WHITE_FROST, properties.lightLevel((state) -> 11));
    }

    @Override @ParametersAreNonnullByDefault
    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource rand) {
        if (rand.nextInt(100) == 0) {
            level.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5f, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 3; i++) {
            double x = (double)pos.getX() + rand.nextDouble();
            double y = (double)pos.getY() + rand.nextDouble();
            double z = (double)pos.getZ() + rand.nextDouble();

            level.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0, -0.05, 0);
        }

    }
}