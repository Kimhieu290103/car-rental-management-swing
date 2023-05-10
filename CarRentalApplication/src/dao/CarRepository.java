package dao;

import java.sql.*;
import java.util.ArrayList;

import db.JDBCUtil;
import models.model.Car;

public class CarRepository implements RepositoryInterface<Car> {

	@Override
	public int insert(Car t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO car(license_plate, name, number_seats, cost, state, status_id)"
					+ " VALUES (?,?,?,?,?,?);";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getLicense_plate());
			pst.setString(2, t.getName());
			pst.setInt(3, t.getNumber_seats());
			pst.setDouble(4, t.getCost());
			pst.setInt(5, t.getState());
			pst.setString(6, t.getStatus_id());

			ketQua = pst.executeUpdate();

			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Car t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE car " + " SET name=?" + ", number_seats=?" + ", cost=?" + ", state=?" + ", status_id=?"
					+ " WHERE license_plate=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setInt(2, t.getNumber_seats());
			st.setDouble(3, t.getCost());
			st.setInt(4, t.getState());
			st.setString(5, t.getStatus_id());
			st.setString(6, t.getLicense_plate());

			Car c = new Car();
			c.setLicense_plate(t.getLicense_plate());
			Car car = (new CarRepository().seclectById(c));

			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(Car t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from car " + " WHERE license_plate =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getLicense_plate());
			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Car> selectAll() {
		ArrayList<Car> result = new ArrayList<Car>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM car";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String license_plate = rs.getString("license_plate");
				String name = rs.getString("name");
				int number_seats = rs.getInt("number_seats");
				Double cost = rs.getDouble("cost");
				int state = rs.getInt("state");
				String status_id = rs.getString("status_id");

				Car car = new Car(license_plate, name, number_seats, cost, state, status_id);
				result.add(car);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Car seclectById(Car t) {
		Car result = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM car WHERE license_plate=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getLicense_plate());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String license_plate = rs.getString("license_plate");
				String name = rs.getString("name");
				int number_seats = rs.getInt("number_seats");
				Double cost = rs.getDouble("cost");
				int state = rs.getInt("state");
				String status_id = rs.getString("status_id");

				result = new Car(license_plate, name, number_seats, cost, state, status_id);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
