package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mySQL://localhost:3306/car_rental_application?useSSL=false";
			String username = "root";
			String password = "thanhvinh0703";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) 
				c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!= null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
