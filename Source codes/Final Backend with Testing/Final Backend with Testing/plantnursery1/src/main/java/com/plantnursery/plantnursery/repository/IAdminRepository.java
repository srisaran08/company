package com.plantnursery.plantnursery.repository;

import java.util.List;

import com.plantnursery.plantnursery.entities.Admin;

public interface IAdminRepository{
	public int login(String username,String password);
	public List<Admin> readAllAdmin();
	
}
