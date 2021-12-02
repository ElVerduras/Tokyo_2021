	package Tokyo_2021_Package;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.io.IOException;
	import java.awt.*;  
	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;

	import java.util.ArrayList;
	import java.util.List;


public class Gestor_De_Olimpiadas_DISCIPLINAS {

		
		protected static final String[] Title_Table22 = null;
		public static void create(JFrame frame) {
			JButton Button_ret = new JButton("VOLVER");
			Button_ret.setBounds(30,210,100,30);
			Button_ret.setVerticalTextPosition(SwingConstants.BOTTOM);
			Button_ret.setHorizontalTextPosition(SwingConstants.CENTER);
	        frame.getContentPane().add(Button_ret);
				      //BEGINNING SET UP RETURN
	        Button_ret.addActionListener( new ActionListener(){
				        	@Override
				 			 public void actionPerformed(ActionEvent e) {
				        		frame.dispose();
							 }
				 		 }); 
	        
	        
		    List<Disciplina> listaDisciplina = FactoryDAO.getDisciplinaDAO().load();
		    Object pepe[][] = new Object[listaDisciplina.size()][2];
	        String[] encabezado = {"Id","Disciplina"};

		    for (int i = 0; i< listaDisciplina.size(); i++) {
		    	   pepe[i][0] = listaDisciplina.get(i).getId();
		    	   pepe[i][1] = listaDisciplina.get(i).getNombre();
		    	   
		    }

                DefaultTableModel model = new DefaultTableModel(pepe, encabezado);
		       JTable tabla = new JTable(model);
		       
		      // JTable datos a mostrar
		    	   
		       
		       Container contentPane = frame.getContentPane();
		       tabla.getTableHeader().setReorderingAllowed(false);
		       tabla.getColumnModel().getColumn(0).setMaxWidth(20);
		       tabla.getColumnModel().getColumn(1).setMaxWidth(150);
		       tabla.setBackground(Color.WHITE);
		       frame.setBackground(Color.WHITE);
		       JScrollPane scroll = new JScrollPane(tabla);
		       scroll.setBackground(Color.WHITE);
		       scroll.setBounds(15,15,140,183);
		       frame.getContentPane().add(scroll);
		       frame.setVisible(true);
		       
			}
		
		
		

		public String[] Listado(){
			String[] Cadena = null;
			 
		return Cadena;}
		public static void createWindow() {
			JFrame Window = new JFrame("Gestor de Olimpiadas - DISCIPLINAS ");
			Window.setBounds(100, 100, 185, 290);
			Icon Icon_Wiew = new ImageIcon("C:\\Users\\diego\\OneDrive\\Escritorio\\facultad\\Taller de lenguaje 2\\ENTREGA FINAL\\fondoDepo.png");
			JLabel image=new JLabel(Icon_Wiew);
			Window.setContentPane(image);
			//Window.setBackground(Color.WHITE);
			Window.getContentPane().setLayout(null);
			create(Window);
			Window.setResizable(false);
			Window.setVisible(true);
		}
	}
	

