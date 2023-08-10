package oj.dungeonbosses;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import oj.dungeonbosses.entity.ModEntities;
import oj.dungeonbosses.entity.custom.EnderWeaverEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class DungeonBosses implements ModInitializer {
	public static  final String MOD_ID = "dugeonbosses";
    public static final Logger LOGGER = LoggerFactory.getLogger("dugeonbosses");

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.ENDER_WEAVER, EnderWeaverEntity.setAttributes());
	}
}