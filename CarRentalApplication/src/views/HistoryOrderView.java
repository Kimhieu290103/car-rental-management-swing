package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import models.model.Order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class HistoryOrderView extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel, bodyPanel;
	private JLabel lb2;

	public JTable orderTable;
		
	private void init() {		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 237, 221));
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);
		
		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 1486, 90);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));
		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 89, 1486, 577);
		bodyPanel.setLayout(new BorderLayout(1, 1));
		bodyPanel.setBorder(new LineBorder(Color.BLACK, 1));
		bodyPanel.setBackground(new Color(86, 157, 170));
		
		lb2 = new JLabel("LỊCH SỬ GIAO DỊCH");
		lb2.setBounds(0, 10, 1486, 70);
		lb2.setFont(new Font("Verdana", Font.BOLD, 22));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lb2);
		
	
		
		String[][] data = new String[0][];
		String[] columns = {"STT", "Mã giao dịch", "Mã khách hàng", "Biển số xe thuê", "Ngày thuê", 
							"Ngày trả", "Tình trạng xe trước khi thuê", "Tình trạng xe sau khi thuê"};
		
		orderTable = new JTable(data, columns);
		orderTable.setBorder(new LineBorder(Color.BLACK, 1));
		orderTable.setBackground(new Color(185, 237, 221));
		orderTable.setShowGrid(true);
		orderTable.setSelectionBackground(Color.WHITE);
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(orderTable);
		scrollPane.getViewport().setBackground(new Color(185, 237, 221));
		scrollPane.setBorder(new LineBorder(Color.BLACK, 1));
		
		JTableHeader tableHeader = orderTable.getTableHeader();
		tableHeader.setBackground(new Color(86, 157, 170));
		tableHeader.setFont(new Font("Verdana", Font.BOLD, 14));
		
		bodyPanel.add(tableHeader, BorderLayout.NORTH);
		bodyPanel.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(headerPanel);
		contentPane.add(bodyPanel);
	}
	private HistoryOrderView() {
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1500, 703);
		setTitle("order RENTAL APPLICATION");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}
	
	public void setOrderTable(List<Order> listOrder) {
		String[][] data = new String[listOrder.size()][5];
		String[] columns = {"STT", "Mã giao dịch", "Mã khách hàng", "Biển số xe thuê", "Ngày thuê", 
				"Ngày trả", "Tình trạng xe trước khi thuê", "Tình trạng xe sau khi thuê"};
		TableModel model = new DefaultTableModel(data, columns);
		int i = 0;
		for (Order order : listOrder) {
			model.setValueAt(String.valueOf(i + 1), i, 0);
			model.setValueAt(order.getOrder_id(), i, 1);
			model.setValueAt(order.getCustomer_id(), i, 2);
			model.setValueAt(order.getCar_id(), i, 3);
			model.setValueAt(order.getBegin_date().toString(), i, 4);
			model.setValueAt(order.getEnd_date().toString(), i, 5);
			model.setValueAt(order.getCar_status_before_rent(), i, 6);
			model.setValueAt(order.getCar_status_after_rent(), i, 7);
			i++;
		}
		orderTable.setModel(model);
	}
	public static HistoryOrderView getInstance() {
		return new HistoryOrderView();
	}
	
}

