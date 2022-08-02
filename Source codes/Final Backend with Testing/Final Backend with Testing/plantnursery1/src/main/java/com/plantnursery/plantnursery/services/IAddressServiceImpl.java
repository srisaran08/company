package com.plantnursery.plantnursery.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.plantnursery.entities.Address;
//package com.plantnursery.plantnursery.services;
import com.plantnursery.plantnursery.repository.IAddressRepository;

@Service
public class IAddressServiceImpl implements IAddressService {

	//List<Address> list;
	@Autowired
	private IAddressRepository iAddressRepository;
	
	@Override
	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return iAddressRepository.findAll();
	}

}
