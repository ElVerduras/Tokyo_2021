package Tokyo_2021_Package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
 
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JTextField; 

public class Gestor_De_Olimpiadas_Deportistas_EDIT {
	private static JLabel Label_Name; 
	private static JTextField Text_Name;
	
	private static JLabel Label_Last_Name; 
	private static JTextField Text_Last_Name;

	private static JLabel Label_Email; 
	private static JTextField Text_Email;
	
	private static JLabel Label_Number_Phone; 
	private static JTextField Text_Number_Phone;
 	
	private static JLabel labelError;
	private static JLabel labelnotice;
	private static JButton Save;

	public static void create(JFrame frame,Deportista d) {
					//NOTICE
						labelnotice=new JLabel("");
						labelnotice.setBounds(10,10,600,20);
						frame.getContentPane().add(labelnotice);
						labelnotice.setVisible(true);
					//ERROR
						labelError = new JLabel("");
						labelError.setBounds(110,55,300,20);
						frame.getContentPane().add(labelError);
						labelError.setVisible(true);
					//NAME
						Label_Name = new JLabel("NOMBRE: ");
						Label_Name.setBounds(110,80,60,20);
						
						Text_Name  = new JTextField("",10); 
						Text_Name.setText(d.getNombre());
						Text_Name.setEditable(true);  
						Text_Name.setBounds(200,80,240,20);
					
					    frame.getContentPane().add(Label_Name);
					    frame.getContentPane().add(Text_Name);
				    //LAST NAME
					    Label_Last_Name = new JLabel("APELLIDO: ");
					    Label_Last_Name.setBounds(100,100,70,20);
						
					    Text_Last_Name  = new JTextField("",10); 
					    Text_Last_Name.setText(d.getApellido());
						Text_Last_Name.setEditable(true);  
						Text_Last_Name.setBounds(200,100,240,20);
					
					    frame.getContentPane().add(Label_Last_Name);
					    frame.getContentPane().add(Text_Last_Name);
				    //E-MAIL
					    Label_Email = new JLabel(" E-MAIL: ");
					    Label_Email.setBounds(115,120,60,20);
							
					    Text_Email  = new JTextField("",10);  
					    Text_Email.setText(d.getEmail());
					    Text_Email.setEditable(true);  
					    Text_Email.setBounds(200,120,240,20);
						
						    frame.getContentPane().add(Label_Email);
						    frame.getContentPane().add(Text_Email);
				    //NUMBER PHONE
						    Label_Number_Phone = new JLabel("TELEFONO: ");
						    Label_Number_Phone.setBounds(100,140,70,20);
							
						    Text_Number_Phone  = new JTextField("",10); 
						    Text_Number_Phone.setText(d.getTelefono());
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
							for (int i = 0; i< ldisciplina.size(); i++) {  Discipline_Str[i] = ldisciplina.get(i).getNombre();  }
							DefaultComboBoxModel<String> Discipline_model=new  DefaultComboBoxModel<String>(Discipline_Str);
							JComboBox<String> Discipline = new JComboBox<String>(Discipline_model);
							
							
							Label_Discipline =new JLabel("DISCIPLINA:"); 
							Label_Discipline.setBounds(90,180,60,20);
							frame.getContentPane().add(Label_Discipline);
							Discipline.setBounds(200,180,240,20);
							frame.getContentPane().add(Discipline);
							
							Deportista_en_disciplina d_d=new Deportista_en_disciplina();
			        		DisciplinaDAO dis_bbdd = FactoryDAO.getDisciplinaDAO();
			        		Deportista_en_disciplinaDAO d_d_ddbb=FactoryDAO.getDeportista_en_disciplinaDAO();
			 	            PaisDAO p_ddbb=FactoryDAO.getPaisDAO();
							String S_pais=p_ddbb.find(d.getId_pais()).getNombre();
			 	            String S_disciplina=dis_bbdd.find(d_d_ddbb.find( d.getId_disciplina()).getId_disciplina()).getNombre();
					 	    labelnotice.setText("Este deportista estaba registrado en pais y disciplina como: "+S_pais+" y "+S_disciplina);

							
				    //BENINNG SAVE
					Save = new JButton("GUARDAR");
				    frame.getContentPane().add(Save);
				    Save.setBounds(200,200,120,20);
				    //END SAVE
				  //BEGINNING SET UP SAVE
				    Save.addActionListener( new ActionListener(){
			        	@Override
			 			 public void actionPerformed(ActionEvent e) {
			        		if(revisarCampos(d.getNombre(),d.getApellido(),d.getEmail(),d.getTelefono(),S_pais,S_disciplina)  ) {
			        		DeportistaDAO d_bbdd = FactoryDAO.getDeportistaDAO(); 
			        		d.setNombre(Text_Name.getText());
			        		d.setApellido(Text_Last_Name.getText());
			        		d.setEmail(Text_Email.getText());
			        		d.setTelefono(Text_Number_Phone.getText());
			        		//accedo a la base de paises y me quedo con el id del pais seleccionado en el desplegable
			        		d.setId_pais(p_ddbb.find(Country.getSelectedItem().toString()).getId());
			        		//accedo a la base de disciplinas y me quedo con el id de la disciplina seleccionada en el desplegable
			 
			        		
			        		//MODIFICATION BBDD
			        		d_d.setId_deportista(dis_bbdd.find(d.getId_disciplina()).getId());
			        		d_d.setId_disciplina(dis_bbdd.find(Discipline.getSelectedItem().toString()).getId());
			        		d_d_ddbb.update(d_d); 
			        		d_bbdd.update(d);
			        		
			    	        //END  SET UP ACCION´S 
			        		frame.dispose();
			        		}
						 }
			 		 }); 
			        //END  SET UP SAVE
		}

				 
	private static boolean revisarCampos(String nombreD, String apellidoD, String emailD, String telefonoD,String pais,String disciplina) {
        boolean cumple=true;
        String texto = "";
        if((nombreD.equals("") || nombreD==null)||(apellidoD.equals("") || apellidoD==null)||(emailD.equals("") || emailD==null)||(telefonoD.equals("") || telefonoD==null)) {
            texto=texto.concat("<html>Todos los campos son obligatorios.<br></html>");
            cumple=false;
        }
        if(!nombreD.matches("^[a-zA-Z\\sñÑ]+")||!apellidoD.matches("^[a-zA-Z\\sñÑ]+")) {
            texto=texto.concat("<html>Nombre y apellido debe contener solo letras.<br></html>");
            cumple=false;
        }
        if (!emailD.matches("^(.+)@(.+)$")){
            texto=texto.concat("<html>El email debe contener una palabra seguido de @ y .</br></html>");
            cumple=false;
        }
        if (!telefonoD.matches("[0-9]+")) {
            texto=texto.concat("El telefono debe contener solo numeros");
            cumple=false;
        }
        labelError.setText(texto);
        return cumple;
    }
	
			
		public static void createWindow(Deportista d) {    
				JFrame Window = new JFrame("Gestor de Olimpiadas - País ");
				Window.setBounds(100, 100, 700, 500);
				Window.getContentPane().setLayout(null);
				create(Window,d);
				Window.setResizable(false);
				Window.setVisible(true);
		}

}
			


