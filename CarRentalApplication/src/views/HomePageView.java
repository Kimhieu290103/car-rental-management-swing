package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class HomePageView extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel, bodyPanel;
	private JLabel lb1, lb2;
	private JButton btnShowDetail, btnRent, btnReturnCar, btnHistory;
	private JTable carTable;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageView frame = new HomePageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void init() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 237, 221));
		contentPane.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.setLayout(null);
		
		headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 780, 90);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(87, 125, 134));
		headerPanel.setBorder(new LineBorder(Color.BLACK, 1));
		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 148, 780, 403);
		bodyPanel.setLayout(new BorderLayout(1, 1));
		bodyPanel.setBorder(new LineBorder(Color.BLACK, 1));
		bodyPanel.setBackground(new Color(86, 157, 170));
		
		lb1 = new JLabel("VTH");
		lb1.setIcon(new ImageIcon("E:\\StudyDocuments\\ExerciseCode\\DUT_Semesters\\Semseter4\\Java\\BaiTapLon\\car-rental-management-swing\\CarRentalApplication\\image\\car.png"));
		lb1.setFont(new Font("Verdana", Font.BOLD, 22));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(10, 10, 127, 70);
		headerPanel.add(lb1);
		
		lb2 = new JLabel("ỨNG DỤNG CHO THUÊ XE OTO");
		lb2.setBounds(180, 10, 460, 70);
		lb2.setFont(new Font("Verdana", Font.BOLD, 22));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lb2);
		
		btnShowDetail = new JButton("Thông tin chi tiết");
		btnShowDetail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShowDetail.setBounds(314, 100, 133, 38);
		btnShowDetail.setBorder(new LineBorder(Color.BLACK, 2));
		btnShowDetail.setBackground(new Color(135, 203, 185));
		contentPane.add(btnShowDetail);
		
		btnRent = new JButton("Thuê xe");
		btnRent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRent.setBorder(new LineBorder(Color.BLACK, 2));
		btnRent.setBackground(new Color(135, 203, 185));
		btnRent.setBounds(552, 100, 85, 38);
		contentPane.add(btnRent);
		
		btnReturnCar = new JButton("Trả xe");
		btnReturnCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturnCar.setBorder(new LineBorder(Color.BLACK, 2));
		btnReturnCar.setBackground(new Color(135, 203, 185));
		btnReturnCar.setBounds(457, 100, 85, 38);
		contentPane.add(btnReturnCar);
		
		btnHistory = new JButton("Lịch sử giao dịch");
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistory.setBorder(new LineBorder(Color.BLACK, 2));
		btnHistory.setBackground(new Color(135, 203, 185));
		btnHistory.setBounds(647, 100, 133, 38);
		contentPane.add(btnHistory);
		
		
		String[][] data = new String[1][5];
		data[0][0] = "1";
		data[0][1] = "1";
		data[0][2] = "1";
		data[0][3] = "1";
		data[0][4] = "1";
		String[] columns = {"STT", "Tên xe", "Biển số", "Số chỗ ngồi", "Giá"};
		carTable = new JTable(data, columns);
		carTable.setBorder(new LineBorder(Color.BLACK, 1));
		carTable.setBackground(new Color(86, 157, 170));
		carTable.setShowGrid(true);
//		carTable.setEnabled(false);
		
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
	public HomePageView() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 588);
		setTitle("CAR RENTAL APPLICATION");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Danh sách các xe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 100, 133, 38);
		contentPane.add(lblNewLabel);		
		
	}
}
