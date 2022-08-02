package com.plantnursery.plantnursery.services;

import java.util.List;

import com.plantnursery.plantnursery.entities.Planter;
import com.plantnursery.plantnursery.planter.exception.DuplicatePlanterIdException;
import com.plantnursery.plantnursery.planter.exception.InvalidPlanterDataException;
import com.plantnursery.plantnursery.planter.exception.NoSuchPlanterException;




public interface IPlanterService {
	
	public int deletePlanter(int planterId) throws NoSuchPlanterException;

	public List<Planter> readAllPlanter();

	public Planter readPlanter(int planterId) throws NoSuchPlanterException;

	public int createPlanter(Planter planter) throws  InvalidPlanterDataException,DuplicatePlanterIdException;

	public int updatePlanter(Planter customer);

	public Planter viewPlanter(int planterId);
	
	public List<Planter> viewPlanter(String planterShape);
}
