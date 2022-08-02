package com.plantnursery.plantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Admin;

@Repository
public class IAdminRepositoryImpl implements IAdminRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int login(String username, String password) {
		TypedQuery<Admin> emptqury=em.createQuery("select c from Admin c",Admin.class);
		List<Admin> c = emptqury.getResultList();
		int k=0;
		for(Admin f:c)
		{
		if(f.getAdminUsername().contains(username))
		 {
			if(f.getAdminPassword().contains(password))
			{
				k=1;
			}
		 }
		}
		return k;
	}

	@Override
	public List<Admin> readAllAdmin() {
		TypedQuery<Admin> emptqury=em.createQuery("select c from Admin c",Admin.class);
		return emptqury.getResultList();
	}

	

}
