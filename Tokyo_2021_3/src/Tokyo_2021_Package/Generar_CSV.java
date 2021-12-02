package Tokyo_2021_Package;
import java.io.*;
import java.util.List;

public class Generar_CSV{

	

    public static void main(String[] args) throws IOException {
        List<Deportista> Deportist = FactoryDAO.getDeportistaDAO().load();
        PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
        DisciplinaDAO disciplina_bbdd = FactoryDAO.getDisciplinaDAO();
        Deportista dep=new Deportista();

        FileWriter csvWriter = new FileWriter("C:\\Users\\diego\\OneDrive\\Escritorio\\Deportistas2.csv");
        //csvWriter.append("Nombre",",","Apellido",",","Pais",",","Disciplina");
        csvWriter.append("Nombre");           csvWriter.append(",");
        csvWriter.append("Apellido");        csvWriter.append(",");
        csvWriter.append("Pais");            csvWriter.append(",");
        csvWriter.append("Disciplina");
        csvWriter.append('\n');

        for (int i=0;i<Deportist.size();i++) {
        	 dep=Deportist.get(i);
            //csvWriter.append(dep.getNombre(),",",dep.getApellido(),",",dep.getPais(),",",dep.getDisciplina());
            csvWriter.append(dep.getNombre());       csvWriter.append(",");
            csvWriter.append(dep.getApellido());     csvWriter.append(",");
            csvWriter.append(pais_bbdd.find(dep.getId_pais()).getNombre());		  csvWriter.append(",");    
            csvWriter.append((CharSequence) disciplina_bbdd.find(Deportist.get(i).getId_disciplina()).getNombre());
            csvWriter.append('\n');
        }
        csvWriter.close();

}

	

}