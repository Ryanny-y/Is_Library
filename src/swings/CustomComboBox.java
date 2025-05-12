/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author RickJohn
 */
public class CustomComboBox extends JComboBox<Object> {

    public CustomComboBox() {
        super();

        addItem("Sort By Status");
        addItem("Available");
        addItem("Pending");
        addItem("Borrowed");
        setBorder(new EmptyBorder(0, 0, 0, 0));

        setFocusable(false);

        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton("\u25BC"); // Down arrow
                button.setBorder(null);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                return button;
            }
        });

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
                if (index == 0 || (index == -1 && getSelectedIndex() == 0)) {
                    label.setForeground(Color.GRAY);
                } else {
                    label.setForeground(Color.BLACK);
                }
                
                label.setBorder(new EmptyBorder(5, 10, 5, 10));
                label.setFont(new Font("Arial", Font.PLAIN, 14));
                return label;
            }
        });
    }
}
