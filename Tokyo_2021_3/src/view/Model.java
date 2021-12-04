package view;


import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel{

    public Model(final Object[][] datos, final String[] title) {
        super(datos, title);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(final int column) {
        return this.getValueAt(0, column).getClass();
    }

}
