package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWStructures;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
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

public class TWWildHuntOutpostStructure extends Structure {
    public static final MapCodec<TWWildHuntOutpostStructure> CODEC = Structure.simpleCodec(TWWildHuntOutpostStructure::new);

    public TWWildHuntOutpostStructure(StructureSettings settings) {
        super(settings);
    }

//    @Override
//    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
//        BlockPos pos = context.chunkPos().getWorldPosition();
//        Rotation rotation = Rotation.getRandom(context.random());
////        var results = TerrainAnalyzer.isFlatEnough(pos, context.structureTemplateManager().getOrCreate(Piece.STRUCTURE_FILE).getSize(rotation), 1, 100, TerrainAnalyzer.context(context));
////        if (!results.getSecond()) {
////            return Optional.empty();
////        }
//
////        int y = context.chunkGenerator().getBaseHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
//
////        TWUtil.Logger.info("Generated at: {} {} {}", pos.getX(), pos.getY(), pos.getZ());
//        return Optional.of(new Structure.GenerationStub(pos, (piecesBuilder) -> piecesBuilder.addPiece(new Piece(pos.atY(y), context, rotation))));
//    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, GenerationContext context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        int y = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());

//        piecesBuilder.addPiece(new Piece(context, Piece.STRUCTURE_FILE, new BlockPos(x, y, z), context.random()));
        piecesBuilder.addPiece(new Piece(new BlockPos(x, y, z), context, Rotation.getRandom(context.random())));
    }

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (builder) -> generatePieces(builder, context));
    }

    @Override
    public @NotNull StructureType<?> type() {
        return TWStructures.WILD_HUNT_OUTPOST.getType();
    }

    public static class Piece extends GelTemplateStructurePiece {
        private static final ResourceLocation STRUCTURE_FILE = TheWitcher.locate("wild_hunt_outpost");

        public Piece(BlockPos pos, GenerationContext context, Rotation rotation) {
            super(TWStructures.WILD_HUNT_OUTPOST.getPieceType().get(), 0, context.structureTemplateManager(), STRUCTURE_FILE, pos);
            this.rotation = rotation;
            setupPlaceSettings(context.structureTemplateManager());
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt) {
            super(TWStructures.WILD_HUNT_OUTPOST.getPieceType().get(), nbt, context.structureTemplateManager());
            setupPlaceSettings(context.structureTemplateManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureTemplateManager structureManager) {
            Vec3i size = structureManager.get(makeTemplateLocation()).get().getSize();
            BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            StructurePlaceSettings settings = new StructurePlaceSettings().setLiquidSettings(LiquidSettings.IGNORE_WATERLOGGING).setRotationPivot(pivot);
            settings.clearProcessors();
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
            settings.addProcessor(TWProcessors.CRACK_DEEP_FROSTED_STONE_BRICKS)
                    .addProcessor(TWProcessors.CRACK_DEEP_FROSTED_STONE_BRICK_STAIRS)
                    .addProcessor(TWProcessors.PowderSnow)
                    .addProcessor(TWProcessors.DamageBattlements);
            return settings;
        }

        @Override
        @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox box) {
        }
    }
}