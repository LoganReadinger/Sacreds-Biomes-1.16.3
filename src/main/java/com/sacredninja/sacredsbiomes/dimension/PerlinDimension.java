package com.sacredninja.sacredsbiomes.dimension;

import java.awt.Dimension;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerEntity.SleepResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;

public class PerlinDimension extends Dimension{
	public PerlinDimension(World world, DimensionType type) { 
		super();
	}
	
	public ChunkGenerator createChunkGenerator(){
		return new CustomChunkGenerator(,,);
	}
	
	// These two functions find the world spawn point for this dimensions
	@Nullable
	public BlockPos findSpawn(ChunkPos chunkIn, boolean checkValid) {
		return null;
	}
	
	@Nullable
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}
	
	// Maximum build height
	public int getActualHeight() {
		return 256;
	}
	
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.NOT_POSSIBLE_HERE;
	}
	
	// Calculates day/night cycle
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		
		if (f1 < 0.0f){
			f1 += 1.0f;
		}
		
		if (f1 > 0.0f){
			f1 -= 1.0f;
		}
		
		float f2 = f1;
		
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0D) / 2.0D);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}
	
	// If it is like the surface world
	public boolean isSurfaceWorld() {
		return true;
	}
	
	// If there is light from the sky
	public boolean hasSkyLight() {
		return true;
	}
}
