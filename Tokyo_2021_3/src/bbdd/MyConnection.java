package bbdd;
import static view.GestorDeOlimpiadasConfiguración.psw;
import static view.GestorDeOlimpiadasConfiguración.usr;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException; 
 
public class MyConnection {
 
	
	private static Connection con = null;
	
	static {
		
		try {		      
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tokyo2021_e3?useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8",usr, psw);		      		      
		}catch (SQLException e) {			
			System.out.println("no se pudo conectar a la BD");
		    e.printStackTrace();		    
		}		
	}
	
	public static Connection getCon() {
		return con;
	}
}

