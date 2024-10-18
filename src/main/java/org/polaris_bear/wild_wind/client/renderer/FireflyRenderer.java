package org.polaris_bear.wild_wind.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.polaris_bear.wild_wind.client.model.FireflyModel;
import org.polaris_bear.wild_wind.common.entity.Firefly;
import org.polaris_bear.wild_wind.util.Helpers;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FireflyRenderer extends GeoEntityRenderer<Firefly> {

    public FireflyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireflyModel());
    }
}
