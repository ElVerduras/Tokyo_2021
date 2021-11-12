package Tokyo_2021_Package;

import java.util.List;

interface DisciplinaDAO {
	
	public String find(String id);
	
	public List<String> load();
	
	public void delete(String nombre);
	
	public void save(String nombre);

}
