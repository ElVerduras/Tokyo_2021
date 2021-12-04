package dao;

public class FactoryDAO {
	
	public static DeportistaDAO getDeportistaDAO() {
		return new DeportistaDAOjdbc();
	}
	
	public static DisciplinaDAO getDisciplinaDAO() {
		return new DisciplinaDAOjdbc();
	}
	
	public static PaisDAO getPaisDAO() {
		return new PaisDAOjdbc();
	}
	
	public static DeportistaEnDisciplinaDAO getDeportista_en_disciplinaDAO() {
		return new DeportistaEnDisciplinaDAOjdbc();
	}
	
}
