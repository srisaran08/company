package com.plantnursery.plantnursery.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class Planter {

	@Id
	private int planterId;
	private int planterHeight;
	private int planterCapacity;
	private int planterHoles;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Plant plant;
	@OneToOne(cascade = CascadeType.ALL)
	private Seed seed;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public int getPlanterHeight() {
		return planterHeight;
	}
	public void setPlanterHeight(int planterHeight) {
		this.planterHeight = planterHeight;
	}
	public int getPlanterCapacity() {
		return planterCapacity;
	}
	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}
	public int getPlanterHoles() {
		return planterHoles;
	}
	public void setPlanterHoles(int planterHoles) {
		this.planterHoles = planterHoles;
	}
	public String getPlanterShape() {
		return planterShape;
	}
	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}
	public int getPlanterStock() {
		return planterStock;
	}
	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}
	public int getPlanterCost() {
		return planterCost;
	}
	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public Seed getSeed() {
		return seed;
	}
	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterHeight=" + planterHeight + ", planterCapacity="
				+ planterCapacity + ", planterHoles=" + planterHoles + ", planterShape=" + planterShape
				+ ", planterStock=" + planterStock + ", planterCost=" + planterCost + ", plant=" + plant + ", seed="
				+ seed + "]";
	}
	public Planter(int planterId, int planterHeight, int planterCapacity, int planterHoles, String planterShape,
			int planterStock, int planterCost, Plant plant, Seed seed) {
		super();
		this.planterId = planterId;
		this.planterHeight = planterHeight;
		this.planterCapacity = planterCapacity;
		this.planterHoles = planterHoles;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plant = plant;
		this.seed = seed;
	}
	public Planter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}