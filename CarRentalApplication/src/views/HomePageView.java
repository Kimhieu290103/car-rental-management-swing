package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import models.model.Car;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class HomePageView extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel, bodyPanel;
	private JLabel lb1, lb2;

	public JTable carTable;
	public JButton btnShowDetail, btnRent, btnReturnCar, btnHistory, btnReset;
	public JButton btnEdit, btnDelete, btnAdd;
	
	private List<Integer> isRentList;
	
	private void init() {		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 237, 221));
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);
		
		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 935, 90);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));
		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 148, 935, 518);
		bodyPanel.setLayout(new BorderLayout(1, 1));
		bodyPanel.setBorder(new LineBorder(Color.BLACK, 1));
		bodyPanel.setBackground(new Color(86, 157, 170));
		
		lb1 = new JLabel("VTH");
		lb1.setIcon(new ImageIcon("image/car.png"));
		lb1.setFont(new Font("Verdana", Font.BOLD, 22));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(26, 10, 127, 70);
		headerPanel.add(lb1);
		
		lb2 = new JLabel("ỨNG DỤNG CHO THUÊ XE OTO");
		lb2.setBounds(212, 10, 518, 70);
		lb2.setFont(new Font("Verdana", Font.BOLD, 22));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lb2);
		
		
		btnShowDetail = new JButton("Thông tin chi tiết");
		btnShowDetail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShowDetail.setBounds(469, 101, 133, 38);
		btnShowDetail.setBorder(new LineBorder(Color.BLACK, 2));
		btnShowDetail.setBackground(new Color(135, 203, 185));
		contentPane.add(btnShowDetail);
		
		btnRent = new JButton("Thuê xe");
		btnRent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRent.setBorder(new LineBorder(Color.BLACK, 2));
		btnRent.setBackground(new Color(135, 203, 185));
		btnRent.setBounds(612, 101, 85, 38);
		contentPane.add(btnRent);
		
		btnReturnCar = new JButton("Trả xe");
		btnReturnCar.setBounds(707, 101, 85, 38);
		btnReturnCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturnCar.setBorder(new LineBorder(Color.BLACK, 2));
		btnReturnCar.setBackground(new Color(135, 203, 185));
		contentPane.add(btnReturnCar);
		
		btnHistory = new JButton("Lịch sử giao dịch");
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistory.setBorder(new LineBorder(Color.BLACK, 2));
		btnHistory.setBackground(new Color(135, 203, 185));
		btnHistory.setBounds(802, 101, 133, 38);
		contentPane.add(btnHistory);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(0, 101, 71, 38);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBorder(new LineBorder(Color.BLACK, 2));
		btnAdd.setBackground(new Color(135, 203, 185));
		contentPane.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(77, 101, 71, 38);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBorder(new LineBorder(Color.BLACK, 2));
		btnEdit.setBackground(new Color(135, 203, 185));
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(158, 101, 71, 38);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBorder(new LineBorder(Color.BLACK, 2));
		btnDelete.setBackground(new Color(135, 203, 185));
		contentPane.add(btnDelete);
		
		
		
		String[][] data = new String[0][];
		String[] columns = {"STT", "Tên xe", "Biển số", "Số chỗ ngồi", "Giá thuê"};
		carTable = new JTable(data, columns);
		carTable.setBorder(new LineBorder(Color.BLACK, 1));
		carTable.setBackground(new Color(86, 157, 170));
		carTable.setShowGrid(true);
		carTable.setSelectionBackground(Color.WHITE);
		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carTable.setDefaultRenderer(Object.class, new MonCellRenderer());
		
		JScrollPane scrollPane = new JScrollPane(carTable);
		scrollPane.getViewport().setBackground(new Color(86, 157, 170));
		scrollPane.setBorder(new LineBorder(Color.BLACK, 1));
		
		JTableHeader tableHeader = carTable.getTableHeader();
		tableHeader.setBackground(new Color(87, 125, 134));
		tableHeader.setFont(new Font("Verdana", Font.BOLD, 14));
		
		bodyPanel.add(tableHeader, BorderLayout.NORTH);
		bodyPanel.add(scrollPane, BorderLayout.CENTER);
		
		contentPane.add(headerPanel);
		contentPane.add(bodyPanel);
	}
	private HomePageView() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 703);
		setTitle("CAR RENTAL APPLICATION");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JLabel lbListCar = new JLabel("Danh sách các xe");
		lbListCar.setHorizontalAlignment(SwingConstants.CENTER);
		lbListCar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lbListCar.setBounds(320, 101, 139, 38);
		contentPane.add(lbListCar);
		
		btnReset = new JButton("ĐẶT LẠI");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBorder(new LineBorder(Color.BLACK, 2));
		btnReset.setBackground(new Color(135, 203, 185));
		btnReset.setBounds(239, 101, 71, 38);
		contentPane.add(btnReset);
	}
	
	public void addActionListener(ActionListener actionListener) {
		btnAdd.addActionListener(actionListener);
		btnDelete.addActionListener(actionListener);
		btnEdit.addActionListener(actionListener);
		btnHistory.addActionListener(actionListener);
		btnRent.addActionListener(actionListener);
		btnReturnCar.addActionListener(actionListener);
		btnShowDetail.addActionListener(actionListener);
		btnReset.addActionListener(actionListener);
	}
	public void setCarTable(List<Car> listCar) {
		isRentList = new ArrayList<>();
		String[][] data = new String[listCar.size()][5];
		String[] columns = {"STT", "Tên xe", "Biển số", "Số chỗ ngồi", "Giá thuê"};
		TableModel model = new DefaultTableModel(data, columns);
		int i = 0;
		for (Car car : listCar) {
			model.setValueAt(String.valueOf(i + 1), i, 0);
			model.setValueAt(car.getName(), i, 1);
			model.setValueAt(car.getLicense_plate(), i, 2);
			model.setValueAt(String.valueOf(car.getNumber_seats()), i, 3);
			model.setValueAt(String.valueOf(car.getCost()), i, 4);
			if (car.getState() == 1) isRentList.add(i);
			i++;
		}
		carTable.setModel(model);
	}
	public static HomePageView getInstance() {
		return new HomePageView();
	}
	
	class MonCellRenderer extends DefaultTableCellRenderer {

	    public Component getTableCellRendererComponent(JTable table, Object value,
	                    boolean isSelected, boolean hasFocus, int row, int column) {
	        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	        if (isRentList.contains(row)) {
	            setBackground(Color.RED);
	        } else {
	            setBackground(Color.WHITE);
	        }
	        return this;
	    }
	}
}

