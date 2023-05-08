package dao;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Car> {

	@Override
	public int insert(Car t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO user(license_plate, name, number_seats, cost, state, status_id)"
					+ " VALUES (?,?,?,?,?,?);";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getUsername());
			pst.setString(2,t.getPassword());
			pst.setString(3,t.getHoVaTen());
			
			//bước 3: thực thi câu lệnh sql
			
			
			ketQua = pst.executeUpdate();
			
			//bước 4: xử lí kết quả
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");
			
			// bước 5: 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Car t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Car t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Car> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car seclectById(Car t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Car> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
