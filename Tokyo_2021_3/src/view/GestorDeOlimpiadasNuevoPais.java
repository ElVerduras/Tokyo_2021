package view;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.PaisDAOjdbc;
import model.Pais;

public class GestorDeOlimpiadasNuevoPais {
	private static JLabel Label_Name; 
	 private static JTextField Text_Name;  
	 private static JButton Save;
	 private static JLabel labelError;
	 
		public static void create(JFrame frame) {		 		
		//ERROR
		labelError = new JLabel("");
		labelError.setBounds(120,50,240,24);
		frame.getContentPane().add(labelError);
		labelError.setVisible(true);
			
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
        		if( revisarCampos(Text_Name.getText()) ){
        		p.setNombre(Text_Name.getText());
        		
        		//MODIFICATION BBDD
        		p_ddbb.save(p);
        		
    	        //END  SET UP ACCION´S 
        		frame.dispose();
	    		GestorDeOlimpiadasPais.createWindow();
        		}
			 }
 		 }); 
        //END  SET UP SAVE        
	 }
		
		
		private static boolean revisarCampos(String nombreD) {
	        boolean cumple=true;
	        String texto = "";

	        if(!nombreD.matches("^[a-zA-Z\\sñÑ]+")){
	            texto=texto.concat("<html>Nombre y apellido debe contener solo letras.<br></html>");
	            cumple=false;
	        }
    		PaisDAOjdbc p_ddbb = new PaisDAOjdbc();
	        if ( p_ddbb.count(nombreD)!=0 ){
	            texto=texto.concat("<html>El país ya se encuentra registrado</br></html>");
	            cumple=false;
	        }
	        labelError.setText(texto);
	        return cumple;
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
	