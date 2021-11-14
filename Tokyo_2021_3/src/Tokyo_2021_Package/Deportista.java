package Tokyo_2021_Package;

public class Deportista{
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private int pais; 
	private int id;
	
	public Deportista() {
		
	}
	
	public Deportista(String nombre, String apellido, String email, String telefono, int pais, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.pais = pais;
		this.id = id;
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
	public int getPais() {
		return pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "'" + apellido + "', '" + nombre + "', '" + email + "', '" + telefono + "', '" + pais + "'";
	}
	
	
	
}
