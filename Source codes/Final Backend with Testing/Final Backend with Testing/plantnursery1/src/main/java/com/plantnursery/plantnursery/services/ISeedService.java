package com.plantnursery.plantnursery.services;
import java.util.List;

import com.plantnursery.plantnursery.entities.Seed;
import com.plantnursery.plantnursery.seed.exception.DuplicateSeedIdException;
import com.plantnursery.plantnursery.seed.exception.InvalidSeedDataException;
import com.plantnursery.plantnursery.seed.exception.NoSuchSeedException;


public interface ISeedService {
	
	public int deleteSed(int seedId) throws NoSuchSeedException;

	public List<Seed> readAllSed();

	public Seed readSed(int seedId) throws NoSuchSeedException;

	public int createSed(Seed seed) throws  InvalidSeedDataException,DuplicateSeedIdException;

	public int updateSed(Seed seed);

	public List<Seed> viewSeed(String commonName);
	public Seed viewSeed(int seedId);
	public List<Seed> viewAllSeeds(String typeOfSeeds);
	}