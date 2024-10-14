package org.polaris_bear.wild_wind.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.polaris_bear.wild_wind.common.entity.goal.FireflyBaseGoal;
import org.polaris_bear.wild_wind.common.entity.goal.FireflyFlyGoal;
import org.polaris_bear.wild_wind.common.entity.goal.FireflyRoostGoal;

public class Firefly extends PathfinderMob implements FlyingAnimal {

    private static final EntityDataAccessor<Boolean> roost = SynchedEntityData.defineId(Firefly.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idle = new AnimationState();
    public Firefly(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(roost, false);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public void setRoost(boolean r) {
        this.entityData.set(roost, r);
    }

    public boolean isRoost() {
        return this.entityData.get(roost);
    }

    @Override
    public void tick() {
        super.tick();
        idle.startIfStopped(tickCount);
    }

    @Override
    public boolean canBeLeashed() {
        return false;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setRoost(compound.getBoolean("roost"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("roost", isRoost());
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level) {
            @Override
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }
        };
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setCanPassDoors(false);
        return flyingPathNavigation;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {

    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FireflyBaseGoal(this));
        this.goalSelector.addGoal(1, new FireflyRoostGoal(this));
        this.goalSelector.addGoal(2, new FireflyFlyGoal(this));

    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        return super.mobInteract(player, hand);
    }

    public static AttributeSupplier createAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8f)
                .add(Attributes.FLYING_SPEED, 0.6f)
                .build();
    }



    @Override
    public boolean isFlying() {
        return true;
    }
}
