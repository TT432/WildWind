package org.polaris_bear.wild_wind.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.polaris_bear.wild_wind.client.model.FireflyModel;
import org.polaris_bear.wild_wind.common.entity.Firefly;
import org.polaris_bear.wild_wind.util.Helpers;

public class FireflyRenderer extends MobRenderer<Firefly, FireflyModel> {
    private static final ResourceLocation FIREFLY_LOCATION = Helpers.location("textures/entity/firefly.png");

    public FireflyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FireflyModel(pContext.bakeLayer(FireflyModel.LOCATION)), 0.4f);
    }


    @Override
    public ResourceLocation getTextureLocation(Firefly entity) {
        return FIREFLY_LOCATION;
    }

    @Override
    public void render(
            Firefly entity,
            float yaw,
            float partialTick,
            PoseStack transform,
            MultiBufferSource bufferSource,
            int packedLight
    ) {

        super.render(entity, yaw, partialTick, transform, bufferSource, packedLight);

    }
}
