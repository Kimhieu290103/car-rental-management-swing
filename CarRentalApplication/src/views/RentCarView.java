package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.model.Car;
import models.model.Customer;
import models.model.Order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RentCarView extends JFrame {

	private JPanel contentPane;
	private JTextField txtL_1;
	private JTextField txtL_2;
	private JTextField txtL_3;
	private JTextField txtL_4;
	
	public JButton btnAddNewCustomer, btnOK, btnReset, btnBack, btnCheck;
	public JTextField txtDateStart;
	public JTextField txtDateEnd;
	public JTextField txtCCCD;
	public JTextField txtCustomerName;
	public JTextField txtCustomerPhone;
	public JButton btnRegister;


	private void init() {
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 895, 71);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(428, 70, 467, 241);
		rightPanel.setBorder(new LineBorder(Color.BLACK, 1));
		rightPanel.setLayout(null);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBorder(new LineBorder(Color.BLACK, 1));
		leftPanel.setBounds(0, 70, 430, 241);
		
		
		JLabel lbTitle = new JLabel("ĐĂNG KÝ THUÊ XE");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Verdana", Font.BOLD, 22));
		lbTitle.setBounds(0, 10, 895, 51);
		headerPanel.add(lbTitle);
		
		
		JLabel lbR_1 = new JLabel("Thông tin khách hàng");
		lbR_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbR_1.setBounds(10, 10, 447, 26);
		lbR_1.setFont(new Font("Verdana", Font.BOLD, 13));
		JLabel lbR_2 = new JLabel("CCCD");
		lbR_2.setBounds(10, 46, 102, 26);
		lbR_2.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbR_3 = new JLabel("Tên khách hàng");
		lbR_3.setBounds(10, 82, 102, 26);
		lbR_3.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbR_4 = new JLabel("Số điện thoại");
		lbR_4.setBounds(10, 118, 102, 26);
		lbR_4.setFont(new Font("Verdana", Font.BOLD, 11));
		
		btnAddNewCustomer = new JButton("Thêm khách hàng mới");
		btnAddNewCustomer.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAddNewCustomer.setBounds(10, 154, 223, 26);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(146, 48, 311, 26);
		txtCCCD.setFont(new Font("Verdana", Font.BOLD, 11));
		
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBackground(Color.WHITE);
		txtCustomerName.setEditable(false);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(146, 82, 311, 26);
		txtCustomerName.setFont(new Font("Verdana", Font.BOLD, 11));
		
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setBackground(Color.WHITE);
		txtCustomerPhone.setEditable(false);
		txtCustomerPhone.setColumns(10);
		txtCustomerPhone.setBounds(146, 118, 311, 26);
		txtCustomerPhone.setFont(new Font("Verdana", Font.BOLD, 11));
		
		btnOK = new JButton("XÁC NHẬN");
		btnOK.setFont(new Font("Verdana", Font.BOLD, 11));
		btnOK.setBounds(10, 190, 146, 26);
		btnOK.setVisible(false);
		btnOK.setFont(new Font("Verdana", Font.BOLD, 11));
		
		btnReset = new JButton("Đặt lại");
		btnReset.setBounds(166, 191, 146, 26);
		btnReset.setFont(new Font("Verdana", Font.BOLD, 11));
		btnReset.setVisible(false);
		
		btnBack = new JButton("Trở lại");
		btnBack.setBounds(322, 191, 135, 26);
		btnBack.setFont(new Font("Verdana", Font.BOLD, 11));
		btnBack.setVisible(false);
		
		btnCheck = new JButton("Kiểm tra");
		btnCheck.setFont(new Font("Verdana", Font.BOLD, 11));
		btnCheck.setBounds(234, 154, 223, 26);
		
		rightPanel.add(btnCheck);
		rightPanel.add(btnReset);
		rightPanel.add(btnBack);
		rightPanel.add(txtCCCD);
		rightPanel.add(txtCustomerName);
		rightPanel.add(txtCustomerPhone);
		rightPanel.add(btnOK);
		rightPanel.add(btnAddNewCustomer);
		rightPanel.add(lbR_1);
		rightPanel.add(lbR_2);
		rightPanel.add(lbR_3);
		rightPanel.add(lbR_4);
		
		
		JLabel lbL_1 = new JLabel("Mã đăng ký thuê xe");
		lbL_1.setBounds(10, 10, 197, 26);
		lbL_1.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbL_2 = new JLabel("Tên xe");
		lbL_2.setBounds(10, 46, 197, 26);
		lbL_2.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbL_3 = new JLabel("Biển số xe");
		lbL_3.setBounds(10, 82, 197, 26);
		lbL_3.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbL_4 = new JLabel("Trình trạng xe trước khi thuê");
		lbL_4.setBounds(10, 118, 197, 26);
		lbL_4.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbL_5 = new JLabel("Ngày thuê");
		lbL_5.setBounds(10, 154, 197, 26);
		lbL_5.setFont(new Font("Verdana", Font.BOLD, 11));
		JLabel lbL_6 = new JLabel("Ngày trả");
		lbL_6.setBounds(10, 190, 197, 26);
		lbL_6.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(lbL_1);
		leftPanel.add(lbL_2);
		leftPanel.add(lbL_3);
		leftPanel.add(lbL_4);
		leftPanel.add(lbL_5);
		leftPanel.add(lbL_6);
		
		
		txtL_1 = new JTextField();
		txtL_1.setBackground(Color.WHITE);
		txtL_1.setEditable(false);
		txtL_1.setBounds(202, 10, 218, 26);
		txtL_1.setColumns(10);
		txtL_1.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtL_1);
		
		txtL_2 = new JTextField();
		txtL_2.setEditable(false);
		txtL_2.setBackground(Color.WHITE);
		txtL_2.setColumns(10);
		txtL_2.setBounds(202, 46, 218, 26);
		txtL_2.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtL_2);
		
		txtL_3 = new JTextField();
		txtL_3.setEditable(false);
		txtL_3.setBackground(Color.WHITE);
		txtL_3.setColumns(10);
		txtL_3.setBounds(202, 82, 218, 26);
		txtL_3.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtL_3);
		
		txtL_4 = new JTextField();
		txtL_4.setEditable(false);
		txtL_4.setBackground(Color.WHITE);
		txtL_4.setColumns(10);
		txtL_4.setBounds(202, 118, 218, 26);
		txtL_4.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtL_4);
		
		txtDateStart = new JTextField();
		txtDateStart.setColumns(10);
		txtDateStart.setBounds(202, 154, 218, 26);
		txtDateStart.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtDateStart);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setColumns(10);
		txtDateEnd.setBounds(202, 190, 218, 26);
		txtDateEnd.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtDateEnd);
		
		btnRegister = new JButton("ĐĂNG KÝ");
		btnRegister.setBounds(10, 324, 875, 26);
		btnRegister.setFont(new Font("Verdana", Font.BOLD, 15));
		btnRegister.setBorder(new LineBorder(Color.BLACK, 2));
		btnRegister.setBackground(new Color(87, 125, 134));
		contentPane.add(btnRegister);
		
		contentPane.add(rightPanel);
		contentPane.add(headerPanel);
		contentPane.add(leftPanel);
	}																																
	private RentCarView() {
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 909, 397);
		setTitle("Thuê xe");
		setLocationRelativeTo(null);
		setContentPane(contentPane);	
	}
	public void clearAll() {
		txtL_1.setText("");
		txtL_2.setText("");
		txtL_3.setText("");
		txtL_4.setText("");
		txtDateStart.setText("");
		txtDateEnd.setText("");
		txtCCCD.setText("");
		txtCustomerName.setText("");
		txtCustomerPhone.setText("");
	}
	public void clearCutomerInformation() {
		txtCCCD.setText("");
		txtCustomerName.setText("");
		txtCustomerPhone.setText("");
	}
	
	public void addActionListener(ActionListener actionListener) {
		btnAddNewCustomer.addActionListener(actionListener);
		btnOK.addActionListener(actionListener);
		btnReset.addActionListener(actionListener);
		btnBack.addActionListener(actionListener);
		btnCheck.addActionListener(actionListener);
		btnRegister.addActionListener(actionListener);
	}
	public void setEnableBtnOK() {
		btnOK.setVisible(true);
	}
	public void setDefaultInformation(Car car) {
		clearAll();
		StringBuffer order_id = new StringBuffer(LocalDateTime.now().toString());
		int i = 0;
		while (i < order_id.length()) {
			if (order_id.charAt(i) < 48 || order_id.charAt(i) > 57) {
				order_id.deleteCharAt(i);
			}
			else i++;
		}
		
		txtL_1.setText(order_id.toString());
		txtL_2.setText(car.getName());
		txtL_3.setText(car.getLicense_plate());
		txtL_4.setText(car.getStatus_id());
	}
	public void setCustomerInformation(Customer customer) {
		txtCCCD.setText(customer.getCar_id());
		txtCustomerName.setText(customer.getName());
		txtCustomerPhone.setText(customer.getPhone());
	}
	public void addNewCustomerMode() {
		txtCustomerName.setEditable(true);
		txtCustomerPhone.setEditable(true);
		btnOK.setVisible(true);
		btnReset.setVisible(true);
		btnBack.setVisible(true);
	}
	public void existCustomerMode() {
		txtCustomerName.setEditable(false);
		txtCustomerPhone.setEditable(false);
		btnOK.setVisible(false);
		btnReset.setVisible(false);
		btnBack.setVisible(false);
	}
	public Order getOrder() {
		Order order = new Order();
		order.setOrder_id(txtL_1.getText());
		order.setCar_id(txtL_3.getText());
		order.setBegin_date(Date.valueOf(txtDateStart.getText()));
		order.setEnd_date(Date.valueOf(txtDateEnd.getText()));
		order.setCar_status_before_rent(txtL_4.getText());
		order.setCustomer_id(txtCCCD.getText());
		return order;
	}
	
	public static RentCarView getInstance() {
		return new RentCarView();
	}

}

