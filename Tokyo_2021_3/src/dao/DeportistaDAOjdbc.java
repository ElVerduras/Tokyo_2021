package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import bbdd.MyConnection;
import model.Deportista;

import java.util.ArrayList;


public class DeportistaDAOjdbc implements DeportistaDAO{
	
	public Deportista find(Deportista d) {
		 Deportista deportista = new Deportista();
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM deportista WHERE nombres='"+d.getNombre()+"' AND apellidos='"+d.getApellido()+"' AND id_pais='"+d.getId_pais()+"'");
			 if (rs.next()==true) {
				 deportista = new Deportista();
				 deportista.setId_disciplina(rs.getInt(1));
				 deportista.setNombre(rs.getString(2));
				 deportista.setApellido(rs.getString(3));
				 deportista.setEmail(rs.getString(4));
				 deportista.setTelefono(rs.getString(5));
				 deportista.setId_pais(rs.getInt(6));
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 e.printStackTrace();
		 }
		 return deportista;
	}
	
	public int recuperar_max_id() {
		 int aux = 0;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT MAX(id) AS id FROM deportista");
			 if(rs.next()) {
			 aux=rs.getInt(1);
			 rs.close();
			 st.close();
			 }
			// con.close();
		 } catch (java.sql.SQLException e) {
			 e.printStackTrace();//("Error de SQL: "+e.getMessage());
		 } 
		 return aux;
	}
	
	/*
	public Deportista find(String d) {
		 Deportista deportista = null;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM deportista WHERE apellidos='"+d.getApellido()+"' AND nombres='"+d.getNombre()+"' AND telefono='"+d.getTelefono()+ "'");
			 if (rs.next()==true) {
				 deportista = new Deportista();
				 deportista.setId_disciplina(rs.getInt(1));
				 deportista.setNombre(rs.getString(2));
				 deportista.setApellido(rs.getString(3));
				 deportista.setEmail(rs.getString(4));
				 deportista.setTelefono(rs.getString(5));
				 deportista.setId_pais(rs.getInt(6));

			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return deportista;
	}
	*/
	

	
	public List<Deportista> load(){
	
		 List<Deportista> listadeportista = new ArrayList<Deportista>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM deportista ");
			 while (rs.next()==true) {
				 Deportista deportista = new Deportista();
				 deportista.setId_disciplina(rs.getInt(1));
				 deportista.setApellido(rs.getString(2));
				 deportista.setNombre(rs.getString(3));
				 deportista.setEmail(rs.getString(4));
				 deportista.setTelefono(rs.getString(5));
				 deportista.setId_pais(rs.getInt(6));
				 
				 
				 listadeportista.add(deportista);
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listadeportista;
	
		
	}
	public Boolean delete(Deportista d) {
		 String nombre = d.getNombre();
		 System.out.println(nombre);
		 String apellido= d.getApellido();
		 System.out.println(apellido);

		 Boolean aux = false;
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			  st.execute("DELETE FROM deportista WHERE nombres='"+nombre+"' AND apellidos='"+apellido+"'");
			 
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		System.out.println(aux);
		return aux;
	}


	public void save(Deportista d) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 //st.executeUpdate("INSERT INTO deportista(apellidos,nombres,email,telefono,id_pais,id) VALUES (apellidos=" + d.getApellido() + ", nombres=" + d.getNombre() + ", email=" + d.getEmail() + ", telefono=" + d.getTelefono() + ", id_pais=" + d.getId_pais() + ", id=" + d.getId_disciplina()+ ")");
			 
			 ResultSet rs= st.executeQuery("SELECT MAX(id) AS id FROM deportista");
			 if(rs.next()) {
				 int aux=rs.getInt(1);
				 aux++;
				 st.executeUpdate("INSERT INTO deportista(apellidos,nombres,email,telefono,id_pais,id) VALUES ('" + d.getApellido() + "','" + d.getNombre() + "','" + d.getEmail() + "','" + d.getTelefono() + "','" + d.getId_pais() + "','" + aux + "')");
			 }
			 rs.close(); 
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
	
	public void update(Deportista d) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 st.executeUpdate("UPDATE deportista SET apellidos='" + d.getApellido() + "' ,nombres='" + d.getNombre() + "' ,email='" + d.getEmail() + "' ,telefono='" + d.getTelefono() + "' ,id_pais='" + d.getId_pais() + "'  WHERE id='" + d.getId_disciplina() + "'");
			 
			// rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL update: "+e.getMessage());
		 }
		
	}

	@Override
	public Deportista find(String d) {
		// TODO Auto-generated method stub
		return null;
	}

}

