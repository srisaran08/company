package com.plantnursery.plantnursery.plant.services;

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
import com.plantnursery.plantnursery.entities.Plant;
import com.plantnursery.plantnursery.plant.exception.DuplicatePlantIdException;
import com.plantnursery.plantnursery.plant.exception.InvalidPlantDataException;
import com.plantnursery.plantnursery.plant.exception.NoSuchPlantException;
import com.plantnursery.plantnursery.repository.IPlantRepository;
import com.plantnursery.plantnursery.services.IPlantService;

@SpringBootTest
class IPlantServiceTest {

	@Autowired
	private IPlantService iPlantService;
	
	final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);
	
	@MockBean
	private IPlantRepository iPlantRepository;

	/*
	@Test
	 void testCreatePlant() {
	//	List<Order> order = new ArrayList<>();
		Plant p1= new Plant(10,0, "Normal","plant","leaf","11.23","medicinal","Norml","indoor","good",3,23.43);
		
		when(iPlantRepository.createPlant(p1)).thenReturn(iPlantRepository.createPlant(p1));
		assertEquals(p1,iPlantRepository.createPlant(p1));
	}
	
	@Test
	 void deletePlantTest() throws NoSuchPlantException {
		Plant p1=new Plant(12,0, "Normal","plant","leaf","11.23","medicinal","Norml","indoor","good",3,23.43);
		iPlantService.deletePlant(30);
		verify(iPlantRepository,times(1)).deletePlant(30);
	}

	@Test
	void testUpdatePlant() {
		Plant p1=new Plant(12,0, "Normal","plant","leaf","21.23","medicinal","Norml","indoor","good",3,23.43);
		iPlantService.updatePlant(p1);
		verify(iPlantRepository,times(1)).updatePlant(p1);
		}
  
	
	@Test
	void testDuplicatePlantIDShouldThrowDuplicateEmpIdException() throws NoSuchPlantException {
		assertThrows(DuplicatePlantIdException.class, ()->{
			Plant plant = new Plant(14,7,"32","Mango","xyz","abc","qwerty","Hard","flower","It's still aliveee",3,23.1);
			iPlantService.createPlant(plant);
		});
		
	}
	

	@Test
	void testCreatePlantShouldThrowInvalidPlantDataSException() {
		assertThrows(InvalidPlantDataException.class, ()->{
			Plant plant = new Plant(-14,7,"32","Mango","xyz","abc","qwerty","Hard","flower","It's still aliveee",3,23.1);
			iPlantService.createPlant(plant);
		});
	}
	/*
	@Test
	void testFindPlantByIdShouldThrowNoSuchPlantException() {
		assertThrows(NoSuchPlantException.class, ()->{
			iPlantService.readPlant(400);
		});
	}
	
 */
	@Test
	void testViewPlant() throws NoSuchPlantException {
		Plant plant = new Plant(14,7,"32","Mango","xyz","abc","qwerty","Hard","flower","It's still aliveee",3,23.1);
		Plant result = iPlantService.readPlant(14);
		logger.info("Plant Id "+result.getPlantId());
		assertEquals(plant.getPlantId(), result.getPlantId());
		assertEquals(plant.getPlantHeight(), result.getPlantHeight());
		assertEquals(plant.getTemperature(), result.getTemperature());
		assertEquals(plant.getCommonname(), result.getCommonname());
		assertEquals(plant.getPlantSpread(), result.getPlantSpread());
		assertEquals(plant.getBloomTime(), result.getBloomTime());
		assertEquals(plant.getMedicinalOrCulinaryUse(), result.getMedicinalOrCulinaryUse());
		assertEquals(plant.getDifficultyLevel(), result.getDifficultyLevel());
		assertEquals(plant.getTypeOfPlant(), result.getTypeOfPlant());
		assertEquals(plant.getDescription(), result.getDescription());
		assertEquals(plant.getPlantStock(), result.getPlantStock());
		assertEquals(plant.getPlantCost(), result.getPlantCost());
	}	
	

}
