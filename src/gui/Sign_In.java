/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.MySQL;
import model.Set_Font;


public class Sign_In extends javax.swing.JPanel {

    public static long USER_ID = 0;
    public static int USER_TYPE = 0;

    public Sign_In() {
        initComponents();
        Font f1 = Set_Font.setFont(37f, Set_Font.MEDIUM);
        Font f2 = Set_Font.setFont(14f, Set_Font.MEDIUM);
        Font f3 = Set_Font.setFont(12f, Set_Font.MEDIUM);
        jPasswordField1.setFont(f2);
        jTextField2.setFont(f2);
        jButton1.setFont(f3);
        jLabel1.setFont(f1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN IN");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo_4.png"))); // NOI18N

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(543, 543, 543)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(477, 477, 477)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 472, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void signUp() {
        String mobile = jTextField2.getText();
        String password = jPasswordField1.getText();

        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your mobile number", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.length() != 10) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("07[1245678][0-9]{7}+").matcher(mobile).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your password", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (password.length() <= 8) {
            JOptionPane.showMessageDialog(this, "Password must have to contain at lest 8 characters", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$").matcher(password).matches()) {
            JOptionPane.showMessageDialog(this, "password must have to contain at least one letter and one number", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet r = MySQL.search("SELECT * FROM `user` WHERE `mob`='" + mobile + "' AND `password`='" + password + "' AND `user_type_id`='1' AND `status_id`!='3';");
                if (r.next()) {
                    this.removeAll();
                    this.revalidate();
                    this.repaint();
                    this.setLayout(new CardLayout());
                    Home h = new Home();
                    this.add(h);
                    this.USER_ID = Long.parseLong(r.getString("user.id"));
                    this.USER_TYPE = Integer.parseInt(r.getString("user.user_type_id"));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid mobile number and password", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        signUp();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        String no = jTextField2.getText();
        String text = no + evt.getKeyChar();
        if (no.length() <= 10) {
            if (!Pattern.compile("0|07|07[1245678]|07[1245678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        if (evt.getKeyCode() == 10) {
            signUp();
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (evt.getKeyCode() == 10) {
            signUp();
        } else if (evt.getKeyCode() == 8) {
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
