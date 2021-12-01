package Tokyo_2021_Package;

import java.util.List;

interface DisciplinaDAO {
	
	public Disciplina find(int id);
	
	public Disciplina find(String nombre);
	
	public List<Disciplina> load();
	
	public void delete(Disciplina nombre);
	
	public void save(Disciplina nombre);
	
	public void update(Disciplina nombre);

}
