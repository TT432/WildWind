package org.polaris_bear.wild_wind.server;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import org.polaris_bear.wild_wind.WildWindMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = WildWindMod.MOD_ID, value = Dist.DEDICATED_SERVER)
public class WildWindServerEventHandler {
}
