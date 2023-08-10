package oj.dungeonbosses;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import oj.dungeonbosses.entity.ModEntities;
import oj.dungeonbosses.entity.client.EnderWeaverRenderer;

public class DungeonBossesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){

        EntityRendererRegistry.register(ModEntities.ENDER_WEAVER, EnderWeaverRenderer::new);

    }
}
