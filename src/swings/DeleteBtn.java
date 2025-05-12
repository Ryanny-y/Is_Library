package swings;

import configuration.Conn;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteBtn extends JButton {

    private final Conn conDb = new Conn();

    private Dashboard parent;

    public DeleteBtn() {
        super("Delete");
        setFocusable(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorder(null);
        setBorderPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.decode("#ad0a10"));
    }

    public DeleteBtn(Dashboard parent, int book_id) {
        super("Delete");
        this.parent = parent;
        setFocusable(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorder(null);
        setBorderPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.decode("#ad0a10"));

        addActionListener((ActionEvent e) -> {
            String query = "DELETE FROM books WHERE id = ?";

            try (Connection con = conDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, book_id);

                pstmt.executeUpdate();
                parent.dispose();
                new Dashboard();
            } catch (SQLException ex) {
                Logger.getLogger(DeleteBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(Color.decode("#c9575b"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(Color.decode("#ad0a10"));
            }

        });
    }

}
