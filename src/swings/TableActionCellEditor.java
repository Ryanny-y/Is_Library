
package swings;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {
    
    
    public TableActionCellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        String status = table.getValueAt(row, 3).toString();
        int book_id = Integer.parseInt(table.getValueAt(row, 0).toString());
        
        DeleteBtn deleteBtn = new DeleteBtn();
        
        return deleteBtn;
    }
    
}
