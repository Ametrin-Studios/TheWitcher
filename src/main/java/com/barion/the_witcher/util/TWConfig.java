package com.barion.the_witcher.util;

import net.neoforged.neoforge.common.ModConfigSpec;

public class TWConfig {
    public static class Common {
        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

//        public final StructureConfig WitcherCitadelConfig;

        public static final ModConfigSpec SPEC = BUILDER.build();


            /*WitcherCitadelConfig = StructureConfig.builder(builder, "witcher_citadel")
                    .pushStructure()
                            .biomes("#minecraft:is_taiga", "#forge:is_plains", "#forge:is_dead", "!#minecraft:is_mountain")
                    .popStructure().build();*/
    }

    public static class Client{
        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        public static final ModConfigSpec.BooleanValue ALWAYS_FOGGY = BUILDER
                .push("white_frost")
                .comment("Should the White Frost always have dense fog")
                .define("always_foggy", false);

        public static final ModConfigSpec SPEC = BUILDER.build();
    }
}