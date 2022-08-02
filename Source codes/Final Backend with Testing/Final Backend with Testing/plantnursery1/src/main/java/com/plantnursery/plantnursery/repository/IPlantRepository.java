package com.plantnursery.plantnursery.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.plantnursery.plantnursery.entities.Plant;




@Repository
public interface IPlantRepository  {
	
	public int deletePlant(int plantId);
	public int createPlant(Plant plant);
	public int updatePlant(Plant plant);
	public Plant readPlant(int plantId);
	public List<Plant> readAllPlants();
	public List<Plant> viewPlant(String commonname);
	public List<Plant> viewAllPlants(String typeOfplant);
}

