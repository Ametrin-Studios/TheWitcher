package com.barion.the_witcher.world.entity;

import com.barion.the_witcher.registry.TWLootTables;
import com.barion.the_witcher.world.TWTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWWildHuntKnightEntity extends Monster {
    public TWWildHuntKnightEntity(EntityType<TWWildHuntKnightEntity> entity, Level level) { super(entity, level); }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));

        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true, (entity, level) -> !entity.getType().is(TWTags.EntityTypes.WILD_HUNT_IGNORE)));
    }

    @NotNull
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 28)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 2);
    }

    private static final EquipmentTable equipmentTable = new EquipmentTable(TWLootTables.Equipment.WILD_HUNT_KNIGHT, 0.2f);

    @Override @ParametersAreNonnullByDefault
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData spawnGroupData) {
        populateDefaultEquipmentSlots(random, difficulty);
        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, @NotNull DifficultyInstance difficulty) {
        equip(equipmentTable);
//        populateEquipmentSlot(EquipmentSlot.HEAD);
//        populateEquipmentSlot(EquipmentSlot.CHEST);
//        populateEquipmentSlot(EquipmentSlot.LEGS);
//        populateEquipmentSlot(EquipmentSlot.FEET);
//        setItemSlot(EquipmentSlot.MAINHAND, getEquipmentItemForSlot(EquipmentSlot.MAINHAND, random.nextInt(3) > 0));
//        if(random.nextInt(3) == 2){
//            setItemSlot(EquipmentSlot.OFFHAND, getEquipmentItemForSlot(EquipmentSlot.OFFHAND, false));
//        }
    }

//    protected void populateEquipmentSlot(EquipmentSlot slot){
//        int chance = random.nextInt(5);
//        if(chance <=  1) {return;}
//
//        setItemSlot(slot, getEquipmentItemForSlot(slot, chance == 4));
//    }
//
//    protected ItemStack getEquipmentItemForSlot(EquipmentSlot slot, boolean isRare){
//        if(isRare){
//            switch(slot){
//                case HEAD -> {return new ItemStack(TWItems.REINFORCED_LEATHER_HELMET.get());}
//                case CHEST -> {return new ItemStack(TWItems.REINFORCED_LEATHER_CHESTPLATE.get());}
//                case LEGS -> {return new ItemStack(TWItems.REINFORCED_LEATHER_LEGGINGS.get());}
//                case FEET -> {return new ItemStack(TWItems.REINFORCED_LEATHER_BOOTS.get());}
//                case MAINHAND -> {return new ItemStack(TWItems.STEEL_SWORD.get());}
//                case OFFHAND -> {return new ItemStack(Items.SHIELD);}
//            }
//        }else {
//            switch(slot){
//                case HEAD -> {return new ItemStack(Items.IRON_HELMET);}
//                case CHEST -> {return new ItemStack(Items.IRON_CHESTPLATE);}
//                case LEGS -> {return new ItemStack(Items.IRON_LEGGINGS);}
//                case FEET -> {return new ItemStack(Items.IRON_BOOTS);}
//                case MAINHAND -> {return new ItemStack(Items.IRON_SWORD);}
//                case OFFHAND -> {return new ItemStack(Items.SHIELD);}
//            }
//        }
//        return ItemStack.EMPTY;
//    }
}