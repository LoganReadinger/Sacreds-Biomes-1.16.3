package com.sacredninja.sacredsbiomes.dimension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.mojang.datafixers.types.templates.List;

import net.minecraft.block.BlockState;
import net.minecraft.data.BiomeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.structure.Structure;

public class CustomBiomeProvider extends BiomeProvider{

	private final RegistryKey<Biome> biome;
	public static final RegistryKey<Biome> SPAWN = Biomes.PLAINS;
	
	public CustomBiomeProvider(DataGenerator p_i242077_1_, RegistryKey<Biome> biome) {
		this.biome = SPAWN;
		super(p_i242077_1_);
	}

	public RegistryKey<Biome> getNoiseBiome(int x, int y, int z) {
		return biome;
	}
	
	public RegistryKey<Biome> getBiomesToSpawnIn(){
		return SPAWN;
	}
	
	public boolean hasStructure(Structure<?> structure) {
		return false;
	}
	
//	public Set<BlockState> getSurfaceBlocks(){
//		if (topBlocksCache.isEmpty()) {
//			topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
//		}
//		
//		return topBlocksCache;
//	}
}
