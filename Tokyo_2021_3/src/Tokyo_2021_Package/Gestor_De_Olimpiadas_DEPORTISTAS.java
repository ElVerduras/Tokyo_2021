package Tokyo_2021_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Gestor_De_Olimpiadas_DEPORTISTAS {
	private JTable Table = new JTable();
  	private JPanel Panel_Buttons = new JPanel();
	//private String[] Title_Table2 = {"Nombre y Apellido","País","Disciplina"};
	
	public static void create(JFrame frame) {
        //BUTTON NEW
		JButton Button_New = new JButton("NUEVO");
		Button_New.setBounds(160,20,100,50);
        Button_New.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_New.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_New);
			      //BEGINNING SET UP RETURN
			        Button_New.addActionListener( new ActionListener(){
			        	@Override
			 			 public void actionPerformed(ActionEvent e) {
			        		Gestor_De_Olimpiadas_NUEVO_DEPORTISTA.createWindow();
						 }
			 		 }); 
			        //END  SET UP RETURN
        //EXPORT CSV
        JButton Button_Export = new JButton("EXPORTAR CSV");
        Button_Export.setBounds(280,20,140,50);
        Button_Export.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Export.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Export);
        //VOLVER
        JButton Button_Return = new JButton("VOLVER");
		Button_Return.setBounds(440,20,100,50);
		Button_Return.setVerticalTextPosition(SwingConstants.BOTTOM);
		Button_Return.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Return); 
        Button_Return.addActionListener( new ActionListener(){
				        	@Override
				 			 public void actionPerformed(ActionEvent e) {
				        		//BEGINNING SET UP ACCION´S 
				        		//MODIFICATION BBDD
				    	        //END  SET UP ACCION´S 
				        		frame.dispose();
							 }
				 		 }); 
				        //END  SET UP RETURN
        
        
        //BARRA DE TITULO DEPORTISTAS
        JLabel Title_Table = new JLabel(" Deportistas ");
        Title_Table.setBounds(160,20,360,75);
        Title_Table.setVerticalTextPosition(SwingConstants.BOTTOM);
        Title_Table.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Title_Table);
        
        //VISUALIZACION DE TABLA DEPORTISTAS
        
        String[] encabezado = {"deportistas"};
	    String[] aCargar = new String[5];//[apellido][pais][disciplina][editar][eliminar]
	    
	    List<Deportista> listaDeportista = FactoryDAO.getDeportistaDAO().load();
	    PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
	    DisciplinaDAO disciplina_bbdd = FactoryDAO.getDisciplinaDAO();
	    Pais pais = new Pais();
	    for (int i = 0; i< listaDeportista.size(); i++) {
	    	   aCargar[0] = listaDeportista.get(i).getApellido();
	    	   System.out.println("Llegue hasta aca");
	    	   System.out.println(listaDeportista.get(i).getApellido());
	    	   pais = pais_bbdd.find(listaDeportista.get(i).getPais());
	    	   aCargar[1] = pais.getNombre();
	    	   System.out.println(pais.getNombre());
	    	   aCargar[2] = disciplina_bbdd.find(listaDeportista.get(i).getId());
	    	   System.out.println(aCargar[2]); 
	    	   
	    }
	}
	

	public String[] Listado(){
		String[] Cadena = null;
		 
	return Cadena;
	}
	
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - DEPORTISTAS ");
		Window.setBounds(100, 100, 700, 500);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}	
	


