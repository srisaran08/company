package com.plantnursery.plantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantnursery.plantnursery.entities.Address;



public interface IAddressRepository extends JpaRepository<Address, Integer>{

}
