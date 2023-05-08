package models.model;

import java.sql.Date;

public class Order{
		private String order_id;
		private String customer_id;
		private String car_id;
		private Date begin_date;
		private Date end_date;
		private String car_status_before_rent;
		private String car_status_after_rent;
		
		public Order(String order_id, String customer_id, String car_id, Date begin_date, Date end_date,
				String car_status_before_rent, String car_status_after_rent) {
			super();
			this.order_id = order_id;
			this.customer_id = customer_id;
			this.car_id = car_id;
			this.begin_date = begin_date;
			this.end_date = end_date;
			this.car_status_before_rent = car_status_before_rent;
			this.car_status_after_rent = car_status_after_rent;
		}

		public Order() {
			super();
		}

		public String getOrder_id() {
			return order_id;
		}

		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}

		public String getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}

		public String getCar_id() {
			return car_id;
		}

		public void setCar_id(String car_id) {
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

		public String getCar_status_before_rent() {
			return car_status_before_rent;
		}

		public void setCar_status_before_rent(String car_status_before_rent) {
			this.car_status_before_rent = car_status_before_rent;
		}

		public String getCar_status_after_rent() {
			return car_status_after_rent;
		}

		public void setCar_status_after_rent(String car_status_after_rent) {
			this.car_status_after_rent = car_status_after_rent;
		}
		
}
