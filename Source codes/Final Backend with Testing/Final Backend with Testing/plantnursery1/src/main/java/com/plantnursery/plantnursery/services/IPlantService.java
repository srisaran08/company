package com.plantnursery.plantnursery.services;

import java.util.List;

import com.plantnursery.plantnursery.entities.Plant;
import com.plantnursery.plantnursery.plant.exception.DuplicatePlantIdException;
import com.plantnursery.plantnursery.plant.exception.InvalidPlantDataException;
import com.plantnursery.plantnursery.plant.exception.NoSuchPlantException;

public interface IPlantService {
	public List<Plant> readAllPlants();
	public int deletePlant(int plantId) throws NoSuchPlantException;
	
	public Plant readPlant(int plantId) throws NoSuchPlantException;

	public int createPlant(Plant plant) throws  InvalidPlantDataException,DuplicatePlantIdException;

	public int updatePlant(Plant plant);
	public Plant viewPlant(int plantId);
	public List<Plant> viewPlant(String commonname);
	public List<Plant> viewAllPlants(String typeOfplant);
}
