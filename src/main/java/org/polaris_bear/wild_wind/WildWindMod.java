package org.polaris_bear.wild_wind;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.polaris_bear.wild_wind.common.init.ModCreativeTabs;
import org.polaris_bear.wild_wind.common.init.ModEntities;
import org.polaris_bear.wild_wind.common.init.ModItems;

@Mod(WildWindMod.MOD_ID)
public class WildWindMod {

    public static final String MOD_ID = "wild_wind";
    public static final String MOD_NAME = "Wild Wind";
    public static final String MOD_VERSION = ModList.get().getModFileById(MOD_ID).versionString();

    public WildWindMod(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, WildWindConfig.SPEC);
    }
}
