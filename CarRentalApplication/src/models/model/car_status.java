package models.model;

public class car_status {
	private String id;
	private double cost;
	private int description;
	public car_status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public car_status(String id, double cost, int description) {
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
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	
	
}
