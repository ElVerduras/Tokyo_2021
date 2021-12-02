package Tokyo_2021_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        
        
        
	    List<Deportista> listaDeportista = FactoryDAO.getDeportistaDAO().load();

	    Object pepe[][] = new Object[listaDeportista.size()][5];
        String[] encabezado = {"Apellido  Nombre","Disciplina","Pais","",""};
        	
	    //p.setNombre(p_ddbb.find(id_pais).getNombre());
        Deportista d = new Deportista();
        
        DeportistaDAO d_ddbb =FactoryDAO.getDeportistaDAO();
        Deportista_en_disciplinaDAOjdbc d_d_ddbb = new Deportista_en_disciplinaDAOjdbc();
	    DisciplinaDAO disciplina_bbdd = FactoryDAO.getDisciplinaDAO();
	    PaisDAO p_bbdd = FactoryDAO.getPaisDAO();

	    for (int i = 0; i< listaDeportista.size(); i++) {
	    	   pepe[i][0] = listaDeportista.get(i).getNombre()+" "+listaDeportista.get(i).getApellido();
	    	   int id_deportista=listaDeportista.get(i).getId_disciplina();
	    	   System.out.println("id_dep: "+id_deportista);
	    	   int id_disciplina=d_d_ddbb.find(id_deportista).getId_disciplina();
	    	   System.out.println("id_disc: "+id_disciplina);
	    	   String nombre=disciplina_bbdd.find(id_disciplina).getNombre();
	    			   //disciplina_bbdd.find(id_disciplina).getNombre();
	    	   System.out.println("nombre: "+nombre);
	    	   pepe[i][1]= nombre;
	    	   pepe[i][2] = p_bbdd.find(listaDeportista.get(i).getId_pais()).getNombre();
	    	   pepe[i][3] = "edit";
	    	   pepe[i][4] = "eliminar";   	   
	    }
	    	
	       DefaultTableModel model = new DefaultTableModel(pepe, encabezado);
	       JTable tabla = new JTable(model);
	       
	       Action editar = new AbstractAction(){
	    	   public void actionPerformed(ActionEvent e) {
		           
	    		   JTable tabla = (JTable)e.getSource(); 
	    		   int fila_editar = Integer.valueOf( e.getActionCommand() );  //pos de fila a borrar
	    		   
	    		   String disip_depor=(String) tabla.getValueAt (fila_editar, 1);  //almaceno el DISCIPLINA a borrar deportista
		            String pais=(String) tabla.getValueAt (fila_editar, 2);
		            String ape_nom=(String) tabla.getValueAt (fila_editar, 0);  //almaceno el NOMBRE Y APELLIDO a borrar deportista 
	    		   int i=0;        String nombre;           String apellido;
		            while(ape_nom.charAt(i) != ' ' ){   i++;  }
		            i++;
		            apellido=ape_nom.substring(i);
		            nombre=ape_nom.substring(0,i);
	    		   Deportista d=new Deportista();
	    		   Deportista d_aux=new Deportista();
	    		   d.setNombre(nombre); 	 d.setApellido(apellido);
	    		   d.setId_pais(p_bbdd.find(pais).getId()); 

	    		   d_aux=d_ddbb.find(d);
					

	    		   Gestor_De_Olimpiadas_Deportistas_EDIT.createWindow(d_aux);
	    		   //EDITA LA BASE DE DATOS
	    		   frame.dispose();
	    		   
	    	   }
	       };
		    ButtonColumn buttonColumn_edit = new ButtonColumn(tabla,editar,3);
		    buttonColumn_edit.setMnemonic(KeyEvent.VK_D);
	       
	       
	       Action eliminar = new AbstractAction(){
	       public void actionPerformed(ActionEvent e) {
	    	   JTable tabla = (JTable)e.getSource();
	    	   Confirmacion.createWindow(e,tabla);
	            /*
	            int modelRow = Integer.valueOf( e.getActionCommand() );  //pos de fila a borrar
	            String disip_depor=(String) tabla.getValueAt (modelRow, 1);  //almaceno el DISCIPLINA a borrar deportista
	            String pais=(String) tabla.getValueAt (modelRow, 2);
	            String ape_nom=(String) tabla.getValueAt (modelRow, 0);  //almaceno el NOMBRE Y APELLIDO a borrar deportista 

	            int i=0;                 String nombre;           String apellido;
	            while(ape_nom.charAt(i) != ' ' ){   i++;  }
	                
	            i++;
	            nombre=ape_nom.substring(0,i);
	            apellido= ape_nom.substring(i);
	            ((DefaultTableModel)tabla.getModel()).removeRow(modelRow);
	            //AGREGAR SENTENCIA DE DELETE
	            
	    		d.setNombre(nombre); 	 d.setApellido(apellido);
	    		d.setId_pais(p_bbdd.find(pais).getId()); 
	    		Deportista d_Aux=new Deportista();
	    		d_Aux=d_ddbb.find(d);
	            Deportista_en_disciplina dd = new Deportista_en_disciplina();
	            Deportista_en_disciplinaDAO dd_ddbb = FactoryDAO.getDeportista_en_disciplinaDAO();
 	            
	            Pais p = new Pais();
	            PaisDAO  p_ddbb =FactoryDAO.getPaisDAO();			   
			    
			    d.setId_disciplina(d_Aux.getId_disciplina());			
			    d.setId_pais(d_Aux.getId_pais());
			    dd.setId_deportista(d_Aux.getId_disciplina());   dd.setId_disciplina(dd_ddbb.find(d_Aux.getId_disciplina()).getId_disciplina());
			    dd_ddbb.delete(dd);
			    d_ddbb.delete(d);
			    if(dd_ddbb.load().size()==0) {
			     		p_ddbb.delete(p);
			    }
			    */
        				   	            
	       }
	    };
	     
	    ButtonColumn buttonColumn = new ButtonColumn(tabla, eliminar, 4);
	    buttonColumn.setMnemonic(KeyEvent.VK_D);
        
	      // JTable datos a mostrar
	    	   
	       
	       tabla.getTableHeader().setReorderingAllowed(false);
	       
	       JScrollPane scroll = new JScrollPane(tabla);
	       scroll.setBounds(15,120,600,265);
	       frame.getContentPane().add(scroll);
	       frame.setVisible(true);
	       
		}
	
 
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - DEPORTISTAS ");
		Window.setBounds(100, 100, 700, 500);
		Icon Icon_Wiew = new ImageIcon("C:\\Users\\diego\\OneDrive\\Escritorio\\facultad\\Taller de lenguaje 2\\ENTREGA FINAL\\fondoDepo.png");
		JLabel image=new JLabel(Icon_Wiew);
		Window.setContentPane(image);
		//Window.setBackground(Color.WHITE);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}
	


