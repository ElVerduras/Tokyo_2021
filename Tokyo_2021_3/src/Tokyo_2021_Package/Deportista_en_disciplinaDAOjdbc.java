package Tokyo_2021_Package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


public class Deportista_en_disciplinaDAOjdbc implements Deportista_en_disciplinaDAO{
	
	public Deportista_en_disciplina find(int id_deportista) { 
		Deportista_en_disciplina deportistadisciplina=null;
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM deportista_en_disciplina WHERE id_deportista='"+id_deportista+"'");
			 if (rs.next()==true) {
				 deportistadisciplina = new Deportista_en_disciplina();
				 deportistadisciplina.setId_deportista(rs.getInt(1));
				 deportistadisciplina.setId_disciplina(rs.getInt(2));
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return deportistadisciplina;
	}
	
	
	public List<Deportista_en_disciplina> load(){
	
		 List<Deportista_en_disciplina> listadeportista = new ArrayList<Deportista_en_disciplina>();
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 ResultSet rs= st.executeQuery("SELECT * FROM deportista_en_disciplina");
			 while (rs.next()==true) {
				 Deportista_en_disciplina deportista_en_disciplina = new Deportista_en_disciplina();
				 deportista_en_disciplina.setId_deportista(rs.getInt(1));
				 deportista_en_disciplina.setId_disciplina(rs.getInt(2));

				 listadeportista.add(deportista_en_disciplina);
			 }
			 rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return listadeportista;
	
		
	}
	public Boolean delete(Deportista_en_disciplina d) {
		 int id_deportista=d.getId_deportista();
		int id_disciplina=d.getId_disciplina();

		 Boolean aux = false;
		 
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			  st.execute("DELETE FROM deportista_en_disciplina WHERE id_deportista='"+id_deportista+"' AND id_disciplina='"+id_disciplina+"'");
			 
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		System.out.println(aux);
		return aux;
	}


	public void save(Deportista_en_disciplina d) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 st.executeUpdate("INSERT INTO deportista_en_disciplina(id_deportista,id_disciplina) VALUES ('"+d.getId_deportista()+"','" +d.getId_disciplina()+"')");
			 
			// rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
	
	public void update(Deportista_en_disciplina d) {
		 try{
			 Connection con = MyConnection.getCon();
			 Statement st = con.createStatement();
			 
			 st.executeUpdate("UPDATE Deportista_en_disciplina SET id_deportista='" + d.getId_deportista() + "' ,id_disciplina='" + d.getId_disciplina() +"'  WHERE id_deportista='" + d.getId_deportista() + "'");
			 
			// rs.close();
			 st.close();
			// con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		
	}
 


 

}