package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
	private String user = "admin";
	private String pasword = "1234";
	
	private Connection con = null;

	public void getCon(String user, String pasword) {
		

		  
		try {
		      
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tokyo2021_3",user, pasword);
		    Statement sent = con.createStatement();
		      
		      
		}catch (SQLException e) {
			System.out.println("no se pudo conectar a la BD");
		    e.printStackTrace();
		}
	}
}

