package oj.dungeonbosses.entity.client;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import oj.dungeonbosses.DungeonBosses;
import oj.dungeonbosses.entity.custom.EnderWeaverEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EnderWeaverModel extends GeoModel<EnderWeaverEntity> {
    @Override
    public Identifier getModelResource(EnderWeaverEntity animatable) {
        return new Identifier(DungeonBosses.MOD_ID, "/geo/enderweaver.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnderWeaverEntity animatable) {
        return new Identifier(DungeonBosses.MOD_ID, "/textures/entity/EnderWeaver.png");
    }

    @Override
    public Identifier getAnimationResource(EnderWeaverEntity animatable) {
        return new Identifier(DungeonBosses.MOD_ID, "/animations/EnderWeaver.animation.json");
    }

    @Override
    public void setCustomAnimations(EnderWeaverEntity animatable, long instanceId, AnimationState<EnderWeaverEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("h_head");

        if (head !=null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }

}
