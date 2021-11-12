package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOjdbc implements DisciplinaDAO {
	
	public String find(String id) {
		 String nombreDisciplina = null;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select d from disciplina where d.id='"+id+"'");
			 if (rs.next()==true) {
				 nombreDisciplina = rs.getString(1);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return nombreDisciplina;
	}

	public List<String> load(){
		 String nombreDisciplina = null;
		 List<String> listaNombreDisciplina = new ArrayList<String>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * from pais ");
			 while (rs.next()==true) {
				 nombreDisciplina = rs.getString(1);

				 listaNombreDisciplina.add(nombreDisciplina);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listaNombreDisciplina;

	}
	
	public void delete(String nombre) {
		 
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
	
	public void save(String nombre) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("INSERT INTO disciplina(nombres) VALUES (" + nombre + ")");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}
