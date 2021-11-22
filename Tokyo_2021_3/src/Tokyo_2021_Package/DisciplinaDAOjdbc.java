package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOjdbc implements DisciplinaDAO {
	
	public String find(int id) {
		 String disciplina = null;
		// List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();

		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			
			 ResultSet rs1= st.executeQuery("Select * from deportista_en_disciplina where id_deportista='"+id+"'");
			 
			 if (rs1.next()==true) {
				 int id_disciplina = rs1.getInt(2);
				 ResultSet rs= st.executeQuery("Select * from disciplina where id='"+id_disciplina+"'");
				 if (rs.next()==true)
					 disciplina = rs.getString(2);
				 else System.out.println("Error de SQL: ");
					 
				 rs.close();

			 }
			 rs1.close();
			 st.close();
			
				// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return disciplina;
	}

	public List<Disciplina> load(){
		 Disciplina disciplina = null;
		 List<Disciplina> listaNombreDisciplina = new ArrayList<Disciplina>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("Select * disciplina ");
			 while (rs.next()==true) {
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
			 
			 ResultSet rs= st.executeQuery("Delete a from deportista_en_disciplina where (a.id_disciplina='"+nombre.getId()+"', && a.id_deportista='"+nombre.getDeportista()+"')");
			 
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
			 
			 int rs= st.executeUpdate("INSERT INTO deportista_en_disciplina(id_deportista, id_disciplina) VALUES (" + nombre.getDeportista() +", "+nombre.getId()+ ")");
			 
			
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}

}
