package models.model;

public class Car {
	private String license_plate;
	private String name;
	private int number_seats;
	private double cost;
	private int state;
	private Car_status status_id;
	public Car(String license_plate, String name, int number_seats, double cost, int state, Car_status status_id) {
		super();
		this.license_plate = license_plate;
		this.name = name;
		this.number_seats = number_seats;
		this.cost = cost;
		this.state = state;
		this.status_id = status_id;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber_seats() {
		return number_seats;
	}
	public void setNumber_seats(int number_seats) {
		this.number_seats = number_seats;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Car_status getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Car_status status_id) {
		this.status_id = status_id;
	}
	
}
