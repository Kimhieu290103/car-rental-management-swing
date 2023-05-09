package app;

import controllers.HomePageController;

public class CarRentalApplication {
	public static void main(String[] args) {
		HomePageController homePageController = new HomePageController();
		homePageController.showGUI(true);
	}
}
