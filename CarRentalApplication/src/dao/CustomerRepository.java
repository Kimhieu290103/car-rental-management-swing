package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import models.model.Customer;

public class CustomerRepository implements RepositoryInterface<Customer> {

	@Override
	public int insert(Customer t) {
		int rs = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO customer(cardId, name, phone)"
					+ " VALUES (?,?,?);";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCar_id());
			pst.setString(2, t.getName());
			pst.setString(3, t.getPhone());

			rs = pst.executeUpdate();
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int update(Customer t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE customer " + " SET name=?" + ", phone=?" + " WHERE cardId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getPhone());
			st.setString(3, t.getCar_id());

			Customer c = new Customer();
			c.setCar_id(t.getCar_id());
			// Customer customer = (new CustomerRepository().seclectById(c));

			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(Customer t) {
		int result = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from customer " + " WHERE cardId =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCar_id());
			result = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM customer";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String cardId = rs.getString("cardId");
				String name = rs.getString("name");
				String phone = rs.getString("phone");

				Customer customer = new Customer(cardId, name, phone);
				result.add(customer);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer seclectById(Customer t) {
		Customer result = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM customer WHERE cardId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCar_id());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String cardId = rs.getString("cardId");
				String name = rs.getString("name");
				String phone = rs.getString("phone");

				result = new Customer(cardId, name, phone);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
