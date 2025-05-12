package swings;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {

    private Dashboard parent;
    public TableActionCellEditor(Dashboard parent) {
        super(new JCheckBox());
        this.parent = parent;
    }
    

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        int book_id = Integer.parseInt(table.getValueAt(row, 0).toString());
        System.out.println(String.valueOf(row));
        DeleteBtn deleteBtn = new DeleteBtn(parent, book_id);

        return deleteBtn;
    }

}
