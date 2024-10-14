package org.polaris_bear.wild_wind.datagen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.polaris_bear.wild_wind.WildWindMod;
import org.polaris_bear.wild_wind.common.init.ModItems;

public class ModLangProviderEn extends LanguageProvider {

    public ModLangProviderEn(PackOutput output) {
        super(output, WildWindMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.FIRE_FLY_EGG.get(), "Firefly Spawn Egg");
    }
}
