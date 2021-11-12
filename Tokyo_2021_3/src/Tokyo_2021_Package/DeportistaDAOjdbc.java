package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class DeportistaDAOjdbc implements DeportistaDAO{
	
	public Deportista find(String id) {
		 Deportista deportista = null;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select d from deportita where d.id='"+id+"'");
			 if (rs.next()==true) {
				 deportista = new Deportista();
				 deportista.setNombre(rs.getString(1));
				 deportista.setApellido(rs.getString(2));
				 deportista.setEmail(rs.getString(3));
				 deportista.setPais(rs.getString(5));
				 deportista.setTelefono(rs.getInt(4));
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return deportista;
	}
	
	
	public List<Deportista> load(){
		 Deportista deportista = null;
		 List<Deportista> listadeportista = new ArrayList<Deportista>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from deportita ");
			 while (rs.next()==true) {
				 deportista = new Deportista();
				 deportista.setNombre(rs.getString(2));
				 deportista.setApellido(rs.getString(1));
				 deportista.setEmail(rs.getString(3));
				 deportista.setPais(rs.getString(5));
				 deportista.setTelefono(rs.getInt(4));
				 
				 listadeportista.add(deportista);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listadeportista;
	
		
	}
	public void delete(Deportista d) {
		 String nombre = d.getNombre();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("Delete a from deportita where a.nombre='"+nombre+"'");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}


	public void save(Deportista d) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("INSERT INTO deportista(apellidos,nombres,email,telefono) VALUES (" + d.toString() + ")");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}

