package com.plantnursery.plantnursery.repository;

import java.util.List;

import com.plantnursery.plantnursery.entities.Seed;





public interface ISeedRepository {
	public List<Seed> readAllSed();
	public int deleteSed(int seedId);
	public Seed readSed(int seedId);
	public int createSed(Seed  seed);
	public int updateSed(Seed seed);
	public List<Seed> viewSeed(String commonName);
	public List<Seed> viewAllSeeds(String typeOfSeeds);
}
