package com.legacy.aether.client.renders.entity;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.legacy.aether.Aether;
import com.legacy.aether.client.models.entities.PhygWingModel;
import com.legacy.aether.entities.passive.mountable.EntityPhyg;

public class PhygRenderer extends RenderLiving
{

	private static final ResourceLocation TEXTURE = Aether.locate("textures/entities/phyg/phyg.png");

	private static final ResourceLocation TEXTURE_WINGS = Aether.locate("textures/entities/phyg/wings.png");

    private static final ResourceLocation TEXTURE_SADDLE = new ResourceLocation("textures/entity/pig/pig_saddle.png");

	private final PhygWingModel wingModel = new PhygWingModel();

	private final ModelPig saddleModel = new ModelPig(0.5F);

	public PhygRenderer()
	{
		super(new ModelPig(), 0.7F);
	}

    protected int renderLayers(EntityPhyg entity, int pass, float particleTicks)
    {
        if (entity.isInvisible())
        {
            return 0;
        }
        else if (pass == 0)
        {
        	this.setRenderPassModel(this.wingModel);
    		this.bindTexture(TEXTURE_WINGS);

            return 1;
        }
        else if (pass == 1 && entity.isSaddled())
        {
        	this.setRenderPassModel(this.saddleModel);
    		this.bindTexture(TEXTURE_SADDLE);

            return 1;
        }

        return -1;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int pass, float particleTicks)
    {
        return this.renderLayers((EntityPhyg)entity, pass, particleTicks);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return TEXTURE;
	}

}