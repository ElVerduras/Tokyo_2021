package Tokyo_2021_Package;

import java.util.List;

interface DisciplinaDAO {
	
	public String find(int id);
	
	public List<Disciplina> load();
	
	public void delete(Disciplina nombre);
	
	public void save(Disciplina nombre);

}
