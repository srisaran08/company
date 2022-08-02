package com.plantnursery.plantnursery.controller;
import com.plantnursery.plantnursery.entities.Seed;
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


import com.plantnursery.plantnursery.seed.exception.DuplicateSeedIdException;
import com.plantnursery.plantnursery.seed.exception.InvalidSeedDataException;
import com.plantnursery.plantnursery.seed.exception.NoSuchSeedException;
import com.plantnursery.plantnursery.services.ISeedService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeedController {

	@Autowired
	private ISeedService iSeedService;
	
	 @GetMapping(path="/seed",produces = "application/json")
		public ResponseEntity<List<Seed>> getAllSeed() {
			List<Seed> result = iSeedService.readAllSed();
			if(result.isEmpty()) {
				return new ResponseEntity("Sorry! Products not available!", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Seed>>(result, HttpStatus.OK);
		}
	
	 @GetMapping(path="/seed/{seedId}",produces = "application/json")
		public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") int seedId) 
		{
		 	Seed seed = iSeedService.viewSeed(seedId);	
		 	if(seed==null) {
				return new ResponseEntity("Sorry! Customers not found!", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Seed>(seed, HttpStatus.OK);
		}
	 
	 @GetMapping(path="/seed/commonname/{commonName}",produces = "application/json")
		public ResponseEntity<List<Seed>> viewSeed(@PathVariable("commonName") String commonName) 
		{
		 List<Seed> result =  iSeedService.viewSeed(commonName);	
		 if(result.isEmpty()) {
				return new ResponseEntity("Sorry! Products not available!", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Seed>>(result, HttpStatus.OK);
		}
	 @GetMapping(path="/seed/typeofseed/{typeOfSeeds}",produces = "application/json")
		public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable("typeOfSeeds") String typeOfSeeds) 
		{
		 List<Seed> result = iSeedService.viewAllSeeds(typeOfSeeds);
		 if(result.isEmpty()) {
				return new ResponseEntity("Sorry! Products not available!", 
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Seed>>(result, HttpStatus.OK);
		}
	
	 
	 @PostMapping(path="/seed",consumes = "application/json", produces = "application/json")
		public ResponseEntity<Seed> createSeed(@RequestBody Seed seed)
				throws DuplicateSeedIdException, InvalidSeedDataException {
			String errormsg = "";
			System.out.println("add seed called");
			int id = iSeedService.createSed(seed);
			if (id >0)
			{
				return ResponseEntity.ok(seed);
			}
			throw new DuplicateSeedIdException("id exist");

		}
		
		@PutMapping(path = "/seed/{seedId}", consumes = "application/json")
		public ResponseEntity<Seed> updateSeed(@PathVariable("seedId") int seedId, @RequestBody Seed seed) {
			int result = iSeedService.updateSed(seed);
			if (result != 0) {
				return ResponseEntity.status(200).build();
			} else {
				return ResponseEntity.status(400).build();
			}

		}
		
		@DeleteMapping(path = "/seed/{seedId}", produces = "application/json")
		public ResponseEntity<Seed> deleteSeedById(@PathVariable("seedId") int seedId)
				throws NoSuchSeedException {
			Seed result = iSeedService.readSed(seedId);
			System.out.println("Seed id is " + result.getSeedId());
			ResponseEntity<Seed> response = null;
			if (result.getSeedId() > 0) {
				System.out.println("Inside if");
				iSeedService.deleteSed(seedId);
				response = new ResponseEntity<Seed>(result, HttpStatus.OK);
				//]ResponseEntity response = new ResponseEntity("seed deleted successfully", HttpStatus.ACCEPTED);
				return response;
			} else {
				System.out.println("Inside else exception");
				throw new NoSuchSeedException("Seed with this ID Not Found");
			}
		}

}
