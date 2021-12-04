package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

@SuppressWarnings("serial")
public class GestorDeOlimpiadasConfiguración extends Frame{
	 private static JLabel Label_User; 
	 private static JTextField Text_User;  
	 private static JLabel Label_Password;   
	 private static JTextField Text_Password ;  
	 private static JButton Return_;  
	 public  static String psw;
	 public static String usr;
 			public static void create(JFrame frame) {

			//DECLARATION USER
			Label_User = new JLabel("      USUARIO DB");
			Label_User.setBounds(20,20,100,27);
			Label_User.setVerticalTextPosition(SwingConstants.BOTTOM);
			Label_User.setHorizontalTextPosition(SwingConstants.CENTER);
	
			Text_User  = new JTextField("", 10); 
			Text_User.setBounds(115,20,140,25);
			Text_User.setEditable(true); 
			
	        frame.getContentPane().add(Label_User);
	        frame.getContentPane().add(Text_User);
			//DECLARATION PASSWORD
			Label_Password = new JLabel("PASSWORD DB"); 
			Label_Password.setBounds(20,40,100,47);
	
			Text_Password  = new JTextField("", 10); 
			Text_Password.setBounds(115,50,140,25);
	
			Text_Password.setEditable(true); 
	        frame.getContentPane().add(Label_Password);
	        frame.getContentPane().add(Text_Password);
	
	 
			//CREATE UP RETURN			
			Return_ = new JButton("VOLVER");
			Return_.setBounds(90,80,100,30);
	        frame.getContentPane().add(Return_);
			//BEGINNING SET UP RETURN
	        Return_.addActionListener( new ActionListener(){
	        	@Override
	 			 public void actionPerformed(ActionEvent e) {
	        		//BEGINNING SET UP ACCION´S 
	        		psw = Text_Password.getText();
	        		usr = Text_User.getText();
	        		//MODIFICATION BBDD
	    	        //END  SET UP ACCION´S 
	        		frame.dispose();
				 }
	 		 }); 
	        //END  SET UP RETURN
	     }
 
	
		public static void createWindow() {
			JFrame Window = new JFrame("Gestor de Olimpiadas - CONFIGURACIÓN ");
			Window.setBounds(100, 100, 300, 170);
			Icon Icon_Wiew = new ImageIcon("C:\\Users\\diego\\OneDrive\\Escritorio\\facultad\\Taller de lenguaje 2\\ENTREGA FINAL\\fondoconf.png");
			JLabel image=new JLabel(Icon_Wiew);
			Window.setContentPane(image);
			Window.getContentPane().setLayout(null);
			create(Window);
			Window.setResizable(false);
			Window.setVisible(true);
		}

		public static void main(String[] args) {
			createWindow();
		}	
	}	