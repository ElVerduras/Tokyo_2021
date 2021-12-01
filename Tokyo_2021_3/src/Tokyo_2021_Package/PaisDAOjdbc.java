package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOjdbc implements PaisDAO{
	
	public Pais find(int id) {
		 Pais pais = new Pais();
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM pais WHERE id='"+id+"'");
			 if (rs.next()==true) {
				 pais.setId(rs.getInt(1));
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
	
	public Pais find(String nombre) {
		 Pais pais = new Pais();
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM pais WHERE nombre='"+nombre+"'");
			 if (rs.next()==true) {
				 pais.setId(rs.getInt(1));
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
		 
		 List<Pais> listapais = new ArrayList<Pais>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM pais ");
			 while (rs.next()==true) {
				 Pais pais =new Pais();
				 pais = new Pais();
				 pais.setId(rs.getInt(1));
				 pais.setNombre(rs.getString(2));
				 
				 listapais.add(pais);
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listapais;
	
		
	}
	public Boolean delete(Pais p) {
		 int id = p.getId();
		 boolean aux=false;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			aux=st.execute("DELETE FROM pais WHERE id='"+id+"'");

			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		return aux;
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
	
	public void update(Pais p) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 int rs= st.executeUpdate("UPDATE pais SET nombre= '" + p.getNombre() + "' WHERE id='" + p.getId() + "'");
			 
			 //rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}
