package Tokyo_2021_Package;

import java.util.List;

interface PaisDAO {

	public Pais find(int id);
	
	public List<Pais> load();
	
	public void delete(Pais p);
	
	public void save(Pais p);
	
}
