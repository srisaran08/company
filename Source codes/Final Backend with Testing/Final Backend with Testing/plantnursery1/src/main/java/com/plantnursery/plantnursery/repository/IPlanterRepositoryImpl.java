package com.plantnursery.plantnursery.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Planter;




@Repository
public class IPlanterRepositoryImpl implements IPlanterRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Planter> readAllPlanter() {
		// TODO Auto-generated method stub
		TypedQuery<Planter> emptqury=em.createQuery("select c from Planter c",Planter.class);
		return emptqury.getResultList();
	}

	@Override
	public int deletePlanter(int planterId) {
		// TODO Auto-generated method stub
		Planter c= em.find(Planter.class,planterId);
		if(c!=null) {
		em.remove(c);
		}
		return c.getPlanterId();
	}

	@Override
	public Planter readPlanter(int planterId) {
		return em.find(Planter.class,planterId);
	}



	

	@Override
	public int createPlanter(Planter planter) {
		em.persist(planter);
		return planter.getPlanterId();

	}

	@Override
	public int updatePlanter(Planter planter) {
		em.merge(planter);
		return planter.getPlanterId();

	}

	@Override
	public List<Planter> viewPlanter(String planterShape) {
		TypedQuery<Planter> emptqury=em.createQuery("select c from Planter c",Planter.class);
		List<Planter> result =  emptqury.getResultList();
		List<Planter> c =  new ArrayList<>();
		for(Planter i:result)
		{
			if(i.getPlanterShape().contains(planterShape))
			{c.add(i);}
		}
		return c;
	}
}
