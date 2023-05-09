package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.CarRepository;
import dao.CarStatusRepository;
import dao.OrderRepository;
import models.model.Car;
import models.model.Car_status;
import models.model.Customer;
import models.model.Order;
import views.ReturnCarView;

public class ReturnCarController implements ActionListener{
	private ReturnCarView returnCarView = ReturnCarView.getInstance();
	
	private OrderRepository orderRepository = new OrderRepository();
	private CarRepository carRepository = new CarRepository();
	private CarStatusRepository carStatusRepository = new CarStatusRepository();
	
	public ReturnCarController() {
		returnCarView.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnCarView.btnConfirm) {
			Order order = returnCarView.getOrder();
			
			Car car = new Car();
			car.setLicense_plate(order.getCar_id());
			Car carDB = carRepository.seclectById(car);
			carDB.setStatus_id(order.getCar_status_after_rent());
			carDB.setState(0);
			
			orderRepository.update(order);
			carRepository.update(carDB);
			
			returnCarView.dispose();
		}
		else if (e.getSource() == returnCarView.btnCheck) {
			Order order = returnCarView.getOrder();
			
			Car car = new Car();
			car.setLicense_plate(order.getCar_id());
			Car carDB = carRepository.seclectById(car);
			
			Car_status car_status = new Car_status();
			car_status.setId(returnCarView.choice.getSelectedItem());
			Car_status carStatusDB = carStatusRepository.seclectById(car_status);
			
			returnCarView.updateTotalCost(carDB, carStatusDB);
			orderRepository.update(order);
		}
	}
	public void setDefaultInformation(Order order, Car car, Customer customer) {
		returnCarView.setDefaultInformation(order, car, customer);
	}
	public void showGUI(boolean check) {
		if (check) returnCarView.setVisible(true);
		else returnCarView.setVisible(false);
	}
}
