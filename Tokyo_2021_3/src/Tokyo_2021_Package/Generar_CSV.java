package Tokyo_2021_Package;
import java.io.*;
import java.util.List;

public class Generar_CSV{


    public static void main(String[] args) throws IOException {

        List<Deportista> Deportist = FactoryDAO.getDeportistaDAO().load();
        Pais pais = new Pais();
        PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();


        FileWriter csvWriter = new FileWriter("/home/claudia/Documentos/salida.csv");
        //csvWriter.append("Nombre",",","Apellido",",","Pais",",","Disciplina");
        csvWriter.append("Nombre");           csvWriter.append(",");
        csvWriter.append("Apellido");        csvWriter.append(",");
        csvWriter.append("Pais");            csvWriter.append(",");
        csvWriter.append("Disciplina");
        csvWriter.append('\n');

        for (int i=0;i<Deportist.size();i++) {

             pais=pais_bbdd.find(Deportist.get(i).getPais());
            //csvWriter.append(dep.getNombre(),",",dep.getApellido(),",",dep.getPais(),",",dep.getDisciplina());
            csvWriter.append(dep.);       csvWriter.append(",");
            csvWriter.append(dep.getApellido());     csvWriter.append(",");
            csvWriter.append(dep.getPais()); 
            csvWriter.append(dep.getPais().      csvWriter.append(",");
            csvWriter.append(dep.getDisciplina());   csvWriter.append(",");
            csvWriter.append('\n');


        }
        csvWriter.close();

}
}