package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	private static String user = "admin";
	private static String pasword = "1234";
	
	private static Connection con = null;
	
	static {
		
		try {		      
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tokyo2021_3",user, pasword);		      		      
		}catch (SQLException e) {			
			System.out.println("no se pudo conectar a la BD");
		    e.printStackTrace();		    
		}		
	}
	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPasword() {
		return pasword;
	}


	public void setPasword(String pasword) {
		this.pasword = pasword;
	}


	public static Connection getCon() {
		return con;
	}
}

