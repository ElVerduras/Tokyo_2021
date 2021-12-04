package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bbdd.MyConnection;
import model.Pais;

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
			 ResultSet rs= st.executeQuery("SELECT * FROM pais ORDER BY nombre ASC");

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
			 
			 st.executeUpdate("INSERT INTO pais(nombre) VALUES ('" + p.getNombre() + "')");
			 
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
			 
			  st.executeUpdate("UPDATE pais SET nombre= '" + p.getNombre() + "' WHERE id='" + p.getId() + "'");
			 
			 //rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

	public int count(String nombre){
		 int n=0;
		 try{
			 
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM pais WHERE nombre='"+nombre+"'");
			 if(rs.next()) {
			        n= rs.getInt(1);
			 }
			 //rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 } 
		return n;
	}
	
	public int count(int id_p){
		 int n=0;
		 try{
			 
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM deportista WHERE id_pais='"+id_p+"'");
			 if(rs.next()) {
			        n= rs.getInt(1);
			 }
			 //rs.close();
			 st.close();
			 //con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 } 
		return n;
	}
	
}
