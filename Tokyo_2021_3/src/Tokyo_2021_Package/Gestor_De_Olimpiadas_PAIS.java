package Tokyo_2021_Package;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
      //JTable estructura
	       JTable tabla = new JTable();
	       String[] encabezado = {"paises"};
	       String [] aCargar = new String[1];
	       DefaultTableModel modelo = new DefaultTableModel(encabezado, 0);
	       
	      //JTable datos a mostrar
	       //List<Pais> temporal = new PaisDAOjdbc().getListaDeportistas();
	      /* 
	       for (int i = 0; i< temporal.size(); i++) {
	    	   aCargar[0] = temporal.get(i).getNombres();
	    	   System.out.println("Llegue hasta aca");
	    	   System.out.println(temporal.get(i).getApellido());
	    	   modelo.addRow(aCargar);
	    	   
	       }
	       tabla.setModel(modelo);
	       Container contentPane;
		//tabla.setBounds(15,120,500,160);
	       //this.getContentPane().add(new JScrollPane(tabla), BorderLayout.SOUTH );
	       //this.setVisible(true);
	       contentPane.add(new JScrollPane(tabla), BorderLayout.CENTER);
	       this.pack();
	       this.setVisible(true);
	   }
			*/}
			

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
			


