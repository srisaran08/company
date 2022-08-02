package com.plantnursery.plantnursery.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.plantnursery.entities.Plant;
import com.plantnursery.plantnursery.plant.exception.DuplicatePlantIdException;
import com.plantnursery.plantnursery.plant.exception.InvalidPlantDataException;
import com.plantnursery.plantnursery.plant.exception.NoSuchPlantException;
import com.plantnursery.plantnursery.repository.IPlantRepository;

@Service
public class IPlantServiceImpl implements IPlantService {
	
	@Autowired
	private IPlantRepository iPlantRepository;
	
	@Override
	public List<Plant> readAllPlants() {
		// TODO Auto-generated method stub
		return iPlantRepository.readAllPlants();
	}

	@Override
	@Transactional
	public int deletePlant(int plantId) throws NoSuchPlantException {
		// TODO Auto-generated method stub
		int pId=iPlantRepository.deletePlant(plantId);
		return pId;
	}

	@Override
	public Plant readPlant(int plantId) throws NoSuchPlantException {
		// TODO Auto-generated method stub
		Plant result = iPlantRepository.readPlant(plantId);
		if(result != null) {
		return result;
		}
		else {
			Plant emptyPlant=new Plant();
			emptyPlant.setPlantId(0);
			return emptyPlant;
		}
		
	}

	@Override
	@Transactional
	public int createPlant(Plant plant) throws InvalidPlantDataException, DuplicatePlantIdException {
		int id=0;
		System.out.println("create Plant called");
		System.out.println("plantid "+plant.getPlantId());
		Plant emp =iPlantRepository.readPlant(plant.getPlantId());
				
		if(emp!=null){
			System.out.println("Duplicate id");
			if(emp.getPlantId()==plant.getPlantId()) {
				throw new DuplicatePlantIdException("Plant with "+plant.getPlantId() +" already Exist");
			}
		}
		if(plant.getPlantId()<=0) {
		throw new InvalidPlantDataException("Plant ID is Invalid");
		}
		id= iPlantRepository.createPlant(plant);
		return id;
	}

	@Override
	@Transactional
	public int updatePlant(Plant plant) {
		 return iPlantRepository.updatePlant(plant);
	}

	@Override
	public Plant viewPlant(int plantId) {
		// TODO Auto-generated method stub
		return iPlantRepository.readPlant(plantId);
	}

	@Override
	public List<Plant> viewPlant(String commonname) {
		// TODO Auto-generated method stub
		return iPlantRepository.viewPlant(commonname);
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfplant) {
		// TODO Auto-generated method stub
		return iPlantRepository.viewAllPlants(typeOfplant);
	}
	
	
	

}
