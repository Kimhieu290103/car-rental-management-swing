package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.model.Car;
import models.model.Car_status;
import models.model.Customer;
import models.model.Order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;

@SuppressWarnings("serial")
public class ReturnCarView extends JFrame {

	private JPanel contentPane;
	private JTextField txtL_1;
	private JTextField txtL_2;
	private JTextField txtL_4;
	private JTextField txtTotalCost;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JTextField txtCCCD;
	private JTextField txtCustomerName;
	private JTextField txtCustomerPhone;
	private JTextField txtLicense_plate;

	public Choice choice;
	public JButton btnConfirm, btnCheck;

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
		rightPanel.setBounds(428, 70, 467, 265);
		rightPanel.setBorder(new LineBorder(Color.BLACK, 1));
		rightPanel.setLayout(null);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBorder(new LineBorder(Color.BLACK, 1));
		leftPanel.setBounds(0, 70, 430, 265);

		JLabel lbTitle = new JLabel("TRẢ THUÊ XE");
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

		txtCCCD = new JTextField();
		txtCCCD.setEditable(false);
		txtCCCD.setBackground(Color.WHITE);
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
		rightPanel.add(txtCCCD);
		rightPanel.add(txtCustomerName);
		rightPanel.add(txtCustomerPhone);
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

		txtLicense_plate = new JTextField();
		txtLicense_plate.setEditable(false);
		txtLicense_plate.setBackground(Color.WHITE);
		txtLicense_plate.setColumns(10);
		txtLicense_plate.setBounds(202, 82, 218, 26);
		txtLicense_plate.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtLicense_plate);

		txtL_4 = new JTextField();
		txtL_4.setEditable(false);
		txtL_4.setBackground(Color.WHITE);
		txtL_4.setColumns(10);
		txtL_4.setBounds(202, 118, 218, 26);
		txtL_4.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtL_4);

		txtDateStart = new JTextField();
		txtDateStart.setBackground(Color.WHITE);
		txtDateStart.setEditable(false);
		txtDateStart.setColumns(10);
		txtDateStart.setBounds(202, 154, 218, 26);
		txtDateStart.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtDateStart);

		txtDateEnd = new JTextField();
		txtDateEnd.setColumns(10);
		txtDateEnd.setBounds(202, 190, 218, 26);
		txtDateEnd.setFont(new Font("Verdana", Font.BOLD, 11));
		leftPanel.add(txtDateEnd);

		btnConfirm = new JButton("XÁC NHẬN TRẢ XE");
		btnConfirm.setBounds(10, 345, 875, 26);
		btnConfirm.setFont(new Font("Verdana", Font.BOLD, 15));
		btnConfirm.setBorder(new LineBorder(Color.BLACK, 2));
		btnConfirm.setBackground(new Color(87, 125, 134));
		contentPane.add(btnConfirm);

		contentPane.add(rightPanel);

		JLabel lbTotalCost = new JLabel("Số tiền phải trả");
		lbTotalCost.setFont(new Font("Verdana", Font.BOLD, 11));
		lbTotalCost.setBounds(10, 154, 102, 26);
		rightPanel.add(lbTotalCost);

		txtTotalCost = new JTextField();
		txtTotalCost.setFont(new Font("Verdana", Font.BOLD, 11));
		txtTotalCost.setEditable(false);
		txtTotalCost.setColumns(10);
		txtTotalCost.setBackground(Color.WHITE);
		txtTotalCost.setBounds(146, 154, 311, 26);
		rightPanel.add(txtTotalCost);

		btnCheck = new JButton("Kiểm tra");
		btnCheck.setFont(new Font("Verdana", Font.BOLD, 15));
		btnCheck.setBorder(new LineBorder(Color.BLACK, 2));
		btnCheck.setBackground(new Color(87, 125, 134));
		btnCheck.setBounds(10, 229, 447, 26);
		rightPanel.add(btnCheck);
		contentPane.add(headerPanel);
		contentPane.add(leftPanel);

		JLabel lbL_7 = new JLabel("Trình trạng xe sau khi thuê");
		lbL_7.setFont(new Font("Verdana", Font.BOLD, 11));
		lbL_7.setBounds(10, 226, 186, 26);
		leftPanel.add(lbL_7);

		choice = new Choice();
		choice.add(String.valueOf(0));
		choice.add(String.valueOf(1));
		choice.add(String.valueOf(2));
		choice.add(String.valueOf(3));
		choice.add(String.valueOf(4));
		choice.add(String.valueOf(5));
		choice.setBounds(202, 226, 218, 30);
		leftPanel.add(choice);
	}

	private ReturnCarView() {
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 909, 421);
		setTitle("Trả xe");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

	public void clearAll() {
		txtL_1.setText("");
		txtL_2.setText("");
		txtLicense_plate.setText("");
		txtL_4.setText("");
		txtDateStart.setText("");
		txtDateEnd.setText("");
		txtCCCD.setText("");
		txtCustomerName.setText("");
		txtCustomerPhone.setText("");
	}

	public void addActionListener(ActionListener actionListener) {
		btnConfirm.addActionListener(actionListener);
		btnCheck.addActionListener(actionListener);
	}

	public void setDefaultInformation(Order order, Car car, Customer customer) {
		clearAll();
		txtL_1.setText(order.getOrder_id());
		txtL_2.setText(car.getName());
		txtLicense_plate.setText(car.getLicense_plate());
		txtL_4.setText(car.getStatus_id());
		txtDateStart.setText(order.getBegin_date().toString());
		txtDateEnd.setText(order.getEnd_date().toString());
		txtCCCD.setText(customer.getCar_id());
		txtCustomerName.setText(customer.getName());
		txtCustomerPhone.setText(customer.getPhone());

		LocalDate d1 = order.getBegin_date().toLocalDate();
		LocalDate d2 = Date.valueOf(txtDateEnd.getText()).toLocalDate();
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays();

		DecimalFormat decimalFormat = new DecimalFormat("#.###");
		txtTotalCost.setText(decimalFormat.format(diffDays * car.getCost()));
	}

	public Order getOrder() {
		Order order = new Order();
		order.setOrder_id(txtL_1.getText());
		order.setCar_id(txtLicense_plate.getText());
		order.setBegin_date(Date.valueOf(txtDateStart.getText()));
		order.setEnd_date(Date.valueOf(txtDateEnd.getText()));
		order.setCar_status_before_rent(txtL_4.getText());
		order.setCar_status_after_rent(choice.getSelectedItem());
		order.setCustomer_id(txtCCCD.getText());
		return order;
	}

	public void updateTotalCost(Car car, Car_status carStatus) {
		LocalDate d1 = Date.valueOf(txtDateStart.getText()).toLocalDate();
		LocalDate d2 = Date.valueOf(txtDateEnd.getText()).toLocalDate();
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays();

		DecimalFormat decimalFormat = new DecimalFormat("#.###");
		txtTotalCost.setText(decimalFormat.format(diffDays * car.getCost() + carStatus.getCost()));
	}

	public static ReturnCarView getInstance() {
		return new ReturnCarView();
	}
}
