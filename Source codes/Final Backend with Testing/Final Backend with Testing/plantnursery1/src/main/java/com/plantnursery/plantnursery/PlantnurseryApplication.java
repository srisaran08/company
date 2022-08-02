package com.plantnursery.plantnursery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlantnurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantnurseryApplication.class, args);
		final Logger logger = LoggerFactory.getLogger(PlantnurseryApplication.class);
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	}

}
