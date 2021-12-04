package dao;

import java.util.List;

import model.Deportista;

public interface DeportistaDAO {
	
	public Deportista find(Deportista d);
	
	public Deportista find(String d);
	
	public List<Deportista> load();
	
	public Boolean delete(Deportista d);
	
	public void save(Deportista d);
	
	public void update(Deportista d);
	
	public int recuperar_max_id();

}
