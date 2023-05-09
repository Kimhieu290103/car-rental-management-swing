package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CarRepository;
import dao.CarStatusRepository;
import dao.CustomerRepository;
import dao.OrderRepository;
import models.model.Car;
import models.model.Car_status;
import models.model.Customer;
import models.model.Order;
import views.HomePageView;

public class HomePageController implements ActionListener{
	private HomePageView homePageView = HomePageView.getInstance();
	
	private CarRepository carRepository = new CarRepository();
	private CarStatusRepository carStatusRepository = new CarStatusRepository();
	private OrderRepository orderRepository = new OrderRepository();
	private CustomerRepository customerRepository = new CustomerRepository();
	
	private RentCarController rentCarController = new RentCarController();
	private DetailInformationController detailInformationController = new DetailInformationController();
	private ReturnCarController returnCarController = new ReturnCarController();
	private AddNewCarController addNewCarController = new AddNewCarController();
	private EditCarController editCarController = new EditCarController();
	private HistoryOrderController historyOrderController = new HistoryOrderController();
	
	public HomePageController() {
		homePageView.addActionListener(this);
		homePageView.setCarTable(carRepository.selectAll());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homePageView.btnRent) {
			int row = homePageView.carTable.getSelectedRow(),
				col = homePageView.carTable.getSelectedColumn();
			
			Car car = new Car(), carDB = null;
			if (row != -1 && col != -1) {
				car = new Car();
				car.setLicense_plate(homePageView.carTable.getValueAt(row, 2).toString());
				carDB = carRepository.seclectById(car);
				
			}
			if (carDB != null && carDB.getState() != 1) {
				rentCarController.setDefaultInformation(carDB);
				rentCarController.showGUI(true);
			}
			homePageView.setCarTable(carRepository.selectAll());
		}
		else if (e.getSource() == homePageView.btnReturnCar) {
			int row = homePageView.carTable.getSelectedRow(),
				col = homePageView.carTable.getSelectedColumn();
			
			Car car = new Car(), carDB = null;
			if (row != -1 && col != -1) {
				car = new Car();
				car.setLicense_plate(homePageView.carTable.getValueAt(row, 2).toString());
				carDB = carRepository.seclectById(car);
				
			}
			if (carDB != null && carDB.getState() == 1) {
				Order orderDB = null;
				List<Order> listOrder = orderRepository.selectAll();
				for (int i = listOrder.size() - 1; i >= 0; i--) {
					if (listOrder.get(i).getCar_id().compareTo(carDB.getLicense_plate()) == 0) {
						orderDB = listOrder.get(i);
						break;
					}
				}
				Customer customer = new Customer();
				customer.setCar_id(orderDB.getCustomer_id());
				returnCarController.setDefaultInformation(orderDB, carDB, customerRepository.seclectById(customer));
				returnCarController.showGUI(true);
			}
			homePageView.setCarTable(carRepository.selectAll());
		}
		else if (e.getSource() == homePageView.btnShowDetail) {
			int row = homePageView.carTable.getSelectedRow(),
				col = homePageView.carTable.getSelectedColumn();
			
			Car car = new Car(), carDB = null;
			if (row != -1 && col != -1) {
				car = new Car();
				car.setLicense_plate(homePageView.carTable.getValueAt(row, 2).toString());
				carDB = carRepository.seclectById(car);
				
			}
			if (carDB != null) {
				detailInformationController.showGUI(true);
				Car_status carStatus = new Car_status();
				carStatus.setId(carDB.getStatus_id());
				detailInformationController.setInformation(carDB, carStatusRepository.seclectById(carStatus));
			}
		}
		else if (e.getSource() == homePageView.btnReset) {
			homePageView.setCarTable(carRepository.selectAll());
		}
		else if (e.getSource() == homePageView.btnAdd) {
			addNewCarController.showGUI(true);
		}
		else if (e.getSource() == homePageView.btnDelete) {
			int row = homePageView.carTable.getSelectedRow(),
				col = homePageView.carTable.getSelectedColumn();
			
			Car car = new Car(), carDB = null;
			if (row != -1 && col != -1) {
				car = new Car();
				car.setLicense_plate(homePageView.carTable.getValueAt(row, 2).toString());
				carDB = carRepository.seclectById(car);
			}
			if (carDB != null) {
				int option = JOptionPane.showConfirmDialog(homePageView, "BẠN CÓ CHẮC CHẮN XÓA XE NÀY KHÔNG?", "CẢNH BÁO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					carRepository.delete(carDB);
					JOptionPane.showMessageDialog(homePageView, "Xóa thành công!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			homePageView.setCarTable(carRepository.selectAll());
		}
		else if (e.getSource() == homePageView.btnEdit) {
			int row = homePageView.carTable.getSelectedRow(),
				col = homePageView.carTable.getSelectedColumn();
			
			Car car = new Car(), carDB = null;
			if (row != -1 && col != -1) {
				car = new Car();
				car.setLicense_plate(homePageView.carTable.getValueAt(row, 2).toString());
				carDB = carRepository.seclectById(car);
			}
			if (carDB != null) {
				editCarController.setInformation(carDB);
				editCarController.showGUI(true);
			}
		}
		else {
			historyOrderController.showGUI(true);
		}
	}
	
	public void showGUI(boolean check) {
		if (check) homePageView.setVisible(true);
		else homePageView.setVisible(false);
	}
}
