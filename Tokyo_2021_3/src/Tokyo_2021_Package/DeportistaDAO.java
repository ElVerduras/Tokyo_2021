package Tokyo_2021_Package;

import java.util.List;

interface DeportistaDAO {
	
	public Deportista find(String id);
	
	public List<Deportista> load();
	
	public void delete(Deportista d);
	
	public void save(Deportista d);
	
	public void update(Deportista d);

}
