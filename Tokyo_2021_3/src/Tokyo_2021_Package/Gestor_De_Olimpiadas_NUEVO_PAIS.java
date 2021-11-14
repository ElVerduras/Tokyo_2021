package Tokyo_2021_Package;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gestor_De_Olimpiadas_NUEVO_PAIS {
	private static JLabel Label_Name; 
	 private static JTextField Text_Name;  
	 private static JButton Save;

		public static void create(JFrame frame) {		 		
		
		Label_Name = new JLabel("NOMBRE: ");
		Label_Name.setBounds(120,80,60,20);
		
		Text_Name  = new JTextField("",10); 
		Text_Name.setEditable(true);  
		Text_Name.setBounds(200,80,240,20);

        frame.getContentPane().add(Label_Name);
        frame.getContentPane().add(Text_Name);

        //BENINNG SAVE
		Save = new JButton("GUARDAR");
        frame.getContentPane().add(Save);
        Save.setBounds(220,140,120,20);
        //END SAVE
		//BEGINNING SET UP SAVE
	    Save.addActionListener( new ActionListener(){
        	@Override
 			 public void actionPerformed(ActionEvent e) {
        		//BEGINNING SET UP ACCION´S 
        		Pais p = new Pais();
        		PaisDAOjdbc p_ddbb = new PaisDAOjdbc();
        		
        		p.setNombre(Text_Name.getText());
        		
        		//MODIFICATION BBDD
        		p_ddbb.save(p);
        		
    	        //END  SET UP ACCION´S 
        		frame.dispose();
			 }
 		 }); 
        //END  SET UP SAVE
	    
	    
        
	 }

		public static void createWindow() {
			JFrame Window = new JFrame("Gestor de Olimpiadas");
			Window.setBounds(100, 100, 600, 300);
			Window.getContentPane().setLayout(null);
			create(Window);
			Window.setResizable(false);
			Window.setVisible(true);
		}
}
	