package com.plantnursery.plantnursery.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plant  {
	
	@Id
	public int plantId;
	private int plantHeight;
	private String temperature;
	private String commonname;
	private String plantSpread;
	private String bloomTime;
	private String medicinalOrCulinaryUse;
	private String difficultyLevel;
	private String typeOfPlant;
	private String description;
	private int plantStock;
	private double plantCost;
	
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plant(int plantId, int plantHeight, String temperature, String commonname, String plantSpread,
			String bloomTime, String medicinalOrCulinaryUse, String difficultyLevel, String typeOfPlant,
			String description, int plantStock, double plantCost) {
		super();
		this.plantId = plantId;
		this.plantHeight = plantHeight;
		this.temperature = temperature;
		this.commonname = commonname;
		this.plantSpread = plantSpread;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.typeOfPlant = typeOfPlant;
		this.description = description;
		this.plantStock = plantStock;
		this.plantCost = plantCost;
	}
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantHeight=" + plantHeight + ", temperature=" + temperature
				+ ", commonname=" + commonname + ", plantSpread=" + plantSpread + ", bloomTime=" + bloomTime
				+ ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse + ", difficultyLevel=" + difficultyLevel
				+ ", typeOfPlant=" + typeOfPlant + ", description=" + description + ", plantStock=" + plantStock
				+ ", plantCost=" + plantCost + "]";
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public int getPlantHeight() {
		return plantHeight;
	}
	public void setPlantHeight(int plantHeight) {
		this.plantHeight = plantHeight;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getCommonname() {
		return commonname;
	}
	public void setCommonname(String commonname) {
		this.commonname = commonname;
	}
	public String getPlantSpread() {
		return plantSpread;
	}
	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}
	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTypeOfPlant() {
		return typeOfPlant;
	}
	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPlantStock() {
		return plantStock;
	}
	public void setPlantStock(int plantStock) {
		this.plantStock = plantStock;
	}
	public double getPlantCost() {
		return plantCost;
	}
	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}
	
	
}
