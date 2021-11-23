package Tokyo_2021_Package;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gestor_De_Olimpiadas_PAIS {

	public static void create(JFrame frame) {
		 //BUTTON NEW
		JButton Button_New = new JButton("NUEVO");
		Button_New.setBounds(310,20,100,50);
		Button_New.setVerticalTextPosition(SwingConstants.BOTTOM);
	    Button_New.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.getContentPane().add(Button_New);
					//BEGINNING SET UP RETURN
					Button_New.addActionListener( new ActionListener(){
					        	@Override
					 			 public void actionPerformed(ActionEvent e) {
					        		Gestor_De_Olimpiadas_NUEVO_PAIS.createWindow();
								 }
					 		 }); 
		//END  SET UP RETURN
		
					
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
        
        
        JTable estructura;
	    JTable tabla = new JTable();
        String[] encabezado = {"Paisés"};
	    //String[] aCargar = new String[5];//[apellido][pais][disciplina][editar][eliminar]
	    Object[][] pepe = {{"h","h","h","h","h"}};
	    pepe[0][0] = "lolo";
	    System.out.println(pepe[0][0]);
	    
	    //DefaultTableModel modelo = new DefaultTableModel();
	    
	    PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
	    List<Pais> listapais = FactoryDAO.getPaisDAO().load();
	    Pais pais = new Pais();
	    for (int i = 0; i< listapais.size(); i++) {
	    	   pepe[1][i] =pais_bbdd.find(listapais.get(i).getId());	 
	    	   pepe[2][i] =pais_bbdd.find(listapais.get(i).getNombre());
	    	   pepe[3][i] = "edit";
	    	   pepe[4][i] = "eliminar"; 
	    }
	    
	             
	      // JTable datos a mostrar
	    	   
	       /*
	       tabla.setModel(new Modelo(pepe, encabezado));
	      // Container contentPane = frame.getContentPane();
	     //  tabla.getTableHeader().setReorderingAllowed(false);
	      // contentPane.setLayout(new BorderLayout());
	       tabla.setBounds(15,120,500,160);
	       JScrollPane scroll = new JScrollPane(tabla);
	       scroll.setBounds(15,120,600,160);
	       frame.getContentPane().add(scroll);
	     //  frame.setVisible(true);
	      // frame.getContentPane().add(tabla);
	      // contentPane.add(new JScrollPane(tabla), BorderLayout.CENTER);
	     //  frame.pack();
	       //frame.setVisible(true);
	     
			*/

			public String[] Listado(){
				String[] Cadena = null;
				 
			return Cadena;}
			
			public static void createWindow() {
				JFrame Window = new JFrame("Gestor de Olimpiadas - País ");
				Window.setBounds(100, 100, 700, 500);
				Window.getContentPane().setLayout(null);
				create(Window);
				Window.setResizable(false);
				Window.setVisible(true);
			}
		}	
			


