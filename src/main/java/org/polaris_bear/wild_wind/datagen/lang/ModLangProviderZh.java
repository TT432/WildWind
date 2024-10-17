package org.polaris_bear.wild_wind.datagen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.polaris_bear.wild_wind.WildWindMod;
import org.polaris_bear.wild_wind.common.init.ModEntities;
import org.polaris_bear.wild_wind.common.init.ModItems;

public class ModLangProviderZh extends LanguageProvider {

    public ModLangProviderZh(PackOutput output) {
        super(output, WildWindMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.FIRE_FLY_EGG.get(), "生成萤火虫");
        add(ModEntities.FIRE_FLY.get(), "萤火虫");
    }
}
