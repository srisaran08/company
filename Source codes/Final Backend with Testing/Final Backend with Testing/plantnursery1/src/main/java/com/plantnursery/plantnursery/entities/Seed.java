package com.plantnursery.plantnursery.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seed {
	
	@Id
	private int seedId;
	private String commonName;
	private String typeOfSeeds;
	private String seedsDescription;
	private int seedsStock;
	private Double seedsCost;
	private String bloomTime;
	private String watering;	
	private String difficultyLevel;
	private int seedsPerPacket;
	private String temperature;
	public int getSeedId() {
		return seedId;
	}
	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}
	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}
	public String getSeedsDescription() {
		return seedsDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}
	public int getSeedsStock() {
		return seedsStock;
	}
	public void setSeedsStock(int seedsStock) {
		this.seedsStock = seedsStock;
	}
	public Double getSeedsCost() {
		return seedsCost;
	}
	public void setSeedsCost(Double seedsCost) {
		this.seedsCost = seedsCost;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public int getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(int seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", commonName=" + commonName + ", typeOfSeeds=" + typeOfSeeds
				+ ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost=" + seedsCost
				+ ", bloomTime=" + bloomTime + ", watering=" + watering + ", difficultyLevel=" + difficultyLevel
				+ ", seedsPerPacket=" + seedsPerPacket + ", temperature=" + temperature + "]";
	}
	public Seed(int seedId, String commonName, String typeOfSeeds, String seedsDescription, int seedsStock,
			Double seedsCost, String bloomTime, String watering, String difficultyLevel, int seedsPerPacket,
			String temperature) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.seedsPerPacket = seedsPerPacket;
		this.temperature = temperature;
	}
	public Seed() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}