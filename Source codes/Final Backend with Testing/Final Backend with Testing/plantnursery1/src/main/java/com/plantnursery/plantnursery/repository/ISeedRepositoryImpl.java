package com.plantnursery.plantnursery.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Seed;






@Repository
public class ISeedRepositoryImpl implements ISeedRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Seed> readAllSed() {
		// TODO Auto-generated method stub
		TypedQuery<Seed> emptqury=em.createQuery("select c from Seed c",Seed.class);
		return emptqury.getResultList();
	}

	@Override
	public int deleteSed(int seedId) {
		// TODO Auto-generated method stub
		Seed c= em.find(Seed.class,seedId);
		if(c!=null) {
		em.remove(c);
		}
		return c.getSeedId();
	}

	@Override
	public Seed readSed(int seedId) {
		return em.find(Seed.class,seedId);
	}


	@Override
	public int createSed(Seed seed) {
		em.persist(seed);
		return seed .getSeedId();
	}
	
	@Override
	public int updateSed(Seed seed) {
		em.merge(seed);
		return seed.getSeedId();
	}

	
	@Override
	public List<Seed> viewSeed(String commonName) {
		// TODO Auto-generated method stub
		TypedQuery<Seed> emptqury=em.createQuery("select c from Seed c",Seed.class);
		List<Seed> c =  emptqury.getResultList();
		List<Seed> k = new ArrayList<>();
		for(Seed i:c)
		{
			if(i.getCommonName().contains(commonName))
			{k.add(i);
			}
		}
		return k;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeeds) {
		// TODO Auto-generated method stub
		TypedQuery<Seed> emptqury=em.createQuery("select c from Seed c",Seed.class);
		List<Seed> c =  emptqury.getResultList();
		List<Seed> k = new ArrayList<>();
		for(Seed i:c)
		{
			if(i.getTypeOfSeeds().contains(typeOfSeeds))
			{k.add(i);}
		}
		return k;
	}

}

