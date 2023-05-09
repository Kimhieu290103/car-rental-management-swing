package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import models.model.Car;
import models.model.Car_status;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DetailInformationView extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JLabel lb6;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	
	private void init() {
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);
		
		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 503, 57);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));
		
		JLabel lbTitle = new JLabel("THÔNG TIN XE CHI TIẾT");
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
		
		lb6 = new JLabel("Mô tả tình trạng");
		lb6.setBounds(10, 283, 172, 34);
		lb6.setFont(new Font("|Verdana", Font.BOLD, 14));
		
		txt1 = new JTextField();
		txt1.setBackground(Color.WHITE);
		txt1.setEditable(false);
		txt1.setColumns(10);
		txt1.setBounds(182, 69, 311, 33);
		txt1.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt1.setBorder(new LineBorder(Color.BLACK, 1));
		
		txt2 = new JTextField();
		txt2.setBackground(Color.WHITE);
		txt2.setEditable(false);
		txt2.setColumns(10);
		txt2.setBounds(182, 110, 311, 33);
		txt2.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt2.setBorder(new LineBorder(Color.BLACK, 1));
		
		txt3 = new JTextField();
		txt3.setBackground(Color.WHITE);
		txt3.setEditable(false);
		txt3.setColumns(10);
		txt3.setBounds(182, 153, 311, 33);
		txt3.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt3.setBorder(new LineBorder(Color.BLACK, 1));
		
		txt4 = new JTextField();
		txt4.setBackground(Color.WHITE);
		txt4.setEditable(false);
		txt4.setColumns(10);
		txt4.setBounds(182, 197, 311, 33);
		txt4.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt4.setBorder(new LineBorder(Color.BLACK, 1));
		
		txt5 = new JTextField();
		txt5.setBackground(Color.WHITE);
		txt5.setEditable(false);
		txt5.setColumns(10);
		txt5.setBounds(182, 241, 311, 33);
		txt5.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt5.setBorder(new LineBorder(Color.BLACK, 1));
		
		txt6 = new JTextField();
		txt6.setBackground(Color.WHITE);
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBounds(182, 283, 311, 33);
		txt6.setFont(new Font("|Verdana", Font.BOLD, 14));
		txt6.setBorder(new LineBorder(Color.BLACK, 1));
		
		contentPane.add(lb1);
		contentPane.add(lb2);
		contentPane.add(lb3);
		contentPane.add(lb4);
		contentPane.add(lb5);
		contentPane.add(lb6);
		contentPane.add(txt1);
		contentPane.add(txt2);
		contentPane.add(txt3);
		contentPane.add(txt4);
		contentPane.add(txt5);
		contentPane.add(txt6);
		contentPane.add(headerPanel);
	}
	private DetailInformationView() {
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 517, 364);
		setTitle("Thông tin chi tiết");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}
	
	public void clearAll() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
		txt6.setText("");
	}
	public void setInformation(Car car, Car_status carStatus) {
		clearAll();
		txt1.setText(car.getName());
		txt2.setText(String.valueOf(car.getNumber_seats()));
		txt3.setText(car.getLicense_plate());
		txt4.setText(String.valueOf(car.getCost()));
		txt5.setText("Mức độ " + car.getStatus_id());
		txt6.setText(carStatus.getDescription());
	}
	
	public static DetailInformationView getInstance() {
		return new DetailInformationView();
	}
}
