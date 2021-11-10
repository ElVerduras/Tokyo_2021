package Tokyo_2021_Package;
import javax.swing.*;
import java.awt.*;  

@SuppressWarnings("serial")
public class Gestor_De_Olimpiadas_CONFIGURACIÓN extends Frame{
	 private static Label Label_User; 
	 private static TextField Text_User;  
	 private static Label Label_Password;   
	 private static TextField Text_Password ;  
	 private JButton Return;  
 	
	public Gestor_De_Olimpiadas_CONFIGURACIÓN() {
		
		setLayout(new FlowLayout());
		
		Label_User = new Label("USUARIO DB      ");
		Text_User  = new TextField("", 10); 
		Text_User.setEditable(true); 
		
		add(Label_User); 
		add(Text_User); 
		
		Label_Password = new Label("PASSWORD DB"); 
		Text_Password  = new TextField("", 10); 
		Text_Password.setEditable(true); 
		
		add(Label_Password); 
		add(Text_Password); 
		
		Return = new JButton("VOLVER");
		add(Return);
		setTitle(" Gestor De Olimpiadas - CONFIGURACIÓN ");
		setSize(250, 100);
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		Gestor_De_Olimpiadas_CONFIGURACIÓN Window_ = new Gestor_De_Olimpiadas_CONFIGURACIÓN();
	}
}



