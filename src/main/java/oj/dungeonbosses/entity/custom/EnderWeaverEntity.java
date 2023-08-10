package oj.dungeonbosses.entity.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EnderWeaverEntity extends EndermanEntity implements GeoEntity{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public EnderWeaverEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 160.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.5f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 4.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 128.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(7, new WanderAroundFarGoal((PathAwareEntity)this, 1.0, 0.0f));

        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 16.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> eAnimationState) {
        if(eAnimationState.isMoving()) {
        eAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.enderweaver.walk", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
        }

        eAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.enderweaver.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}


