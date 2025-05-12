package swings;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DeleteBtn extends JButton{
    
    public DeleteBtn() {
        super("Delete");
        setFocusable(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorder(null);
        setBorderPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.decode("#ad0a10"));
        
        addActionListener((ActionEvent e) -> {
            System.out.println("Clicked");
        });
    }
    
    
}
