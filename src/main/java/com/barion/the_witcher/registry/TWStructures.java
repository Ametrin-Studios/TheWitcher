package com.barion.the_witcher.registry;

//import com.barion.the_witcher.world.TWTags;
//import com.barion.the_witcher.util.TWUtil;
//import com.barion.the_witcher.world.gen.structure.TWIcyRuinStructure;
//import com.barion.the_witcher.world.gen.structure.TWWildHuntOutpostStructure;
//import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
//import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
//import com.legacy.structure_gel.api.structure.GridStructurePlacement;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

public final class TWStructures {
    private TWStructures() {}

    public static void init() {}

//    public static StructureRegistrar<TWIcyRuinStructure> IcyRuin;
//    public static StructureRegistrar<TWWitcherCitadelStructure> WitcherCitadel;
//    public static StructureRegistrar<TWWildHuntOutpostStructure> WildHuntOutpost;


    static {
//        IcyRuin = StructureRegistrar.builder(TWUtil.locate("icy_ruin"), () -> ()-> TWIcyRuinStructure.Codec)
//                .addPiece(()-> TWIcyRuinStructure.Piece::new)
//                .pushStructure(TWIcyRuinStructure::new)
//                        .biomes(TWTags.Biomes.HAS_ICY_RUIN)
//                        .dimensions(TWLevels.WHITE_FROST)
//                .popStructure()
//                .placement(()-> GridStructurePlacement.builder(27, 0.8f).build(IcyRuin.getRegistryName()))
//                .build();

        /*WildHuntOutpost = StructureRegistrar.builder(TWUtil.location("wild_hunt_outpost"), ()-> ()-> TWWildHuntOutpostStructure.Codec)
                .addPiece(()-> TWWildHuntOutpostStructure.Piece::new)
                .pushStructure(TWWildHuntOutpostStructure::new)
                        .biomes(TWTags.Biomes.hasIcyRuin)
                        .dimensions(TWLevels.WhiteFrost)
//                        .spawns(MobCategory.MONSTER, StructureSpawnOverride.BoundingBoxType.PIECE,)
                        .terrainAdjustment(TerrainAdjustment.BEARD_BOX)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(40, 0.7f).build(WildHuntOutpost.getRegistryName()))
                .build();*/

//        WitcherCitadel = StructureRegistrar.builder(TWUtil.locate("witcher_citadel"), ()-> ()-> TWWitcherCitadelStructure.Codec)
//                .addPiece(()-> TWWitcherCitadelStructure.Piece::new)
//                .pushStructure(TWWitcherCitadelStructure::new)
////                        .config(TWConfig.COMMON.WitcherCitadelConfig::getStructure)
//                        .dimensions(Level.OVERWORLD)
//                        .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
//                .popStructure()
//                .placement(()-> GridStructurePlacement.builder(72, 48, 0.9f).allowedNearSpawn(false).build(WitcherCitadel.getRegistryName()))
//                .build();
    }
}