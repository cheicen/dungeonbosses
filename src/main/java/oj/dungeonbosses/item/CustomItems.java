package oj.dungeonbosses.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import oj.dungeonbosses.DungeonBosses;
import oj.dungeonbosses.entity.ModEntities;

public class CustomItems {
    public static final Item ENDER_WEAVER_EGG = registerItem("Ender_Weaver_Spawn_Egg",
            new SpawnEggItem(ModEntities.ENDER_WEAVER, 0x012a39,0x390d3f,new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DungeonBosses.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DungeonBosses.LOGGER.info("Registering Mod Items for " + DungeonBosses.MOD_ID);
    }

}
