package Tokyo_2021_Package;

public class deportista {
	String nombre;
	String apellido;
	String email;
	int telefono;
	String pais; //pais y disciplina hay que darles un tipo segun la base de datos
	String disciplina;
	
	
	public deportista(String nombre, String apellido, String email, int telefono, String pais, String disciplina) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.pais = pais;
		this.disciplina = disciplina;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
	@Override
	public String toString() {
		return "deportista [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono
				+ ", pais=" + pais + ", disciplina=" + disciplina + "]";
	}
	
	
	
}
