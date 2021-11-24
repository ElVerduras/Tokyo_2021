package Tokyo_2021_Package;

import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.FlowLayout;

//import com.sun.tools.javac.util.List;

//import jdk.tools.jlink.internal.Jlink;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	
	/*
	private static JLabel Label_Country;
	static String[] Country_Str={ "Argentina","Bolivia","Peru" };
	static DefaultComboBoxModel<String> Country_model=new  DefaultComboBoxModel<String>(Country_Str);
	static JComboBox<String> Country = new JComboBox<String>(Country_model);
	*/

 	/*
 	private static JLabel Label_Discipline;
	static String[] Discipline_Str={ "Arquería","Gimnasia Artistica","Atletismo" };
	static DefaultComboBoxModel<String> Discipline_model=new  DefaultComboBoxModel<String>(Discipline_Str);
	static JComboBox<String> Discipline = new JComboBox<String>(Discipline_model);
 	*/
 	
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
			//COUNTRY	
				     
				    JLabel Label_Country;			    
				    List<Pais> lpais = FactoryDAO.getPaisDAO().load();
					String Country_Str[]=new String[lpais.size()];

				    for (int i = 0; i< lpais.size(); i++) {
				    	Country_Str[i] = lpais.get(i).getNombre(); 
				    }
				     DefaultComboBoxModel<String> Country_model=new  DefaultComboBoxModel<String>(Country_Str);
				     JComboBox<String> Country = new JComboBox<String>(Country_model);
					
					 Label_Country = new JLabel("PAÍS: ");
					 Label_Country.setBounds(100,160,60,20);
					 frame.getContentPane().add(Label_Country);	 
					 Country.setBounds(200,160,240,20);
					frame.getContentPane().add(Country);

			//DISCIPLINE
					JLabel Label_Discipline;

					 List<Disciplina> ldisciplina = FactoryDAO.getDisciplinaDAO().load();
					String Discipline_Str[]=new String[ldisciplina.size()];
					for (int i = 0; i< ldisciplina.size(); i++) {
						 Discipline_Str[i] = ldisciplina.get(i).getNombre(); 
					}
					DefaultComboBoxModel<String> Discipline_model=new  DefaultComboBoxModel<String>(Discipline_Str);
					JComboBox<String> Discipline = new JComboBox<String>(Discipline_model);
					
					
					Label_Discipline =new JLabel("DISCIPLINA:"); 
					Label_Discipline.setBounds(90,180,60,20);
					frame.getContentPane().add(Label_Discipline);
					Discipline.setBounds(200,180,240,20);
					frame.getContentPane().add(Discipline);

					
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
	        		Pais p = new Pais();
	        		Disciplina dis = new Disciplina();
	        		DisciplinaDAO dis_bbdd = FactoryDAO.getDisciplinaDAO();
	        		
	        		DeportistaDAO d_bbdd = FactoryDAO.getDeportistaDAO(); 
	        		d.setNombre(Text_Name.getText());
	        		d.setApellido(Text_Last_Name.getText());
	        		d.setEmail(Text_Email.getText());
	        		d.setTelefono(Text_Number_Phone.getText());
	        		d.setPais(Country.getSelectedIndex() + 1);
	        		
	        		//MODIFICATION BBDD
	        		d_bbdd.save(d);
	        		d = d_bbdd.find(d.getApellido());
	        		dis.setId(Discipline.getSelectedIndex() + 1);
	        		System.out.println(Discipline.getSelectedIndex() + 1);
	        		dis.setDeportista(d.getId());
	        		dis_bbdd.save(dis);
	        		
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