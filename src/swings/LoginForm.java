package swings;

import configuration.Conn;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LoginForm extends javax.swing.JPanel {

    private final Conn conDb = new Conn();
    
    public LoginForm() {
        initComponents();
        setOpaque(false);
        
        emailListener(username_field, "Enter Your Username");
        password_field.setEchoChar((char) 0);
        passwordListener(password_field, "Enter Your Password");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton("Login");
        password_field = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(500, 500));
        setRequestFocusEnabled(false);

        Name.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Name.setForeground(new java.awt.Color(101, 45, 126));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("IS1A Library");

        greetings.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        greetings.setText("Welcome Back! Please login your account");

        username_field.setBackground(new java.awt.Color(240, 240, 240));
        username_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username_field.setForeground(new java.awt.Color(51, 51, 51));
        username_field.setText("Enter Your Username");
        username_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Password");

        LoginBtn.setBackground(new java.awt.Color(101, 45, 126));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.setBorder(null);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setFocusPainted(false);
        LoginBtn.setFocusable(false);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        password_field.setBackground(new java.awt.Color(240, 240, 240));
        password_field.setText("Enter Your Password");
        password_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        password_field.setPreferredSize(new java.awt.Dimension(123, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(greetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_field, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greetings)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        // TODO add your handling code here:
        String username = username_field.getText();
        String password = String.valueOf(password_field.getPassword());
        
        if(username.isBlank() || username.equals("Enter Your Username") || password.isBlank() || password.equals("Enter Your Password")) {
            JOptionPane.showMessageDialog(null, "Username and Password are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }     
        
        String query = "SELECT * FROM admin WHERE username = ? AND PASSWORD = ?";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                parentFrame.dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void emailListener(JTextField field, String text) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(field.getText().equals(text)) {
                    field.setText("");
                } 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(field.getText().isBlank()) {
                    field.setText(text);
                }
            }
        });
    }
    
    private void passwordListener(JTextField field, String text) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String pass = String.valueOf(password_field.getPassword()).trim();

                if (pass.equals(text)) {
                    password_field.setText(""); // Clear placeholder
                    password_field.setForeground(Color.BLACK);
                    password_field.setEchoChar('*'); // Enable password masking
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String pass = String.valueOf(password_field.getPassword()).trim();

                if (pass.isEmpty()) {
                    password_field.setText(text);
                    password_field.setForeground(Color.GRAY);
                    password_field.setEchoChar((char) 0); // Show text instead of *
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}