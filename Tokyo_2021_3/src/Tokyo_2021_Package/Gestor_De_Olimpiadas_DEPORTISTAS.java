package Tokyo_2021_Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;  
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gestor_De_Olimpiadas_DEPORTISTAS {

	//private String[] Title_Table2 = {"Nombre y Apellido","País","Disciplina"};
	
	public static void create(JFrame frame) {
        //BUTTON NEW
		JButton Button_New = new JButton("NUEVO");
		Button_New.setBounds(160,20,100,50);
        Button_New.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_New.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_New);
			      //BEGINNING SET UP RETURN
			        Button_New.addActionListener( new ActionListener(){
			        	@Override
			 			 public void actionPerformed(ActionEvent e) {
			        		Gestor_De_Olimpiadas_NUEVO_DEPORTISTA.createWindow();
						 }
			 		 }); 
			        //END  SET UP RETURN
        //EXPORT CSV
        JButton Button_Export = new JButton("EXPORTAR CSV");
        Button_Export.setBounds(280,20,140,50);
        Button_Export.setVerticalTextPosition(SwingConstants.BOTTOM);
        Button_Export.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Export);
        //VOLVER
        JButton Button_Return = new JButton("VOLVER");
		Button_Return.setBounds(440,20,100,50);
		Button_Return.setVerticalTextPosition(SwingConstants.BOTTOM);
		Button_Return.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Button_Return); 
        Button_Return.addActionListener( new ActionListener(){
				        	@Override
				 			 public void actionPerformed(ActionEvent e) {
				        		//BEGINNING SET UP ACCION´S 
				        		//MODIFICATION BBDD
				    	        //END  SET UP ACCION´S 
				        		frame.dispose();
							 }
				 		 }); 
				        //END  SET UP RETURN
        //BARRA DE TITULO DEPORTISTAS
        JLabel Title_Table = new JLabel(" Deportistas ");
        Title_Table.setBounds(160,20,360,75);
        Title_Table.setVerticalTextPosition(SwingConstants.BOTTOM);
        Title_Table.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.getContentPane().add(Title_Table);
        //VISUALIZACION DE TABLA DEPORTISTAS
        
      //JTable estructura
	       JTable tabla = new JTable();
	       String[] encabezado = {"deportistas"};
	       String [] aCargar = new String[1];
	       DefaultTableModel modelo = new DefaultTableModel(encabezado, 0);
	       
	       //JTable datos a mostrar
	       /*List<Deportista> temporal = new DeportistaDAOjdbc().getListaDeportistas();
	       
	       for (int i = 0; i< temporal.size(); i++) {
	    	   aCargar[0] = temporal.get(i).getNombres();
	    	   System.out.println("Llegue hasta aca");
	    	   System.out.println(temporal.get(i).getApellido());
	    	   modelo.addRow(aCargar);
	    	   
	       }
	       tabla.setModel(modelo);
	       Container contentPane;
		//tabla.setBounds(15,120,500,160);
	       //this.getContentPane().add(new JScrollPane(tabla), BorderLayout.SOUTH );
	       //this.setVisible(true);
	       contentPane.add(new JScrollPane(tabla), BorderLayout.CENTER);
	       //contentPane.add(new JScrollPane(volver));
	       //contentPane.add(new JScrollPane(nuevo), BorderLayout.NORTH);
	       //contentPane.add(new JScrollPane(exportar), BorderLayout.NORTH);
	       this.pack();
	       this.setVisible(true);
	       */
	   }
	
	
	

	public String[] Listado(){
		String[] Cadena = null;
		 
	return Cadena;}
	
	public static void createWindow() {
		JFrame Window = new JFrame("Gestor de Olimpiadas - DEPORTISTAS ");
		Window.setBounds(100, 100, 700, 500);
		Window.getContentPane().setLayout(null);
		create(Window);
		Window.setResizable(false);
		Window.setVisible(true);
	}
}	
	


