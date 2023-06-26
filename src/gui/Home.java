/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.MySQL;
import model.Set_Font;

public class Home extends javax.swing.JPanel {

    HomeImage useing_Page;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Home() {
        initComponents();
        setUp();
        setDateTime();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String date = "";
        try {
            date = sdf.format(sdf.parse(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 2) + "-" + c.get(Calendar.DAY_OF_MONTH)));
            ResultSet data = MySQL.search("SELECT DISTINCT `stock`.`id`,`item`.`id`,`measurement`,`stock`.`individual_pieces`,`stock`.`a_individual_pieces`,`stock`.`qty`,`grn_item`.`buying_price`,`stock`.`selling_price`,`stock`.`room_id`,`stock`.`MFD`,`stock`.`EXD`,`item_category`.`name`,`item_category_type`.`name`,`item`.`name`,`grn`.`datetime` FROM `stock` INNER JOIN `item` ON `stock`.`item_id` = `item`.`id` INNER JOIN `grn_item` ON `stock`.`id` = `grn_item`.`stock_id` INNER JOIN `grn` ON `grn_item`.`grn_id` =`grn`.`id` INNER JOIN `item_category` ON `item`.`item_category_id` = `item_category`.`id` INNER JOIN `item_category_type` ON `item`.`item_category_type_id` = `item_category_type`.`id` WHERE `stock`.`EXD`<='" + date + "' AND `stock`.`stock_status_id`!='3'  ORDER BY `stock`.`EXD` ASC;");
            if (data.next()) {
                Medicine_Expiration_Reminder mer = new Medicine_Expiration_Reminder(useing_Page);
                Home.jPanel3.removeAll();
                Home.jPanel3.setLayout(new CardLayout());
                Home.jPanel3.revalidate();
                Home.jPanel3.repaint();
                Home.jPanel3.add(mer);
                Home.jLabel1.setText("Medicine Expiration Reminder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void setUp() {

        HomeImage hi = new HomeImage();
        useing_Page = hi;
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(hi);
        jLabel1.setText("Home");

        jPanel1.setkStartColor(new Color(242, 242, 242));
        jPanel1.setkGradientFocus(200);
        jPanel1.setkEndColor(new Color(220, 220, 220));
        Font f1 = Set_Font.setFont(20f, Set_Font.MEDIUM);
        Font f2 = Set_Font.setFont(12f, Set_Font.MEDIUM);
        Font f3 = Set_Font.setFont(19f, Set_Font.BOLD);
        jButton2.setFont(f1);
        jButton3.setFont(f1);
        jButton5.setFont(f1);
        jButton7.setFont(f1);
        jButton4.setFont(f1);
        jButton6.setFont(f1);
        jButton1.setFont(f1);
        jLabel1.setFont(f3);
        
        jLabel3.setFont(f2);
        jLabel4.setFont(f2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(242, 44, 29));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo_4.png"))); // NOI18N

        jButton1.setBackground(new Color(250, 250, 250, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Rooms");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new Color(250, 250, 250, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Dashboard");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new Color(250, 250, 250, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Staff");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new Color(250, 250, 250, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Patient");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new Color(250, 250, 250, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Salary Manager");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new Color(250, 250, 250, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Stock");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new Color(250, 250, 250, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Back");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel2.setMinimumSize(new java.awt.Dimension(1016, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(113, 100));

        jLabel1.setBackground(new java.awt.Color(242, 242, 242));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Home");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Moday 07/10/2022");

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("07:12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton3.setBackground(new Color(211, 211, 211, 0));
        jButton1.setBackground(new Color(211, 211, 211, 0));
        jButton5.setBackground(new Color(211, 211, 211, 0));
        jButton4.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 0));
        jButton2.setBackground(new Color(211, 211, 211, 250));
        Dashboard d = new Dashboard(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(d);
        jLabel1.setText("Dashboard");
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setDateTime() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE  MM/dd/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        Runnable r = () -> {
            while (true) {
                Date d = new Date();
                try {
                    jLabel3.setText(sdf1.format(d));
                    jLabel4.setText(sdf2.format(d));
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton1.setBackground(new Color(211, 211, 211, 0));
        jButton5.setBackground(new Color(211, 211, 211, 0));
        jButton4.setBackground(new Color(211, 211, 211, 0));
        jButton2.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 0));
        jButton3.setBackground(new Color(211, 211, 211, 250));
        Staff_Management sm = new Staff_Management(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(sm);
        jLabel1.setText("Staff Management");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton3.setBackground(new Color(211, 211, 211, 0));
        jButton1.setBackground(new Color(211, 211, 211, 0));
        jButton5.setBackground(new Color(211, 211, 211, 0));
        jButton4.setBackground(new Color(211, 211, 211, 0));
        jButton2.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 250));
        Stock_Management sm = new Stock_Management(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(sm);
        jLabel1.setText("Stock Management");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton3.setBackground(new Color(211, 211, 211, 0));
        jButton1.setBackground(new Color(211, 211, 211, 250));
        jButton5.setBackground(new Color(211, 211, 211, 0));
        jButton4.setBackground(new Color(211, 211, 211, 0));
        jButton2.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 0));
        Room_Registration rm = new Room_Registration(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(rm);
        jLabel1.setText("Room Management");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton3.setBackground(new Color(211, 211, 211, 0));
        jButton1.setBackground(new Color(211, 211, 211, 0));
        jButton5.setBackground(new Color(211, 211, 211, 250));
        jButton4.setBackground(new Color(211, 211, 211, 0));
        jButton2.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 0));
        Salary_Manager sm = new Salary_Manager(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(sm);
        jLabel1.setText("Salary Manager");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setBackground(new Color(211, 211, 211, 0));
        jButton1.setBackground(new Color(211, 211, 211, 0));
        jButton5.setBackground(new Color(211, 211, 211, 0));
        jButton4.setBackground(new Color(211, 211, 211, 250));
        jButton2.setBackground(new Color(211, 211, 211, 0));
        jButton6.setBackground(new Color(211, 211, 211, 0));
        Patient_Registration sm = new Patient_Registration(useing_Page);
        jPanel3.removeAll();
        jPanel3.setLayout(new CardLayout());
        jPanel3.revalidate();
        jPanel3.repaint();
        jPanel3.add(sm);
        jLabel1.setText("Patient Registration");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Sign_In.USER_ID = 0;
        Sign_In.USER_TYPE = 0;
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.setLayout(new CardLayout());
        Sign_In si = new Sign_In();
        this.add(si);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
