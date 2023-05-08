package models.model;

public class CarModel {
	private String license_plate;
	private String name;
	private int number_seats;
	private double cost;
	public CarModel(String license_plate, String name, int number_seats, double cost) {
		super();
		this.license_plate = license_plate;
		this.name = name;
		this.number_seats = number_seats;
		this.cost = cost;
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
	
}
