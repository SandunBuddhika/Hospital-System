/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Set_Font;

/**
 *
 * @author SANDUN BUDDHIKA
 */
public class Medicine_Expiration_Reminder extends javax.swing.JPanel {

    /**
     * Creates new form Product_registration
     */
    HomeImage previous_Page;

    public Medicine_Expiration_Reminder(HomeImage hi) {
        this.previous_Page = hi;
        initComponents();
        loadStock();
        jLabel13.setFont(Set_Font.setFont(16f, Set_Font.BOLD));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Medicine expiration reminder");

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back_icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remind Me Later");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_ID", "Name", "Type", "Category", "Stock_ID", "Measurement", "IP", "A-IP", "qty", "B_price", "S_price", "R_id", "MFD", "EXD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        goPreviousPage();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void goPreviousPage() {
        if (this.previous_Page != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page);
            Home.jLabel1.setText("Stock Management");

        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Please confirm your request", "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            for (int j = 0; j < jTable1.getRowCount(); j++) {
                MySQL.iud("UPDATE `stock` SET `stock_status_id`='3' WHERE `id`='" + jTable1.getValueAt(j, 4) + "';");
                JOptionPane.showMessageDialog(this, "Succussfully Removed", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                goPreviousPage();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        goPreviousPage();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void loadStock() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String date = "";
        try {
            date = sdf.format(sdf.parse(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 2) + "-" + c.get(Calendar.DAY_OF_MONTH)));
            ResultSet data = MySQL.search("SELECT DISTINCT `stock`.`id`,`item`.`id`,`measurement`,`stock`.`individual_pieces`,`stock`.`a_individual_pieces`,`stock`.`qty`,`grn_item`.`buying_price`,`stock`.`selling_price`,`stock`.`room_id`,`stock`.`MFD`,`stock`.`EXD`,`item_category`.`name`,`item_category_type`.`name`,`item`.`name`,`grn`.`datetime` FROM `stock` INNER JOIN `item` ON `stock`.`item_id` = `item`.`id` INNER JOIN `grn_item` ON `stock`.`id` = `grn_item`.`stock_id` INNER JOIN `grn` ON `grn_item`.`grn_id` =`grn`.`id` INNER JOIN `item_category` ON `item`.`item_category_id` = `item_category`.`id` INNER JOIN `item_category_type` ON `item`.`item_category_type_id` = `item_category_type`.`id` WHERE `stock`.`EXD`<='" + date + "' AND `stock`.`stock_status_id`!='3'  ORDER BY `stock`.`EXD` ASC;");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (data.next()) {
                Vector v = new Vector();
                v.add(data.getString("item.id"));
                v.add(data.getString("item.name"));
                v.add(data.getString("item_category_type.name"));
                v.add(data.getString("item_category.name"));
                v.add(data.getString("stock.id"));
                v.add(data.getString("stock.measurement"));
                v.add(data.getString("stock.individual_pieces"));
                v.add(data.getString("stock.a_individual_pieces"));
                v.add(data.getString("stock.qty"));
                v.add(data.getString("grn_item.buying_price"));
                v.add(data.getString("stock.selling_price"));
                v.add(data.getString("stock.room_id"));
                v.add(data.getString("stock.MFD"));
                v.add(data.getString("stock.EXD"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}