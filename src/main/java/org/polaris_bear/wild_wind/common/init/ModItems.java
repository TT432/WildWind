package org.polaris_bear.wild_wind.common.init;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.polaris_bear.wild_wind.WildWindMod;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(WildWindMod.MOD_ID);

    public static final DeferredItem<Item> GLOW_GOOP = register("glow_goop");
    public static final DeferredItem<Item> FIRE_FLY_EGG =
            register("firefly_egg",
            new DeferredSpawnEggItem(ModEntities.FIRE_FLY, 0x000000,
                    0x000000, new Item.Properties()));

    private static DeferredItem<Item> register(String name) {
        return ITEMS.registerSimpleItem(name);
    }

    private static DeferredItem<Item> register(String name, Item item) {
        return ITEMS.registerItem(name, properties -> item);
    }

}
