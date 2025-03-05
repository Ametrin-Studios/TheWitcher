package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWTags;
import com.barion.the_witcher.world.gen.structure.TWIcyRuinStructure;
import com.barion.the_witcher.world.gen.structure.TWWildHuntOutpostStructure;
import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
import com.legacy.structure_gel.api.registry.RegistrarHolder;
import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import com.legacy.structure_gel.api.structure.GridStructurePlacement;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

@RegistrarHolder
public final class TWStructures {
    private TWStructures() { }

    public static final StructureRegistrar<TWIcyRuinStructure> ICY_RUIN = StructureRegistrar.builder(TheWitcher.locate("icy_ruin"), () -> () -> TWIcyRuinStructure.CODEC)
            .placement(() -> GridStructurePlacement.builder(27, 0.8f).allowedNearSpawn(true).build(TWStructures.ICY_RUIN))
            .addPiece(() -> TWIcyRuinStructure.Piece::new)
            .pushStructure(TWIcyRuinStructure::new)
                    .biomes(TWTags.Biomes.HAS_ICY_RUIN)
            .popStructure()
            .build();

    public static final StructureRegistrar<TWWildHuntOutpostStructure> WILD_HUNT_OUTPOST = StructureRegistrar.builder(TheWitcher.locate("wild_hunt_outpost"), () -> () -> TWWildHuntOutpostStructure.CODEC)
            .placement(() -> GridStructurePlacement.builder(40, 0.7f).allowedNearSpawn(true).build(TWStructures.WILD_HUNT_OUTPOST))
            .addPiece(() -> TWWildHuntOutpostStructure.Piece::new)
            .pushStructure(TWWildHuntOutpostStructure::new)
                    .biomes(TWTags.Biomes.HAS_ICY_RUIN)
//                    .spawns(MobCategory.MONSTER, StructureSpawnOverride.BoundingBoxType.PIECE,)
            .terrainAdjustment(TerrainAdjustment.BEARD_BOX)
            .popStructure()
            .build();

    public static final StructureRegistrar<TWWitcherCitadelStructure> WITCHER_CITADEL = StructureRegistrar.builder(TheWitcher.locate("witcher_citadel"), () -> () -> TWWitcherCitadelStructure.CODEC)
            .placement(() -> GridStructurePlacement.builder(72, 48, 0.9f).allowedNearSpawn(false).build(TWStructures.WITCHER_CITADEL))
            .addPiece(() -> TWWitcherCitadelStructure.Piece::new)
            .pushStructure(TWWitcherCitadelStructure::new)
                    .biomes(TWTags.Biomes.HAS_WITCHER_CITADEL)
                    .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .popStructure()
            .build();
}