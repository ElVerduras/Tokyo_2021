package Tokyo_2021_Package;
import static Tokyo_2021_Package.Gestor_De_Olimpiadas_CONFIGURACIÓN.psw;
import static Tokyo_2021_Package.Gestor_De_Olimpiadas_CONFIGURACIÓN.usr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	//private static String user = "root";
	//private static String pasword = "1234";
	
	private static Connection con = null;
	
	static {
		
		try {		      
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tokyo2021_e3?useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8","root","1234");		      		      
		}catch (SQLException e) {			
			System.out.println("no se pudo conectar a la BD");
		    e.printStackTrace();		    
		}		
	}
	
	public static Connection getCon() {
		return con;
	}
}

