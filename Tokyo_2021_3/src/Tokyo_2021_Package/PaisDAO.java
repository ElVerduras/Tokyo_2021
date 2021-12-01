package Tokyo_2021_Package;

import java.util.List;

interface PaisDAO {

	public Pais find(int id);
	
	public Pais find(String id);
	
	public List<Pais> load();
	
	public Boolean delete(Pais p);
	
	public void save(Pais p);
	
	public void update(Pais p);
	
}
