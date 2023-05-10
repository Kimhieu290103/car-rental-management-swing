package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import models.model.Order;

public class OrderRepository implements RepositoryInterface<Order> {

	@Override
	public int insert(Order t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO order_table (order_id, customer_id, car_id, begin_date, end_date, car_status_before_rent, car_status_after_rent) "
					+
					" VALUES (?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder_id());
			st.setString(2, t.getCustomer_id());
			st.setString(3, t.getCar_id());
			st.setDate(4, t.getBegin_date());
			st.setDate(5, t.getEnd_date());
			st.setString(6, t.getCar_status_before_rent());
			st.setString(7, t.getCar_status_after_rent());

			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Order t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE order_table " + " SET customer_id=?" + ", car_id=?" + ", begin_date=?" + ", end_date=?"
					+ ", car_status_before_rent=?" + ", car_status_after_rent=?" + " WHERE order_id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomer_id());
			st.setString(2, t.getCar_id());
			st.setDate(3, t.getBegin_date());
			st.setDate(4, t.getEnd_date());
			st.setString(5, t.getCar_status_before_rent());
			st.setString(6, t.getCar_status_after_rent());
			st.setString(7, t.getOrder_id());

			Order o = new Order();
			o.setOrder_id(t.getOrder_id());
			Order order = (new OrderRepository().seclectById(o));

			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(Order t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from order_table " + " WHERE order_id =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder_id());
			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM order_table";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String order_id = rs.getString("order_id");
				String customer_id = rs.getString("customer_id");
				String car_id = rs.getString("car_id");
				Date begin_date = rs.getDate("begin_date");
				Date end_date = rs.getDate("end_date");
				String car_status_before_rent = rs.getString("car_status_before_rent");
				String car_status_after_rent = rs.getString("car_status_after_rent");

				Order order = new Order(order_id, customer_id, car_id, begin_date, end_date, car_status_before_rent,
						car_status_after_rent);
				result.add(order);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order seclectById(Order t) {
		Order result = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM order_table WHERE order_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder_id());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String order_id = rs.getString("order_id");
				String customer_id = rs.getString("customer_id");
				String car_id = rs.getString("car_id");
				Date begin_date = rs.getDate("begin_date");
				Date end_date = rs.getDate("end_date");
				String car_status_before_rent = rs.getString("car_status_before_rent");
				String car_status_after_rent = rs.getString("car_status_after_rent");

				result = new Order(order_id, customer_id, car_id, begin_date, end_date, car_status_before_rent,
						car_status_after_rent);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
