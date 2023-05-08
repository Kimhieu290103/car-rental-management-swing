package models.model;

public class Car_status {
	private String id;
	private double cost;
	private String description;
	public Car_status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car_status(String id, double cost, String description) {
		super();
		this.id = id;
		this.cost = cost;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
