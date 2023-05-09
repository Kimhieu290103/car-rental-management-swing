package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.CarRepository;
import models.model.Car;
import views.EditCarView;

public class EditCarController implements ActionListener{
	private EditCarView editCarView = EditCarView.getInstance();
	
	private CarRepository carRepository = new CarRepository();
	
	public EditCarController() {
		editCarView.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editCarView.btnOK) {
			Car car = editCarView.getCar();
			if (car != null) {
				Car carDB = carRepository.seclectById(car);
				car.setState(carDB.getState());
				carRepository.update(car);
				editCarView.dispose();
				JOptionPane.showMessageDialog(editCarView, "Cập nhật thành công!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public void setInformation(Car car) {
		editCarView.setInformation(car);
	}
	public void showGUI(boolean check) {
		if (check) editCarView.setVisible(true);
		else editCarView.setVisible(false);
	}
}
