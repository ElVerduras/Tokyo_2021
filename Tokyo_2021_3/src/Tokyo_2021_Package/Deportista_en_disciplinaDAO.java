package Tokyo_2021_Package;

import java.util.List;

interface Deportista_en_disciplinaDAO {

	public Deportista_en_disciplina find(int id);

	public List<Deportista_en_disciplina> load();

	public Boolean delete(Deportista_en_disciplina d);

	public void save(Deportista_en_disciplina d);

	public void update(Deportista_en_disciplina d);

}
