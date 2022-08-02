package com.plantnursery.plantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.plantnursery.plantnursery.entities.Admin;
import com.plantnursery.plantnursery.services.IAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;
	
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAdmin(){

		List<Admin> result = this.iAdminService.getAdmin();	
		if(result.isEmpty()) {
			return new ResponseEntity("Sorry! Admin not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Admin>>(result, HttpStatus.OK);
	}
	
	@GetMapping(path="/admin/{username}/{password}",produces = "application/json")
	public  int loginadmin(@PathVariable("username") String username,@PathVariable("password") String password) 
	{
		return iAdminService.loginadmin(username,password);	
	}

}
