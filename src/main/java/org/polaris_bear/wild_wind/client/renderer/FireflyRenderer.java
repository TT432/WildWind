package org.polaris_bear.wild_wind.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.tt432.eyelib.capability.RenderData;
import io.github.tt432.eyelib.capability.component.AnimationComponent;
import io.github.tt432.eyelib.client.ClientTickHandler;
import io.github.tt432.eyelib.client.animation.BrAnimator;
import io.github.tt432.eyelib.client.loader.BrModelLoader;
import io.github.tt432.eyelib.client.render.BrModelTextures;
import io.github.tt432.eyelib.client.render.ModelRenderer;
import io.github.tt432.eyelib.client.render.RenderParams;
import io.github.tt432.eyelib.client.render.visitor.BuiltInBrModelRenderVisitors;
import io.github.tt432.eyelib.client.render.visitor.ModelRenderVisitorList;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import org.polaris_bear.wild_wind.WildWindMod;
import org.polaris_bear.wild_wind.common.entity.Firefly;

import java.util.HashMap;
import java.util.List;

public class FireflyRenderer extends EntityRenderer<Firefly> {
    private static final ResourceLocation TEXTURE = WildWindMod.mod("textures/entity/firefly.png");
    private static final ResourceLocation MODEL = WildWindMod.mod("firefly");

    public FireflyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(Firefly entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);

        poseStack.pushPose();

        RenderData<Object> component = RenderData.getComponent(entity);
        AnimationComponent animationComponent = component.getAnimationComponent();
        animationComponent.setup(MODEL, MODEL);
        var infos = BrAnimator.tickAnimation(animationComponent,
                component.getScope(), ClientTickHandler.getTick() + partialTick);

        RenderType renderType = RenderType.entityCutout(TEXTURE);
        ModelRenderer.render(new RenderParams(
                        entity,
                        poseStack.last().copy(),
                        poseStack,
                        renderType,
                        bufferSource.getBuffer(renderType),
                        packedLight,
                        LivingEntityRenderer.getOverlayCoords(entity, 0)
                ), BrModelLoader.getModel(MODEL), infos,
                new BrModelTextures.TwoSideInfoMap(new HashMap<>()),
                new ModelRenderVisitorList(List.of(BuiltInBrModelRenderVisitors.BLANK.get())));
        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(Firefly firefly) {
        return TEXTURE;
    }
}
