package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import models.model.Car_status;

public class CarStatusRepository implements RepositoryInterface<Car_status> {

	@Override
	public int insert(Car_status t) {
		int rs = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO car_status(id, cost, description)"
					+ " VALUES (?,?,?);";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getId());
			pst.setDouble(2,t.getCost());
			pst.setString(3,t.getDescription());
			
			rs = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public ArrayList<Car_status> selectAll() {
		ArrayList<Car_status> result = new ArrayList<Car_status>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM car_status";
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
 
			while(rs.next()) {
				String id = rs.getString("id");
				Double cost = rs.getDouble("cost");
				String description = rs.getString("description");
				
				Car_status cs = new Car_status(id, cost, description);
				result.add(cs);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Car_status seclectById(Car_status t) {
		Car_status result = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM car_status WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getId());
			
			ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				String id = rs.getString("id");
				Double cost = rs.getDouble("cost");
				String description = rs.getString("description");
				
				result = new Car_status(id, cost, description);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Car_status t) {
		return 0;
	}

	@Override
	public int delete(Car_status t) {
		return 0;
	}
}
