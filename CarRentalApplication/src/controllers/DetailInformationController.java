package controllers;

import models.model.Car;
import models.model.Car_status;
import views.DetailInformationView;

public class DetailInformationController{
	private DetailInformationView detailInformationView = DetailInformationView.getInstance();
	
	public DetailInformationController() {
		
	}
	
	public void setInformation(Car car, Car_status carStatus) {
		detailInformationView.setInformation(car, carStatus);
	}
	
	public void showGUI(boolean check) {
		if (check) detailInformationView.setVisible(true);
		else detailInformationView.setVisible(false);
	}
}
