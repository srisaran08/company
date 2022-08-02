package com.plantnursery.plantnursery.services;

import java.util.List;

import com.plantnursery.plantnursery.entities.Admin;

public interface IAdminService {
	 
	public List<Admin> getAdmin();
	
	public int loginadmin(String username,String password);
}
