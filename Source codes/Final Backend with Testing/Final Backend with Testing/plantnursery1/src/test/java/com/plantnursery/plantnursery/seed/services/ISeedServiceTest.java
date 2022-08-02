package com.plantnursery.plantnursery.seed.services;

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
import com.plantnursery.plantnursery.entities.Seed;
import com.plantnursery.plantnursery.repository.ISeedRepository;
//import com.plantnursery.plantnursery.Order.entity.Order;

import com.plantnursery.plantnursery.seed.exception.DuplicateSeedIdException;
import com.plantnursery.plantnursery.seed.exception.InvalidSeedDataException;
import com.plantnursery.plantnursery.seed.exception.NoSuchSeedException;
import com.plantnursery.plantnursery.services.ISeedService;

@SpringBootTest
class ISeedServiceTest {

	@Autowired
	private ISeedService iSeedService;
	
	final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);
	
	@MockBean
	private ISeedRepository iSeedRepository;

	
	 
	
	@Test
	 void deleteSeedTest() throws NoSuchSeedException {
		//List<Order> order = new ArrayList<>();
		Seed s=new Seed(0, "A67","abc","Terza",123,12.4,"23","high","high",10,"cool");
		iSeedService.deleteSed(30);
		verify(iSeedRepository,times(1)).deleteSed(30);
	}

	@Test
	void testUpdateSeed() {
		//List<Order> order = new ArrayList<>();
		Seed s=new Seed(0, "A67","xyz","Terza",123,12.4,"23","high","high",10,"cool");
		iSeedService.updateSed(s);
		verify(iSeedRepository,times(1)).updateSed(s);
		}
   
	
	@Test
	void testDuplicateSeedIDShouldThrowDuplicateEmpIdException() throws NoSuchSeedException {
		//List<Order> order = new ArrayList<>();
		assertThrows(DuplicateSeedIdException.class, ()->{
			Seed seed = new Seed(0, "A57","xyz","Terza",123,12.4,"23","high","high",10,"cool");
			iSeedService.createSed(seed);
		});
		
	}

	@Test
	void testCreateSeedShouldThrowInvalidSeedDataSException() {
		//List<Order> order = new ArrayList<>();
		assertThrows(InvalidSeedDataException.class, ()->{
			Seed seed = new Seed(0, "A57","xyz","Terza",123,12.4,"23","high","high",10,"cool");
			iSeedService.createSed(seed);
		});
	}
	
	@Test
	void testFindSeedByIdShouldThrowNoSuchSeedException() {
		assertThrows(NoSuchSeedException.class, ()->{
			iSeedService.readSed(400);
		});
	}
	

	@Test
	void testViewSeed() throws NoSuchSeedException {
		//List<Order> order = new ArrayList<>();
		Seed seed = new Seed(0, "A57","xyz","Terza",123,12.4,"23","high","high",10,"cool");
		Seed result = iSeedService.readSed(25);
		logger.info("Seed Id "+result.getSeedId());
		assertEquals(seed.getSeedId(), result.getSeedId());
		assertEquals(seed.getCommonName(), result.getCommonName());
		assertEquals(seed.getTypeOfSeeds(), result.getTypeOfSeeds());
		assertEquals(seed.getSeedsDescription(), result.getSeedsDescription());
		assertEquals(seed.getSeedsStock(), result.getSeedsStock());
		assertEquals(seed.getSeedsCost(),result.getSeedsCost());
		assertEquals(seed.getBloomTime(), result.getBloomTime());
		assertEquals(seed.getWatering(), result.getWatering());
		assertEquals(seed.getDifficultyLevel(), result.getDifficultyLevel());
		assertEquals(seed.getSeedsPerPacket(), result.getSeedsPerPacket());
		assertEquals(seed.getTemperature(), result.getTemperature());
		
	}

}
