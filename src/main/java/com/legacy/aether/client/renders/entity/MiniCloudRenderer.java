package com.legacy.aether.client.renders.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.legacy.aether.Aether;
import com.legacy.aether.client.models.entities.MiniCloudModel;

public class MiniCloudRenderer extends RenderLiving
{

	public MiniCloudRenderer() 
	{
		super(new MiniCloudModel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return Aether.locate("textures/entities/mini_cloud/mini_cloud.png");
	}

}