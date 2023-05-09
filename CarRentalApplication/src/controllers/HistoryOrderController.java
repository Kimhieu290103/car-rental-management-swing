package controllers;

import dao.OrderRepository;
import views.HistoryOrderView;

public class HistoryOrderController{
	private HistoryOrderView historyOrderView = HistoryOrderView.getInstance();

	private OrderRepository orderRepository = new OrderRepository();
	
	public void setOrderTable() {
		historyOrderView.setOrderTable(orderRepository.selectAll());
	}
	public void showGUI(boolean check) {
		if (check) {
			setOrderTable();
			historyOrderView.setVisible(true);
		}
		else historyOrderView.setVisible(false);
	}
}
