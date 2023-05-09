package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.CarRepository;
import dao.CustomerRepository;
import dao.OrderRepository;
import models.model.Car;
import models.model.Customer;
import models.model.Order;
import views.RentCarView;

public class RentCarController implements ActionListener{
	private RentCarView rentCarView = RentCarView.getInstance();
	
	private CustomerRepository customerRepository = new CustomerRepository();
	private OrderRepository orderRepository = new OrderRepository();
	private CarRepository carRepository = new CarRepository();
	
	public RentCarController() {
		rentCarView.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rentCarView.btnAddNewCustomer) {
			rentCarView.addNewCustomerMode();
		}
		else if (e.getSource() == rentCarView.btnCheck) {
			Customer newCustomer = new Customer();
			newCustomer.setCar_id(rentCarView.txtCCCD.getText());
			if (customerRepository.seclectById(newCustomer) != null) {
				rentCarView.setCustomerInformation(customerRepository.seclectById(newCustomer));
			}
			else {
				JOptionPane.showMessageDialog(rentCarView, "Khách hàng này không tồn tại!", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (e.getSource() == rentCarView.btnOK) {
			if (rentCarView.txtCCCD.getText().isEmpty() || rentCarView.txtCustomerName.getText().isEmpty() || rentCarView.txtCustomerPhone.getText().isEmpty()) {
				JOptionPane.showMessageDialog(rentCarView, "BẠN PHẢI ĐIỀN ĐỦ THÔNG TIN KHÁCH HÀNG!", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Customer newCustomer = new Customer();
				newCustomer.setCar_id(rentCarView.txtCCCD.getText());
				newCustomer.setName(rentCarView.txtCustomerName.getText());
				newCustomer.setPhone(rentCarView.txtCustomerPhone.getText());
				
				if (customerRepository.seclectById(newCustomer) == null) {
					customerRepository.insert(newCustomer);
					JOptionPane.showMessageDialog(rentCarView, "Khách hàng mới đã được thêm thành công!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rentCarView, "Khách hàng đã tồn tại!", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if (e.getSource() == rentCarView.btnReset) {
			rentCarView.clearCutomerInformation();
		}
		else if (e.getSource() == rentCarView.btnBack) {
			rentCarView.existCustomerMode();
		}
		else {
			Customer customer = new Customer();
			customer.setCar_id(rentCarView.txtCCCD.getText());
			if (rentCarView.txtDateStart.getText().isEmpty() || rentCarView.txtDateEnd.getText().isEmpty() || customerRepository.seclectById(customer) == null) {
				JOptionPane.showMessageDialog(rentCarView, "BẠN PHẢI ĐIỀN ĐỦ THÔNG TIN!", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Order order = rentCarView.getOrder();
				orderRepository.insert(order);
				
				Car car = new Car();
				car.setLicense_plate(order.getCar_id());
				Car updateCar = carRepository.seclectById(car);
				updateCar.setState(1);
				carRepository.update(updateCar);
				rentCarView.dispose();
			}
		}
	}
	public void setDefaultInformation(Car car) {
		rentCarView.setDefaultInformation(car);
	}
	public void showGUI(boolean check) {
		if (check) rentCarView.setVisible(true);
		else rentCarView.setVisible(false);
	}
}
