package com.plantnursery.plantnursery.controller;
import com.plantnursery.plantnursery.entities.Planter;
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


import com.plantnursery.plantnursery.planter.exception.DuplicatePlanterIdException;
import com.plantnursery.plantnursery.planter.exception.InvalidPlanterDataException;
import com.plantnursery.plantnursery.planter.exception.NoSuchPlanterException;
import com.plantnursery.plantnursery.services.IPlanterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlanterController {

	@Autowired
	private IPlanterService iPlanterService;
	
	@GetMapping(path="/planter",produces = "application/json")
	public ResponseEntity<List<Planter>> getAllPlanters() {
		List<Planter> result = iPlanterService.readAllPlanter();
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Planter>>(result, HttpStatus.OK);
	}

 @GetMapping(path="/planter/{planterId}",produces = "application/json")
	public ResponseEntity<Planter> viewPlanter(@PathVariable("planterId") int plantId) 
	{
	    Planter planter =  iPlanterService.viewPlanter(plantId);	
	    if(planter==null) {
			return new ResponseEntity("Sorry! Customers not found!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Planter>(planter, HttpStatus.OK);
	}
 
 @GetMapping(path="/planter/plantershape/{planterShape}",produces = "application/json")
	public ResponseEntity<List<Planter>> viewPlanter(@PathVariable("planterShape") String planterShape) 
	{
	 List<Planter> result = iPlanterService.viewPlanter(planterShape);	
	 if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Planter>>(result, HttpStatus.OK);
	}
 
 @PostMapping(path="/planter",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Planter> createPlanter(@RequestBody Planter planter)
			throws DuplicatePlanterIdException, InvalidPlanterDataException {
		String errormsg = "";
		System.out.println("add planter called");
		int id = iPlanterService.createPlanter(planter);
		if (id >0)
		{
			return ResponseEntity.ok(planter);
		}
		throw new DuplicatePlanterIdException("id exist");

	}
	
	@PutMapping(path = "/planter/{planterId}", consumes = "application/json")
	public ResponseEntity<Planter> updatePlanter(@PathVariable("planterId") int planterId, @RequestBody Planter planter) {
		int result = iPlanterService.updatePlanter(planter);
		if (result != 0) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	@DeleteMapping(path = "/planter/{planterId}", produces = "application/json")
	public ResponseEntity<Planter> deletePlanterById(@PathVariable("planterId") int planterId)
			throws NoSuchPlanterException {
		Planter result = iPlanterService.readPlanter(planterId);
		System.out.println("Planter id is " + result.getPlanterId());
		ResponseEntity<Planter> response = null;
		if (result.getPlanterId() > 0) {
			System.out.println("Inside if");
			iPlanterService.deletePlanter(planterId);
			response = new ResponseEntity<Planter>(result, HttpStatus.OK);
			//]ResponseEntity response = new ResponseEntity("planter deleted successfully", HttpStatus.ACCEPTED);
			return response;
		} else {
			System.out.println("Inside else exception");
			throw new NoSuchPlanterException("Planter with this ID Not Found");
		}
	}
	

}
