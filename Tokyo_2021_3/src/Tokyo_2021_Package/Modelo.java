package Tokyo_2021_Package;


import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Modelo extends DefaultTableModel{

    public Modelo(final Object[][] datos, final String[] title) {
        super(datos, title);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(final int column) {
        return this.getValueAt(0, column).getClass();
    }

}
