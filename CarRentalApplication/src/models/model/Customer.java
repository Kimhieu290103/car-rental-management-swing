package models.model;

public class Customer {
	private String car_id;
	private String name;
	private String phone;
	public Customer() {
		super();
	}
	public Customer(String car_id, String name, String phone) {
		super();
		this.car_id = car_id;
		this.name = name;
		this.phone = phone;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
