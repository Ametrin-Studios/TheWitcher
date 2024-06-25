package com.barion.the_witcher.registry;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import com.barion.the_witcher.world.entity.TWWildHuntHoundEntity;
import com.barion.the_witcher.world.entity.TWWildHuntKnightEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TWEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TheWitcher.MOD_ID);

    public static final Supplier<EntityType<TWIceGhostEntity>> ICE_GHOST = register("ice_ghost", livingEntity(TWIceGhostEntity::new, MobCategory.MONSTER, 0.6f, 1.95f, 8));
    public static final Supplier<EntityType<TWWildHuntHoundEntity>> WILD_HUNT_HOUND = register("wild_hunt_hound", livingEntity(TWWildHuntHoundEntity::new, MobCategory.MONSTER, 1.3f, 1.2f, 16));
    public static final Supplier<EntityType<TWWildHuntKnightEntity>> WILD_HUNT_KNIGHT = register("wild_hunt_knight", livingEntity(TWWildHuntKnightEntity::new, MobCategory.MONSTER, 0.6f, 1.95f, 16));

    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ICE_GHOST.get(), TWIceGhostEntity.createAttributes().build());
        event.put(WILD_HUNT_HOUND.get(), TWWildHuntHoundEntity.createAttributes().build());
        event.put(WILD_HUNT_KNIGHT.get(), TWWildHuntKnightEntity.createAttributes().build());
    }

    private static <E extends Entity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> boat(EF entity) {
        return entity(entity, MobCategory.MISC,1.375f,0.5625f);
    }
    private static <E extends LivingEntity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> livingEntity(EF entity, MobCategory category, float width, float height, int trackingRange){
        return entity(entity, category, width, height).clientTrackingRange(trackingRange);
    }
    private static <E extends Entity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> entity(EF entity, MobCategory category, float width, float height){
        return EntityType.Builder.of(entity, category).sized(width, height);
    }
    private static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> register(String id, EntityType.Builder<E> builder) {return REGISTER.register(id, ()-> builder.build(TWUtil.location(id).toString()));}
}