package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")
public class GestorDeOlimpiadas extends JFrame{
	public static void create(JFrame frame) {
		//Generation Buttons
		
		Icon Deportist_Icon = new ImageIcon(".\\athlete.png");
        JButton Button_Deportist = new JButton("Deportista");
        Button_Deportist.setBounds(20,20,120,75);
        Button_Deportist.setIcon(Deportist_Icon);
        Button_Deportist.setIconTextGap(2);
        Button_Deportist.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Deportist.setBackground(Color.WHITE);
        Button_Deportist.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Deportist);
        //BEGINNING SET UP RETURN
        Button_Deportist.addActionListener( new ActionListener(){
        	@Override
 			 public void actionPerformed(ActionEvent e) {
        		GestorDeOlimpiadasDeportista.createWindow();
			 }
 		 }); 
        //END  SET UP RETURN
        
		Icon Country_Icon = new ImageIcon(".\\Pais.png");
        JButton Button_Country = new JButton("Pais");
        Button_Country.setBounds(160,20,120,75);
        Button_Country.setIcon(Country_Icon);
        Button_Country.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Country.setHorizontalTextPosition(SwingConstants.CENTER);
        Button_Country.setBackground(Color.WHITE);
        //BEGINNING SET UP RETURN
        Button_Country.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorDeOlimpiadasPais.createWindow();
			}
		}); 
		//END  SET UP RETURN
        frame.getContentPane().add(Button_Country);
        

		Icon Discipline_Icon = new ImageIcon(".\\Disciplina.png");
        JButton Button_Discipline = new JButton("Disciplina");
        Button_Discipline.setBounds(300,20,120,75);
        Button_Discipline.setIcon(Discipline_Icon);
        Button_Discipline.setBackground(Color.WHITE);
        Button_Discipline.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Discipline.setHorizontalTextPosition(SwingConstants.CENTER);
        
        Button_Discipline.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorDeOlimpiadasDisciplinas.createWindow();
			}
		}); 
		//END  SET UP RETURN
        frame.getContentPane().add(Button_Discipline);    
       
        
        //BEGINNING BUTTONS_VOID

    	JButton Button1 = new JButton("Sin Definir");
        Button1 .setBounds(20,100,120,75);
        Button1 .setVerticalTextPosition(SwingConstants.BOTTOM);
        Button1 .setBackground(Color.WHITE);
        Button1 .setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button1);
  
        JButton Button2 = new JButton("Sin Definir");
        Button2 .setBounds(160,100,120,75); 
        Button2 .setVerticalTextPosition(SwingConstants.BOTTOM);
        Button2 .setHorizontalTextPosition(SwingConstants.CENTER);
        Button2 .setBackground(Color.WHITE);
        frame.getContentPane().add(Button2);

        JButton Button3 = new JButton("Sin Definir");
        Button3 .setBounds(300,100,120,75);
        Button3 .setBackground(Color.WHITE);
        Button3 .setVerticalTextPosition(SwingConstants.BOTTOM);
        Button3 .setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button3);    
        
        //END BUTTONS_VOID

        //CREATE SETTINGS
		Icon Settings_Icon = new ImageIcon(".\\config.png");
		JButton Settings_ = new JButton(Settings_Icon);
		Settings_.setBounds(460,10,30,30);
        frame.getContentPane().add(Settings_);
      //BEGINNING SET UP SETTINGS
        Settings_.addActionListener( new ActionListener(){
        	@Override
 			 public void actionPerformed(ActionEvent e) {
        		GestorDeOlimpiadasConfiguración.createWindow();
			 }
 		 }); 
        //END  SET UP SETTINGS
				
	}
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas");
		Window.setBounds(100, 100, 520, 300);
		Icon Icon_Wiew = new ImageIcon(".\\fondo.png");
		JLabel image=new JLabel(Icon_Wiew);
		Window.setContentPane(image);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}

	 
}

