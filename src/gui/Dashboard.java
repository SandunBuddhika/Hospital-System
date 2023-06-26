/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import com.raven.chart.ModelChart;
import static gui.Home.jLabel1;
import static gui.Home.jPanel3;
import java.awt.CardLayout;
import java.awt.Color;
import model.MySQL;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SANDUN BUDDHIKA
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat df = new DecimalFormat("0.00");

    public Dashboard() {
        initComponents();
    }
    HomeImage previous_Page;

    public Dashboard(HomeImage h) {
        initComponents();

        previous_Page = h;
        setUp();
    }

    public void setUp() {
        kGradientPanel1.setkStartColor(new Color(103, 21, 204));
        kGradientPanel1.setkGradientFocus(200);
        kGradientPanel1.setkEndColor(new Color(40, 112, 250));

        kGradientPanel2.setkStartColor(new Color(252, 79, 27));
        kGradientPanel2.setkGradientFocus(200);
        kGradientPanel2.setkEndColor(new Color(247, 181, 55));

        kGradientPanel3.setkStartColor(new Color(8, 177, 150));
        kGradientPanel3.setkGradientFocus(200);
        kGradientPanel3.setkEndColor(new Color(144, 199, 59));

        kGradientPanel4.setkStartColor(new Color(239, 16, 112));
        kGradientPanel4.setkGradientFocus(200);
        kGradientPanel4.setkEndColor(new Color(254, 100, 7));

        user();
        patient();
        attendence();
        appointment();
        profit();
        loadInvoice();
    }

    private void user() {
        try {
            ResultSet r = MySQL.search("SELECT * FROM `user`;");
            int a_user = 0;
            int all_user = 0;
            while (r.next()) {
                all_user += 1;
                if (r.getString("user.status_id").equals("1")) {
                    a_user += 1;
                }
            }

            if (all_user == 0 || a_user == 0) {
                jLabel3.setText("Available: " + a_user);
                jLabel4.setText("0% Woking");
                jProgressBar1.setValue(0);
            } else {
                int working_users = 100 / all_user * (a_user);
                jLabel3.setText("Available : " + a_user);
                jLabel4.setText(working_users + "% Woking");
                jProgressBar1.setValue(working_users);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void patient() {
        try {
            ResultSet r = MySQL.search("SELECT * FROM `patient` WHERE `date`='" + sdf.format(new Date()) + "';");
            int proccessing = 0;
            int discharge = 0;
            while (r.next()) {

                if (r.getString("patient.status_id").equals("4")) {
                    proccessing += 1;
                } else if (r.getString("patient.status_id").equals("5")) {
                    discharge += 1;
                }
            }
            if (proccessing == 0 || discharge == 0) {
                jLabel7.setText("All Patient: " + (proccessing + discharge));
                jLabel8.setText("0% Processing");
                jProgressBar2.setValue(0);
            } else {
                int proccessing_patien = 100 / (proccessing + discharge) * (proccessing);
                jLabel7.setText("All Patient: " + (proccessing + discharge));
                jLabel8.setText(proccessing_patien + "% Processing");
                jProgressBar2.setValue(proccessing_patien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void attendence() {
        try {
            ResultSet r = MySQL.search("SELECT * FROM `attendance` INNER JOIN `date` INNER JOIN `attendance_type` ON `attendance`.`date_id`=`date`.`id` AND `attendance`.`attendance_type_id`=`attendance_type`.`id` WHERE `date`.`date`='" + sdf.format(new Date()) + "'");
            int all_record = 0;
            int present = 0;
            while (r.next()) {
                all_record += 1;
                if (r.getString("attendance.attendance_type_id").equals("1")) {
                    present += 1;
                }
            }
            if (all_record == 0 || present == 0) {
                jLabel11.setText("All records: " + all_record);
                jLabel12.setText("0% Present");
                jProgressBar3.setValue(0);
            } else {
                int present_record = (100 / all_record) * (present);
                jLabel11.setText("All records: " + all_record);
                jLabel12.setText(present_record + "% Present");
                jProgressBar3.setValue(present_record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void appointment() {
        try {
            ResultSet r = MySQL.search("SELECT * FROM `appointment` LEFT JOIN `process` ON `process`.`appointment_id`=`appointment`.`id` WHERE `appointment`.`date`='" + sdf.format(new Date()) + "'");
            int all_record = 0;
            int not_proccess = 0;
            while (r.next()) {
                all_record += 1;
                if (r.getString("process.id") == null) {
                    not_proccess += 1;
                }
            }
            if (all_record == 0 || not_proccess == 0) {
                jLabel15.setText("All appointments: " + all_record);
                jLabel16.setText("0% processed");
                jProgressBar4.setValue(0);
            } else {
                int present_record = (100 / all_record) * (not_proccess);
                jLabel15.setText("All appointments: " + all_record);
                jLabel16.setText(present_record + "% processed");
                jProgressBar4.setValue(present_record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void profit() {
        HashMap hm = new HashMap();
        try {
            chart.start();
            chart.addLegend("Income", new Color(245, 189, 135));
            chart.addLegend("Expense", new Color(135, 189, 245));
            chart.addLegend("Profit", new Color(189, 135, 245));

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            int month = c.get(Calendar.MONTH);
            for (int i = (month - 1); i <= (month + 1); i++) {
                double income = 0;
                double expense = 0;
                double profit = 0;
                c.setTime(sdf.parse(c.get(Calendar.YEAR) + "-" + i + "-01"));
                Date datefr = sdf.parse(c.get(Calendar.YEAR) + "-" + i + "-01");
                Date dateto = sdf.parse(c.get(Calendar.YEAR) + "-" + i + "-" + c.getActualMaximum(Calendar.DAY_OF_MONTH));

                ResultSet r = MySQL.search("SELECT * FROM `invoice_payment` INNER JOIN `invoice` ON `invoice`.`id`=`invoice_payment`.`invoice_id` WHERE `invoice`.`date`>='" + (sdf.format(datefr) + " 00:00:00") + "' AND `invoice`.`date`<='" + (sdf.format(dateto) + " 00:00:00") + "';");
                while (r.next()) {
                    income += Double.parseDouble(r.getString("invoice_payment.payment"));
                }

                ResultSet r1 = MySQL.search("SELECT * FROM `grn_payment` INNER JOIN `grn` INNER JOIN `grn_item` INNER JOIN `company_profit` ON `grn`.`id`=`grn_payment`.`grn_id` AND `grn`.`id`=`grn_item`.`grn_id` AND `company_profit`.`id`=`grn_payment`.`company_profit_id` WHERE `grn`.`datetime`>='" + (sdf.format(datefr) + " 00:00:00") + "' AND `grn`.`datetime`<='" + (sdf.format(dateto) + " 00:00:00") + "';");
                while (r1.next()) {
                    expense += (Double.parseDouble(r1.getString("grn_payment.payment")) - Double.parseDouble(r1.getString("company_profit.profit")));
                }
                ResultSet r3 = MySQL.search("SELECT * FROM `pay_sheet` WHERE `pay_sheet`.`date`>='" + sdf.format(datefr) + "' AND `pay_sheet`.`date`<='" + sdf.format(dateto) + "';");
                while (r3.next()) {
                    expense += Double.parseDouble(r3.getString("pay_sheet.total"));
                }
                ResultSet r4 = MySQL.search("SELECT * FROM `vehicle_grn_payment` INNER JOIN `vehicle_grn` ON `vehicle_grn`.`id`=`vehicle_grn_payment`.`vehicle_grn_id`  WHERE `vehicle_grn`.`datetime`>='" + (sdf.format(datefr) + " 00:00:00") + "' AND `vehicle_grn`.`datetime`<='" + (sdf.format(dateto) + " 00:00:00") + "'");
                while (r3.next()) {
                    expense += Double.parseDouble(r3.getString("payment"));
                }

                ResultSet r2 = MySQL.search("SELECT * FROM `company_profit` INNER JOIN `invoice_payment` INNER JOIN `invoice` ON `invoice_payment`.`company_profit_id`=`company_profit`.`id` AND `invoice`.`id`=`invoice_payment`.`invoice_id` WHERE `invoice`.`date`>='" + (sdf.format(datefr) + " 00:00:00") + "' AND `invoice`.`date`<='" + (sdf.format(dateto) + " 00:00:00") + "';");
                while (r2.next()) {
                    profit += Double.parseDouble(r2.getString("profit"));
                    income += Double.parseDouble(r2.getString("profit"));
                }
                ResultSet r5 = MySQL.search("SELECT * FROM `company_profit` INNER JOIN `grn_payment` INNER JOIN `grn` ON `grn_payment`.`company_profit_id`=`company_profit`.`id` AND `grn`.`id`=`grn_payment`.`grn_id` WHERE `grn`.`datetime`>='" + (sdf.format(datefr) + " 00:00:00") + "' AND `grn`.`datetime`<='" + (sdf.format(dateto) + " 00:00:00") + "';");
                while (r5.next()) {
                    profit += Double.parseDouble(r5.getString("profit"));
                    income += Double.parseDouble(r5.getString("profit"));
                }
                ResultSet r6 = MySQL.search("SELECT * FROM `company_profit` INNER JOIN `pay_sheet` ON `company_profit`.`id` =`pay_sheet`.`company_profit_id`  WHERE `pay_sheet`.`date`>='" + sdf.format(datefr) + "' AND `pay_sheet`.`date`<='" + sdf.format(dateto) + "';");
                while (r6.next()) {
                    profit += Double.parseDouble(r6.getString("profit"));
                    income += Double.parseDouble(r6.getString("profit"));
                }
                chart.addData(new ModelChart(new SimpleDateFormat("MMM").format(datefr), new double[]{income, expense, profit}));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        chart = new com.raven.chart.Chart();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1036, 541));
        setMinimumSize(new java.awt.Dimension(1036, 541));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back_icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/users_group_icon.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Available : 61");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("50% Woking");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12))
        );

        jProgressBar2.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patient");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/patient.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Available : 61");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("50% Woking");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12))
        );

        jProgressBar3.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Attendance");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Attendance.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Available : 61");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("50% Woking");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12))
        );

        jProgressBar4.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Appointment");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Appointment.png"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Available : 61");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("50% Woking");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel47MouseClicked(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Attendace Management");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/attendance_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel39MouseClicked(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Patient_1.png"))); // NOI18N

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Patient Registration");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/medical-appointment.png"))); // NOI18N

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Appointment");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel40MouseClicked(evt);
            }
        });

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/process.png"))); // NOI18N

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Appointment Proccess");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel50MouseClicked(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/work-schedule.png"))); // NOI18N

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Shift Manager");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Datetime", "Payment", "Balance", "Fee", "Name", "IP", "Qty", "Patient name", "UserID", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (previous_Page != null) {
            Home.jButton2.setBackground(new Color(232, 232, 232, 0));
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page);
            Home.jLabel1.setText("Home");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel47MouseClicked
        Attendance_Management sm = new Attendance_Management(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(sm);
        Home.jLabel1.setText("Attendace Management");
    }//GEN-LAST:event_jPanel47MouseClicked

    private void jPanel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel39MouseClicked
        Patient_Registration pr = new Patient_Registration(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(pr);
        Home.jLabel1.setText("Patient Registration");
    }//GEN-LAST:event_jPanel39MouseClicked

    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked
        Appointment a = new Appointment(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(a);
        Home.jLabel1.setText("Appointment");
    }//GEN-LAST:event_jPanel48MouseClicked

    private void jPanel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseClicked
        Appointment_Process ap = new Appointment_Process(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(ap);
        Home.jLabel1.setText("Appointment Process");
    }//GEN-LAST:event_jPanel40MouseClicked

    private void jPanel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel50MouseClicked
        Shift_Manager sm = new Shift_Manager(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(sm);
        Home.jLabel1.setText("Shift Manager");
    }//GEN-LAST:event_jPanel50MouseClicked

    private void loadInvoice() {
        try {
            ResultSet data = MySQL.search("SELECT `invoice`.`id`,`stock`.`id`,`invoice`.`user_id`,`stock`.`selling_price`, `invoice`.`date`, `invoice_payment`.`payment`, `invoice_payment`.`balance`, `invoice_payment`.`fee`, `invoice_item`.`individual_pieces`, `invoice_item`.`qty`, `item`.`name`, `bill`.`id`, `bill_status`.`name`, `patient`.`f_name`, `patient`.`m_name`, `patient`.`l_name`, `patient`.`id` FROM `invoice` INNER JOIN `invoice_item` ON `invoice`.`id` = `invoice_item`.`invoice_id` INNER JOIN `invoice_payment` ON `invoice`.`id` = `invoice_payment`.`invoice_id` INNER JOIN `stock` ON `invoice_item`.`stock_id` = `stock`.`id` INNER JOIN `item` ON `stock`.`item_id` = `item`.`id` INNER JOIN `bill` ON `invoice`.`bill_id` = `bill`.`id` INNER JOIN `bill_status` ON `bill`.`bill_status_id` = `bill_status`.`id` INNER JOIN `appointment_bill` ON `bill`.`id` = `appointment_bill`.`bill_id` INNER JOIN `process` ON `appointment_bill`.`process_id` = `process`.`id` INNER JOIN `appointment` ON `process`.`appointment_id` = `appointment`.`id` INNER JOIN `patient` ON `appointment`.`patient_id` = `patient`.`id` INNER JOIN `company_profit` ON `invoice_payment`.`company_profit_id` = `company_profit`.`id` INNER JOIN `profit_type` ON `company_profit`.`profit_type_id` = `profit_type`.`id`;");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (data.next()) {
                Vector v = new Vector();

                v.add(data.getString("invoice.id"));
                v.add(data.getString("invoice.date"));
                v.add(data.getString("invoice_payment.payment"));
                v.add(data.getString("invoice_payment.balance"));
                v.add(data.getString("invoice_payment.fee"));

                v.add(data.getString("item.name"));
                v.add(data.getString("invoice_item.individual_pieces"));
                v.add(data.getString("invoice_item.qty"));
                if (data.getString("patient.m_name").equals("-")) {
                    if (!data.getString("patient.l_name").equals("-")) {
                        v.add(data.getString("patient.f_name") + " " + data.getString("patient.l_name"));
                    } else {
                        v.add(data.getString("patient.f_name"));
                    }
                } else {
                    if (!data.getString("patient.l_name").equals("-")) {
                        v.add(data.getString("patient.f_name") + " " + data.getString("patient.m_name") + " " + data.getString("patient.l_name"));
                    } else {
                        v.add(data.getString("patient.f_name") + " " + data.getString("patient.m_name"));
                    }
                }
                v.add(data.getString("invoice.user_id"));
                v.add(df.format(Double.parseDouble(data.getString("invoice_payment.payment")) - Double.parseDouble(data.getString("invoice_payment.balance"))));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    // End of variables declaration//GEN-END:variables
}
