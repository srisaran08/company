package com.plantnursery.plantnursery.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Plant;



@Repository
public class IPlantRepositoryImpl implements IPlantRepository
{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int deletePlant(int id) {
		Plant c= em.find(Plant.class,id);
		if(c !=null) {
		em.remove(c);
		}
		return c.getPlantId();
	}

	@Override
	public int createPlant(Plant plant) {
		em.persist(plant);
		return plant.getPlantId();
	}

	@Override
	public int updatePlant(Plant plant) {
		em.merge(plant);
		return plant.getPlantId();
	}

	@Override
	public Plant readPlant(int plantId) {
		return em.find(Plant.class,plantId);
	}

	@Override
	public List<Plant> readAllPlants() {
		TypedQuery<Plant> emptqury=em.createQuery("select c from Plant c",Plant.class);
		return emptqury.getResultList();
	}

	@Override
	public List<Plant> viewPlant(String commonname) {
		TypedQuery<Plant> emptqury=em.createQuery("select c from Plant c",Plant.class);
		List<Plant> result = emptqury.getResultList();
		List<Plant> c =  new ArrayList<>();
		for(Plant i:result)
		{
			if(i.getCommonname().contains(commonname))
			{c.add(i);}
		}
		return c;  
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfplant) {
		TypedQuery<Plant> emptqury=em.createQuery("select c from Plant c",Plant.class);
		List<Plant> result = emptqury.getResultList();
		List<Plant> c =  new ArrayList<>();
		for(Plant i:result)
		{
			if(i.getTypeOfPlant().contains(typeOfplant))
			{c.add(i);}
		}
		return c;
		
	}

}
