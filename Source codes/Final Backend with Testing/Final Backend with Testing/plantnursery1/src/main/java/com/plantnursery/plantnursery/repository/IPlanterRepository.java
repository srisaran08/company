package com.plantnursery.plantnursery.repository;

import java.util.List;

import com.plantnursery.plantnursery.entities.Planter;






public interface IPlanterRepository {
	public List<Planter> readAllPlanter();
	public int deletePlanter(int planterId);
	public Planter readPlanter(int planterId);
	public int createPlanter(Planter planter);
	public int updatePlanter(Planter planter);
	public List<Planter> viewPlanter(String planterShape);
}
