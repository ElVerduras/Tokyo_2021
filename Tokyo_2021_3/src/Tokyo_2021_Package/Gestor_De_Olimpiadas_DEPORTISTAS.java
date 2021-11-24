package Tokyo_2021_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;  
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

public class Gestor_De_Olimpiadas_DEPORTISTAS {
	
	protected static final String[] Title_Table22 = null;
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
        Button_Export.addActionListener( new ActionListener(){
        			@Override
 			 		public void actionPerformed(ActionEvent e) { 
        					try {
								Generar_CSV.main(Title_Table22);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
        	}	
        }); 
		
			        
			        
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
        
        
        JTable estructura;
	    JTable tabla = new JTable();
	    
	    List<Deportista> listaDeportista = FactoryDAO.getDeportistaDAO().load();
	    PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
	    
	    DisciplinaDAO disciplina_bbdd = FactoryDAO.getDisciplinaDAO();
	    Pais pais = new Pais();
	    Object pepe[][] = new Object[listaDeportista.size()][5];
        String[] encabezado = {"","","","",""};

	    for (int i = 0; i< listaDeportista.size(); i++) {
	    	   pepe[i][0] = listaDeportista.get(i).getNombre()+" "+listaDeportista.get(i).getApellido();
	    	   pepe[i][1] = listaDeportista.get(i).getPais();
	    	   pepe[i][2] = disciplina_bbdd.find(listaDeportista.get(i).getId());
	    	   pepe[i][3] = "edit";
	    	   pepe[i][4] = "eliminar";
	    	   
	    }
		       
	      // JTable datos a mostrar
	    	   
	       
	       Container contentPane = frame.getContentPane();
	       tabla.getTableHeader().setReorderingAllowed(false);
	       
	       tabla.setModel(new Modelo(pepe, encabezado));
	       
	       JScrollPane scroll = new JScrollPane(tabla);
	       scroll.setBounds(15,120,600,265);
	       frame.getContentPane().add(scroll);
	       frame.setVisible(true);
	       
		}
	
	
	

	public String[] Listado(){
		String[] Cadena = null;
		 
	return Cadena;}
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - DEPORTISTAS ");
		Window.setBounds(100, 100, 700, 500);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}
	


