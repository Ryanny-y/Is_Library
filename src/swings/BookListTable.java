package swings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookListTable extends JTable {

    public BookListTable() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setShowVerticalLines(false);
        setRowHeight(40);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");

                if (column == 6 || column == 5) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }

                return header;
            }
        });

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 3) {
                    String strValue = value.toString();
                    JLabel label = new JLabel(strValue);
                    Color foreground = new Color(46, 204, 113);

                    if (strValue.equalsIgnoreCase("available")) {
                        foreground = new Color(46, 204, 113);
                    } else if (strValue.equalsIgnoreCase("pending")) {
                        foreground = new Color(214, 74, 4);
                    } else if (strValue.equalsIgnoreCase("borrowed")) {
                        foreground = new Color(196, 14, 17);
                    } else {
                        foreground = new Color(0xFFB200);
                    }

                    if (isSelected) {
                        label.setForeground(Color.decode("#652D7E"));
                        label.setFont(new Font("sansserif", 1, 12));
                    } else {
                        label.setForeground(foreground);
                    }

                    return label;
                } else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);

                    if (isSelected) {
                        com.setForeground(new Color(27, 76, 140));
                        com.setFont(new Font("sansserif", 1, 12));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                }
            }
        });
        
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

}
