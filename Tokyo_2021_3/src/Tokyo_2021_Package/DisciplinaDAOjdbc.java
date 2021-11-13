package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOjdbc implements DisciplinaDAO {
	
	public String find(int id) {
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

	public List<Disciplina> load(){
		 Disciplina disciplina = null;
		 ArrayList<Disciplina> listaNombreDisciplina = new ArrayList<Disciplina>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * disciplina ");
			 while (rs.next()==true) {
				 disciplina.setNombre(rs.getString(1));
				 disciplina.setDeportista(0);
				 disciplina.setId(rs.getInt(0));
				 
				 listaNombreDisciplina.add(disciplina);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listaNombreDisciplina;

	}
	
	public void delete(Disciplina nombre) {
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("Delete a from deportista_en_disciplina where (a.id_disciplina='"+nombre.getId()+"', && a.id_deportista='"+nombre.getDeportista()+"')");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
	
	public void save(Disciplina nombre) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 ResultSet rs= st.executeQuery("INSERT INTO deportista_en_disciplina(id_deportista,id_disciplina) VALUES (" + nombre.getDeportista() +", "+nombre.getId()+ ")");
			 
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}
