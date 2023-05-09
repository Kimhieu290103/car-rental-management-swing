package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.CarRepository;
import models.model.Car;
import views.AddNewCarView;

public class AddNewCarController implements ActionListener{
	private AddNewCarView addNewCarView = AddNewCarView.getInstance();
	
	private CarRepository carRepository = new CarRepository();
	
	public AddNewCarController() {
		addNewCarView.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addNewCarView.btnOK) {
			Car car = addNewCarView.getCar();
			if (car != null) {
				carRepository.insert(car);
				addNewCarView.dispose();
				JOptionPane.showMessageDialog(addNewCarView, "Xe mới đã được thêm thành công!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

	public void showGUI(boolean check) {
		addNewCarView.setDefaultInfromation();
		if (check) addNewCarView.setVisible(true);
		else addNewCarView.setVisible(false);
	}
}
