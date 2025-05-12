
package swings;

import configuration.Conn;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UpdateBookStatus extends javax.swing.JFrame {

    private Conn conDb = new Conn();
    private int statusIndex = 0;
    private int book_id;
    
    private Dashboard dashboard;
    public UpdateBookStatus(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
        setTitle("Add New Book");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        book_title = new javax.swing.JLabel();
        status_comboBoxc = new javax.swing.JComboBox<>();
        update_btn = new javax.swing.JButton();
        findBook_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(101, 45, 126));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Book Status");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(101, 45, 126));
        jLabel2.setText("Book ID");

        id_field.setBackground(new java.awt.Color(240, 240, 240));
        id_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_field.setText("ID");
        id_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        id_field.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(101, 45, 126));
        jLabel3.setText("Status");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(101, 45, 126));
        jLabel5.setText("Book Title");

        book_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        book_title.setText("Sample Title");

        status_comboBoxc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "available", "pending", "borrowed" }));

        update_btn.setBackground(new java.awt.Color(101, 45, 126));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.setBorder(null);
        update_btn.setBorderPainted(false);
        update_btn.setFocusPainted(false);
        update_btn.setFocusable(false);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        findBook_btn.setBackground(new java.awt.Color(101, 45, 126));
        findBook_btn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        findBook_btn.setForeground(new java.awt.Color(255, 255, 255));
        findBook_btn.setText("Find Book");
        findBook_btn.setBorder(null);
        findBook_btn.setBorderPainted(false);
        findBook_btn.setFocusPainted(false);
        findBook_btn.setFocusable(false);
        findBook_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBook_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(status_comboBoxc, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(book_title, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(findBook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(book_title, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(id_field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(findBook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status_comboBoxc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed

        String query = "UPDATE books SET status = ? WHERE id = ?";
        String new_status = status_comboBoxc.getSelectedItem().toString();
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setString(1, new_status);
            pstmt.setInt(2, book_id);
            
            int result = pstmt.executeUpdate();
            if(result > 0) {
                JOptionPane.showMessageDialog(null, "Update Status Successfully", "Update Status", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                dashboard.dispose();
                new Dashboard();
                new UpdateBookStatus(dashboard);
            } else {
                JOptionPane.showMessageDialog(null, "Update Status Failed", "Update Status", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBookStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_update_btnActionPerformed

    private void findBook_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBook_btnActionPerformed
        // TODO add your handling code here:
        String book_idVal = id_field.getText();
        
        if(book_idVal.equals("ID") || book_idVal.isBlank()) {
            JOptionPane.showMessageDialog(null, "Invalid Id!", "invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String query = "SELECT * FROM books WHERE id = ?";
        
        try (Connection con = conDb.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)){
            pstmt.setInt(1, Integer.parseInt(book_idVal));
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String status = rs.getString("status");
                
                this.book_id = id;
                book_title.setText(title);
                
                switch (status) {
                    case "available":
                        this.statusIndex = 0;
                        break;
                    case "pending":
                        this.statusIndex = 1;
                        break;
                    case "borrowed":
                        this.statusIndex = 2;
                        break;
                }
                
                status_comboBoxc.setSelectedIndex(statusIndex);
            } else {
                JOptionPane.showMessageDialog(null, "Book ID: " + book_idVal + " Not Found!", "Book Not found.", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBookStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_findBook_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book_title;
    private javax.swing.JButton findBook_btn;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> status_comboBoxc;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
