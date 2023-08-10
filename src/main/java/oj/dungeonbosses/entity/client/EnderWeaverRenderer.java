package oj.dungeonbosses.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import oj.dungeonbosses.DungeonBosses;
import oj.dungeonbosses.entity.custom.EnderWeaverEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EnderWeaverRenderer extends GeoEntityRenderer<EnderWeaverEntity> {
    public EnderWeaverRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new EnderWeaverModel());
    }

    @Override
    public Identifier getTextureLocation(EnderWeaverEntity animatable){
        return new Identifier(DungeonBosses.MOD_ID, "/textures/entity/enderweaver.png");
    }

}
