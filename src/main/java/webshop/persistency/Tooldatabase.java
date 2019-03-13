package webshop.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tooldatabase {
	protected final Connection getConnection() {
		Connection con = null;
	 		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(
				"jdbc:oracle:thin:@ondora04.hu.nl:8521/educ36","martijn","Jayisgay123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	     return con;
	     }

}
