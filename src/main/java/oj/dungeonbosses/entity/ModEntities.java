package oj.dungeonbosses.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import oj.dungeonbosses.DungeonBosses;
import oj.dungeonbosses.entity.custom.EnderWeaverEntity;


public class ModEntities  {
    public static final EntityType<EnderWeaverEntity> ENDER_WEAVER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(DungeonBosses.MOD_ID, "ender_weaver"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EnderWeaverEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 3)).build());
}
