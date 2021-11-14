package Tokyo_2021_Package;

import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

//import com.sun.tools.javac.util.List;

//import jdk.tools.jlink.internal.Jlink;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Gestor_De_Olimpiadas_NUEVO_DEPORTISTA {
	private static JLabel Label_Name; 
	private static JTextField Text_Name;
	
	private static JLabel Label_Last_Name; 
	private static JTextField Text_Last_Name;

	private static JLabel Label_Email; 
	private static JTextField Text_Email;
	
	private static JLabel Label_Number_Phone; 
	private static JTextField Text_Number_Phone;
	
	private static JLabel Label_Country;
	private static  JList<String> Country=new JList();
 	static String[] Country_Str;
	
	private static JLabel Label_Discipline; 
 	static JComboBox<String> Discipline;
 	static String[] Discipline_Str;
 	
 	private static DefaultListModel modelo = new DefaultListModel();
	private static JButton Save;

	public static void create(JFrame frame) {		 		
			//NAME
				Label_Name = new JLabel("NOMBRE: ");
				Label_Name.setBounds(110,80,60,20);
				
				Text_Name  = new JTextField("",10); 
				Text_Name.setEditable(true);  
				Text_Name.setBounds(200,80,240,20);
			
			    frame.getContentPane().add(Label_Name);
			    frame.getContentPane().add(Text_Name);
		    //LAST NAME
			    Label_Last_Name = new JLabel("APELLIDO: ");
			    Label_Last_Name.setBounds(100,100,70,20);
				
			    Text_Last_Name  = new JTextField("",10); 
				Text_Last_Name.setEditable(true);  
				Text_Last_Name.setBounds(200,100,240,20);
			
			    frame.getContentPane().add(Label_Last_Name);
			    frame.getContentPane().add(Text_Last_Name);
		    //E-MAIL
			    Label_Email = new JLabel(" E-MAIL: ");
			    Label_Email.setBounds(115,120,60,20);
					
			    Text_Email  = new JTextField("",10); 
			    Text_Email.setEditable(true);  
			    Text_Email.setBounds(200,120,240,20);
				
				    frame.getContentPane().add(Label_Email);
				    frame.getContentPane().add(Text_Email);
		    //NUMBER PHONE
				    Label_Number_Phone = new JLabel("TELEFONO: ");
				    Label_Number_Phone.setBounds(100,140,70,20);
					
				    Text_Number_Phone  = new JTextField("",10); 
				    Text_Number_Phone.setEditable(true);  
				    Text_Number_Phone.setBounds(200,140,240,20);
				
				    frame.getContentPane().add(Label_Number_Phone);
				    frame.getContentPane().add(Text_Number_Phone);
				    
					 Label_Country = new JLabel("PAÍS: ");
					 Label_Country.setBounds(100,160,60,20);
					 frame.getContentPane().add(Label_Country);
					 String[] ars={ "nombre1","apellidp","disciplina" };
					 for(String ar: ars) {
						modelo.addElement(ar);
					 }
					Country.setModel(modelo);
					Country.setVisibleRowCount(ars.length);
					Country.getSelectedValue();
					frame.getContentPane().add(Country);
					add(new JScrollPane(Country));
  						
					Label_Discipline =new JLabel("DISCIPLINA: "); 
					Label_Discipline.setBounds(100,180,60,20);
					frame.getContentPane().add(Label_Discipline);
 					 
		    //BENINNG SAVE
			Save = new JButton("GUARDAR");
		    frame.getContentPane().add(Save);
		    Save.setBounds(200,200,120,20);
		    //END SAVE
		  //BEGINNING SET UP SAVE
		    Save.addActionListener( new ActionListener(){
	        	@Override
	 			 public void actionPerformed(ActionEvent e) {
	        		//BEGINNING SET UP ACCION´S 
	        		Deportista d = new Deportista();
	        		DeportistaDAOjdbc d_bbdd = new DeportistaDAOjdbc(); 
	        		d.setNombre(Text_Name.getText());
	        		d.setApellido(Text_Last_Name.getText());
	        		d.setEmail(Text_Email.getText());
	        		d.setTelefono(Text_Number_Phone.getText());
	        		//Hay que agregar el desplegable de seleccion de pais
	        		int a = 1;
	        		d.setPais(a);
	        		//MODIFICATION BBDD
	        		d_bbdd.save(d);
	    	        //END  SET UP ACCION´S 
	        		frame.dispose();
				 }
	 		 }); 
	        //END  SET UP SAVE
}
 
	private static void add(JScrollPane jScrollPane) {
		// TODO Auto-generated method stub
		
	}

	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - NUEVO DEPORTISTA");
		Window.setBounds(100, 100, 520, 300);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}