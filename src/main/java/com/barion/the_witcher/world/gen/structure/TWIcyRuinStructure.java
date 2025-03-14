package com.barion.the_witcher.world.gen.structure;

import com.ametrinstudios.ametrin.world.gen.util.StructurePieces;
import com.barion.the_witcher.registry.TWStructures;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

import static com.barion.the_witcher.TheWitcher.locate;
import static com.barion.the_witcher.util.TWUtil.pieceBuilder;

public class TWIcyRuinStructure extends Structure {

    public static final MapCodec<TWIcyRuinStructure> CODEC = Structure.simpleCodec(TWIcyRuinStructure::new);

    public TWIcyRuinStructure(StructureSettings structureSettings) {
        super(structureSettings);
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, GenerationContext context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        int y = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());

        piecesBuilder.addPiece(new Piece(context.structureTemplateManager(), Piece.STRUCTURE_FILES.getRandomPiece(context.random()), new BlockPos(x, y, z), context.random()));
    }

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (builder) -> generatePieces(builder, context));
    }

    @Override
    public @NotNull StructureType<?> type() {
        return TWStructures.ICY_RUIN.getType();
    }

    public static class Piece extends GelTemplateStructurePiece {
        private static final StructurePieces STRUCTURE_FILES = pieceBuilder().offset(-5, -1, -4).add(locate("icy_ruin/small")).offset(-7, -4, -6).add(locate("icy_ruin/big")).offset(-4, -4, -7).add(locate("icy_tower")).build();

        public Piece(StructureTemplateManager structureManager, StructurePieces.Piece piece, BlockPos pos, RandomSource random) {
            super(TWStructures.ICY_RUIN.getPieceType().get(), 0, structureManager, piece.Resource, pos.offset(piece.Offset));
            rotation = Rotation.getRandom(random);
            setupPlaceSettings(structureManager);
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt) {
            super(TWStructures.ICY_RUIN.getPieceType().get(), nbt, context.structureTemplateManager());
            setupPlaceSettings(context.structureTemplateManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureTemplateManager structureManager) {
            var size = structureManager.get(this.makeTemplateLocation()).get().getSize();
            var pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            var settings = new StructurePlaceSettings().setLiquidSettings(LiquidSettings.IGNORE_WATERLOGGING).setRotationPivot(pivot);
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR).addProcessor(RemoveGelStructureProcessor.INSTANCE);
            settings.addProcessor(TWProcessors.CobbleFrostedStoneBricks)
                    .addProcessor(TWProcessors.CrackFrostedStoneBricks)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickStairs)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickSlab)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickWall);
            return settings;
        }

        @Override
        @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox box) {
        }
    }
}