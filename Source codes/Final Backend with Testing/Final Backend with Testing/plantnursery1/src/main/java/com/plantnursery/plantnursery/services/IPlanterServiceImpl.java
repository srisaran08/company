package com.plantnursery.plantnursery.services;

import java.util.List;
//import java.util.Map;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.plantnursery.entities.Planter;
import com.plantnursery.plantnursery.planter.exception.DuplicatePlanterIdException;
import com.plantnursery.plantnursery.planter.exception.InvalidPlanterDataException;
import com.plantnursery.plantnursery.planter.exception.NoSuchPlanterException;
import com.plantnursery.plantnursery.repository.IPlanterRepository;


@Service
public class IPlanterServiceImpl implements IPlanterService {

	@Autowired
	private IPlanterRepository planterDao;


	@Override
	@Transactional
	public int deletePlanter(int planterId) throws NoSuchPlanterException {
		// TODO Auto-generated method stub
		int plaId=planterDao.deletePlanter(planterId);
		return plaId;
	}

	@Override
	public Planter readPlanter(int planterId) throws NoSuchPlanterException{
		Planter result = planterDao.readPlanter(planterId);
		if(result != null) {
		return result;
		}
		else {
			Planter emptyPla=new Planter();
			emptyPla.setPlanterId(0);
			return emptyPla;
		}
	}

	@Override
	@Transactional
	public int createPlanter(Planter planter) throws DuplicatePlanterIdException, InvalidPlanterDataException {
		int id=0;
		System.out.println("create planter called");
		System.out.println("planterid "+planter.getPlanterId());
		Planter pla=planterDao.readPlanter(planter.getPlanterId());
		//if pla is null and (that pla is not present in database
		//if pla is not null( is pla already present)
		if(pla!=null){
			System.out.println("Duplicate id");
			if(pla.getPlanterId()==planter.getPlanterId()) {
				throw new DuplicatePlanterIdException("Planter with "+planter.getPlanterId() +" already Exist");
			}
		}
		if(planter.getPlanterId()<=0) {
		throw new InvalidPlanterDataException("Planter ID is Invalid");
		}
		id=planterDao.createPlanter(planter);
		return id;
	}

	@Override
	@Transactional
	public int updatePlanter(Planter planter) {
		// TODO Auto-generated method stub
		return planterDao.updatePlanter(planter);
	}

	@Override
	public List<Planter> readAllPlanter() {
		// TODO Auto-generated method stub
		return planterDao.readAllPlanter();
	}

	@Override
	public Planter viewPlanter(int planterId) {
		// TODO Auto-generated method stub
		return planterDao.readPlanter(planterId);
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) {
		// TODO Auto-generated method stub
		return planterDao.viewPlanter(planterShape);
	}
}

	

	


	

