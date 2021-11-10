package Tokyo_2021_Package;
import javax.swing.*;

@SuppressWarnings("serial")
public class Gestor_De_Olimpiadas extends JFrame{
	
	
	public static void create(JFrame frame) {
		
		//Generation Buttons
		
		Icon Deportist_Icon = new ImageIcon("resources/athlete.png");
        JButton Button_Deportist = new JButton("Deportista");
        Button_Deportist.setBounds(20,20,120,75);
        Button_Deportist.setIcon(Deportist_Icon);
        Button_Deportist.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Deportist.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Deportist);
        

		Icon Country_Icon = new ImageIcon("resources/Pais.png");
        JButton Button_Country = new JButton("Pais");
        Button_Country.setBounds(160,20,120,75);
        Button_Country.setIcon(Country_Icon);
        Button_Country.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Country.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Country);

		Icon Discipline_Icon = new ImageIcon("resources/Disciplina.png");
        JButton Button_Discipline = new JButton("Disciplina");
        Button_Discipline.setBounds(300,20,120,75);
        Button_Discipline.setIcon(Discipline_Icon);
        Button_Discipline.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Discipline.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Discipline);          

		Icon Settings_Icon = new ImageIcon("resources/config.png");
		JButton Settings_ = new JButton(Settings_Icon);
		Settings_.setBounds(460,10,30,30);
        frame.getContentPane().add(Settings_);
				
	}
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas");
		Window.setBounds(100, 100, 520, 300);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
	
}

