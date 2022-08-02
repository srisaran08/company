package com.plantnursery.plantnursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.plantnursery.entities.Admin;
import com.plantnursery.plantnursery.repository.IAdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminRepository iAdminRepository;

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		//return list;
		return iAdminRepository.readAllAdmin();
	}


	@Override
	public int loginadmin(String username, String password) {
		// TODO Auto-generated method stub
		return iAdminRepository.login(username, password);
	}



}
