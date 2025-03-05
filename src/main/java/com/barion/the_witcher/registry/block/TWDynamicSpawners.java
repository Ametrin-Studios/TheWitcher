package com.barion.the_witcher.registry.block;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.registry.TWLootTables;
import com.legacy.structure_gel.api.dynamic_spawner.DynamicSpawnerType;
import com.legacy.structure_gel.api.registry.RegistrarHolder;
import com.legacy.structure_gel.api.registry.StructureGelRegistries;
import com.legacy.structure_gel.api.registry.registrar.Registrar;
import com.legacy.structure_gel.api.registry.registrar.RegistrarHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentTable;
import net.minecraft.world.level.SpawnData;

import java.util.Optional;

import static com.legacy.structure_gel.api.block_entity.SpawnerAccessHelper.createSpawnerEntity;

@RegistrarHolder
public final class TWDynamicSpawners {
    public static final RegistrarHandler<DynamicSpawnerType> HANDLER = RegistrarHandler.getOrCreate(StructureGelRegistries.Keys.DYNAMIC_SPAWNER_TYPE, TheWitcher.MOD_ID);

    public static final Registrar.Static<DynamicSpawnerType> WITCHER_CITADEL_TOP = HANDLER.createStatic("witcher_citadel/tower", () -> (builder, registry) ->
    {
        builder.spawnData(createSpawnerEntity(EntityType.SKELETON, new CompoundTag(), Optional.of(new SpawnData.CustomSpawnRules(new InclusiveRange<>(0, 11), new InclusiveRange<>(0, 15))), Optional.of(new EquipmentTable(TWLootTables.Equipment.WITCHER_CITADEL_TOP_SKELETON, 0.1f))));
        builder.maxNearbyEntities(2);
    });
}
