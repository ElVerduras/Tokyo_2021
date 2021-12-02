package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOjdbc implements DisciplinaDAO {
	
	public Disciplina find(int id) {
		// List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
		Disciplina disciplina = new Disciplina();

		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM disciplina WHERE id='"+id+"'");
			 if(rs.next()) {
				 disciplina.setId(rs.getInt(1));
				 disciplina.setNombre(rs.getString(2));
			 }
			 //ResultSet rs1= st.executeQuery("SELECT * FROM deportista_en_disciplina WHERE id_deportista='"+id+"'");
			 
			/* if (rs1.next()==true) {
				 disciplina.setId(rs1.getInt(1));
				 ResultSet rs= st.executeQuery("SELECT * FROM disciplina WHERE id='"+disciplina.getId()+"'");
				 if (rs.next()==true)
					 disciplina.setNombre(rs.getString(2));
				 else System.out.println("Error de SQL: ");
					 
				 rs.close();

			 }*/
			 
			 rs.close();
			 //rs1.close();
			 st.close();
			
				// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return disciplina;
	}
	
	
	public Disciplina find(String nombre) { 
			// List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
			Disciplina disciplina = new Disciplina();

			 try{
				 Connection con = MyConnection.getCon();
				 Statement st = con.createStatement();
				
				 ResultSet rs1= st.executeQuery("SELECT * FROM disciplina WHERE nombre='"+nombre+"'");
				 if (rs1.next()==true) {
					 disciplina.setId(rs1.getInt(1)); 
					 disciplina.setNombre(rs1.getString(2));
				} 
				 rs1.close();
				 st.close();
				
					// con.close();
			 } 
			 catch (java.sql.SQLException e) {
				 System.out.println("Error de SQL: "+e.getMessage());
			 }
			 return disciplina;
		
	}


	public List<Disciplina> load(){
		 List<Disciplina> listaNombreDisciplina = new ArrayList<Disciplina>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM disciplina ");
			 while (rs.next()) {
				 Disciplina disciplina=new Disciplina();
				 disciplina.setNombre(rs.getString(2));
				 disciplina.setDeportista(0);
				 disciplina.setId(rs.getInt(1));
				 
				 listaNombreDisciplina.add(disciplina);
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listaNombreDisciplina;

	}
	
	public void delete(Disciplina nombre) {
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 //MIRAR EL && PUEDE SER QUE SEA "AND" POR ESTAR TRABAJANDO EN UN BBDD
			 ResultSet rs= st.executeQuery("DELETE a FROM deportista_en_disciplina WHERE (a.id_disciplina='"+nombre.getId()+"', && a.id_deportista='"+nombre.getDeportista()+"')");
			 
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
	
	public void save(Disciplina nombre) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 int rs= st.executeUpdate("INSERT INTO deportista(id_deportista, id_disciplina) VALUES (" + nombre.getDeportista() +", "+nombre.getId()+ ")");
			 
			
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
	
	public void update(Disciplina nombre) {
		this.delete(nombre);
		this.save(nombre); 
	}

}
