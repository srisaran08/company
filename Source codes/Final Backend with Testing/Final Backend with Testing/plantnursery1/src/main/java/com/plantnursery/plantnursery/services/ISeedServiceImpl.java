package com.plantnursery.plantnursery.services;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.plantnursery.entities.Seed;
import com.plantnursery.plantnursery.repository.ISeedRepository;

import com.plantnursery.plantnursery.seed.exception.DuplicateSeedIdException;
import com.plantnursery.plantnursery.seed.exception.InvalidSeedDataException;
import com.plantnursery.plantnursery.seed.exception.NoSuchSeedException;


@Service

public class ISeedServiceImpl implements ISeedService {

	@Autowired
	private ISeedRepository seedDao;

	@Override
	@Transactional
	public int deleteSed(int seedId) throws NoSuchSeedException {
		// TODO Auto-generated method stub
		int sedId=seedDao.deleteSed(seedId);
		return sedId;
	}

	@Override
	public Seed readSed(int seedId) throws NoSuchSeedException{
		Seed result = seedDao.readSed(seedId);
		if(result != null) {
		return result;
		}
		else {
			Seed emptySeede=new Seed();
			emptySeede.setSeedId(0);
			return emptySeede;
		}
	}

	@Override
	@Transactional
	public int createSed(Seed seed) throws DuplicateSeedIdException, InvalidSeedDataException {
		int id=0;
		System.out.println("create sed called");
		System.out.println("sedid "+seed.getSeedId());
		Seed sed=seedDao.readSed(seed.getSeedId());
		//if ord is null and (that ord is not present in database
		//if ord is not null(ord is already present)
		if(sed!=null){
			System.out.println("Duplicate id");
			if(sed.getSeedId()==seed.getSeedId()) {
				throw new DuplicateSeedIdException("Ord with "+seed.getSeedId() +" already Exist");
			}
		}
		if(seed.getSeedId()<=0) {
		throw new InvalidSeedDataException("Ord ID is Invalid");
		}
		id=seedDao.createSed(seed);
		return id;
	}

	@Override
	@Transactional
	public int updateSed(Seed order) {
		// TODO Auto-generated method stub
		return seedDao.updateSed(order);
	}

	@Override
	public List<Seed> readAllSed() {
		// TODO Auto-generated method stub
		return seedDao.readAllSed();
	}

	@Override
	public List<Seed> viewSeed(String commonName) {
		// TODO Auto-generated method stub
		return seedDao.viewSeed(commonName);
	}

	@Override
	public Seed viewSeed(int seedId) {
		// TODO Auto-generated method stub
		return seedDao.readSed(seedId);
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeeds) {
		// TODO Auto-generated method stub
		return seedDao.viewAllSeeds(typeOfSeeds);
		}
}

