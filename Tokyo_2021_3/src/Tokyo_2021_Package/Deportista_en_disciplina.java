package Tokyo_2021_Package;

public class Deportista_en_disciplina {
	private int id_deportista; 
	private int id_disciplina;
	
	
public Deportista_en_disciplina() { }
	
	public Deportista_en_disciplina(int id_deportista, int id_disciplina) {
		super();
		this.id_disciplina = id_disciplina;
		this.id_deportista = id_deportista;
	}
	
	
	public int getId_deportista() {
		return id_deportista;
	}
	public void setId_deportista(int id_deportista) {
		this.id_deportista = id_deportista;
	}
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	
	@Override
	public String toString() {
		return "'" + id_deportista + "', '" + id_disciplina+"'";
	}
}
