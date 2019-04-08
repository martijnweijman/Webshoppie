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
						"jdbc:oracle:thin:@localhost:1521:xe","webshopadmin","admin");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	     return con;
	     }

}