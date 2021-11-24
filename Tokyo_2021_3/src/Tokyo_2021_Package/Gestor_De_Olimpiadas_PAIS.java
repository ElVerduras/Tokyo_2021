package Tokyo_2021_Package;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gestor_De_Olimpiadas_PAIS {

	private static Container contentPane;

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
        String[] encabezado = {"","","",""};
	    

	    PaisDAO pais_bbdd = FactoryDAO.getPaisDAO();
	    List<Pais> listapais = FactoryDAO.getPaisDAO().load();
	    System.out.print(listapais.size());
	    Pais pais = new Pais();
	    Object pepe[][] = new Object[listapais.size()][4];
	   // Object[listapais.size()][4] pepe ;     //{"","","",""}
	    for (int i = 0; i< listapais.size(); i++) {
	    	   pepe[i][0] =listapais.get(i).getId(); 
	    	   pepe[i][1] =listapais.get(i).getNombre();
	    	   pepe[i][2] = "edit";
	    	   pepe[i][3] = "eliminar";
	    }
	    
	      // JTable datos a mostrar
	    	   
	       Container contentPane = frame.getContentPane();
	       tabla.getTableHeader().setReorderingAllowed(false);
	       tabla.setModel(new Modelo(pepe, encabezado));
	       tabla.getColumnModel().getColumn(0).setMaxWidth(10);;
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
			


