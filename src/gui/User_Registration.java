/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.Set_Font;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author SANDUN BUDDHIKA
 */
public class User_Registration extends javax.swing.JPanel {

    /**
     * Creates new form User_Registration
     */
    Staff_Management previous_Page;
    Employee_Manager previous_Page2;
    Driver_Manager previous_Page3;
    Attendance_Management previous_Page4;
    Appointment previous_Page5;
    Item_Invoice_Manager previous_Page6;
    Shift_Manager previous_Page7;
    Salary_Manager previous_Page8;
    String isDriver_manager = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public User_Registration() {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
    }

    public User_Registration(Staff_Management jp) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page = jp;
    }

    public User_Registration(Employee_Manager jp) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page2 = jp;
    }

    public User_Registration(Attendance_Management am) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page4 = am;
    }

    public User_Registration(Driver_Manager jp, int i) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page3 = jp;
        if (i == 0) {
            jComboBox2.setSelectedItem("Drivers");
            jComboBox2.setEnabled(false);
        } else if (i == 1) {
            jComboBox2.setSelectedItem("Paramedics");
            jComboBox2.setEnabled(false);
        }
        loadUsers();
    }

    public User_Registration(Appointment a) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page5 = a;
        jComboBox2.setSelectedItem("Doctor");
        loadUsers();
    }

    User_Registration(Item_Invoice_Manager ivm) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page6 = ivm;
    }

    User_Registration(Shift_Manager sm) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page7 = sm;
    }

    User_Registration(Salary_Manager sm) {
        initComponents();
        loadGender();
        loadUserType();
        loadPasse();
        loadStatusType();
        loadCity();
        loadUsers();
        setUp();
        jDateChooser2.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton2.setEnabled(false);
        previous_Page8 = sm;
    }

    private void setUp() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField7 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("First Name");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel3.setText("Middle Name ");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel4.setText("Last Name");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel5.setText("Surname");

        jLabel6.setText("Mobile no");

        jLabel7.setText("Image");

        jLabel8.setText("Gender");

        jLabel9.setText("DOB");

        jLabel10.setText("User Type");

        jLabel11.setText("Passe");

        jLabel12.setText("Room");

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jButton3.setText("Select");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jButton4.setText("Select");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setText("Password");

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jLabel15.setText("Status Type");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel16.setText("AD_line 1");

        jLabel17.setText("AD_line 2");

        jLabel18.setText("City");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Add");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setText("Search");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "MOB", "Password", "Gender", "DOB", "Type", "Passe", "Room", "Status", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
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

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TO");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel21.setText("ID");

        jLabel20.setText("Sort by:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User ID ASC", "User ID DESC", "First Name ASC", "First Name DESC", "Middle Name ASC", "Middle Name DESC", "Last Name ASC", "Last Name DESC", "Mobile ASC", "Mobile DESC", "DOB ASC", "DOB DESC" }));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 158, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(185, 185, 185))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(jTextField13)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("User Info");

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back_icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(247, 247, 247))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents
    File f = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fname = jTextField1.getText();
        String mname = jTextField2.getText();
        String lname = jTextField3.getText();
        String surname = jTextField4.getText();
        String mob = jTextField12.getText();
        String line1 = jTextField5.getText();
        String line2 = jTextField6.getText();
        File image = f;
        String password = jTextField13.getText();
        String gender = jComboBox1.getSelectedItem().toString();
        String userType = jComboBox2.getSelectedItem().toString();
        String status = jComboBox3.getSelectedItem().toString();
        String passe = jComboBox4.getSelectedItem().toString();
        String city = jComboBox5.getSelectedItem().toString();
        String roomId = jLabel1.getText();
        Date date = null;
        if (jDateChooser1.getDate() != null) {
            date = jDateChooser1.getDate();
        }
        if (Sign_In.USER_TYPE == 0) {
            JOptionPane.showMessageDialog(this, "You don't have a permission to add a user", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else 
        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your first name", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (mname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your middle name", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your last name", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (surname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your surname", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (mob.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your mobile numder", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (mob.length() != 10) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number1", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("07[1245678][0-9]{7}+").matcher(mob).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number2", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (image == null) {
            JOptionPane.showMessageDialog(this, "Please select a image (The size must have to be 2x2)", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a gender", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your password", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (!Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$").matcher(password).matches()) {
            JOptionPane.showMessageDialog(this, "password must have to contain at least one letter and one number", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (userType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a type", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (passe.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a passe", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (status.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a status", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (roomId.equals("Name")) {
            JOptionPane.showMessageDialog(this, "Please select a room", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (line1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address line 1", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (line2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address line 2", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a city", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (date == null) {
            JOptionPane.showMessageDialog(this, "Please select a date", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            InputStream is = null;
            OutputStream os = null;
            try {

                long userId = System.currentTimeMillis() + Sign_In.USER_ID;
                long addressId = Sign_In.USER_ID + System.currentTimeMillis();

                String newdate = sdf.format(date);

                String tdate = sdf.format(new Date());
                String filename = System.currentTimeMillis() + Sign_In.USER_ID + "." + f.getPath().substring(f.getPath().lastIndexOf("."));
                String filefullname = "src//resources//images//" + filename;

                //I have to fix the Room selector
                MySQL.iud("INSERT INTO `user` (`id`,`user`.`surname`,`user`.`f_name`,`user`.`m_name`,`user`.`l_name`,`user`.`img`,`user`.`mob`,`user`.`password`,`user`.`gender_id`,`user`.`dob`,`user`.`user_type_id`,`user`.`passe_id`,`user`.`status_id`,`user`.`room_id`,`user`.`date`) VALUES ('" + userId + "','" + surname + "','" + fname + "','" + mname + "','" + lname + "','" + filename + "','" + mob + "','" + password + "',(SELECT `id` FROM `gender` WHERE `name`='" + gender + "'),'" + newdate + "',(SELECT `id` FROM `user_type` WHERE `name`='" + userType + "'),(SELECT `id` FROM `passe` WHERE `name`='" + passe + "'),(SELECT `id` FROM `status` WHERE `name`='" + status + "'),'1','" + tdate + "');");

                MySQL.iud("INSERT INTO `address` (`id`,`line_1`,`line_2`,`location_id`) VALUES ('" + addressId + "','" + line1 + "','" + line2 + "',(SELECT `id` FROM `location` WHERE `city_id`=(SELECT `id` FROM `city` WHERE `name`='" + city + "')));");
                MySQL.iud("INSERT INTO `user_has_address`  (`user_id`,`address_id`) VALUES ('" + userId + "','" + addressId + "');");

                File dest = new File(filefullname);
                Files.copy(f.toPath(), dest.toPath());

                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField12.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jButton3.setEnabled(true);
                jTextField13.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);
                jComboBox4.setSelectedIndex(0);
                jComboBox5.setSelectedIndex(0);
                roomId = "";
                jDateChooser1.setDate(null);
                jTextField1.grabFocus();
                loadUsers();
                JOptionPane.showMessageDialog(this, "New user successfully added to the system", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                f = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        if (fc.getSelectedFile() == null) {
            JOptionPane.showMessageDialog(this, "Please try again", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            f = fc.getSelectedFile();
            Window parentWindow = SwingUtilities.windowForComponent(this);
            Frame parentFrame = null;
            if (parentWindow instanceof Frame) {
                parentFrame = (Frame) parentWindow;
            }
            Show_image a = new Show_image(parentFrame, true, f.getPath());
            a.setVisible(true);
            jLabel7.setEnabled(false);
            jButton3.setEnabled(false);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        String no = jTextField12.getText();
        String text = no + evt.getKeyChar();
        if (no.length() <= 9) {
            if (!Pattern.compile("0|07|07[1245678]|07[1245678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField12KeyTyped

    public void loadUsers() {
        try {
            String q = "";
            if (jComboBox2.getSelectedItem().toString().equals("Drivers")) {
                q = "WHERE `user_type`.`id`='2'";

            } else if (jComboBox2.getSelectedItem().toString().equals("Paramedics")) {
                q = "WHERE `user_type`.`id`='3'";
            } else if (jComboBox2.getSelectedItem().toString().equals("Doctor")) {
                q = "WHERE `user_type`.`id`='4'";
            }
            ResultSet data = MySQL.search("SELECT * FROM `user` INNER JOIN `gender` INNER JOIN `user_type` INNER JOIN `passe` INNER JOIN `room` INNER JOIN `status` ON `user`.`gender_id`=`gender`.`id` AND `user`.`user_type_id`=`user_type`.`id` AND `user`.`passe_id`=`passe`.`id` AND `user`.`room_id`=`room`.`id` AND `user`.`status_id`=`status`.`id` " + q + " ;");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (data.next()) {
                Vector v = new Vector();

                v.add(data.getString("user.id"));

                if (data.getString("user.m_name").equals("-")) {
                    v.add(data.getString("user.f_name") + " " + data.getString("user.l_name"));
                } else {
                    v.add(data.getString("user.f_name") + " " + data.getString("user.m_name") + " " + data.getString("user.l_name"));
                }
                v.add(data.getString("user.mob"));
                v.add(data.getString("user.password"));
                v.add(data.getString("gender.name"));
                v.add(data.getString("user.dob"));
                v.add(data.getString("user_type.name"));
                v.add(data.getString("passe.name"));
                v.add(data.getString("room.name"));
                v.add(data.getString("status.name"));
                v.add(data.getString("user.date"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGender() {
        try {
            ResultSet data = MySQL.search("SELECT * FROM `gender`");
            Vector v = new Vector();
            v.add("Select");
            while (data.next()) {
                v.add(data.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUserType() {
        try {
            ResultSet data = MySQL.search("SELECT * FROM `user_type`");
            Vector v = new Vector();
            v.add("Select");
            while (data.next()) {
                v.add(data.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPasse() {
        try {
            ResultSet data = MySQL.search("SELECT * FROM `passe`");
            Vector v = new Vector();
            v.add("Select");
            while (data.next()) {
                v.add(data.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox4.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadStatusType() {
        try {
            ResultSet data = MySQL.search("SELECT * FROM `status`");
            Vector v = new Vector();
            v.add("Select");
            while (data.next()) {
                v.add(data.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCity() {
        try {
            ResultSet data = MySQL.search("SELECT * FROM `city`");
            Vector v = new Vector();
            v.add("Select");
            while (data.next()) {
                v.add(data.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox5.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int isSearch = 0;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        search();
    }//GEN-LAST:event_jButton2ActionPerformed
    int isPressBack = 0;

    public void search(String id) {
        if (!id.isEmpty()) {
            isPressBack = 0;
            try {
                ResultSet data = MySQL.search("SELECT * FROM `user` INNER JOIN `gender` INNER JOIN `user_type` INNER JOIN `passe` INNER JOIN `room` INNER JOIN `status` ON `user`.`gender_id`=`gender`.`id` AND `user`.`user_type_id`=`user_type`.`id` AND `user`.`passe_id`=`passe`.`id` AND `user`.`room_id`=`room`.`id` AND `user`.`status_id`=`status`.`id` WHERE `user`.`id`='" + id + "';");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);
                while (data.next()) {
                    Vector v = new Vector();

                    v.add(data.getString("user.id"));

                    if (data.getString("user.m_name").equals("-")) {
                        v.add(data.getString("user.f_name") + " " + data.getString("user.l_name"));
                    } else {
                        v.add(data.getString("user.f_name") + " " + data.getString("user.m_name") + " " + data.getString("user.l_name"));
                    }
                    v.add(data.getString("user.mob"));
                    v.add(data.getString("user.password"));
                    v.add(data.getString("gender.name"));
                    v.add(data.getString("user.dob"));
                    v.add(data.getString("user_type.name"));
                    v.add(data.getString("passe.name"));
                    v.add(data.getString("room.name"));
                    v.add(data.getString("status.name"));
                    v.add(data.getString("user.date"));
                    dtm.addRow(v);
                    Runnable r = () -> {
                        try {
                            Thread.sleep(10000);
                            if (isPressBack == 0) {
                                if (this.previous_Page2 != null) {
                                    Home.jPanel3.removeAll();
                                    Home.jPanel3.setLayout(new CardLayout());
                                    Home.jPanel3.revalidate();
                                    Home.jPanel3.repaint();
                                    Home.jPanel3.add(this.previous_Page2);
                                    Home.jLabel1.setText("Employee Manager");
                                    previous_Page2.reset();
                                }
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    };
                    Thread t = new Thread(r);
                    t.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void search() {
        if (isSearch == 1) {

            Vector querry = new Vector();

            String id = jTextField7.getText();
            String fname = jTextField1.getText();
            String mname = jTextField2.getText();
            String lname = jTextField3.getText();
            String surname = jTextField4.getText();
            String mob = jTextField12.getText();
            String password = jTextField13.getText();
            String gender = jComboBox1.getSelectedItem().toString();
            String userType = jComboBox2.getSelectedItem().toString();
            String status = jComboBox3.getSelectedItem().toString();
            String passe = jComboBox4.getSelectedItem().toString();
            String roomId = jLabel1.getText();
            String date = null;
            String date2 = null;

            if (jDateChooser1.getDate() != null) {
                date = sdf.format(jDateChooser1.getDate());
            }
            if (jDateChooser2.getDate() != null) {
                date2 = sdf.format(jDateChooser2.getDate());
            }

            if (!id.isEmpty()) {
                querry.add("`user`.`id`LIKE'%" + id + "%'");
            }
            if (!fname.isEmpty()) {
                querry.add("`user`.`f_name`LIKE'%" + fname + "%'");
            }
            if (!mname.isEmpty()) {
                querry.add("`user`.`m_name`LIKE'%" + mname + "%'");
            }
            if (!lname.isEmpty()) {
                querry.add("`user`.`l_name`LIKE'%" + lname + "%'");
            }
            if (!surname.isEmpty()) {
                querry.add("`user`.`surname`LIKE'%" + surname + "%'");
            }
            if (date != null) {
                querry.add("`user`.`dob`>='" + date + "'");
            }
            if (date2 != null) {
                querry.add("`user`.`dob`<='" + date2 + "'");
            }
            if (!mob.isEmpty()) {
                querry.add("`user`.`mob`LIKE'%" + mob + "%'");
            }
            if (!password.isEmpty()) {
                querry.add("`user`.`password`LIKE'%" + password + "%'");
            }
            if (!gender.equals("Select")) {
                querry.add("`gender`.`name`='" + gender + "'");
            }
            if (!userType.equals("Select")) {
                querry.add("`user_type`.`name`='" + userType + "'");
            }
            if (!roomId.equals("Name")) {
                querry.add("`room`.`name`='" + roomId + "'");
            }
            if (!passe.equals("Select")) {
                querry.add("`passe`.`name`='" + passe + "'");
            }
            if (!status.equals("Select")) {
                querry.add("`status`.`name`='" + status + "'");
            }

            int sortBy = jComboBox6.getSelectedIndex();
            String sortquerry = "";
            switch (sortBy) {
                case 0:
                    sortquerry = "`user`.`id` ASC";
                    break;
                case 1:
                    sortquerry = "`user`.`id` DESC";
                    break;
                case 2:
                    sortquerry = "`user`.`f_name` ASC";
                    break;
                case 3:
                    sortquerry = "`user`.`f_name` DESC";
                    break;
                case 4:
                    sortquerry = "`user`.`m_name` ASC";
                    break;
                case 5:
                    sortquerry = "`user`.`m_name` DESC";
                    break;
                case 6:
                    sortquerry = "`user`.`l_name` ASC";
                    break;
                case 7:
                    sortquerry = "`user`.`l_name` DESC";
                    break;
                case 8:
                    sortquerry = "`user`.`mob` ASC";
                    break;
                case 9:
                    sortquerry = "`user`.`mob` DESC";
                    break;
                case 10:
                    sortquerry = "`user`.`dob` ASC";
                    break;
                case 11:
                    sortquerry = "`user`.`dob` DESC";
                    break;
                default:
                    sortquerry = "`user`.`id` ASC";
                    break;
            }
            String fixquerry = "";

            for (int j = 0; j < querry.size(); j++) {
                if (j == 0) {
                    fixquerry += "WHERE ";
                }
                fixquerry += querry.get(j) + " ";
                if (j < querry.size() - 1) {
                    fixquerry += "AND ";
                }
            }

            try {
                ResultSet data = MySQL.search("SELECT * FROM `user` INNER JOIN `gender` INNER JOIN `user_type` INNER JOIN `passe` INNER JOIN `room` INNER JOIN `status` ON `user`.`gender_id`=`gender`.`id` AND `user`.`user_type_id`=`user_type`.`id` AND `user`.`passe_id`=`passe`.`id` AND `user`.`room_id`=`room`.`id` AND `user`.`status_id`=`status`.`id` " + fixquerry + " ORDER BY " + sortquerry + ";");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);
                while (data.next()) {
                    Vector v = new Vector();

                    v.add(data.getString("user.id"));

                    if (data.getString("user.m_name").equals("-")) {
                        v.add(data.getString("user.f_name") + " " + data.getString("user.l_name"));
                    } else {
                        v.add(data.getString("user.f_name") + " " + data.getString("user.m_name") + " " + data.getString("user.l_name"));
                    }
                    v.add(data.getString("user.mob"));
                    v.add(data.getString("user.password"));
                    v.add(data.getString("gender.name"));
                    v.add(data.getString("user.dob"));
                    v.add(data.getString("user_type.name"));
                    v.add(data.getString("passe.name"));
                    v.add(data.getString("room.name"));
                    v.add(data.getString("status.name"));
                    v.add(data.getString("user.date"));
                    dtm.addRow(v);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (evt.getClickCount() == 2) {
            if (isSearch != 1) {
                int i = JOptionPane.showConfirmDialog(this, "Please confirm your request", "QUESTION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == JOptionPane.YES_OPTION) {
                    jButton1.setEnabled(false);
                    jTextField5.setEnabled(false);
                    jTextField6.setEnabled(false);
                    jComboBox5.setEnabled(false);
                    jButton3.setEnabled(false);
                    jDateChooser2.setEnabled(true);
                    jComboBox6.setEnabled(true);
                    jTextField7.setEnabled(true);
                    jButton2.setEnabled(true);
                    isSearch = 1;
                }
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (isSearch == 1) {
            if (isSearch == 1) {
                int i = JOptionPane.showConfirmDialog(this, "Please confirm your request", "QUESTION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == JOptionPane.YES_OPTION) {
                    jButton1.setEnabled(true);
                    jTextField5.setEnabled(true);
                    jTextField6.setEnabled(true);
                    jComboBox5.setEnabled(true);
                    jButton3.setEnabled(true);
                    jDateChooser2.setEnabled(false);
                    jComboBox6.setEnabled(false);
                    jTextField7.setEnabled(false);
                    jButton2.setEnabled(false);
                    isSearch = 0;
                }
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        search();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        search();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        search();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        search();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        search();
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        search();
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        search();
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        search();
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        goPrevious();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void goPrevious() {
        if (this.previous_Page != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page);
            Home.jLabel1.setText("Staff Management");

        } else if (this.previous_Page2 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page2);
            Home.jLabel1.setText("Employee Manager");
            isPressBack = 1;
        } else if (this.previous_Page3 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page3);
            Home.jLabel1.setText("Driver & paramedics Manager");
        } else if (this.previous_Page4 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page4);
            Home.jLabel1.setText("Attendance Management");
        } else if (this.previous_Page5 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page5);
            Home.jLabel1.setText("Appointment");
        } else if (this.previous_Page6 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page6);
            Home.jLabel1.setText("Item Invoice Manager");
        } else if (this.previous_Page7 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page7);
            Home.jLabel1.setText("Shift Manager");
        } else if (this.previous_Page8 != null) {
            Home.jPanel3.removeAll();
            Home.jPanel3.setLayout(new CardLayout());
            Home.jPanel3.revalidate();
            Home.jPanel3.repaint();
            Home.jPanel3.add(this.previous_Page8);
            Home.jLabel1.setText("Salary_Manager");
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            if (jTable1.getSelectedRow() != -1) {
                try {
                    if (this.previous_Page2 != null) {
                        ResultSet r = MySQL.search("SELECT * FROM `user` INNER JOIN `gender` INNER JOIN `user_type` INNER JOIN `passe` INNER JOIN `room` INNER JOIN `status` INNER JOIN `address` INNER JOIN `user_has_address` INNER JOIN `location` INNER JOIN `city` INNER JOIN `district` INNER JOIN `province` ON `user`.`gender_id`=`gender`.`id` AND `user`.`user_type_id`=`user_type`.`id` AND `user`.`passe_id`=`passe`.`id` AND `user`.`room_id`=`room`.`id` AND `user`.`status_id`=`status`.`id` AND `user`.`id`=`user_has_address`.`user_id` AND `address`.`id`=`user_has_address`.`address_id` AND `location`.`id`=`address`.`location_id` AND `location`.`city_id` = `city`.`id` AND `location`.`district_id` = `district`.`id` AND `location`.`province_id`=`province`.`id` WHERE `user`.`id`='" + jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "';");
                        previous_Page2.r = r;
                        goPrevious();
                        this.previous_Page2.setAllDataToFields();
                    } else if (previous_Page3 != null) {
                        goPrevious();
                        if (this.previous_Page3.jLabel1.getText().isEmpty()) {
                            this.previous_Page3.jLabel1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            this.previous_Page3.jButton1.setEnabled(false);
                        } else if (this.previous_Page3.jLabel4.getText().isEmpty()) {
                            if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel5.getText())) {
                                this.previous_Page3.jLabel4.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel6.getText())) {
                                this.previous_Page3.jLabel4.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel7.getText())) {
                                this.previous_Page3.jLabel4.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                this.previous_Page3.jLabel4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            }
                        } else if (this.previous_Page3.jLabel5.getText().isEmpty()) {
                            if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel4.getText())) {
                                this.previous_Page3.jLabel5.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel6.getText())) {
                                this.previous_Page3.jLabel5.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel7.getText())) {
                                this.previous_Page3.jLabel5.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                this.previous_Page3.jLabel5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            }
                        } else if (this.previous_Page3.jLabel6.getText().isEmpty()) {
                            if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel5.getText())) {
                                this.previous_Page3.jLabel6.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel4.getText())) {
                                this.previous_Page3.jLabel6.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel7.getText())) {
                                this.previous_Page3.jLabel6.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                this.previous_Page3.jLabel6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            }
                        } else if (this.previous_Page3.jLabel7.getText().isEmpty()) {
                            if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel5.getText())) {
                                this.previous_Page3.jLabel7.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel6.getText())) {
                                this.previous_Page3.jLabel7.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equals(this.previous_Page3.jLabel4.getText())) {
                                this.previous_Page3.jLabel7.setText("None");
                                JOptionPane.showMessageDialog(this, "This Driver already selected", "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                this.previous_Page3.jLabel7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (previous_Page4 != null) {
                    previous_Page4.jButton1.setEnabled(false);
                    previous_Page4.jLabel39.setEnabled(false);
                    previous_Page4.jLabel1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    goPrevious();
                    previous_Page4.setImage();
                    search();
                } else if (previous_Page5 != null) {
                    previous_Page5.jButton9.setEnabled(false);
                    previous_Page5.jLabel8.setEnabled(false);
                    previous_Page5.jLabel9.setEnabled(false);
                    previous_Page5.jLabel8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    previous_Page5.search();
                    goPrevious();
                } else if (previous_Page6 != null) {
                    previous_Page6.jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    goPrevious();
                } else if (previous_Page7 != null) {
                    previous_Page7.jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    goPrevious();
                    previous_Page7.setImage(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    previous_Page7.search();
                } else if (previous_Page8 != null) {
                    previous_Page8.jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    goPrevious();
                    previous_Page8.setImage(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    previous_Page8.name = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                    previous_Page8.number = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                    previous_Page8.type = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
                    previous_Page8.search();
                    previous_Page8.setData();
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Room_Registration rm = new Room_Registration(this);
        Home.jPanel3.removeAll();
        Home.jPanel3.setLayout(new CardLayout());
        Home.jPanel3.revalidate();
        Home.jPanel3.repaint();
        Home.jPanel3.add(rm);
        Home.jLabel1.setText("Select a Room");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (evt.getClickCount() == 2) {
            jButton4.setEnabled(true);
            jLabel1.setText("ID");
            search();
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (evt.getClickCount() == 2) {
            jLabel7.setEnabled(false);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    public javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
