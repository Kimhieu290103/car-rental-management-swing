package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.model.Car;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditCarView extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;

	public JButton btnOK;

	private void init() {
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);

		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 503, 57);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));

		JLabel lbTitle = new JLabel("CHỈNH SỬA THÔNG TIN XE");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(0, 10, 503, 37);
		lbTitle.setFont(new Font("Verdana", Font.BOLD, 22));
		headerPanel.add(lbTitle);

		lb1 = new JLabel("Tên xe");
		lb1.setBounds(10, 67, 172, 33);
		lb1.setFont(new Font("Verdana", Font.BOLD, 14));

		lb2 = new JLabel("Số chỗ ngồi");
		lb2.setBounds(10, 110, 172, 33);
		lb2.setFont(new Font("Verdana", Font.BOLD, 14));

		lb3 = new JLabel("Biển số xe");
		lb3.setBounds(10, 153, 172, 34);
		lb3.setFont(new Font("Verdana", Font.BOLD, 14));

		lb4 = new JLabel("Giá thuê");
		lb4.setBounds(10, 197, 172, 34);
		lb4.setFont(new Font("Verdana", Font.BOLD, 14));

		lb5 = new JLabel("Tình trạng xe");
		lb5.setBounds(10, 241, 172, 34);
		lb5.setFont(new Font("Verdana", Font.BOLD, 14));

		txt1 = new JTextField();
		txt1.setBackground(Color.WHITE);
		txt1.setColumns(10);
		txt1.setBounds(182, 69, 311, 33);
		txt1.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt1.setBorder(new LineBorder(Color.BLACK, 1));

		txt2 = new JTextField();
		txt2.setBackground(Color.WHITE);
		txt2.setColumns(10);
		txt2.setBounds(182, 110, 311, 33);
		txt2.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt2.setBorder(new LineBorder(Color.BLACK, 1));

		txt3 = new JTextField();
		txt3.setBackground(Color.WHITE);
		txt3.setColumns(10);
		txt3.setEditable(false);
		txt3.setForeground(Color.BLACK);
		txt3.setBounds(182, 153, 311, 33);
		txt3.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt3.setBorder(new LineBorder(Color.BLACK, 1));

		txt4 = new JTextField();
		txt4.setBackground(Color.WHITE);
		txt4.setColumns(10);
		txt4.setBounds(182, 197, 311, 33);
		txt4.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt4.setBorder(new LineBorder(Color.BLACK, 1));

		txt5 = new JTextField();
		txt5.setBackground(Color.WHITE);
		txt5.setColumns(10);
		txt5.setBounds(182, 241, 311, 33);
		txt5.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt5.setBorder(new LineBorder(Color.BLACK, 1));

		btnOK = new JButton("Xác  nhận");
		btnOK.setBounds(10, 285, 483, 32);
		btnOK.setBorder(new LineBorder(Color.BLACK, 1));
		btnOK.setFont(new Font("|Verdana", Font.BOLD, 14));
		btnOK.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnOK);
		contentPane.add(lb1);
		contentPane.add(lb2);
		contentPane.add(lb3);
		contentPane.add(lb4);
		contentPane.add(lb5);
		contentPane.add(txt1);
		contentPane.add(txt2);
		contentPane.add(txt3);
		contentPane.add(txt4);
		contentPane.add(txt5);
		contentPane.add(headerPanel);
	}

	private EditCarView() {
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 517, 364);
		setTitle("Chỉnh sửa thông tin");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

	public void clearAll() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
	}

	public void setInformation(Car car) {
		clearAll();
		txt1.setText(car.getName());
		txt2.setText(String.valueOf(car.getNumber_seats()));
		txt3.setText(car.getLicense_plate());
		txt4.setText(String.valueOf(car.getCost()));
		txt5.setText(car.getStatus_id());
	}

	public Car getCar() {
		if (txt1.getText().isEmpty() || txt2.getText().isEmpty() || txt3.getText().isEmpty() || txt4.getText().isEmpty()
				|| txt5.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "BẠN PHẢI ĐIỀN ĐỦ THÔNG TIN!", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
			return null;
		}

		Car car = new Car();
		car.setName(txt1.getText());
		car.setNumber_seats(Integer.parseInt(txt2.getText().trim()));
		car.setLicense_plate(txt3.getText());
		car.setCost(Double.parseDouble(txt4.getText().trim()));
		car.setStatus_id(txt5.getText());
		return car;
	}

	public void addActionListener(ActionListener actionListener) {
		btnOK.addActionListener(actionListener);
	}

	public static EditCarView getInstance() {
		return new EditCarView();
	}
}
