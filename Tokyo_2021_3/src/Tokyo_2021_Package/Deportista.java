package Tokyo_2021_Package;

public class Deportista{
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private int id_pais; 
	private int id_disciplina;
	
	public Deportista() {
		
	}
	
	public Deportista(String nombre, String apellido, String email, String telefono, int id_pais, int id_disciplina) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.id_pais = id_pais;
		this.id_disciplina = id_disciplina;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

 
	@Override
	public String toString() {
		return "(apellidos=" + apellido + ", nombres=" + nombre + ", email=" + email + ", telefono=" + telefono + ", id_pais=" + id_pais + ", id=" + id_disciplina+ ")";
	}
	
	
	
	
}
