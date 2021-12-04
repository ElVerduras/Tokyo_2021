package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.FactoryDAO;
import dao.PaisDAOjdbc;
import model.Pais;

public class GestorDeOlimpiadasPais {

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
					        		frame.dispose();
					        		GestorDeOlimpiadasNuevoPais.createWindow();
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
        
        
        String[] encabezado = {"Id","País","",""};
	    

	    List<Pais> listapais = FactoryDAO.getPaisDAO().load();
	    Object pepe[][] = new Object[listapais.size()][4];
	   // Object[listapais.size()][4] pepe ;     //{"","","",""}
	    for (int i = 0; i< listapais.size(); i++) {
	    	   pepe[i][0] =listapais.get(i).getId(); 
	    	   pepe[i][1] =listapais.get(i).getNombre();
	    	   pepe[i][2] = "editar";
	    	   pepe[i][3] = "eliminar";
	    }
	    
	      // JTable datos a mostrar
	    
	       DefaultTableModel model = new DefaultTableModel(pepe, encabezado);
	       JTable tabla = new JTable(model);
	       Action editar = new AbstractAction(){
	    	   public void actionPerformed(ActionEvent e) {
		           JTable tabla = (JTable)e.getSource(); 
	    		   int fila_editar = Integer.valueOf( e.getActionCommand() );  //pos de fila a borrar
	               int id_pais=(int) tabla.getValueAt (fila_editar, 0);  
	               String nombre_pais=(String) tabla.getValueAt(fila_editar, 1);
	               Pais pais=new Pais();
	               pais.setId(id_pais);
	               pais.setNombre(nombre_pais);
	    		   GestorDeOlimpiadasPaisEdit.createWindow(pais);
	    		   //EDITA LA BASE DE DATOS
	    		   frame.dispose();
	    		   GestorDeOlimpiadasPais.createWindow();
	    	   }
	       };
		    ButtonColumn buttonColumn_edit = new ButtonColumn(tabla,editar,2);
		    buttonColumn_edit.setMnemonic(KeyEvent.VK_D);
	       
	       Action eliminar = new AbstractAction(){
	        public void actionPerformed(ActionEvent e) {
	            JTable tabla = (JTable)e.getSource();
	            int modelRow = Integer.valueOf( e.getActionCommand() );  //pos de fila a borrar
	            String nombre_pais=(String) tabla.getValueAt (modelRow, 1);  //almaceno el MOMBRE del pais a borrar  
	            int id_pais=(int) tabla.getValueAt (modelRow, 0);      //almaceno el ID del pais a borrar   
	            ((DefaultTableModel)tabla.getModel()).removeRow(modelRow);
	            //AGREGAR SENTENCIA DE DELETE
	            Pais p = new Pais();
        		PaisDAOjdbc p_ddbb = new PaisDAOjdbc();
        		p.setId(id_pais); 	
        		p.setNombre(nombre_pais); 
        			
            	if(p_ddbb.count(p.getId())>0){
        				    String cmd = e.getActionCommand();
                		    JOptionPane.showMessageDialog(frame, "el pais registrado bajo el id_pais: " + cmd + " ,no se pudo eliminar,pruebe eliminando los deportistas ");
        		}
            	else {
            			String cmd = e.getActionCommand();
            		    JOptionPane.showMessageDialog(frame, "el pais registrado bajo el id_pais: " + cmd + " , se pudo eliminar");
            		    p_ddbb.delete(p);
            	}
            	frame.dispose();
            	GestorDeOlimpiadasPais.createWindow();
            	
        		}
	    };
	     
	    ButtonColumn buttonColumn_delete = new ButtonColumn(tabla, eliminar,3);
	    buttonColumn_delete.setMnemonic(KeyEvent.VK_D);
	    	   
	       tabla.getTableHeader().setReorderingAllowed(false);
	       tabla.getColumnModel().getColumn(0).setMaxWidth(20);
	       tabla.setBackground(Color.WHITE);
	       frame.setBackground(Color.WHITE);
	       JScrollPane scroll = new JScrollPane(tabla);
	       scroll.setBounds(15,120,600,300);
	       frame.getContentPane().add(scroll);
	       frame.setVisible(true);

		}		 
			
		public static void createWindow() {
				JFrame Window = new JFrame("Gestor de Olimpiadas - País ");
				Window.setBounds(100, 100, 700, 500);
				Window.getContentPane().setLayout(null);
				create(Window);
				Window.setResizable(false);
				Window.setVisible(true);
		}

}
			


