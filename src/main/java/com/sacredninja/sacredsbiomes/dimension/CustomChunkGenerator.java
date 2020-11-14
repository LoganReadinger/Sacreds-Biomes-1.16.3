package com.sacredninja.sacredsbiomes.dimension;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.BiomeProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

public abstract class CustomChunkGenerator extends ChunkGenerator{
	
	public CustomChunkGenerator(net.minecraft.world.biome.provider.BiomeProvider p_i231887_1_, net.minecraft.world.biome.provider.BiomeProvider p_i231887_2_, DimensionStructuresSettings p_i231887_3_, long p_i231887_4_) {
		super(p_i231887_1_, p_i231887_2_, p_i231887_3_, p_i231887_4_);
	}
	
	public void generateSurface(WorldGenRegion region, IChunk chunk) {
		BlockState bedrock = Blocks.BEDROCK.getDefaultState();
		BlockState stone = Blocks.STONE.getDefaultState();
		ChunkPos chunkpos = chunk.getPos();
		PerlinNoise perlin = new PerlinNoise();
		
		BlockPos.Mutable pos = new BlockPos.Mutable();
		
		int x;
		int z;
		
		// Set Bedrock
		for (x = 0; x < 16; x++) {
			for(z = 0; z < 16; z++) {
				chunk.setBlockState(pos.setPos(x,0,z), bedrock, false);
			}
		}
		
		// Set Stone
		for (x = 0; x < 16; x++) {
			for(z = 0; z < 16; z++) {
				int realx = chunkpos.x * 16 + x;
				int realz = chunkpos.z * 16 + z;
				int height = (int) (65 + Math.sin(realx / 20.0f) * 10 + Math.cos(realz / 20.0f) * 10);
				
				perlin.perlin(x, 0.0, z);
				for(int y = 1; y < height; y++) {					
					chunk.setBlockState(pos.setPos(x,y,z), stone, false);
				}
			}
		}
	}
	
	public void makeBase(IWorld worldIn, IChunk chunkIn) {
		
	}
	
	public int func222529_a(int p_222529_l_, int p_222529_2_, Heightmap.Type heightmapType) {
		return 0;
	}
}
