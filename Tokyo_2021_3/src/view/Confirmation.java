package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.DeportistaDAO;
import dao.DeportistaEnDisciplinaDAO;
import dao.FactoryDAO;
import dao.PaisDAO;
import model.Deportista;
import model.DeportistaEnDisciplina;
import model.Pais;

public class Confirmation {

	public static void create(JFrame frame,ActionEvent E,JTable tabla) {
        //BUTTON NEW
		JButton Button_Confirmation = new JButton("DESEA BORRAR EL DEPORTISTA");
		Button_Confirmation.setBounds(10,10,240,50);
		Button_Confirmation.setVerticalTextPosition(SwingConstants.BOTTOM);
		Button_Confirmation.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Confirmation);
			      //BEGINNING SET UP RETURN
        Button_Confirmation.addActionListener( new ActionListener(){
			        	@Override
			 			 public void actionPerformed(ActionEvent e) {
	            int modelRow = Integer.valueOf(E.getActionCommand() );  //pos de fila a borrar
	            String pais=(String) tabla.getValueAt (modelRow, 2);
	            String ape_nom=(String) tabla.getValueAt (modelRow, 0);  //almaceno el NOMBRE Y APELLIDO a borrar deportista 

	            int i=0;                 String nombre;           String apellido;
	            while(ape_nom.charAt(i) != ' ' ){   i++;  }
	                
	            i++;
	            nombre=ape_nom.substring(0,i);
	            apellido= ape_nom.substring(i);
	            ((DefaultTableModel)tabla.getModel()).removeRow(modelRow);
	            //AGREGAR SENTENCIA DE DELETE
	    		
	            Deportista d_Aux=new Deportista();
	            Deportista d=new Deportista();

	            Pais p = new Pais();
	            PaisDAO  p_bbdd =FactoryDAO.getPaisDAO();		
	            DeportistaDAO  d_ddbb =FactoryDAO.getDeportistaDAO();		
	            
	    		d.setNombre(nombre); 	 d.setApellido(apellido);
	    		d.setId_pais(p_bbdd.find(pais).getId()); 
	    		d_Aux=d_ddbb.find(d);
	            DeportistaEnDisciplina dd = new DeportistaEnDisciplina();
	            DeportistaEnDisciplinaDAO dd_ddbb = FactoryDAO.getDeportista_en_disciplinaDAO();
 	            
	            	   
			    
			    d.setId_disciplina(d_Aux.getId_disciplina());			
			    d.setId_pais(d_Aux.getId_pais());
			    dd.setId_deportista(d_Aux.getId_disciplina());   dd.setId_disciplina(dd_ddbb.find(d_Aux.getId_disciplina()).getId_disciplina());
			    dd_ddbb.delete(dd);
			    d_ddbb.delete(d);
			    if(dd_ddbb.load().size()==0) {
			    	p_bbdd.delete(p);
			    }
			    frame.dispose();
        				   	            
	       }
	    });
	    
	       
		}
	
	
	
	
	public static void createWindow(ActionEvent E,JTable tabla) {
		JFrame Window = new JFrame("");
		Window.setBounds(520, 515, 280, 110);
		Icon Icon_Wiew = new ImageIcon("C:\\Users\\diego\\OneDrive\\Escritorio\\facultad\\Taller de lenguaje 2\\ENTREGA FINAL\\fondoDepo.png");
		JLabel image=new JLabel(Icon_Wiew);
		Window.setContentPane(image);
		//Window.setBackground(Color.WHITE);
		Window.getContentPane().setLayout(null);
		create(Window,E,tabla);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}
