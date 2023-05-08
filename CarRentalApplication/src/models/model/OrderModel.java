package models.model;

import java.sql.Date;

public class OrderModel {
		private String orser_id;
		private CustomerModel customer_id;
		private CarModel car_id;
		private Date begin_date;
		private Date end_date;
		private int car_status_before_rent;
		private int car_status_after_rent;
		public OrderModel(String orser_id, CustomerModel customer_id, CarModel car_id, Date begin_date, Date end_date,
				int car_status_before_rent, int car_status_after_rent) {
			super();
			this.orser_id = orser_id;
			this.customer_id = customer_id;
			this.car_id = car_id;
			this.begin_date = begin_date;
			this.end_date = end_date;
			this.car_status_before_rent = car_status_before_rent;
			this.car_status_after_rent = car_status_after_rent;
		}
		public OrderModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getOrser_id() {
			return orser_id;
		}
		public void setOrser_id(String orser_id) {
			this.orser_id = orser_id;
		}
		public CustomerModel getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(CustomerModel customer_id) {
			this.customer_id = customer_id;
		}
		public CarModel getCar_id() {
			return car_id;
		}
		public void setCar_id(CarModel car_id) {
			this.car_id = car_id;
		}
		public Date getBegin_date() {
			return begin_date;
		}
		public void setBegin_date(Date begin_date) {
			this.begin_date = begin_date;
		}
		public Date getEnd_date() {
			return end_date;
		}
		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		}
		public int getCar_status_before_rent() {
			return car_status_before_rent;
		}
		public void setCar_status_before_rent(int car_status_before_rent) {
			this.car_status_before_rent = car_status_before_rent;
		}
		public int getCar_status_after_rent() {
			return car_status_after_rent;
		}
		public void setCar_status_after_rent(int car_status_after_rent) {
			this.car_status_after_rent = car_status_after_rent;
		}
		
		
}
