package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOjdbc implements PaisDAO{
	
	public Pais find(int id) {
		 Pais pais = null;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from pais where id='"+id+"'");
			 if (rs.next()==true) {
				 pais = new Pais();
				 pais.setNombre(rs.getString(2));
			 }
			 rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return pais;
	}
	
	
	public List<Pais> load(){
		 Pais pais = null;
		 List<Pais> listapais = new ArrayList<Pais>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from pais ");
			 while (rs.next()==true) {
				 pais = new Pais();
				 pais.setNombre(rs.getString(1));
				 
				 listapais.add(pais);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listapais;
	
		
	}
	public void delete(Pais p) {
		 String nombre = p.getNombre();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("Delete a from pais where a.nombre='"+nombre+"'");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}


	public void save(Pais p) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 int rs= st.executeUpdate("INSERT INTO pais(nombre) VALUES ('" + p.getNombre() + "')");
			 
			 //rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}
