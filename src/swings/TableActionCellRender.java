package swings;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        DeleteBtn deleteBtn = new DeleteBtn();
        return deleteBtn;
    }
    
}
