package com.plantnursery.plantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.plantnursery.entities.Plant;
import com.plantnursery.plantnursery.plant.exception.DuplicatePlantIdException;
import com.plantnursery.plantnursery.plant.exception.InvalidPlantDataException;
import com.plantnursery.plantnursery.plant.exception.NoSuchPlantException;
import com.plantnursery.plantnursery.services.IPlantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlantController {

	@Autowired
	private IPlantService iPlantService;
	
	@GetMapping(path="/plant",produces ="application/json")
	public  ResponseEntity<List<Plant>> getAllPlants()
	{
		List<Plant> result = iPlantService.readAllPlants();
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Plant>>(result, HttpStatus.OK);
	}
	
	@GetMapping(path="/plant/{plantId}",produces = "application/json")
	public ResponseEntity<Plant> viewPlant(@PathVariable("plantId") int plantId) 
	{
	 	Plant plant = iPlantService.viewPlant(plantId);	
	 	if(plant==null) {
			return new ResponseEntity("Sorry! Customers not found!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
 
	@GetMapping(path="/plant/commonname/{commonname}",produces = "application/json")
	public ResponseEntity<List<Plant>> viewPlant(@PathVariable("commonname") String commonname) 
	{
		List<Plant> result = iPlantService.viewPlant(commonname);
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Plant>>(result, HttpStatus.OK);
	}
	
	@GetMapping(path="/plant/typeofplant/{typeOfplant}",produces = "application/json")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable("typeOfplant") String typeOfplant) 
	{
		List<Plant> result = iPlantService.viewAllPlants(typeOfplant);
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Plant>>(result, HttpStatus.OK);
	}
	
	
			
	@PostMapping(path="/plant",consumes = "application/json",produces ="application/json")
	public ResponseEntity<Plant> createPlant(@RequestBody Plant plant)
			throws DuplicatePlantIdException, InvalidPlantDataException {
		String errormsg = "";
		System.out.println("Add Plant called");
		int id = iPlantService.createPlant(plant);
		if (id >0)
		{
			return ResponseEntity.ok(plant);
		}
		throw new DuplicatePlantIdException("id exist");
	}
	
	@PutMapping(path="/plant/{plantId}",consumes ="application/json")
	public ResponseEntity<Plant> updatePlant(@PathVariable("plantId") int plantId, @RequestBody Plant plant) {
		int result = iPlantService.updatePlant(plant);
		if (result != 0) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	
	@DeleteMapping(path = "/plant/{plantId}",consumes ="application/json")
	public ResponseEntity<Plant> deletePlantById(@PathVariable("plantId") int plantId)
			throws NoSuchPlantException
	{
		Plant result = iPlantService.readPlant(plantId);
		System.out.println("Plant id is " + result.getPlantId());
		ResponseEntity<Plant> response = null;
		if (result.getPlantId() > 0) {
			System.out.println("Inside if");
			iPlantService.deletePlant(plantId);
			response = new ResponseEntity<Plant>(result, HttpStatus.OK);
			//]ResponseEntity response = new ResponseEntity("employee deleted successfully", HttpStatus.ACCEPTED);
			return response;
		} else {
			System.out.println("Inside else exception");
			throw new NoSuchPlantException("Plant with this ID Not Found");
		}
	}
	

}
