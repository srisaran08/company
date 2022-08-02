package com.plantnursery.plantnursery.planter.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.plantnursery.plantnursery.PlantnurseryApplication;
//import com.plantnursery.plantnursery.Order.entity.Order;
//import com.plantnursery.plantnursery.seed.entity.Seed;
//import com.plantnursery.plantnursery.plant.entity.Plant;

import com.plantnursery.plantnursery.customer.exceptions.DuplicateCustomerIdException;
import com.plantnursery.plantnursery.customer.exceptions.InvalidCustomerDataException;
import com.plantnursery.plantnursery.customer.exceptions.NoSuchCustomerException;
import com.plantnursery.plantnursery.entities.Planter;
import com.plantnursery.plantnursery.planter.exception.DuplicatePlanterIdException;
import com.plantnursery.plantnursery.planter.exception.InvalidPlanterDataException;
import com.plantnursery.plantnursery.planter.exception.NoSuchPlanterException;
import com.plantnursery.plantnursery.repository.ICustomerRepository;
import com.plantnursery.plantnursery.repository.IPlanterRepository;
import com.plantnursery.plantnursery.services.IPlanterService;


@SpringBootTest
  class IPlanterServiceTest {
	@Autowired
	private IPlanterService iPlanterService;
	final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);

	@MockBean
	private IPlanterRepository iPlanterRepository;

	@Test
	 void testCreatePlanter() {
		Planter c= new Planter(12,21,22,3, null, 0, 0, null, null);
		when(iPlanterRepository.createPlanter(c)).thenReturn(iPlanterRepository.createPlanter(c));
		assertEquals(c,iPlanterRepository.createPlanter(c));
	}
	
	@Test
	 void deletePlanterTest() throws NoSuchPlanterException {
		Planter c=new Planter(12,23,223,21, null, 0, 0, null, null);
		iPlanterService.deletePlanter(30);
		verify(iPlanterRepository,times(1)).deletePlanter(30);
	}

	@Test
	void testUpdatePlanter() {
		Planter c=new Planter(30,112,21, 0, null, 0, 0, null, null);
		iPlanterService.updatePlanter(c);
		verify(iPlanterRepository,times(1)).updatePlanter(c);
		}
   
	
	@Test
	void testDuplicatePlanterIDShouldThrowDuplicateEmpIdException() throws NoSuchPlanterException {
		assertThrows(DuplicatePlanterIdException.class, ()->{
			Planter planter= new Planter(25,2,23, 0, null, 0, 0, null, null);
			iPlanterService.createPlanter(planter);
		});
		
	}

	@Test
	void testCreatePlanterShouldThrowInvalidPlanterDataPlanterException() {
     	assertThrows(InvalidPlanterDataException.class, ()->{
			Planter planter = new Planter(-1,12,233,4, null, 0, 0, null, null);
			iPlanterService.createPlanter(planter);
		});
	}
	
	@Test
	void testFindPlanterByIdShouldThrowNoSuchPlanterException() {
		assertThrows(NoSuchPlanterException.class, ()->{
			iPlanterService.readPlanter(400);
		});
	}
	

	@Test
	void testViewPlanter() throws NoSuchPlanterException {
		Planter planter = new Planter(25,11,23, 0, null, 0, 0, null, null);
		Planter result = iPlanterService.readPlanter(25);
		logger.info("planter Id "+result.getPlanterId());
		assertEquals(planter.getPlanterId(), result.getPlanterId());
		assertEquals(planter.getPlanterHeight(), result.getPlanterHeight());
		assertEquals(planter.getPlanterCapacity(), result.getPlanterCapacity());
		assertEquals(planter.getPlanterHoles(), result.getPlanterHoles());
		assertEquals(planter.getPlanterShape(), result.getPlanterShape());
		assertEquals(planter.getPlanterStock(), result.getPlanterStock());
		assertEquals(planter.getPlanterCost(), result.getPlanterCost());
	}

}