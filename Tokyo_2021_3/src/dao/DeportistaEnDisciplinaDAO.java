package dao;

import java.util.List;

import model.DeportistaEnDisciplina;

public interface DeportistaEnDisciplinaDAO {

	public DeportistaEnDisciplina find(int id);

	public List<DeportistaEnDisciplina> load();

	public Boolean delete(DeportistaEnDisciplina d);

	public void save(DeportistaEnDisciplina d);

	public void update(DeportistaEnDisciplina d);

}
