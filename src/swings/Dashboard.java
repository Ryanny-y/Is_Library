package swings;

import configuration.Conn;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableCellRenderer;

public class Dashboard extends javax.swing.JFrame {

    private final Conn conDb = new Conn();

    public Dashboard() {
        initComponents();

        setTitle("IS1A Library");
        getContentPane().setBackground(new Color(245, 245, 245));
        cardInit();
        bookInit();
        bookListTable1.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        bookListTable1.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(this));
        setVisible(true);
    }
    
    public void refetchBooks() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) bookListTable1.getModel();
        model.setRowCount(0);
        
        bookInit();
    }

    private void cardInit() {
        String query = "SELECT \n"
                + "    COUNT(*) AS total_books,\n"
                + "    COUNT(CASE WHEN status = 'available' THEN 1 END) AS available_books,\n"
                + "    COUNT(CASE WHEN status = 'pending' THEN 1 END) AS pending_books,\n"
                + "    COUNT(CASE WHEN status = 'borrowed' THEN 1 END) AS borrowed_books\n"
                + "FROM books;";

        try (Connection con = conDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int t_books = rs.getInt("total_books");
                int a_books = rs.getInt("available_books");
                int p_books = rs.getInt("pending_books");
                int b_books = rs.getInt("borrowed_books");

                total_books.setData(String.valueOf(t_books), "src/images/book.png", "Total Books");
                available_books.setData(String.valueOf(a_books), "src/images/available.png", "Available Books");
                pending_books.setData(String.valueOf(p_books), "src/images/pending.png", "Pending Books");
                borrowed_books.setData(String.valueOf(b_books), "src/images/borrow.png", "Borrowed Books");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void bookInit() {
        String query = "SELECT * FROM books";

        try (Connection con = conDb.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year_published = rs.getInt("year_published");
                String status = rs.getString("status");
                String created_at = rs.getString("created_at");

                bookListTable1.addRow(new Object[]{id, title, author, status, year_published, created_at});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        Summaries = new javax.swing.JPanel();
        total_books = new swings.SummaryCard();
        available_books = new swings.SummaryCard();
        pending_books = new swings.SummaryCard();
        borrowed_books = new swings.SummaryCard();
        jLabel2 = new javax.swing.JLabel();
        addBook_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookListTable1 = new swings.BookListTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(1000, 55));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Welcome Back, Admin!");

        logoutBtn.setBackground(new java.awt.Color(101, 45, 126));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.setBorder(null);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Summaries.setOpaque(false);
        Summaries.setLayout(new java.awt.GridLayout(1, 4, 10, 0));
        Summaries.add(total_books);
        Summaries.add(available_books);
        Summaries.add(pending_books);
        Summaries.add(borrowed_books);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(101, 45, 126));
        jLabel2.setText("Books List");

        addBook_btn.setBackground(new java.awt.Color(101, 45, 126));
        addBook_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBook_btn.setForeground(new java.awt.Color(255, 255, 255));
        addBook_btn.setText("Add Book");
        addBook_btn.setBorder(null);
        addBook_btn.setBorderPainted(false);
        addBook_btn.setFocusPainted(false);
        addBook_btn.setFocusable(false);
        addBook_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBook_btnActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        bookListTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        bookListTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Status", "Year Published", "Created At", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookListTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Summaries, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Summaries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPage();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addBook_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBook_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBook_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Summaries;
    private javax.swing.JButton addBook_btn;
    private swings.SummaryCard available_books;
    private swings.BookListTable bookListTable1;
    private swings.SummaryCard borrowed_books;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private swings.SummaryCard pending_books;
    private swings.SummaryCard total_books;
    // End of variables declaration//GEN-END:variables
}
